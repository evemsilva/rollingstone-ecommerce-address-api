package com.rollingstone.spring.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "rollingstone_account")
public class Account {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY) private long id;

    @Column(name = "account_number", nullable = false) private String accountNumber;

    @OneToOne @JoinColumn(name = "user_profile_id") private User user;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "account") @JsonIgnore private Set<Address> addresses = new HashSet<>();

    public Account() {
    }

    public Account(long id, String accountNumber, User user, Set<Address> addresses) {
	this.id = id;
	this.accountNumber = accountNumber;
	this.user = user;
	this.addresses = addresses;
    }

    public long getId() {
	return id;
    }

    public void setId(long id) {
	this.id = id;
    }

    public String getAccountNumber() {
	return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
	this.accountNumber = accountNumber;
    }

    public User getUser() {
	return user;
    }

    public void setUser(User user) {
	this.user = user;
    }

    public Set<Address> getAddresses() {
	return addresses;
    }

    public void setAddresses(Set<Address> addresses) {
	this.addresses = addresses;
    }

    @Override
    public boolean equals(Object o) {
	if (this == o)
	    return true;
	if (o == null || getClass() != o.getClass())
	    return false;
	Account account = (Account)o;
	return id == account.id && accountNumber.equals(account.accountNumber) && user.equals(account.user) && addresses.equals(
			account.addresses);
    }

    @Override
    public int hashCode() {
	return Objects.hash(id, accountNumber, user, addresses);
    }

    @Override
    public String toString() {
	return "Account{" + "id=" + id + ", accountNumber='" + accountNumber + '\'' + ", user=" + user + ", addresses=" + addresses + '}';
    }
}
