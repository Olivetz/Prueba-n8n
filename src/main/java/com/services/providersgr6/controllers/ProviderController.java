package com.services.providersgr6.controllers;

import com.services.providersgr6.models.Provider;
import com.services.providersgr6.repositories.ProviderRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ProviderController {

    private final ProviderRepository providerRepository;

    public ProviderController(ProviderRepository providerRepository) {
        this.providerRepository = providerRepository;
    }

    @PostMapping("/providers")
    Provider newProvider(@RequestBody Provider provider){
        return providerRepository.save(provider);
    }

    @GetMapping("/providers")
    List<Provider> getAllProviders(@RequestParam("name") Optional<String> name){
        if(name.isPresent()){
            return providerRepository.findByRegexName(name.get());
        }
        else{
            return providerRepository.findAll();
        }
    }

    @GetMapping("/providers/{id}")
    Provider getProvider(@PathVariable("id") String id){
        Provider provider = providerRepository.findById(id).orElse(null);

        if(provider == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay ningun proeevedor asociado al id " + id);
        }

        return provider;
    }

    @PutMapping("/providers/{id}")
    Provider changeProvider(@PathVariable String id, @RequestBody Provider newProvider){
        Provider oldProvider = providerRepository.findById(id).orElse(null);

        if(oldProvider == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay ningun proeevedor asociado al id " + id);
        }
        if(oldProvider.getName() != newProvider.getName() && newProvider.getName() != null){
            oldProvider.setName(newProvider.getName());
        }
        if(oldProvider.getTip_document() != newProvider.getTip_document() && newProvider.getTip_document() != null){
            oldProvider.setTip_document(newProvider.getTip_document());
        }
        if(oldProvider.getNum_document() != newProvider.getNum_document() && newProvider.getNum_document() != null){
            oldProvider.setNum_document(newProvider.getNum_document());
        }
        if(oldProvider.getCity() != newProvider.getCity() && newProvider.getCity() != null){
            oldProvider.setCity(newProvider.getCity());
        }
        if(oldProvider.getAddress() != newProvider.getAddress() && newProvider.getAddress() != null){
            oldProvider.setAddress(newProvider.getAddress());
        }
        if(oldProvider.getPhone_num() != newProvider.getPhone_num() && newProvider.getPhone_num() != null){
            oldProvider.setPhone_num(newProvider.getPhone_num());
        }
        if(oldProvider.getMobile_num() != newProvider.getMobile_num() && newProvider.getMobile_num() != null){
            oldProvider.setMobile_num(newProvider.getMobile_num());
        }
        if(oldProvider.getSocial_security() != newProvider.getSocial_security() && newProvider.getSocial_security() != null){
            oldProvider.setSocial_security(newProvider.getSocial_security());
        }
        if(oldProvider.getValue() != newProvider.getValue() && newProvider.getValue() != null){
            oldProvider.setValue(newProvider.getValue());
        }
        if(oldProvider.getPassword() != newProvider.getPassword() && newProvider.getPassword() != null){
            oldProvider.setPassword(newProvider.getPassword());
        }
        if(oldProvider.getTip_user() != newProvider.getTip_user() && newProvider.getTip_user() != null){
            oldProvider.setTip_user(newProvider.getTip_user());
        }

        if (newProvider.getId() != null) {
            if (!newProvider.getId().isEmpty() && (oldProvider.getId() != newProvider.getId())) {
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No tienes autorizacion de modificar otro usuario");
            }
        }

        providerRepository.save(oldProvider);

        return oldProvider;
    }

    @DeleteMapping("/providers/{id}")
    Provider deleteProvider(@PathVariable("id") String id){
        Provider provider = providerRepository.findById(id).orElse(null);

        if(provider == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "No hay ningun proeevedoor asociado al id " + id);
        }

        providerRepository.delete(provider);
        return provider;
    }


}
