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
    requires org.hibernate.orm.core;
    requires org.hibernate.commons.annotations;
    requires jakarta.persistence;
    requires java.naming;
    requires jakarta.activation;
    //requires eu.hansolo.tilesfx;

    opens com.vicego.recordtracker to javafx.fxml, org.slf4j, lombok;
    opens com.vicego.recordtracker.entity to org.hibernate.orm.core;
    exports com.vicego.recordtracker;

    exports com.vicego.recordtracker.controller;

    opens com.vicego.recordtracker.controller to javafx.base, javafx.fxml, org.hibernate.orm.core;
}