package se.Lexicon.Interfaces;

import se.Lexicon.model.Product;

@FunctionalInterface
public interface Action {

    void execute(Product product);
}
