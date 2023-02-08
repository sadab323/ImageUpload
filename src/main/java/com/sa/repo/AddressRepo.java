package com.sa.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sa.model.Address;

public interface AddressRepo extends JpaRepository<Address,Integer> {

}
