
package visitor;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;
import component.CartComponent;

public class ReceiptVisitor implements ProductVisitor {

    private StringBuilder aReceipt = new StringBuilder();

    private String formatMoney(long pAmount) {
        return String.format("%,d", pAmount)
                .replace(',', '.') + " VNĐ";
    }

    @Override
    public void visitBook(Book pBook) {
        appendProduct(pBook, "Book");
    }

    @Override
    public void visitElectronics(Electronics pElectronics) {
        appendProduct(pElectronics, "Electronics");
    }

    @Override
    public void visitClothing(Clothing pClothing) {
        appendProduct(pClothing, "Clothing");
    }

    private void appendProduct(
            product.Product pProduct,
            String pType) {

        aReceipt.append(String.format(
            "%-15s | %-20s | SL: %d | Don gia: %s | Thanh tien: %s%n",
            pType,
            pProduct.getName(),
            pProduct.getQuantity(),
            formatMoney(pProduct.getPrice()),
            formatMoney(pProduct.getSubtotal())
        ));
    }

    @Override
    public void visitProductBundle(ProductBundle pBundle) {

        aReceipt.append("\n[Nhom san pham: ")
                .append(pBundle.getName())
                .append("]\n");

        for (CartComponent item : pBundle.getChildren()) {
            item.accept(this);
        }
    }

    public String getReceipt() {
        return aReceipt.toString();
    }
}
