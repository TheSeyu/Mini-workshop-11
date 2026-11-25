
import cart.ShoppingCart;

import product.Book;
import product.Electronics;
import product.Clothing;
import product.ProductBundle;

import visitor.TotalPriceVisitor;
import visitor.ReceiptVisitor;
import visitor.ShippingFeeVisitor;
import visitor.DiscountVisitor;

public class Main {

    private static String formatMoney(long pAmount) {
        return String.format("%,d", pAmount)
                .replace(',', '.') + " VNĐ";
    }

    public static void main(String[] args) {

        // ==================================
        // 1. TẠO CÁC SẢN PHẨM
        // ==================================

        Book book = new Book(
            "Clean Code",
            180000,
            2,
            "Robert C. Martin",
            600
        );

        Electronics mouse = new Electronics(
            "Wireless Mouse",
            250000,
            1,
            24
        );

        Clothing shirt = new Clothing(
            "Basic T-Shirt",
            120000,
            3,
            "L"
        );

        // ==================================
        // 2. TẠO NHÓM SẢN PHẨM COMPOSITE
        // ==================================

        ProductBundle nestedBundle =
                new ProductBundle("Clothing Bundle");

        nestedBundle.add(shirt);

        ProductBundle mainBundle =
                new ProductBundle("Electronics and Accessories");

        mainBundle.add(mouse);
        mainBundle.add(nestedBundle);

        // ==================================
        // 3. TẠO GIỎ HÀNG
        // ==================================

        ShoppingCart cart = new ShoppingCart();

        cart.add(book);
        cart.add(mainBundle);

        // ==================================
        // 4. THỰC HIỆN TOTAL PRICE VISITOR
        // ==================================

        TotalPriceVisitor totalVisitor =
                new TotalPriceVisitor();

        cart.accept(totalVisitor);

        long total = totalVisitor.getTotal();

        // ==================================
        // 5. THỰC HIỆN RECEIPT VISITOR
        // ==================================

        ReceiptVisitor receiptVisitor =
                new ReceiptVisitor();

        cart.accept(receiptVisitor);

        // ==================================
        // 6. THỰC HIỆN SHIPPING FEE VISITOR
        // ==================================

        ShippingFeeVisitor shippingVisitor =
                new ShippingFeeVisitor();

        cart.accept(shippingVisitor);

        long shippingFee = shippingVisitor.getFee();

        // ==================================
        // 7. THỰC HIỆN DISCOUNT VISITOR
        // ==================================

        DiscountVisitor discountVisitor =
                new DiscountVisitor();

        cart.accept(discountVisitor);

        long discount = discountVisitor.getDiscount();

        // ==================================
        // 8. TÍNH TỔNG TIỀN THANH TOÁN
        // ==================================

        long finalTotal = total + shippingFee - discount;

        // ==================================
        // 9. HIỂN THỊ KẾT QUẢ
        // ==================================

        System.out.println("======================================");
        System.out.println("       ONLINE SHOPPING CART");
        System.out.println("======================================");

        System.out.println("\nSO LUONG THANH PHAN CAP NGOAI CUNG: "
                + cart.size());

        System.out.println("\nCHI TIET HOA DON");
        System.out.println("--------------------------------------");

        System.out.println(receiptVisitor.getReceipt());

        System.out.println("--------------------------------------");
        System.out.println("Tong tien hang: "
                + formatMoney(total));

        System.out.println("Phi van chuyen: "
                + formatMoney(shippingFee));

        System.out.println("Tien giam gia: "
                + formatMoney(discount));

        System.out.println("--------------------------------------");
        System.out.println("TONG THANH TOAN: "
                + formatMoney(finalTotal));

        System.out.println("======================================");
    }
}
