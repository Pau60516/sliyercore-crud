package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.StocksDTO;
import sena.com.back_end_game.model.Stocks;
import sena.com.back_end_game.repository.IStocks;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class StocksService {

    @Autowired
    private IStocks data;

    public List<Stocks> findAll() {
        return data.findAll();
    }

    public Optional<Stocks> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteStock(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The stock record does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Stock record deleted successfully");
    }

    public responseDTO save(StocksDTO stocksDTO) {
        Stocks stock = convertToModel(stocksDTO);
        data.save(stock);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Stock record saved successfully");
    }

    public StocksDTO convertToDTO(Stocks stock) {
        return new StocksDTO(
                stock.getstock_id(),
                stock.get_product(),
                stock.get_quantity());
    }

    public Stocks convertToModel(StocksDTO stocksDTO) {
        return new Stocks(
                stocksDTO.getStockId(),
                stocksDTO.getProduct(),
                stocksDTO.getQuantity());
    }


    }

