package com.rollingstone.listeners;

import com.rollingstone.events.AddressEvent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AddressEventListener {

	private final Logger log = LoggerFactory.getLogger(this.getClass());
	
	@EventListener
	public void onApplicationEvent(AddressEvent addressEvent) {
		log.info("Received Address Event : "+ addressEvent.getEventType());
		log.info("Received Address From Address Event :"+ addressEvent.getAddress().toString());
	}
}
