package com.example.finalproject.Exception;

	public class IdNotFound extends RuntimeException {
		
		String message="ID not found";
		
		@Override
		public String getMessage() {
		
			return message;
		}

	}

