/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodin2;


import ejerciciodin2.ui.FXMLDocumentController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author 2dam
 */
public class Application extends javafx.application.Application {
    
    @Override
    public void start(Stage stage) throws Exception {
        //Parent root = FXMLLoader.load(getClass().getResource("ui/FXMLDocument.fxml"));
        FXMLLoader loader= new FXMLLoader(getClass().getResource("ui/FXMLDocument.fxml"));
        Parent root=(Parent) loader.load();
        FXMLDocumentController viewController =((FXMLDocumentController) loader.getController());
        //Scene scene = new Scene(root);
        viewController.setStage(stage);
        viewController.initStage(root);
        //stage.setScene(scene);
        stage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
