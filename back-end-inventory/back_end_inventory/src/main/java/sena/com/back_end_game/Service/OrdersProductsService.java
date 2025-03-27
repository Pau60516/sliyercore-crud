package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.OrdersProductsDTO;
import sena.com.back_end_game.model.OrdersProducts;
import sena.com.back_end_game.repository.IOrdersProducts;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersProductsService {

    @Autowired
    private IOrdersProducts data;

    public List<OrdersProducts> findAll() {
        return data.findAll();
    }

    public Optional<OrdersProducts> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteOrderProduct(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The order product does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Order product deleted successfully");
    }

    public responseDTO save(OrdersProductsDTO ordersProductsDTO) {
        if (ordersProductsDTO.getQuantity() < 1) {
            return new responseDTO(
                    HttpStatus.BAD_REQUEST.toString(),
                    "Quantity must be at least 1");
        }
        OrdersProducts orderProduct = convertToModel(ordersProductsDTO);
        data.save(orderProduct);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Order product saved successfully");
    }

    public OrdersProductsDTO convertToDTO(OrdersProducts orderProduct) {
        return new OrdersProductsDTO(
                orderProduct.getOrderProductId(),
                orderProduct.get_order(),
                orderProduct.get_product(),
                orderProduct.get_quantity(),
                orderProduct.get_unitPrice());
    }

    public OrdersProducts convertToModel(OrdersProductsDTO ordersProductsDTO) {
        return new OrdersProducts(
                ordersProductsDTO.getOrderProductId(),
                ordersProductsDTO.getOrder(),
                ordersProductsDTO.getProduct(),
                ordersProductsDTO.getQuantity(),
                ordersProductsDTO.getUnitPrice());
    }
}

    

