package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because...
// Order would not make sense here

public class PhysicalProduct extends Product implements Discountable
{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    PhysicalProduct() {}

    PhysicalProduct(Long id, String name, double price,
                    double weightKg, String dimensions)
    {
        super(id, name, price);
        this.weightKg = weightKg;
        this.dimensions = dimensions;
    }

    @Override
    public String getSummary() { return "Physical: " + getName() + " | Weight: " + getWeightKg() + "kg"; }

    public double getWeightKg() { return weightKg; }
    public String getDimensions() { return dimensions; }

    @Override
    public void applyDiscount(double rate) { discountedPrice = getPrice() * (1 - Math.min(0.20, rate)); }

    @Override
    public double getDiscountedPrice() { return discountedPrice; }
}
