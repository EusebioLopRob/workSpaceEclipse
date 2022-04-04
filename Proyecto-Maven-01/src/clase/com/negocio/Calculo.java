package clase.com.negocio;

public class Calculo {
	private Double tInicial;
	private Double tFinal;
	private Double distancia;
	
	public Calculo(){}

	public Calculo(Double tInicial, Double tFinal, Double distancia) {
		super();
		this.tInicial = tInicial;
		this.tFinal = tFinal;
		this.distancia = distancia;
	}

	public Double getiInicial() {
		return tInicial;
	}

	public void setiInicial(Double tInicial) {
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
	
		
	
	public Double tiempoTotal() {
		return (this.tFinal - this.tInicial);
	}
	
	public Double velocidad() {
		return (this.distancia/this.tiempoTotal());
	}
	
}
