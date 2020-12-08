package com.cg.oas.exceptions;
public class InvalidDataFormatException extends Exception{

		private String message;
		
		public InvalidDataFormatException() {
			this.message="";
		}

		public InvalidDataFormatException(String message) {
			super();
			this.message = message;
		}
		

	}


