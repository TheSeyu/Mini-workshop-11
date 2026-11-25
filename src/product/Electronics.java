
package product;

import visitor.ProductVisitor;

public class Electronics extends Product {

    private int aWarrantyMonths;

    public Electronics(
            String pName,
            long pPrice,
            int pQuantity,
            int pWarrantyMonths) {

        super(pName, pPrice, pQuantity);

        this.aWarrantyMonths = pWarrantyMonths;
    }

    public int getWarrantyMonths() {
        return aWarrantyMonths;
    }

    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visitElectronics(this);
    }
}
