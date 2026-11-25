
package product;

import component.CartComponent;
import visitor.ProductVisitor;

public abstract class Product implements CartComponent {

    private String aName;
    private long aPrice;
    private int aQuantity;

    public Product(String pName, long pPrice, int pQuantity) {
        this.aName = pName;
        this.aPrice = pPrice;
        this.aQuantity = pQuantity;
    }

    public String getName() {
        return aName;
    }

    public long getPrice() {
        return aPrice;
    }

    public int getQuantity() {
        return aQuantity;
    }

    // Tính thành tiền của sản phẩm
    public long getSubtotal() {
        return aPrice * aQuantity;
    }

    @Override
    public abstract void accept(ProductVisitor visitor);
}
