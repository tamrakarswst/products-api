package uk.ac.westminster.products_api;

// A PhysicalProduct IS-A Product because it shares common product properties like id, name, and price.
// A ShoppingCart is NOT a Product because it contains products rather than being a type of product (HAS-A relationship).

public class PhysicalProduct extends Product implements Discountable{
    private double weightKg;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct(){
    }

    public PhysicalProduct(Long id, String name, double price, double weightKg, String dimensions){
        super(id,name,price);
        this.weightKg=weightKg;
        this.dimensions=dimensions;
    }

    public double getWeightKg() {
        return weightKg;
    }
    public String getDimensions(){
        return dimensions;
    }

    @Override
    public String getSummary(){
        return "Physical:"+getName()
                +" | Weight: "+weightKg;
    }
    @Override
    public void applyDiscount(double rate) {
        double capped=Math.min(rate,0.20);
        discountedPrice = getPrice() * (1 - capped);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }

}

