package sena.com.back_end_game.Service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.SuppliersDTO;
import sena.com.back_end_game.model.Suppliers;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    private final List<Suppliers> suppliersList = new ArrayList<>();

    public List<Suppliers> findAll() {
        return suppliersList;
    }

    public Optional<Suppliers> findById(int id) {
        return suppliersList.stream().filter(s -> s.getSupplier_Id() == id).findFirst();
    }

    public responseDTO deleteSupplier(int id) {
        Optional<Suppliers> supplier = findById(id);
        if (!supplier.isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The supplier does not exist");
        }
        suppliersList.remove(supplier.get());
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Supplier deleted successfully");
    }

    public responseDTO save(SuppliersDTO suppliersDTO) {
        Suppliers supplier = convertToModel(suppliersDTO);
        suppliersList.add(supplier);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Supplier saved successfully");
    }

    public SuppliersDTO convertToDTO(Suppliers supplier) {
        return new SuppliersDTO(
                supplier.getSupplier_Id(),
                supplier.getName(),
                supplier.getCountry(),
                supplier.getPhone());
    }

    public Suppliers convertToModel(SuppliersDTO suppliersDTO) {
        return new Suppliers(
                suppliersDTO.getSupplierId(),
                suppliersDTO.getName(),
                suppliersDTO.getCountry(),
                suppliersDTO.getPhone());
    }
}