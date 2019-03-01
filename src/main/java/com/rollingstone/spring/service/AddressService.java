package com.rollingstone.spring.service;

import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.dto.AddressDTO;
import java.util.Optional;
import org.springframework.data.domain.Page;

public interface AddressService {

    Address save(Address address);

    Optional<Address> get(long id);

    AddressDTO getAddressPartial(long id);

    Page<Address> getAddressesByPage(Integer pageNumber, Integer pageSize);

    void update(long id, Address user);

    void delete(long id);
}
