module com.example.burget_joel {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.example.burget_joel to javafx.fxml;
    exports com.example.burget_joel;
}
