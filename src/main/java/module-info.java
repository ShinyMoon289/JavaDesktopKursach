module com.example.kursach2024prog {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;

	requires org.controlsfx.controls;
	requires validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires eu.hansolo.tilesfx;

	opens com.example.kursach2024prog to javafx.fxml;
	exports com.example.kursach2024prog;
}