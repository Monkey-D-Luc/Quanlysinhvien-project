tải cái logo2.png và MenuImage.png, Menu.css

Các Controller chỉ cần extends MainController

cái fxml thì cop cái children và thêm stylesheets="@Main.css" vào anchorpanel và xóa aciton nút trang mình làm.
hoặc có css riêng thì cop hết bỏ cái outline đầu tiên đi.

file java thì cop dòng này sau dòng scene 
scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
