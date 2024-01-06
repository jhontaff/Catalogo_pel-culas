package co.com.jt.presentacion;

import java.util.Scanner;

import co.com.jt.peliculas.negocio.*;

public class LabPeliculas {

	public static void main(String[] args) {
		var opcion = -1;
		@SuppressWarnings("resource")
		var scanner = new Scanner(System.in);
		ICatalogoPeliculas catalogo = new CatalogoPeliculasImpl();
		while (opcion != 0) {
			System.out.println("Bienvenido, por favor seleccione una opción: \n" + "1. Iniciar catálogo de películas\n"
					+ "2. Agregar película\n" + "3. Listar películas\n" + "4. Buscar película\n"
					+ "5. Volver al menú principal\n" + "0. salir");
			opcion = Integer.parseInt(scanner.nextLine());

			switch (opcion) {
			case 1:
				catalogo.iniciarCatalogoPeliculas();
				break;
			case 2:
				System.out.println("Ingrese la pelicula a agregar");
				var nombre = scanner.nextLine();
				catalogo.agregarPelicula(nombre);
				break;
			case 3:
				catalogo.listarPeliculas();
				break;
			case 4:
				System.out.println("Nombre de la pelicula a buscar");
				var nombreBusq = scanner.nextLine();
				catalogo.buscarPelicula(nombreBusq);
				break;
			case 0:
				System.out.println("Hasta pronto!");
				break;
			}
		}
	}
}
