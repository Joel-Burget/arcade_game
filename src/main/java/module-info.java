module com.example.burget_joel {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.graphics;
    requires java.desktop;

    opens com.example.burget_joel to javafx.fxml;
    exports com.example.burget_joel;
}
