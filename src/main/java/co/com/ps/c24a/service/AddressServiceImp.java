package co.com.ps.c24a.service;

import co.com.ps.c24a.entity.Address;
import co.com.ps.c24a.repository.AddressRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AddressServiceImp implements AddressService{

    private final AddressRepository addressRepository;

    @Override
    public String defaultWelcome(){
        return "Welcome to my first crud in java.";
    }

    @Override
    public List<Address> getAddressByPersonId(Long id) {
        List<Address> tmp = new ArrayList<>();
        addressRepository.findAll().forEach(address -> {
            if (address.getPersonId().equals(id)) {
                tmp.add(address);
            }
        });
        return tmp;
    }

    @Override
    public Address saveAddress(Address address) {
        if(address.getPersonId() == null || address.getPersonId() <= 0){
            throw new RuntimeException("Required person_id");
        }
        if(address.getCity() == null || address.getCity().trim().isEmpty()){
            throw new RuntimeException("Required city");
        }
        return addressRepository.save(address);
    }

    @Override
    public Address updateAddress(Long id, Address address) {
        if(!addressRepository.existsById(id)){
            throw new RuntimeException("ID " + id + " not found");
        }
        if(address.getPersonId() == null || address.getPersonId() <= 0){
            throw new RuntimeException("Required person_id");
        }
        if(address.getCity() == null || address.getCity().trim().isEmpty()){
            throw new RuntimeException("Required city");
        }
        address.setId(id);
        return addressRepository.save(address);
    }

    @Override
    public String deleteAddress(Long id) {
        if(!addressRepository.existsById(id)){
            throw new RuntimeException("ID " + id + "not found");
        }
        addressRepository.deleteById(id);

        return "Item ID "+id+" successfully deleted.";
    }

}