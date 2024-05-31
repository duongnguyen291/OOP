module ict.aimsprojectweek5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.naming;

    opens ict.aimsprojectweek5 to javafx.fxml;
    opens ict.aimsprojectweek5.media to javafx.base;
    exports ict.aimsprojectweek5;
    exports ict.aimsprojectweek5.screen.customer.controller;
    exports ict.test.screen.customer.store;
    exports ict.test.screen.customer.cart to javafx.graphics;
    opens ict.aimsprojectweek5.screen.customer.controller to javafx.fxml;
}
