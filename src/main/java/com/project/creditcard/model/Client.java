package com.project.creditcard.model;

public class Client {
	
	private String codeClient;
	private String name;
	private String lastName;
	private String dni;
	private String address;
	private String phoneNumber;
	private String clientType;

	public Client(String codeClient, String name, String lastName, String dni, String address, String phoneNumber,
		String clientType) {
		
		this.codeClient = codeClient;
		this.name = name;
		this.lastName = lastName;
		this.dni = dni;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.clientType = clientType;
	}

	public String getCodeClient() {
		return codeClient;
	}

	public void setCodeClient(String codeClient) {
		this.codeClient = codeClient;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getClientType() {
		return clientType;
	}

	public void setClientType(String clientType) {
		this.clientType = clientType;
	}
	
	
	

}
