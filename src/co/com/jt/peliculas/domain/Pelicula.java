package co.com.jt.peliculas.domain;

public class Pelicula {

	private String name;
	
	public Pelicula() {
		
	}
	
	public Pelicula(String name){
		this.name = name;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Pelicula:");
		builder.append(name);
		builder.append("");
		return builder.toString();
	}
	
	
}
