package sena.com.back_end_game.DTO;

import sena.com.back_end_game.model.products;

public class StockDTO {

   private int stock_id;
   private products product;
   private int quantity;

   // Constructor sin parámetros
   public StockDTO() {
   }

   // Constructor con parámetros
   public StockDTO(int stock_id, products product, int quantity) {
      this.stock_id = stock_id;
      this.product = product;
      this.quantity = quantity;
   }

   public int getStock_id() {
      return stock_id;
   }

   public void setStock_id(int stock_id) {
      this.stock_id = stock_id;
   }

   public products getProduct() {
      return product;
   }

   public void setProduct(products product) {
      this.product = product;
   }

   public int getQuantity() {
      return quantity;
   }

   public void setQuantity(int quantity) {
      this.quantity = quantity;
   }
}
