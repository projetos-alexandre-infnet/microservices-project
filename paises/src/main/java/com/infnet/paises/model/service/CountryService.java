package com.infnet.paises.model.service;

import com.infnet.paises.model.entities.Country;
import com.infnet.paises.model.repository.CountryRepository;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    private CountryRepository repository;

    public CountryService(CountryRepository repository) {
        this.repository = repository;
    }

    public String findByCountryName(String name) {
        Country countryFounded = repository.findByName(name);
        return countryFounded.getPhoneCode();
    }
}
