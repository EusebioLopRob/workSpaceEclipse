package clase.com.negocio;
/*Bean o Clase POJO*/

public class Calculo {
	private Double tInicial;
	private Double tFinal;
	private Double distancia;
	
	public Calculo() {
		
	}		
	
	public Calculo(Double tInicial, Double tFinal, Double distancia) {
		super();
		this.tInicial = tInicial;
		this.tFinal = tFinal;
		this.distancia = distancia;
	}
	
	public Double velocidad() {
		return distancia/(tFinal-tInicial);
	}
	
	public Double tiempoTotal() {
		return tFinal-tInicial;
	}

	public Double gettInicial() {
		return tInicial;
	}
	public void settInicial(Double tInicial) {
		this.tInicial = tInicial;
	}
	public Double gettFinal() {
		return tFinal;
	}
	public void settFinal(Double tFinal) {
		this.tFinal = tFinal;
	}
	public Double getDistancia() {
		return distancia;
	}
	public void setDistancia(Double distancia) {
		this.distancia = distancia;
	}
	
	
	

}
