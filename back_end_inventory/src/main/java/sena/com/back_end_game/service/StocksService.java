package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.StockDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.stocks;
import sena.com.back_end_game.repository.IStocks;
import sena.com.back_end_game.repository.IProducts;

import java.util.List;
import java.util.Optional;

@Service
public class StocksService {

    @Autowired
    private IStocks stockRepository;

    @Autowired
    private IProducts productRepository;

    // Obtener todos los registros de stocks
    public List<stocks> findAll() {
        return stockRepository.findAll();
    }

    // Obtener un stock por su ID
    public Optional<stocks> findById(int id) {
        return stockRepository.findById(id);
    }

    // Eliminar un stock
    public responseDTO deleteStock(int id) {
        Optional<stocks> stock = findById(id);
        if (!stock.isPresent()) {
            return new responseDTO(HttpStatus.NOT_FOUND.toString(), "El stock no existe");
        }
        stockRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Stock eliminado correctamente");
    }

    // Guardar o actualizar un stock
    public responseDTO save(StockDTO dto) {
        Optional<products> product = productRepository.findById(dto.getProduct().getproduct_Id());
        if (!product.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El producto no existe");
        }

        // Convertir el DTO en una entidad 'stocks' y guardarla
        stocks entity = convertToModel(dto, product.get());
        stockRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Stock guardado correctamente");
    }

    // Convertir la entidad 'stocks' en un DTO
    public StockDTO convertToDTO(stocks entity) {
        return new StockDTO(
                entity.getstock_id(),
                entity.get_product(),
                entity.get_quantity()
        );
    }

    // Convertir un DTO en una entidad 'stocks'
    public stocks convertToModel(StockDTO dto, products product) {
        return new stocks(
                dto.getStock_id(),
                product,
                dto.getQuantity()
        );
    }
}
