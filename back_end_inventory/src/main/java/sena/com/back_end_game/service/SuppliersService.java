package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.SupplierDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.suppliers;
import sena.com.back_end_game.repository.ISuppliers;

import java.util.List;
import java.util.Optional;

@Service
public class SuppliersService {

    @Autowired
    private ISuppliers data;

    // Buscar todos los registros
    public List<suppliers> findAll() {
        return data.findAll();
    }

    // Buscar un registro por su ID
    public Optional<suppliers> findById(int id) {
        return data.findById(id);
    }

    // Eliminar un proveedor
    public responseDTO deleteSupplier(int id) {
        Optional<suppliers> supplier = findById(id);
        if (!supplier.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(), "El proveedor no existe");
        }
        data.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Proveedor eliminado correctamente");
    }

    // Guardar o actualizar un proveedor
    public responseDTO save(SupplierDTO dto) {
        if (dto.getName().length() < 1 || dto.getName().length() > 150) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El nombre debe estar entre 1 y 150 caracteres");
        }

        if (dto.getPhone().length() < 1 || dto.getPhone().length() > 20) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El teléfono debe estar entre 1 y 20 caracteres");
        }

        suppliers supplier = convertToModel(dto);
        data.save(supplier);
        return new responseDTO(HttpStatus.OK.toString(), "Proveedor guardado correctamente");
    }

    // Convertir el modelo de proveedor a DTO
    public SupplierDTO convertToDTO(suppliers supplier) {
        return new SupplierDTO(
                supplier.getSupplier_Id(),
                supplier.getName(),
                supplier.getCountry(),
                supplier.getPhone()
        );
    }

    // Convertir DTO a modelo de proveedor
    public suppliers convertToModel(SupplierDTO dto) {
        return new suppliers(
                dto.getSupplier_id(),
                dto.getName(),
                dto.getCountry(),
                dto.getPhone()
        );
    }
}

