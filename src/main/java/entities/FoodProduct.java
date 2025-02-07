package entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class FoodProduct extends Product {
    private String expirationDate;

    public FoodProduct(String name, String expirationDate) {
        super(name);
        this.expirationDate = expirationDate;
    }


    @Override
    public String toString() {
        return "FoodProduct {" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", expirationDate='" + getExpirationDate() + '\'' +
                '}';
    }
}
