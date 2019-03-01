package com.rollingstone.spring.controller;

import com.rollingstone.events.AddressEvent;
import com.rollingstone.exceptions.HTTP404Exception;
import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.dto.AddressDTO;
import com.rollingstone.spring.service.AddressService;
import java.util.Optional;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/address")
public class AddressController
		extends AbstractController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
	this.addressService = addressService;
    }

    /*---Add new Address---*/
    @PostMapping
    public ResponseEntity<?> createAddress(@RequestBody Address address) {
	Address savedAddress = addressService.save(address);
	final AddressDTO addressDTO = new AddressDTO(address.getId(), address.getHouseNumber(), address.getStreetAddress(), address.getCity(), address.getState(), address.getZipCode(), address.getAccount().getId());
	AddressEvent categoryCreatedEvent = new AddressEvent(this, "AddressCreatedEvent", addressDTO);
	eventPublisher.publishEvent(categoryCreatedEvent);
	return ResponseEntity.ok().body("New address has been saved with ID:" + savedAddress.getId());
    }

    /*---Get a Address by id---*/
    @GetMapping("/{id}")
    public ResponseEntity<AddressDTO> getAddress(@PathVariable("id") long id) {
	AddressDTO addressDTO = Optional.ofNullable(addressService.getAddressPartial(id)).orElseThrow(() -> new HTTP404Exception("Resource Not Found"));
	AddressEvent retrievedCreatedEvent = new AddressEvent(this, "AddressRetrievedEvent", addressDTO);
	eventPublisher.publishEvent(retrievedCreatedEvent);
	return ResponseEntity.ok().body(addressDTO);
    }

    /*---get all Address---*/
    @GetMapping
    @ResponseBody
    public Page<Address> getAddressesByPage(@RequestParam(value = "pagenumber", defaultValue = DEFAULT_PAGE_NUMBER) Integer pageNumber,
					   @RequestParam(value = "pagesize", defaultValue = DEFAULT_PAGE_SIZE) Integer pageSize) {
	return addressService.getAddressesByPage(pageNumber, pageSize);
    }

    /*---Update a Address by id---*/
    @PutMapping("/{id}")
    public ResponseEntity<?> updateAddress(@PathVariable("id") long id, @RequestBody Address category) {
	checkResourceFound(this.addressService.getAddressPartial(id));
	addressService.update(id, category);
	return ResponseEntity.ok().body("Address has been updated successfully.");
    }

    /*---Delete a Address by id---*/
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteAddress(@PathVariable("id") long id) {
	checkResourceFound(this.addressService.get(id));
	addressService.delete(id);
	return ResponseEntity.ok().body("Address has been deleted successfully.");
    }
}