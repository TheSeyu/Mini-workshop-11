
package visitor;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;
import component.CartComponent;

public class TotalPriceVisitor implements ProductVisitor {

    private long aTotal = 0;

    @Override
    public void visitBook(Book pBook) {
        aTotal += pBook.getSubtotal();
    }

    @Override
    public void visitElectronics(Electronics pElectronics) {
        aTotal += pElectronics.getSubtotal();
    }

    @Override
    public void visitClothing(Clothing pClothing) {
        aTotal += pClothing.getSubtotal();
    }

    @Override
    public void visitProductBundle(ProductBundle pBundle) {

        // Duyệt các thành phần trong nhóm
        for (CartComponent item : pBundle.getChildren()) {
            item.accept(this);
        }
    }

    public long getTotal() {
        return aTotal;
    }
}
