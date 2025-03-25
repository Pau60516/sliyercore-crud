package sena.com.back_end_game.DTO;

public class CategoriesDTO {
  
    private String name;
    
    private String description;

    public CategoriesDTO(String name, String description) {
        this.name = name;
        this.description = description;

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public String getdescription() {
        return description;
    }

    public void setdescription(String description) {
        this.description = description;
    }
    
}
