package com.jpa.advertiseapp.exceptions;

public class UserNotFoundException extends Exception
{
	
		private String mString;

		public UserNotFoundException() {
			super();
			this.mString="";
		}

		public UserNotFoundException(String mesString) {
			super();
			this.mString = mString;
		}
		
		
		
	}

