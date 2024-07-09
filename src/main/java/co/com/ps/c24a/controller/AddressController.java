package co.com.ps.c24a.controller;

import co.com.ps.c24a.entity.Address;
import co.com.ps.c24a.service.AddressService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/address")
@RequiredArgsConstructor
public class AddressController {

    private final AddressService addressService;

    @GetMapping
    public String defaultWelcome(){
        return addressService.defaultWelcome();
    }

    @GetMapping("/{id}")
    public List<Address> getAddressByPersonId(@PathVariable Long id){
        return addressService.getAddressByPersonId(id);
    }

    @PostMapping
    public Address saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @PutMapping("/{id}")
    public Address updateAddress(@PathVariable Long id, @RequestBody Address address){
        return addressService.updateAddress(id,address);
    }

    @DeleteMapping("/{id}")
    public String deleteAddress(@PathVariable Long id){
        return addressService.deleteAddress(id);
    }

}
