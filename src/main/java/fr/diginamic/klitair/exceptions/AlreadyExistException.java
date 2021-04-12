package fr.diginamic.klitair.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.FORBIDDEN)
public class AlreadyExistException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6402709294650633149L;

	public AlreadyExistException(String msg) {
		super(msg);
	}

}
