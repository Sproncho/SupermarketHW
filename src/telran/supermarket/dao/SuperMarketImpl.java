package telran.supermarket.dao;

import telran.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class SuperMarketImpl implements SuperMarket,Iterable<Product> {
    ArrayList<Product> productList = new ArrayList<Product>();
    @Override
    public boolean addProduct(Product product) {
        if(findByBarcode(product.getBarCode())  != null){
            return false;
        }
        productList.add(product);
        return true;
    }

    @Override
    public Product removeProduct(long barCode) {
        Product product = findByBarcode(barCode);
        productList.removeIf((Product p) -> p.getBarCode() == barCode);
        return product;
    }

    @Override
    public Product findByBarcode(long barCode) {
        return findProductByPredicate(product -> barCode == product.getBarCode());
    }

    @Override
    public Iterable<Product> findByCategory(String category) {
        return findProductsByPredicate(product -> product.getCategory().equals(category));
    }

    @Override
    public Iterable<Product> findByBrand(String brand) {
        return findProductsByPredicate(product -> product.getBrand().equals(brand));
    }

    @Override
    public Iterable<Product> findProductWithExpDate() {
        return findProductsByPredicate(product -> product.getExpDate().isBefore(LocalDate.now()));
    }

    @Override
    public int skuQuantitu() {
        return productList.size();
    }

    private Product findProductByPredicate(Predicate<Product> predicate){
        for(Product product : productList){
            if(predicate.test(product))
                return product;
        }
        return null;
    }

    private Iterable<Product> findProductsByPredicate(Predicate<Product> predicate){
        ArrayList<Product> res = new ArrayList<>();
        for (Product p :productList){
            if (predicate.test(p))
                res.add(p);
        }
        return res;
    }

    @Override
    public Iterator<Product> iterator() {
        return new Iterator<Product>() {
            int ind = 0;
            @Override
            public boolean hasNext() {
                return ind < productList.size();
            }

            @Override
            public Product next() {
                Product data = productList.get(ind);
                ind++;
                return data;
            }
        };
    }
}
