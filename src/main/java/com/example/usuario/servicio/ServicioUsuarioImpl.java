package com.example.usuario.servicio;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.usuario.Repositorio.RepositorioUsuario;
import com.example.usuario.modelo.Usuario;
import com.example.usuario.servicio.excepciones.ValidacionUsuarioException;

@Service
public class ServicioUsuarioImpl implements ServicioUsuario {
	private RepositorioUsuario repositorioUsuario;

	@Autowired
	public ServicioUsuarioImpl(RepositorioUsuario repositorioUsuario) {
		this.repositorioUsuario = repositorioUsuario;
	}

	@Override
	public void guardar(Usuario usuario) throws ValidacionUsuarioException {
		Map<Integer, String> errores = this.validar(usuario);
		if (!errores.isEmpty()) {
			throw new ValidacionUsuarioException(errores);
		}

		repositorioUsuario.guardar(usuario);

	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		return this.repositorioUsuario.obtenerUsuarios();
	}

	@Override
	public Usuario obtenerUsuariosPorIdentificador(Integer identificador) {
		return this.repositorioUsuario.obtenerUsuariosPorIdentificador(identificador);
	}

	@Override
	public Usuario obtenerUsuariosPorNombre(String nombre) {
		return this.repositorioUsuario.obtenerUsuariosPorNombre(nombre);
	}

	@Override
	public void modificador(String nombreViejo, String nombreNuevo) {
		this.repositorioUsuario.modificador(nombreViejo, nombreNuevo);
	}

	@Override
	public void borrar(Integer identificador) {
		this.repositorioUsuario.borrar(identificador);
	}

	public Map<Integer, String> validar(Usuario usuario) {
		Map<Integer, String> resultado = new HashMap<Integer, String>();
		if (usuario.getNombre() == null || usuario.getNombre().isEmpty()) {
			resultado.put(1, "Nombre está vacío");
		}
		return resultado;
	}
}
