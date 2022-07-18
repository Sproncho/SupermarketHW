package telran.supermarket.dao;

import telran.supermarket.model.Product;

public interface SuperMarket {
    public boolean addProduct(Product product);
    public Product removeProduct(long barCode);
    public Product findByBarcode(long barCode);
    Iterable<Product> findByCategory(String category);
    Iterable<Product> findByBrand(String brand);
    Iterable<Product> findProductWithExpDate();
    int skuQuantitu();
}
