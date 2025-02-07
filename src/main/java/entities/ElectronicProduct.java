package entities;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public final class ElectronicProduct extends Product {
    private int warrantyPeriod;

    public ElectronicProduct(String name, int warrantyPeriod) {
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }


    @Override
    public String toString() {
        return "ElectronicProduct {" +
                "name='" + getName() + '\'' +
                ", price=" + getPrice() +
                ", quantity=" + getQuantity() +
                ", warrantyPeriod=" + getWarrantyPeriod() +
                '}';
    }

}
