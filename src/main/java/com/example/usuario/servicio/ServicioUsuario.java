package com.example.usuario.servicio;

import java.util.List;

import com.example.usuario.modelo.Usuario;
import com.example.usuario.servicio.excepciones.ValidacionUsuarioException;

public interface ServicioUsuario {
	public void guardar(Usuario usuario) throws ValidacionUsuarioException;

	public List<Usuario> obtenerUsuarios();

	public Usuario obtenerUsuariosPorIdentificador(Integer identificador);

	public Usuario obtenerUsuariosPorNombre(String nombre);

	public void modificador(String nombreViejo, String nombreNuevo);

	public void borrar(Integer identificador);
}
