package com.controleservico.os.repository;

import com.controleservico.os.model.AddressUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AddressRepository extends JpaRepository<AddressUser, Long> {
}
