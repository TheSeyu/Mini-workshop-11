
package cart;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import component.CartComponent;
import visitor.ProductVisitor;

public class ShoppingCart {

    private List<CartComponent> aItems;

    public ShoppingCart() {
        this.aItems = new ArrayList<>();
    }

    // Thêm sản phẩm hoặc nhóm sản phẩm vào giỏ hàng
    public void add(CartComponent pItem) {
        if (pItem == null) {
            throw new IllegalArgumentException(
                "Thanh phan khong duoc null."
            );
        }

        aItems.add(pItem);
    }

    // Xóa sản phẩm hoặc nhóm sản phẩm khỏi giỏ hàng
    public boolean remove(CartComponent pItem) {
        return aItems.remove(pItem);
    }

    // Lấy danh sách thành phần trong giỏ hàng
    public List<CartComponent> getItems() {
        return Collections.unmodifiableList(aItems);
    }

    // Số lượng thành phần ở cấp ngoài cùng
    public int size() {
        return aItems.size();
    }

    // Cho Visitor duyệt toàn bộ giỏ hàng
    public void accept(ProductVisitor visitor) {
        for (CartComponent item : aItems) {
            item.accept(visitor);
        }
    }
}
