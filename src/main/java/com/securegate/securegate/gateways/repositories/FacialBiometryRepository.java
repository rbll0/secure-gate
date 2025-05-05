package com.securegate.securegate.gateways.repositories;

import com.securegate.securegate.domains.FacialBiometry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FacialBiometryRepository extends MongoRepository<FacialBiometry, String> {
}
