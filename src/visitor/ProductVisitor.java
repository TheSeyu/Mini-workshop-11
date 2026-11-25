
package visitor;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;

public interface ProductVisitor {

    void visitBook(Book pBook);

    void visitElectronics(Electronics pElectronics);

    void visitClothing(Clothing pClothing);

    void visitProductBundle(ProductBundle pBundle);
}
