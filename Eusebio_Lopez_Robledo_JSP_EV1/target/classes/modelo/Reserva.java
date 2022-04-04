package modelo;

import java.time.LocalDate;

public class Reserva {
	private String codHotel;
	private LocalDate fechaEntrada;
	
	public Reserva() {
		this.codHotel = "";
		this.fechaEntrada = null;		
		
	}
	
	public Reserva(String codHotel, LocalDate fechaEntrada) {		
		this.codHotel = codHotel;
		this.fechaEntrada = fechaEntrada;
	}
	
	

	public String getCodHotel() {
		return codHotel;
	}

	public void setCodHotel(String codHotel) {
		this.codHotel = codHotel;
	}

	public LocalDate getFechaEntrada() {
		return fechaEntrada;
	}

	public void setFechaEntrada(LocalDate fechaEntrada) {
		this.fechaEntrada = fechaEntrada;
	}

	@Override
	public String toString() {
		return "--------\nReserva:\n"+"Código de hotel: "+this.codHotel+
				"\nFecha de entrada: "+this.fechaEntrada.toString()+
				"\n--------";
	}
}
