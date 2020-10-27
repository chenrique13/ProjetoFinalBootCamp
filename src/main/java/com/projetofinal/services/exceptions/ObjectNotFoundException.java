package com.projetofinal.services.exceptions;

public class ObjectNotFoundException extends RuntimeException {

	/**
	 * Mesagem de erro para quando não tiver elemento na busca
	 * @author Cícero Junior 
	 */
	private static final long serialVersionUID = 1L;

	public ObjectNotFoundException(String mensagem) {
		super(mensagem);

	}
	
	public ObjectNotFoundException(String mensagem, Throwable causa) {
		super(mensagem, causa);

	}

}
