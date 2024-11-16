module com.example.kursach2024prog {
	requires javafx.controls;
	requires javafx.fxml;
	requires javafx.web;

	requires org.controlsfx.controls;
	requires validatorfx;
	requires org.kordamp.ikonli.javafx;
	requires eu.hansolo.tilesfx;
	requires java.security.jgss;

	opens kursach2024 to javafx.fxml;
	exports kursach2024;
}