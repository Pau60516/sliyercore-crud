package sena.com.back_end_game.DTO;


public class BrandDTO {

    private int brandId;
    private String name;
    private String originCountry;

    public BrandDTO() {
    }

    public BrandDTO(int brandId, String name, String originCountry) {
        this.brandId = brandId;
        this.name = name;
        this.originCountry = originCountry;
    }

    public int getBrandId() {
        return brandId;
    }

    public void setBrandId(int brandId) {
        this.brandId = brandId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOriginCountry() {
        return originCountry;
    }

    public void setOriginCountry(String originCountry) {
        this.originCountry = originCountry;
    }
}

