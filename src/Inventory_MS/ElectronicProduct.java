package Inventory_MS;

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
    public void getInfo() {
        super.getInfo();
        System.out.println("Warranty period: " + warrantyPeriod + " months");
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
