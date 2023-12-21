tải cái logo2.png và MenuImage.png, Menu.css

Các Controller chỉ cần extends MainController

cái fxml thì cop cái children xong xóa cái ảnh trang chủ và cái label "hệ thống quản lý sinh viên" đi, và thêm stylesheets="@Main.css" vào anchorpanel và xóa aciton nút trang mình làm.
hoặc có css riêng thì cop hết bỏ cái .outline.label .text đầu tiên đi.

file java thì cop dòng này sau dòng scene 
scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
