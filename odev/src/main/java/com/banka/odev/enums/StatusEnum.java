package com.banka.odev.enums;

public enum StatusEnum {
	FAILED("FAILED"),
	SUCCESS("SUCCESS");

	String status;
	
	StatusEnum(String status) {
		this.status = status;
	}
}
