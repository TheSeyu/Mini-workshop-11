
package product;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import component.CartComponent;
import visitor.ProductVisitor;

public class ProductBundle implements CartComponent {

    private String aName;
    private List<CartComponent> aChildren;

    public ProductBundle(String pName) {
        this.aName = pName;
        this.aChildren = new ArrayList<>();
    }

    public String getName() {
        return aName;
    }

    // Thêm sản phẩm hoặc nhóm sản phẩm vào nhóm
    public void add(CartComponent pItem) {
        if (pItem == null || pItem == this) {
            throw new IllegalArgumentException(
                "Thanh phan khong hop le."
            );
        }

        aChildren.add(pItem);
    }

    // Xóa thành phần khỏi nhóm
    public boolean remove(CartComponent pItem) {
        return aChildren.remove(pItem);
    }

    // Trả về danh sách thành phần
    public List<CartComponent> getChildren() {
        return Collections.unmodifiableList(aChildren);
    }

    // Chấp nhận Visitor
    @Override
    public void accept(ProductVisitor visitor) {
        visitor.visitProductBundle(this);
    }
}
