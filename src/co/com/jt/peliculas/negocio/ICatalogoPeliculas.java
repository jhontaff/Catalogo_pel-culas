package co.com.jt.peliculas.negocio;

public interface ICatalogoPeliculas {
	
	String NOMBRE_RECURSO = System.getProperty("user.dir")+"\\peliculas.txt";
	
	public void agregarPelicula(String nombrePelicula);
	
	public void listarPeliculas();

	public void buscarPelicula(String nombrePelicula);

	public void iniciarCatalogoPeliculas();
}
