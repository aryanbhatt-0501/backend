package com.example.finalproject.Exception;

public class Menu extends RuntimeException {
	String message="Menu Not Available";
	public String getMessage() {
		return message;
	}

}