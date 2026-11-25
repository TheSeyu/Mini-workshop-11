
package component;

import visitor.ProductVisitor;

public interface CartComponent {

    // Chấp nhận một Visitor để thực hiện thao tác xử lý
    void accept(ProductVisitor visitor);
}
