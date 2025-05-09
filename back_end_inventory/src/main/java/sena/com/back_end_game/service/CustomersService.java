package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.CustomerDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.customers;
import sena.com.back_end_game.repository.ICustomers;

import java.util.List;
import java.util.Optional;

@Service
public class CustomersService {

    @Autowired
    private ICustomers data;

    public List<customers> findAll() {
        return data.findAll();
    }

    public Optional<customers> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteCustomer(int id) {
        Optional<customers> customer = findById(id);
        if (!customer.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "El registro no existe");
        }
        data.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public responseDTO save(CustomerDTO dto) {
        if (dto.getName().length() < 1 || dto.getName().length() > 100) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El nombre debe estar entre 1 y 100 caracteres");
        }

        if (dto.getEmail().length() < 1 || dto.getEmail().length() > 50) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El correo debe estar entre 1 y 50 caracteres");
        }

        customers entity = convertToModel(dto);
        data.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public CustomerDTO convertToDTO(customers entity) {
        return new CustomerDTO(
            entity.getcustomerss_id(),
            entity.get_name(),
            entity.get_email(),
            entity.get_address(),
            entity.get_phone()
        );
    }

    public customers convertToModel(CustomerDTO dto) {
        return new customers(
            dto.getCustomerId(),
            dto.getName(),
            dto.getEmail(),
            dto.getAddress(),
            dto.getPhone()
        );
    }
}
