package sena.com.back_end_game.DTO;

public class CustomerDTO {

    private int customerId;
    private String name;
    private String email;
    private String address;
    private String phone;

    public CustomerDTO() {
    }

    public CustomerDTO(int customerId, String name, String email, String address, String phone) {
        this.customerId = customerId;
        this.name = name;
        this.email = email;
        this.address = address;
        this.phone = phone;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
