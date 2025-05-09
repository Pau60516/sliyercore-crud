package sena.com.back_end_game.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sena.com.back_end_game.model.products;
import sena.com.back_end_game.model.productsSuppliers;
import sena.com.back_end_game.model.suppliers;

public interface IProductsSuppliers extends JpaRepository <productsSuppliers,Integer>{

    /*
     * C
     * R
     * U
     * D
     */

    @Query("SELECT ps.product FROM productssuppliers ps WHERE ps.supplier.supplier_id = :supplierId")
    List<products> findProductsBySupplierId(@Param("supplierId") int supplierId);

    @Query("SELECT ps.supplier FROM productssuppliers ps WHERE ps.product.product_Id = :productId")
    List<suppliers> findSuppliersByProductId(@Param("productId") int productId);
}