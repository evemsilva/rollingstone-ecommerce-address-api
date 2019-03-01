package com.rollingstone.spring.service;

import com.rollingstone.spring.dao.AddressDaoRepository;
import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.dto.AddressDTO;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class AddressServiceImpl
		implements AddressService {

    @Autowired private AddressDaoRepository addressDao;

    @Override
    public Address save(Address address) {
	return addressDao.save(address);
    }

    @Override
    public Optional<Address> get(long id) {
	return addressDao.findById(id);
    }

    @Override
    public AddressDTO getAddressPartial(long id) {
	return addressDao.getAddressByID(id);
    }

    @Override
    public Page<Address> getAddressesByPage(Integer pageNumber, Integer pageSize) {
	Pageable pageable = PageRequest.of(pageNumber, pageSize, Sort.by("houseNumber").descending());
	return addressDao.findAll(pageable);
    }

    @Override
    public void update(long id, Address address) {
	addressDao.save(address);
    }

    @Override
    public void delete(long id) {
	addressDao.deleteById(id);
    }

}
