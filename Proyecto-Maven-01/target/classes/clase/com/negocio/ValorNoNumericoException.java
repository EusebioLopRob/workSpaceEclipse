package clase.com.negocio;

public class ValorNoNumericoException extends NumberFormatException{
	public ValorNoNumericoException(String msg) {
        super(msg);
    }
}