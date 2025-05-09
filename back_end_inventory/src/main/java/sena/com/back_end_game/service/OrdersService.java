package sena.com.back_end_game.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import sena.com.back_end_game.DTO.OrderDTO;
import sena.com.back_end_game.DTO.responseDTO;
import sena.com.back_end_game.model.customers;
import sena.com.back_end_game.model.orders;
import sena.com.back_end_game.repository.IOrders;
import sena.com.back_end_game.repository.ICustomers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class OrdersService {

    @Autowired
    private IOrders orderRepository;

    @Autowired
    private ICustomers customerRepository;

    public List<orders> findAll() {
        return orderRepository.findAll();
    }

    public Optional<orders> findById(int id) {
        return orderRepository.findById(id);
    }

    public responseDTO deleteOrder(int id) {
        Optional<orders> order = findById(id);
        if (!order.isPresent()) {
            return new responseDTO(HttpStatus.OK.toString(), "El registro no existe");
        }
        orderRepository.deleteById(id);
        return new responseDTO(HttpStatus.OK.toString(), "Se eliminó correctamente");
    }

    public responseDTO save(OrderDTO dto) {
        Optional<customers> customer = customerRepository.findById(dto.getCustomerId());
        if (!customer.isPresent()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El cliente no existe");
        }

        if (dto.getStatus().isEmpty()) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El estado no puede estar vacío");
        }

        if (dto.getTotal().compareTo(BigDecimal.ZERO) < 0) {
            return new responseDTO(HttpStatus.BAD_REQUEST.toString(), "El total no puede ser negativo");
        }

        orders entity = convertToModel(dto, customer.get());
        orderRepository.save(entity);
        return new responseDTO(HttpStatus.OK.toString(), "Se guardó correctamente");
    }

    public OrderDTO convertToDTO(orders entity) {
        return new OrderDTO(
            entity.getorder_id(),
            entity.get_customer().getcustomerss_id(),
            entity.get_date(),
            entity.get_total(),
            entity.get_status()
        );
    }

    public orders convertToModel(OrderDTO dto, customers customer) {
        return new orders(
            dto.getOrderId(),
            customer,
            dto.getDate(),
            dto.getTotal(),
            dto.getStatus()
        );
    }
}