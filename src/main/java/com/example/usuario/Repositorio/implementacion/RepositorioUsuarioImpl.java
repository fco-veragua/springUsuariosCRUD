package com.example.usuario.Repositorio.implementacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.example.usuario.Repositorio.RepositorioUsuario;
import com.example.usuario.modelo.Usuario;

@Repository
public class RepositorioUsuarioImpl implements RepositorioUsuario {
	private List<Usuario> usuarios;

	@Override
	public void guardar(Usuario usuario) {
		if (this.usuarios == null) {
			this.usuarios = new ArrayList<Usuario>();
		}
		this.usuarios.add(usuario);

	}

	@Override
	public List<Usuario> obtenerUsuarios() {
		// TODO Auto-generated method stub
		return this.usuarios;
	}

	@Override
	public Usuario obtenerUsuariosPorIdentificador(Integer id) {
		return this.usuarios.stream().filter(usuario -> usuario.getId() == id).findFirst().orElse(null);
	}

	@Override
	public Usuario obtenerUsuariosPorNombre(String nombre) {
		return this.usuarios.stream().filter(usuario -> usuario.getNombre().equals(nombre)).findFirst().orElse(null);
	}

	@Override
	public void modificador(String nombreViejo, String nombreNuevo) {
		Optional<Usuario> usuarioEncontrado = this.usuarios.stream()
				.filter(usuario -> usuario.getNombre().equals(nombreViejo)).findFirst();

		if (usuarioEncontrado.isPresent()) {
			Usuario usuarioExistente = usuarioEncontrado.get();
			this.usuarios.remove(usuarioExistente);
			usuarioExistente.setNombre(nombreNuevo);
			this.guardar(usuarioExistente);
		}
	}

	@Override
	public void borrar(Integer identificador) {
		Usuario usuario = this.obtenerUsuariosPorIdentificador(identificador);
		this.usuarios.remove(usuario);

	}

}
