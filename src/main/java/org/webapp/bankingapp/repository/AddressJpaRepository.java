package org.webapp.bankingapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.webapp.bankingapp.entity.Address;

@Repository
public interface AddressJpaRepository extends JpaRepository<Address, Long> {
}
