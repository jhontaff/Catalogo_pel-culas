package co.com.jt.peliculas.negocio;

import co.com.jt.peliculas.datos.AccesoDatosImpl;
import co.com.jt.peliculas.datos.IAccesoDatos;
import co.com.jt.peliculas.domain.Pelicula;
import co.com.jt.peliculas.excepciones.AccesoDatosEx;
import co.com.jt.peliculas.excepciones.LecturaDatosEx;

public class CatalogoPeliculasImpl implements ICatalogoPeliculas {

	public final IAccesoDatos datos;

	public CatalogoPeliculasImpl() {
		this.datos = new AccesoDatosImpl();
	}

	@Override
	public void agregarPelicula(String nombrePelicula) {
		Pelicula pelicula = new Pelicula(nombrePelicula);
		boolean anexar = false;
		try {
			anexar = datos.existe(NOMBRE_RECURSO);
			datos.escribir(pelicula, NOMBRE_RECURSO, anexar);
		} catch (AccesoDatosEx e) {
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public void listarPeliculas() {
		try {
			var peliculas = this.datos.listar(NOMBRE_RECURSO);
			for(var pelicula : peliculas) {
				System.out.println(pelicula);
			}
		} catch (AccesoDatosEx e) {
			e.printStackTrace(System.out);
		}
		
	}

	@Override
	public void buscarPelicula(String nombrePelicula) {
		String resultado = null;
		try {
			resultado = this.datos.buscar(NOMBRE_RECURSO, nombrePelicula);

		} catch (LecturaDatosEx e) {
			e.printStackTrace(System.out);
		}
		System.out.println("Resultado = " + resultado);
	}

	@Override
	public void iniciarCatalogoPeliculas() {
		try {
			if(this.datos.existe(NOMBRE_RECURSO)) {
				datos.borrar(NOMBRE_RECURSO);
				datos.crear(NOMBRE_RECURSO);
			}
			else {
				datos.crear(NOMBRE_RECURSO);
			}
		} catch (AccesoDatosEx e) {
			e.printStackTrace(System.out);
		}
		
	}


}
