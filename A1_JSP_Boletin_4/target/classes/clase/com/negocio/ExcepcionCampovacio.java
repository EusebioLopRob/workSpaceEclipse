package clase.com.negocio;

public class ExcepcionCampovacio extends RuntimeException{
	private static final long serialVersionUID = 1L;
	
	public ExcepcionCampovacio (String s) {
		super(s);
	}
	
	public ExcepcionCampovacio () {
		super();
	}

}
