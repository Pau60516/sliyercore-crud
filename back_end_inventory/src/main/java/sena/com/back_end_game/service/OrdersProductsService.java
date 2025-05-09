package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.OrderProductDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.ordersProducts;
import sena.com.back_end_game.model.orders;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.repository.IOrdersProducts;
import sena.com.back_end_game.repository.IOrders;
import sena.com.back_end_game.repository.IProducts;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersProductsService {

    @Autowired
    private IOrdersProducts ordersProductsRepository;

    @Autowired
    private IOrders ordersRepository;

    @Autowired
    private IProducts productsRepository;

    public List<ordersProducts> findAll() {
        return ordersProductsRepository.findAll();
    }

    public Optional<ordersProducts> findById(int id) {
        return ordersProductsRepository.findById(id);
    }

    public responseDTO deleteOrderProduct(int id) {
        Optional<ordersProducts> orderProduct = findById(id);
        if (!orderProduct.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "El registro no existe");
        }
        ordersProductsRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public responseDTO save(OrderProductDTO dto) {
        Optional<orders> order = ordersRepository.findById(dto.getOrderId());
        if (!order.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La orden no existe");
        }

        Optional<products> product = productsRepository.findById(dto.getProductId());
        if (!product.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El producto no existe");
        }

        if (dto.getQuantity() <= 0) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "La cantidad debe ser mayor a 0");
        }

        if (dto.getUnitPrice().compareTo(BigDecimal.ZERO) < 0) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El precio unitario no puede ser negativo");
        }

        ordersProducts entity = convertToModel(dto, order.get(), product.get());
        ordersProductsRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public OrderProductDTO convertToDTO(ordersProducts entity) {
        return new OrderProductDTO(
            entity.getOrderProductId(),
            entity.get_order().getorder_id(),
            entity.get_product().getproduct_Id(),
            entity.get_quantity(),
            entity.get_unitPrice()
        );
    }

    public ordersProducts convertToModel(OrderProductDTO dto, orders order, products product) {
        return new ordersProducts(
            dto.getOrderProductId(),
            order,
            product,
            dto.getQuantity(),
            dto.getUnitPrice()
        );
    }
}