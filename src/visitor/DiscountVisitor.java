
package visitor;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;
import component.CartComponent;

public class DiscountVisitor implements ProductVisitor {

    private long aDiscount = 0;

    @Override
    public void visitBook(Book pBook) {
        aDiscount += pBook.getSubtotal() * 10 / 100;
    }

    @Override
    public void visitElectronics(Electronics pElectronics) {
        aDiscount += pElectronics.getSubtotal() * 5 / 100;
    }

    @Override
    public void visitClothing(Clothing pClothing) {
        aDiscount += pClothing.getSubtotal() * 15 / 100;
    }

    @Override
    public void visitProductBundle(ProductBundle pBundle) {

        // Duyệt nhóm và tính giảm giá cho từng sản phẩm
        for (CartComponent item : pBundle.getChildren()) {
            item.accept(this);
        }
    }

    public long getDiscount() {
        return aDiscount;
    }
}
