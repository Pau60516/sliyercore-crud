package sena.com.back_end_game.DTO;

public class BrandsDTO {

        private String name;
    
        private String originCountry;
    
        public BrandsDTO(String name, String originCountry) {
            this.name = name;
            this.originCountry = originCountry;

        }
    
        public String get_name() {
            return name;
        }
    
        public void set_name(String name) {
            this.name = name;
        }
    
        public String get_originCountry() {
            return originCountry;
        }
    
        public void set_originCountry(String originCountry) {
            this.originCountry = originCountry;
        }
    
}
