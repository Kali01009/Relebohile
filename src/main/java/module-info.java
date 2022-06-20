module com.example.relebohile {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.relebohile to javafx.fxml;
    exports com.example.relebohile;
}