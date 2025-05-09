package sena.com.back_end_game.DTO;

public class responseDTO {

    private String status; // Estado HTTP como String
    private String message; // Mensaje de la respuesta

    // Constructor
    public responseDTO(String status, String message) {
        this.status = status;
        this.message = message;
    }

    // Getters y Setters
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

}
