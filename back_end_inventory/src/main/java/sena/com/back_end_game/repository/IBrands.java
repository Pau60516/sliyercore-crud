package sena.com.back_end_game.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sena.com.back_end_game.model.brands;
import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.suppliers;

import java.util.List;

public interface IBrands extends JpaRepository<brands, Integer> {

    @Query("SELECT ps.product FROM productssuppliers ps JOIN ps.product p JOIN ps.supplier s WHERE s.supplier_id = :supplierId")
    List<products> findProductsBySupplierId(@Param("supplierId") int supplierId);

    @Query("SELECT ps.supplier FROM productssuppliers ps JOIN ps.supplier s JOIN ps.product p WHERE p.product_Id = :productId")
    List<suppliers> findSuppliersByProductId(@Param("productId") int productId);
}
