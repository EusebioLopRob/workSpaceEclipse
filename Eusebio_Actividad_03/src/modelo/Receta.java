package modelo;

import java.util.ArrayList;

public class Receta {
    private String titulo;
    private String harina;
    private ArrayList<String> liquidos;
    private String levadura;
    private String azucar;
    private String sal;
    private String preparacion;
    
    
    
	public Receta(String titulo) {
		
		this.titulo = titulo;
	}
	public Receta(String titulo, String harina, ArrayList<String> liquidos, String levadura, String azucar, String sal, String preparacion) {
		
		this.titulo = titulo;
		this.harina = harina;
		this.liquidos = liquidos;
		this.levadura = levadura;
		this.azucar = azucar;
		this.sal = sal;
		this.preparacion = preparacion;
	}
	public String getTitulo() {
		return titulo;
	}
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}
	public String getHarina() {
		return harina;
	}
	public void setHarina(String harina) {
		this.harina = harina;
	}
	public ArrayList<String> getLiquidos() {
		return liquidos;
	}
	public void setLiquidos(ArrayList<String> liquidos) {
		this.liquidos = liquidos;
	}
	public String getLevadura() {
		return levadura;
	}
	public void setLevadura(String levadura) {
		this.levadura = levadura;
	}
	public String getAzucar() {
		return azucar;
	}
	public void setAzucar(String azucar) {
		this.azucar = azucar;
	}
	public String getSal() {
		return sal;
	}
	public void setSal(String sal) {
		this.sal = sal;
	}
	public String getPreparacion() {
		return preparacion;
	}
	public void setPreparacion(String preparacion) {
		this.preparacion = preparacion;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((titulo == null) ? 0 : titulo.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Receta other = (Receta) obj;
		if (titulo == null) {
			if (other.titulo != null)
				return false;
		} else if (!titulo.equals(other.titulo))
			return false;
		return true;
	}
	
	
	
	
	
	
	
	
	
    
    
}
