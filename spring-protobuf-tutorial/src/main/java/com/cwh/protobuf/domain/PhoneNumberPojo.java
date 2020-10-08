package com.cwh.protobuf.domain;

public class PhoneNumberPojo {
	private String number;
	private PhoneTypePojo type;
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public PhoneTypePojo getType() {
		return type;
	}
	public void setType(PhoneTypePojo type) {
		this.type = type;
	}
}
