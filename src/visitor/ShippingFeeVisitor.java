
package visitor;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;
import component.CartComponent;

public class ShippingFeeVisitor implements ProductVisitor {

    private long aFee = 0;

    @Override
    public void visitBook(Book pBook) {

        // Tổng trọng lượng = trọng lượng x số lượng
        long totalWeight =
                (long) pBook.getWeightGrams()
                * pBook.getQuantity();

        // Mỗi 500 gram tính 5.000 VNĐ, làm tròn lên
        long units = (totalWeight + 499) / 500;

        aFee += units * 5000;
    }

    @Override
    public void visitElectronics(Electronics pElectronics) {
        aFee += 30000L * pElectronics.getQuantity();
    }

    @Override
    public void visitClothing(Clothing pClothing) {
        aFee += 15000L * pClothing.getQuantity();
    }

    @Override
    public void visitProductBundle(ProductBundle pBundle) {

        // Duyệt nhóm và tính phí cho từng thành phần
        for (CartComponent item : pBundle.getChildren()) {
            item.accept(this);
        }
    }

    public long getFee() {
        return aFee;
    }
}
