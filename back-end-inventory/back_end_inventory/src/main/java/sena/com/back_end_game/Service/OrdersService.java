package sena.com.back_end_game.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import sena.com.back_end_game.DTO.OrdersDTO;
import sena.com.back_end_game.DTO.CustomersDTO;
import sena.com.back_end_game.model.Orders;
import sena.com.back_end_game.model.Customers;
import sena.com.back_end_game.repository.IOrders;
import sena.com.back_end_game.DTO.responseDTO;

import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private IOrders data;

    public List<Orders> findAll() {
        return data.findAll();
    }

    public Optional<Orders> findById(int id) {
        return data.findById(id);
    }

    public responseDTO deleteOrder(int id) {
        if (!findById(id).isPresent()) {
            return new responseDTO(
                    HttpStatus.NOT_FOUND.toString(),
                    "The order does not exist");
        }
        data.deleteById(id);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Order deleted successfully");
    }

    public responseDTO save(OrdersDTO ordersDTO) {
        Orders order = convertToModel(ordersDTO);
        data.save(order);
        return new responseDTO(
                HttpStatus.OK.toString(),
                "Order saved successfully");
    }

    public OrdersDTO convertToDTO(Orders order) {
        return new OrdersDTO(
                order.getorder_id(),
                new CustomersDTO(
                        order.get_customer().get_name(),
                        order.get_customer().get_email(),
                        order.get_customer().get_address(),
                        order.get_customer().get_phone()),
                order.get_date(),
                order.get_total(),
                order.get_status()
        );
    }

    public Orders convertToModel(OrdersDTO ordersDTO) {
        return new Orders(
                0,
                new Customers(
                        0,
                        ordersDTO.getCustomer().getName(),
                        ordersDTO.getCustomer().getEmail(),
                        ordersDTO.getCustomer().getAddress(),
                        ordersDTO.getCustomer().getPhone()),
                ordersDTO.getDate(),
                ordersDTO.getTotal(),
                ordersDTO.getStatus()
        );
    }
}



