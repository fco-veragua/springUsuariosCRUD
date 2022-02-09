package com.example.usuario.controlador;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.usuario.modelo.Usuario;
import com.example.usuario.servicio.ServicioUsuario;
import com.example.usuario.servicio.excepciones.ValidacionUsuarioException;

@RestController
@RequestMapping("/api/v1")
public class Controlador {
	@Autowired
	private ServicioUsuario servicioUsuario;

	@GetMapping("/usuarios")
	public List<Usuario> obtenerUsuarios() {
		return this.servicioUsuario.obtenerUsuarios();

	}

//	@GetMapping("/usuarios/{nombre}")
//	public List<Usuario> obtenerUsuariosPorNombre() {
//		return this.servicioUsuario.obtenerUsuariosPorNombre();
//
//	}

	@PostMapping("/usuarios")
	public ResponseEntity<?> guardaUsuario(@RequestBody Usuario usuario) {
		Map<Integer, Object> errores = new HashMap<Integer, Object>();
		HttpStatus estado = HttpStatus.OK;

		try {
			this.servicioUsuario.guardar(usuario);
		} catch (ValidacionUsuarioException e) {
			estado = HttpStatus.PRECONDITION_FAILED;
			errores.put(0, e.getErrores());
		}

		return new ResponseEntity<>(errores, estado);
	}

//	@PutMapping("/usuarios/{nombre}")
//	public ResponseEntity<Usuario> modificarUsuario(@RequestBody Usuario usuario) {
//		ResponseEntity<Usuario> resultado = null;
//
//		this.servicioUsuario.guardar(usuario);
//		resultado = new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
//		return resultado;
//	}

	@PutMapping("/usuario/modificar/{nombreUsuarioViejo}/{nombreUsuarioNuevo}")
	public ResponseEntity<Usuario> modificarUsuario(@PathVariable String nombreUsuarioViejo,
			@PathVariable String nombreUsuarioNuevo) {
		this.servicioUsuario.modificador(nombreUsuarioViejo, nombreUsuarioNuevo);
		return new ResponseEntity<Usuario>(HttpStatus.OK);
	}

	@DeleteMapping("/usuario/borrar/{id}")
	public ResponseEntity<Usuario> modificarUsuario(@PathVariable Integer id) {

		this.servicioUsuario.borrar(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}

//	@GetMapping("/usuario/{id}")
//	public ResponseEntity<Usuario> (@PathVariable Integer id) {
//
//		this.servicioUsuario.borrar(id);
//		return new ResponseEntity<>(HttpStatus.OK);
//
//	}
}
