package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.CustomersDTO;
import sena.com.back_end_game.model.Customers;
import sena.com.back_end_game.repository.ICustomers;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private ICustomers data;

    public List<Customers> findAll() {
        return data.findAll();
    }

    public Optional<Customers> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteCustomer(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The customer does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Customer deleted successfully");
    }

    public responseDTO save(CustomersDTO customersDTO) {
        if (customersDTO.getName().length() < 1 || customersDTO.getName().length() > 50) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "The customer name must be between 1 and 50 characters");
        }
        Customers customer = convertToModel(customersDTO);
        data.save(customer);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Customer saved successfully");
    }

    public CustomersDTO convertToDTO(Customers customer) {
        return new CustomersDTO(
                customer.get_name(),
                customer.get_email(),
                customer.get_address(),
                customer.get_phone());
    }

    public Customers convertToModel(CustomersDTO customersDTO) {
        return new Customers(
                0,
                customersDTO.getName(),
                customersDTO.getEmail(),
                customersDTO.getAddress(),
                customersDTO.getPhone());
    }
}
