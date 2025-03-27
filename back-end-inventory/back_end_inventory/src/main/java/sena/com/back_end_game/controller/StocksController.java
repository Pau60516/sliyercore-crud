package sena.com.back_end_game.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import sena.com.back_end_game.DTO.StocksDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.Service.StocksService;

@RestController
@RequestMapping("/api/v1/stocks")
public class StocksController {

    /*
     * GET
     * POST(REGISTER)
     * PUT
     * DELETE
     */
    @Autowired
    private StocksService stocksService;

    @PostMapping("/")
    public ResponseEntity<Object> registerStocks(@RequestBody StocksDTO stocks) {
        responseDTO respuesta = stocksService.save(stocks);
        return new ResponseEntity<>(respuesta, HttpStatus.OK);
    }

    @GetMapping("/")
    public ResponseEntity<Object> getAllStocks() {
        var listaStocks = stocksService.findAll();
        return new ResponseEntity<>(listaStocks, HttpStatus.OK);
    }

    /*
     * Se requiere un dato, el ID
     * PathVariable=captura de información por la URL
     */
    @GetMapping("/{id}")
    public ResponseEntity<Object> getOneStocks(@PathVariable int id) {
        var stocks = stocksService.findById(id);
        if (!stocks.isPresent()) {
            return new ResponseEntity<>("Stocks not found", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(stocks, HttpStatus.OK);
    }
}
