package com.rollingstone.spring.dao;

import com.rollingstone.spring.model.Address;
import com.rollingstone.spring.model.dto.AddressDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

public interface AddressDaoRepository
		extends PagingAndSortingRepository<Address, Long> {

	Page<Address> findAll(Pageable pageable);

	@Query(name = "AddressDaoRepository.getAddressByID", nativeQuery = true)
	AddressDTO getAddressByID(@Param("id") long id);
}
