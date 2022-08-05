package com.giantlink.grh.exceptions;

import lombok.Getter;

@Getter
public class AlreadyExistsException extends Exception {

	private String message;
	private String object;
	public AlreadyExistsException(String Entity, String Msg) {
		super( Msg);
		
		this.message =  Msg;
		this.object = Entity;
	}
}
