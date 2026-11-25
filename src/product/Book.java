
package product;

import visitor.ProductVisitor;

public class Book extends Product {

    private String aAuthor;
    private int aWeightGrams;

    public Book(
            String pName,
            long pPrice,
            int pQuantity,
            String pAuthor,
            int pWeightGrams) {

        super(pName, pPrice, pQuantity);

        this.aAuthor = pAuthor;
        this.aWeightGrams = pWeightGrams;
    }

    public String getAuthor() {
        return aAuthor;
    }

    public int getWeightGrams() {
        return aWeightGrams;
    }

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visitBook(this);
    }
}
