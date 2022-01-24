package se.Lexicon;

import se.Lexicon.Interfaces.Action;
import se.Lexicon.Interfaces.Conditional;
import se.Lexicon.model.Product;

import java.util.*;

public class App
{
    public static void main( String[] args ) {

        List<Product> products = new ArrayList(Arrays.asList(
                new Product("Car1", 300, 0),
                new Product("Car2", 100, 3),
                new Product("Car3", 0, 13),
                new Product("Car4", 300, 50),
                new Product("Car5", 3000, 66),
                new Product("Truck1", 500, 0),
                new Product("Truck2", 30, 7),
                new Product("Truck3", 50, 1)
        ));
        Action print = p -> System.out.println(p.toString());

        Conditional stockValue0 = p -> p.getStock()==0;
        System.out.println("\n* The products that have stock value of 0");
        iterate(products, stockValue0, print);

        Conditional nameStartWithC = p -> p.getProductName().toLowerCase().startsWith("c");
        System.out.println("\n* The products that start with C");
        iterate(products, nameStartWithC, print);

        Conditional priceAbove100Less300 = p -> p.getPrice() <= 300 && p.getPrice() >= 100;
        System.out.println("\n* The products that have price above 100 AND lower than 150:");
        iterate( products, priceAbove100Less300, print);

        Conditional stockLess10AndAbove0 = p -> p.getStock()>=0&& p.getStock()<=10;
        Action Increase = p->p.setPrice(p.getPrice()+p.getPrice()*0.5);
        iterate(products, stockLess10AndAbove0,Increase);
        System.out.println("\n* the price of products that have a stock value of less than 10 AND above 0, was increased by 50%:");

    }


    static void iterate(Collection<Product>products, Conditional conditional, Action action){
        for (Product product: products) {
            if (conditional.test(product)) {
                action.execute(product);
            }
        }
    }



}
