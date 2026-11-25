# Online Shopping Cart - Composite + Visitor

Yeu cau: JDK 17 tro len, khong can thu vien ngoai.

## Cau truc
- cart: ShoppingCart
- component: CartComponent
- product: Product, Book, Electronics, Clothing, ProductBundle
- visitor: ProductVisitor va 4 Visitor cu the
- Main.java: du lieu mau va chay demo

## Chay tren Windows PowerShell
Mo terminal tai thu muc giai nen, chay:
```powershell
javac -encoding UTF-8 -d out (Get-ChildItem -Recurse src -Filter *.java).FullName
java -cp out Main
```

## Quy tac tinh minh hoa
- Book: 5.000 VND moi 500g, lam tron len, tinh theo tong trong luong.
- Electronics: 30.000 VND/san pham.
- Clothing: 15.000 VND/san pham.
- Giam gia: Book 10%, Electronics 5%, Clothing 15%.
- ProductBundle khong co gia/phi rieng; Visitor duyet cac phan tu con.
- Moi thao tac tao Visitor moi de tranh cong don ket qua giua cac lan chay.
