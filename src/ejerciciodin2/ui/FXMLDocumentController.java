/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodin2.ui;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author 2dam
 */
public class FXMLDocumentController{
    private Stage stage;
    @FXML
    private TableView table;
    @FXML
    private TextField txtf_nCuenta;
    @FXML
    private Label lbl_nCuenta;
    @FXML
    private Button btn_mostrar;
    @FXML
    private Button btn_volver;
    @FXML
    private Label lbl_mError;
    @FXML
    private void mostrar(ActionEvent event){
        if(lbl_nCuenta.getText().length()!=0 && lbl_nCuenta.getText().length()<=20 );
            
    }
    @FXML
    private void volver(ActionEvent event) {
        Platform.exit();
                
    }
     
    public void initialize(){
        //Foco campo nºcuenta
        
 
        //Label de error no contendrá texto.
        lbl_mError.setText("");
    }   
}
