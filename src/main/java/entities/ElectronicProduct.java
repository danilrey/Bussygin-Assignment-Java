package entities;

public final class ElectronicProduct extends Product {
    private int warrantyPeriod;

    public ElectronicProduct(String name, int warrantyPeriod) {
        super(name);
        this.warrantyPeriod = warrantyPeriod;
    }
    public int getWarrantyPeriod() {
        return warrantyPeriod;
    }

    public void setWarrantyPeriod(int warrantyPeriod) {
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
