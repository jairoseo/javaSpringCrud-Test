import co.com.ps.c24a.entity.Address;
import co.com.ps.c24a.repository.AddressRepository;
import co.com.ps.c24a.service.AddressService;
import co.com.ps.c24a.service.AddressServiceImp;
import org.checkerframework.checker.units.qual.A;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

public class AddressServiceTest {

    @Mock
    private AddressRepository addressRepository;

    @InjectMocks
    private AddressServiceImp addressService;

    @BeforeEach
    void setUp(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void testGetAddressByPersonId(){
        Address address = new Address();
        address.setPersonId(1L);
        address.setCity("Alabama");

        List<Address> addresses = new ArrayList<>();
        addresses.add(address);

        when(addressRepository.findAll()).thenReturn(addresses);

        List<Address> result = addressService.getAddressByPersonId(1L);

        assertNotNull(result);
        assertEquals(1L, result.get(0).getPersonId());
        assertEquals("Alabama", result.get(0).getCity());

        verify(addressRepository, times(1)).findAll();
    }

    @Test
    void testUpdateAddress(){
        Address address = new Address();
        address.setPersonId(1L);
        address.setCity("Alabama");

        when(addressRepository.existsById(2L)).thenReturn(true);
        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address result = addressService.updateAddress(2L,address);

        assertNotNull(result);

        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void testSaveAddress(){
        Address address = new Address();
        address.setPersonId(1L);
        address.setCity("Miami");

        when(addressRepository.save(any(Address.class))).thenReturn(address);

        Address result = addressService.saveAddress(address);
        assertNotNull(result);
        assertEquals(1L, result.getPersonId());
        assertEquals("Miami", result.getCity());

        verify(addressRepository, times(1)).save(address);
    }

    @Test
    void testDeleteAddress(){
        when(addressRepository.existsById(2L)).thenReturn(true);
        doNothing().when(addressRepository).deleteById(2L);

        addressService.deleteAddress(2L);
        verify(addressRepository, times(1)).existsById(2L);
        verify(addressRepository, times(1)).deleteById(2L);
    }

    @Test
    void testDeleteAddress_NotFound(){

        when(addressRepository.existsById(2L)).thenReturn(false);

        assertThrows(RuntimeException.class, () -> addressService.deleteAddress(2L));
        verify(addressRepository, times(1)).existsById(2L);
        verify(addressRepository, never()).deleteById(2L);
    }

}
