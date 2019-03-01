package com.rollingstone.events;

import com.rollingstone.spring.model.dto.AddressDTO;
import org.springframework.context.ApplicationEvent;

public class AddressEvent
		extends ApplicationEvent {

    private String     eventType;
    private AddressDTO address;

    public String getEventType() {
	return eventType;
    }

    public void setEventType(String eventType) {
	this.eventType = eventType;
    }

    public AddressDTO getAddress() {
	return address;
    }

    public void setAddress(AddressDTO address) {
	this.address = address;
    }

    public AddressEvent(Object source, String eventType, AddressDTO address) {
	super(source);
	this.eventType = eventType;
	this.address = address;
    }

    @Override
    public String toString() {
	return "Address Event [eventType=" + eventType + ", address=" + address + "]";
    }

}
