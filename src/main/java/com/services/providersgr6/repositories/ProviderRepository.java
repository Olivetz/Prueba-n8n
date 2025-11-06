package com.services.providersgr6.repositories;

import com.services.providersgr6.models.Provider;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProviderRepository extends MongoRepository<Provider, String> {
    @Query("{'name': {'$regex': ?0}}")
    List<Provider> findByRegexName(String regexp);

    //@Query("{'name' : :#{#name}}")
    //List<Provider> findByNamePrueba9(@Param("name") String name);
}
