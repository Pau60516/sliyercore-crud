package sena.com.back_end_game.DTO;

public class BrandsDTO {

        private String name;
    
        private String originCountry;
    
        public BrandsDTO(String name, String originCountry) {
            this.name = name;
            this.originCountry = originCountry;

        }
    
        public String getNombre() {
            return name;
        }
    
        public void setNombre(String name) {
            this.name = name;
        }
    
        public String getoriginCountry() {
            return originCountry;
        }
    
        public void setoriginCountry(String originCountry) {
            this.originCountry = originCountry;
        }
    
}
