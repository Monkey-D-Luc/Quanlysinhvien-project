Đây là Project nhỏ làm phục vụ bộ môn Java. Phần mềm giúp quản lý thông tin cá nhân của sinh viên. 
-Giao diện đăng nhập của hệ thống: (hình 1.1) Người dùng nhập tên tài khoản và mật khẩu, sau đó ấn nút đăng nhập nếu tài khoản hợp lệ thì người dùng truy cập vào hệ thống.Có 2 cấp độ chức năng của tài khoản là admin và sinh viên. Chỉ có admin là được thao tác lên thông tin của sinh viên. Tài khoản của sinh viên chỉ có quyền xem.

![dangnhap](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/8d33f80e-19b9-4914-bc57-38a33399454c)

Hình 1.1 Giao diện đăng nhập

---------------------------
-Giao diện trang chủ: (hình 1.2) Có chức năng chính là để chuyển đổi qua lại giữa các cửa sổ chức năng của hệ thống. 

![menu](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/f69e32b4-6ebd-4244-92c1-910639234f19)

Hình 1.2 Giao diện Trang Chủ

---------------------------
-Giao diện quản lý thông tin sinh viên: (hình 1.3) Người dùng tra cứu thông tin sinh viên dựa vào các thông tin như khoa, khóa học, lớp. Đồng thời, người dùng cũng có thể thêm thông tin sinh viên vào hệ thống.

![1 3](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/bce5965e-682d-4ab7-b10c-d3df6620169e)

Hình 1.3 Giao diện quản lí danh sách sinh viên

---------------------------
-Giao diện thêm thông tin sinh viên: (hình 1.4) Gồm các ô để người quản lý có thể nhập thông tin của sinh viên mới sau đó ấn nút lưu để thông tin được cập nhật vào cơ sở dữ liệu. Đồng thời tạo thêm 1 tài khoản sinh viên với mã sinh viên là tên tài khoản và mật khẩu là 1.

![1 4](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/3071df12-4e9e-4df5-92e5-9bf35d1e32a8)

Hình 1.4 Giao diện thêm thông tin sinh viên

------------------------
-Giao diện thông tin cá nhân: (hình 1.5) giao diện này chỉ riêng tài khoản sinh viên có. Giúp hiển thị và chỉnh sửa toàn bộ thông tin của sinh viên đó. 

![1 5](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/ecd52016-5356-4340-86ad-6c71779325d7)

Hình 1.5 Giao diện thêm thông tin cá nhân

------------------------
-Giao diện quản lý điểm thi: Có 2 giao diện là điểm cá nhân và danh sách điểm như hình 1.6 và 1.7. Người dùng có thể lựa chọn 1 trong 2 giao diện thông qua Choice Box.
+Điểm cá nhân: Người dùng cần điền mã sinh viên và họ tên sinh viên cần tìm sau đó nhấn nút tìm kiếm. Nếu thông tin hợp lệ, bảng điểm các môn học và các thông tin như TBC học tập hay xếp loại của sinh viên đó sẽ hiển thị. Nếu thông tin không hợp lệ sẽ hiện thông báo lỗi.
+Danh sách điểm: Người dùng cần điền môn học, mã môn học và lớp cần tìm sau đó nhấn nút tìm kiếm. Nếu thông tin hợp lệ, danh sách điểm tương ứng sẽ hiển thị. Nếu thông tin không hợp lệ sẽ hiện thông báo lỗi. Có thể chỉnh sửa thông tin điểm thành phần và điểm thi của các sinh viên trong bảng bằng cách nhấp đúp chuột vào ô cần chỉnh sửa, nhấn Enter để lưu, nhấp chuột ra ngoài để huỷ.

![1 6](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/d2e7111d-87be-4ae4-ba5b-e4b2ba551c68)

Hình 1.6 Giao diện tra cứu điểm cá nhân

-------------------------
![1 7](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/bc219a94-ae78-42ed-a100-2de63ffb57d7)

Hình 1.7 : Giao diện quản lý danh sách điểm

-----------------------
Giao diện quản lý lịch học: (hình 1.8) Tại phần tra cứu lịch học, người dùng nhập vào ô văn bản tùy theo nhu cầu tìm kiếm, ví dụ nhập vào mã sinh viên, hệ thống sẽ hiển thị những môn học mà sinh viên có mã sinh viên đó tham gia, hoặc nhập tên giáo viên thì sẽ hiển thị những lớp mà giáo viên đó giảng dạy, ....
Tại phần thêm lịch, người dùng điền lần lượt thông tin vào các phần tương ứng, bấm chọn "Thêm", hệ thống sẽ thêm lịch đó vào cơ sở dữ liệu. 
Với phần xóa, người dùng bấm chọn mục muốn xóa tại bảng hiển thị, tiếp đó chọn "Xóa", lịch sẽ được xóa khỏi cơ sở dữ liệu. 
Nếu muốn chỉnh sửa lịch, người chỉ cần chọn vào mục muốn sửa, thông tin của mục sẽ hiển thị theo các thành phần ở phía bên trái, sửa theo ý muốn rồi chọn "Sửa", lịch mới sẽ được lưu vào cơ sở dữ liệu. 
Mục "Clear" giúp người dùng xóa nhanh các văn bản tại mục điền ở bên trái phần hiển thị lịch nếu cảm thấy không cần dùng đến.

![1 8](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/6cb70b75-199a-46c1-917c-743fe09860aa)

Hình 1.8 Giao diện quản lý lịch học

---------------------
-Giao diện quản lý tài chính: Giúp người dùng có thể tra cứu toàn bộ thông tin tài chính về học phí của một nhóm sinh viên cụ thể. (hình 1.9)

 ![1 9](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/3a8bb9c6-41fb-4323-b665-fc185c230634)
 
Hình 1.9 Giao diện quản lý tài chính

---------------------
-Giao diện nộp tiền học:  Chỉ có người quản lý có thể cập nhật số tiền nộp học của từng sinh viên một qua nút nộp tiền để dễ dàng quản lý thông tin tài chính. Tài khoản sinh viên chỉ có quyền xem.

![1 10](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/8fd44838-a38f-41f5-b214-a27b4698d0f7)

Hình 1.10 Giao diện nộp học phí

----------------------
-Giao diện thông tin tài khoản: hiển thị các thông tin cơ bản của tài khoản như chức vụ, tên tài khoản.

![1 11](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/8ae01a9f-dfcd-45bf-aee1-bb60728e1f82)

Hình 1.11 Giao diện thông tin tài khoản

--------------------
![1 12](https://github.com/Monkey-D-Luc/Quanlysinhvien/assets/133494882/3cc027b8-3618-4916-975c-c62baa7f41ea)

Hình 1.12 Giao diện đổi mật khẩu
