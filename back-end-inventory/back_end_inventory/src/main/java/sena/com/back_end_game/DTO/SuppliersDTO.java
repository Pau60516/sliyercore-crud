package sena.com.back_end_game.DTO;

public class SuppliersDTO {

    private int supplierId;
    private String name;
    private String country;
    private String phone;

    public SuppliersDTO(int supplierId, String name, String country, String phone) {
        this.supplierId = supplierId;
        this.name = name;
        this.country = country;
        this.phone = phone;
    }

    public int getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(int supplierId) {
        this.supplierId = supplierId;
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



