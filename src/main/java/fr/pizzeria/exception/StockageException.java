package fr.pizzeria.exception;

import java.io.FileNotFoundException;

import com.itextpdf.text.DocumentException;

public class StockageException extends Exception{

	/**
	 * 
	 */
	private static final long serialVersionUID = -2114867832046339229L;

	public StockageException(String message) {
		super(message);
	}


}
