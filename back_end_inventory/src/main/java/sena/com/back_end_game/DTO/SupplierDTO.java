package sena.com.back_end_game.DTO;

public class SupplierDTO {

   private int supplier_id;
   private String name;
   private String country;
   private String phone;

   // Constructor sin parámetros
   public SupplierDTO() {
   }

   // Constructor con parámetros
   public SupplierDTO(int supplier_id, String name, String country, String phone) {
      this.supplier_id = supplier_id;
      this.name = name;
      this.country = country;
      this.phone = phone;
   }

   public int getSupplier_id() {
      return supplier_id;
   }

   public void setSupplier_id(int supplier_id) {
      this.supplier_id = supplier_id;
   }

   public String getName() {
      return name;
   }

   public void setName(String name) {
      this.name = name;
   }

   public String getCountry() {
      return country;
   }

   public void setCountry(String country) {
      this.country = country;
   }

   public String getPhone() {
      return phone;
   }

   public void setPhone(String phone) {
      this.phone = phone;
   }
}
