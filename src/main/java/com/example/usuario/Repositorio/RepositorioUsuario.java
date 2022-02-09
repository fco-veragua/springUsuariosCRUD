package com.example.usuario.Repositorio;

import java.util.List;

import com.example.usuario.modelo.Usuario;

public interface RepositorioUsuario {
	public void guardar(Usuario usuario);

	public List<Usuario> obtenerUsuarios();

	public Usuario obtenerUsuariosPorIdentificador(Integer identificador);

	public Usuario obtenerUsuariosPorNombre(String nombre);

	public void modificador(String nombreViejo, String nombreNuevo);

	public void borrar(Integer identificador);
}
