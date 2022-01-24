package se.Lexicon.Interfaces;

import se.Lexicon.model.Product;

@FunctionalInterface
public interface Conditional {
    boolean test(Product product);
}
