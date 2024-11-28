package com.rentcar.app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.HashMap;
import java.util.Map;

public class Main extends Application {

    private static Stage primaryStage;
    private static final Map<String, String> screens = new HashMap<>();

    @Override
    public void start(Stage stage) {
        primaryStage = stage;
        initializeScreens();
        loadScreen("VeiculoView");
    }

    private void initializeScreens() {
        screens.put("CategoriaView", "/com/rentcar/view/CategoriaVeiculoView.fxml");
        screens.put("VeiculoView", "/com/rentcar/view/VeiculoView.fxml");
        screens.put("FuncionarioView", "/com/rentcar/view/FuncionarioView.fxml");
        screens.put("AluguelView", "/com/rentcar/view/AluguelView.fxml");
        screens.put("ManutencaoView", "/com/rentcar/view/ManutencaoView.fxml");
    }

    public static void loadScreen(String screenName) {
        try {
            String fxmlPath = screens.get(screenName);
            if (fxmlPath == null) {
                throw new IllegalArgumentException("Screen not found: " + screenName);
            }
            FXMLLoader loader = new FXMLLoader(Main.class.getResource(fxmlPath));
            Scene scene = new Scene(loader.load());
            primaryStage.setScene(scene);
            primaryStage.setTitle("RentCar - " + screenName);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
