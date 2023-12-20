tải cái logo2.png và MenuImage.png, Menu.css

controller thì cop hết trừ cái hàm phần mình làm.

cái fxml thì cop cái children và thêm stylesheets="@Main.css" vào anchorpanel và xóa aciton nút trang mình làm.

file java thì cop dòng này sau dòng scene 
scene.getStylesheets().add(getClass().getResource("Main.css").toExternalForm());
