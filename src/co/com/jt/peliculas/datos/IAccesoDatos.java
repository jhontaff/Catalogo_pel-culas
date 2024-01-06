package co.com.jt.peliculas.datos;

import java.util.List;
import co.com.jt.peliculas.domain.Pelicula;
import co.com.jt.peliculas.excepciones.*;

public interface IAccesoDatos {

	boolean existe(String nombreArchivo) throws AccesoDatosEx;

	List<Pelicula> listar(String nombre) throws LecturaDatosEx;

	void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) throws EscrituraDatosEx;

	String buscar(String nombreArchivo, String text) throws LecturaDatosEx;

	void crear(String nombreArchivo) throws AccesoDatosEx;

	void borrar(String nombreArchivo) throws AccesoDatosEx;

}
