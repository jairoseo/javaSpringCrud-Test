package co.com.ps.c24a.service;

import co.com.ps.c24a.entity.Address;

import java.util.List;

public interface AddressService {

    String defaultWelcome();
    List<Address> getAddressByPersonId(Long id);
    Address saveAddress(Address address);
    Address updateAddress(Long id, Address address);
    String deleteAddress(Long id);

}