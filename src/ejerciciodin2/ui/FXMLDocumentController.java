/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ejerciciodin2.ui;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;


/**
 *
 * @author 2dam
 */
public class FXMLDocumentController {
    
    @FXML
    private Label lbl_nCuenta;
    @FXML
    private Button btn_mostrar;
    @FXML
    private TableView table;
    @FXML
    private TextField txtf_nCuenta;
    @FXML
    private Label lbl_mError;
    @FXML
    private Button btn_volver;
    
    @FXML
    private void mostrarAction(){
        
    }
    /*
    @FXML
    private void handleButtonAction(ActionEvent event) {
    
    }
    */
    /**
     * Este metodo se ejecuta solo si es publico y sin parametros llamada initialize
     */
    @FXML
    public void initialize() {
        // TODO
        
        //Label de error no contendrá texto.
        lbl_mError.setText(" ");
        //Campo nº cuenta habilitado.
        txtf_nCuenta.setDisable(false);
        //Botón mostrar habilitado.
        btn_mostrar.setDisable(false);
        //Tabla movimientos vacio
        //Botón Volver habilitado
        btn_volver.setDisable(false);
        //Foco campo nºcuenta
        txtf_nCuenta.requestFocus();
        
    }
    @FXML
    public void onActionMostrarBuscaCuenta(){
        if(esNumerico(txtf_nCuenta.getText())){
            if(txtf_nCuenta.getText().length()==10){
                //BUSCA
            }else{
                lbl_mError.setText("El numero de cuenta tiene que contener 10 digitos");
            }
        }else{
            lbl_mError.setText("El numero de cuenta solo contiene digitos");
        }
        
    }
    
    @FXML
    public void btnVolver(){
        Platform.exit();
    }
    
    private boolean esNumerico(String frase){
        boolean ret=true;
        for(int i=0;i<frase.length();i++){
            if(Character.isAlphabetic(frase.charAt(i))){
                ret=false;
                break;
            }
        }
        return ret;
    }
}
