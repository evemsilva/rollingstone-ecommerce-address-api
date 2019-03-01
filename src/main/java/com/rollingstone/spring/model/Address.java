package com.rollingstone.spring.model;

import com.rollingstone.spring.model.dto.AddressDTO;
import javax.persistence.Column;
import javax.persistence.ColumnResult;
import javax.persistence.ConstructorResult;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.SqlResultSetMapping;
import javax.persistence.Table;

@SqlResultSetMapping(name = "addressPartialMapping", classes = {
		@ConstructorResult(targetClass = AddressDTO.class, columns = {@ColumnResult(name = "id", type = Long.class),
									      @ColumnResult(name = "house_Number", type = String.class),
									      @ColumnResult(name = "street_address", type = String.class),
									      @ColumnResult(name = "city", type = String.class),
									      @ColumnResult(name = "state", type = String.class),
									      @ColumnResult(name = "zip_code", type = String.class),
									      @ColumnResult(name = "account_id", type = Long.class)})})

@NamedNativeQueries({
		@NamedNativeQuery(name = "AddressDaoRepository.getAddressByID", query = "SELECT id, city, house_number, state, strret_address, zip_code, account_id FROM rollingstone_address a WHERE a.id = :id", resultSetMapping = "addressPartialMapping")})

@Entity
@Table(name = "rollingstone_address")
public class Address {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "house_number", nullable = false) private String houseNumber;

    @Column(name = "street_address", nullable = false) private String streetAddress;

    private String city;

    private String state;

    @Column(name = "zip_code", nullable = false) private String zipCode;

    @ManyToOne(fetch = FetchType.LAZY) @JoinColumn(name = "account_id", nullable = false) private Account account;

    public Address() {
    }

    public Address(long id, String houseNumber, String streetAddress, String city, String state, String zipCode, Account account) {
	this.id = id;
	this.houseNumber = houseNumber;
	this.streetAddress = streetAddress;
	this.city = city;
	this.state = state;
	this.zipCode = zipCode;
	this.account = account;
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

    public Account getAccount() {
	return account;
    }

    public void setAccount(Account account) {
	this.account = account;
    }
}
