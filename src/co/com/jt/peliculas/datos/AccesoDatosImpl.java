package co.com.jt.peliculas.datos;

import java.io.*;
import java.util.*;
import co.com.jt.peliculas.domain.Pelicula;
import co.com.jt.peliculas.excepciones.*;

public class AccesoDatosImpl implements IAccesoDatos {

	@Override
	public boolean existe(String nombreArchivo){
		var archivo = new File(nombreArchivo);
		return archivo.exists();
	}

	@Override
	public List<Pelicula> listar(String nombre) throws LecturaDatosEx {
		var archivo = new File(nombre);
		var lista = new ArrayList<Pelicula>();
		// List<Pelicula> lsta = new ArrayList<>();
		try {
			var entrada = new BufferedReader(new FileReader(archivo));
			var lectura = entrada.readLine();
			while (lectura != null) {
				var pelicula = new Pelicula(lectura);
				lista.add(pelicula);
				lectura = entrada.readLine();
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("Excepción al listar peliculas: " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new LecturaDatosEx("Excepción al listar peliculas: " + e.getMessage());
		}

		return lista;
	}

	@Override
	public void escribir(Pelicula pelicula, String nombreArchivo, Boolean anexar) throws EscrituraDatosEx {
		var archivo = new File(nombreArchivo);
		try {
			var salida = new PrintWriter(new FileWriter(archivo, anexar));
			salida.println(pelicula.getName());
			salida.close();
			System.out.println("La pelicula " + pelicula.getName()+ " se ha agregado correctamente");
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
			throw new EscrituraDatosEx("Excepción al escribir pelicula" + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new EscrituraDatosEx("Excepción al escribir pelicula" + e.getMessage());
		}
	}

	@Override
	public void crear(String nombreArchivo) throws AccesoDatosEx {
		var archivo = new File(nombreArchivo);
		try {
			var salida = new PrintWriter(new FileWriter(archivo));
			salida.close();
			System.out.println("Se ha creado el archivo");
		} catch (IOException e) {
			e.printStackTrace(System.out);
			throw new AccesoDatosEx("Excepcion al crear archivo: " + e.getMessage());
		}
	}

	@Override
	public void borrar(String nombreArchivo) {
		var archivo = new File(nombreArchivo);
		if(archivo.exists()) {
			archivo.delete();
			System.out.println("Se ha borrado el archivo");
		}
		
	}

	@Override
	public String buscar(String nombreArchivo, String text) throws LecturaDatosEx {
		var archivo = new File(nombreArchivo);
		@SuppressWarnings("unused")
		String resultado = null;
		try {
			var entrada = new BufferedReader(new FileReader(archivo));
			var lectura = entrada.readLine();
			var indice = 1;
			while (lectura != null) {
				if(text != null && text.equalsIgnoreCase(lectura)) {
					resultado = "Pelicula encontrada: " + lectura + " en el indice "+ indice;
					break;
				}
				lectura = entrada.readLine();
				indice++;
			}
			entrada.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion de busqueda de pelicula " + e.getMessage());
		} catch (IOException e) {
			e.printStackTrace();
			throw new LecturaDatosEx("Excepcion de busqueda de pelicula " + e.getMessage());
		}
		return resultado;
	}

}
