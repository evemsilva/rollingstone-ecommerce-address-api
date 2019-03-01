package com.rollingstone.spring.model.dto;

import java.util.Objects;

public class AddressDTO {

    private long id;

    private String houseNumber;

    private String streetAddress;

    private String city;

    private String state;

    private String zipCode;

    private long accountId;

    public AddressDTO() {
    }

    public AddressDTO(long id, String houseNumber, String streetAddress, String city, String state, String zipCode, long accountId) {
	this.id = id;
	this.houseNumber = houseNumber;
	this.streetAddress = streetAddress;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.accountId = accountId;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getHouseNumber() {
	return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
	this.houseNumber = houseNumber;
    }

    public String getStreetAddress() {
	return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
	this.streetAddress = streetAddress;
    }

    public String getCity() {
	return city;
    }

    public void setCity(String city) {
	this.city = city;
    }

    public String getState() {
	return state;
    }

    public void setState(String state) {
	this.state = state;
    }

    public String getZipCode() {
	return zipCode;
    }

    public void setZipCode(String zipCode) {
	this.zipCode = zipCode;
    }

    public long getAccountId() {
	return accountId;
    }

    public void setAccountId(long accountId) {
	this.accountId = accountId;
    }

    @Override
    public String toString() {
	return "AddressDTO{"
			+ "id="
			+ id
			+ ", houseNumber='"
			+ houseNumber
			+ '\''
			+ ", streetAddress='"
			+ streetAddress
			+ '\''
			+ ", city='"
			+ city
			+ '\''
			+ ", state='"
			+ state
			+ '\''
			+ ", zipCode='"
			+ zipCode
			+ '\''
			+ ", accountId="
			+ accountId
			+ '}';
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	AddressDTO that = (AddressDTO)o;
	return id == that.id && accountId == that.accountId && houseNumber.equals(that.houseNumber) && streetAddress.equals(
			that.streetAddress) && city.equals(that.city) && state.equals(that.state) && zipCode.equals(that.zipCode);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, houseNumber, streetAddress, city, state, zipCode, accountId);
    }
}
