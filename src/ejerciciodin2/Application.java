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
        FXMLLoader loader= new FXMLLoader(Application.class.getResource("ui/FXMLDocument.fxml"));
        Parent root = (Parent)loader.load();
        
       FXMLDocumentController viewController=
                    ((FXMLDocumentController)loader.getController());
            //Set greeting to be used in JavaFX view controller
            
        viewController.setStage(stage);
        viewController.initStage(root);
              
    }
    public static void main(String[] args) {
        launch(args);
    }
    
}
