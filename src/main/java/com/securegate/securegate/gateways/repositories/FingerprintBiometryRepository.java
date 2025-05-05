package com.securegate.securegate.gateways.repositories;

import com.securegate.securegate.domains.FingerprintBiometry;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FingerprintBiometryRepository extends MongoRepository<FingerprintBiometry, String> {
}
