package telran.supermarket.controller;

import telran.supermarket.dao.SuperMarketImpl;
import telran.supermarket.model.Product;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Controller {
    public static void main(String[] args) {
        SuperMarketImpl superMarket = new SuperMarketImpl();
        superMarket.addProduct(new Product(213213,"Bread","Food","Hlebniy Dom",210, LocalDate.of(2021,12,1)));
        superMarket.addProduct(new Product(213214,"Meat","Food","Myasnoi Dom",210,LocalDate.of(2021,12,1)));
        superMarket.addProduct(new Product(213213,"Mill","Food","Hlebniy Dom",210,LocalDate.of(2021,12,1)));
        superMarket.addProduct(new Product(213216,"Bicycle","Transport","Cube",210,LocalDate.of(2023,12,1)));
        superMarket.addProduct(new Product(213217,"Table","Furniture","IKEA",210,LocalDate.of(2023,12,1)));
        for (Product p :superMarket){
            System.out.println(p);
        }
        System.out.println("==========================");
        ArrayList<Product> productsWithExpDate = (ArrayList<Product>) superMarket.findProductWithExpDate();
        for (Product p: productsWithExpDate){
            System.out.println(p);
        }
    }
}
