
package product;

import visitor.ProductVisitor;

public class Clothing extends Product {

    private String aSize;

    public Clothing(
            String pName,
            long pPrice,
            int pQuantity,
            String pSize) {

        super(pName, pPrice, pQuantity);

        this.aSize = pSize;
    }

    public String getSize() {
        return aSize;
    }

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visitClothing(this);
    }
}
