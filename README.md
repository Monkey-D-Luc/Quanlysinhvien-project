tải cái logo2.png và MenuImage.png, Menu.css

Các Controller chỉ cần extends MainController

cái fxml thì cop cái children xong xóa cái ảnh trang chủ và cái label "hệ thống quản lý sinh viên" đi, và thêm stylesheets="@Main.css" vào anchorpanel và xóa aciton nút trang mình làm.
hoặc có css riêng thì cop hết bỏ cái .outline.label .text đầu tiên đi.

file java thì cop dòng này sau dòng scene 
scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());

tài khoản với pass đây

id	accountName	password	role
1	2155010119	123	Student
2	J1ckay	321	Admin
3	2155010269	1	Student
4	2155010270	2	Student
5	2155010271	3	Student
6	2155010245	4	Student
7	2155010289	5	Student
8	2155010298	6	Student
