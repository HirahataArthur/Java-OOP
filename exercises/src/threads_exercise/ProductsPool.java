package threads_exercise;

public class ProductsPool {
    private final int products_amount;
    public ProductsPool(int products_amount) throws InterruptedException{
        if (products_amount < 1){
            throw new IllegalArgumentException("Invalid arguments in ProductsPool constructor.");
        }else {
            this.products_amount = products_amount;
        }
    }

    public int getProducts(int nr_products){
        return 1; // placeholder
    }
}
