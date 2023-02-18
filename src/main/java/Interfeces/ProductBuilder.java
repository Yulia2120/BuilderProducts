package Interfeces;

import Models.Product;

public interface ProductBuilder {

    public ProductBuilder addCategory();
    public ProductBuilder addCompany();
    public Product create();
}
