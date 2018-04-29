/**
 * 
 */
package logicLayer;

/**
 * @author plisik
 *
 */
public class LogicLayerException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3099297478265171564L;

	/**
	 * 
	 */
	public LogicLayerException() {
	}

	/**
	 * @param message
	 */
	public LogicLayerException(String message) {
		super(message);
	}

	/**
	 * @param cause
	 */
	public LogicLayerException(Throwable cause) {
		super(cause);
	}

	/**
	 * @param message
	 * @param cause
	 */
	public LogicLayerException(String message, Throwable cause) {
		super(message, cause);
	}

	/**
	 * @param message
	 * @param cause
	 * @param enableSuppression
	 * @param writableStackTrace
	 */
	public LogicLayerException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
	}

}
