module com.vicego.recordtracker {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires org.kordamp.ikonli.javafx;
    requires lombok;
    requires org.slf4j;
    requires MaterialFX;
    //requires eu.hansolo.tilesfx;

    opens com.vicego.recordtracker to javafx.fxml;
    exports com.vicego.recordtracker;

    exports com.vicego.recordtracker.controller;

    opens com.vicego.recordtracker.controller to javafx.base, javafx.fxml;
}