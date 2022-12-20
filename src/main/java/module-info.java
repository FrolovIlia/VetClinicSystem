module com.example.vetclinicsystem {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.vetclinicsystem to javafx.fxml;
    exports com.example.vetclinicsystem;
}