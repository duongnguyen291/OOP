module ict.aimsprojectweek5 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.naming;

    opens ict.aimsprojectweek5 to javafx.fxml;
    exports ict.aimsprojectweek5;
    exports ict.aimsprojectweek5.screen.customer.controller;
    exports ict.test.screen.customer.store;
    opens ict.aimsprojectweek5.screen.customer.controller to javafx.fxml;
}
