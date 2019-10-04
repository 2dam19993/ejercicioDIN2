/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package ejerciciodin2.ui;

import clases.Movement;
import control.DAO;
import control.DAOFactory;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;


/**
 * Es el controlador del FXML
 * @author 2dam
 */
public class FXMLDocumentController {
    private static DAO dao=new DAOFactory().getDAO();
    private static final Logger LOGGER = Logger.getLogger("ejerciciodin2.ui.FXMLDocumentController");
    
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
    private Stage stage;
    
    
    @FXML
    private void mostrarAction(){
        
    }
    
    public void setStage  (Stage stage){
        this.stage=stage;
    }
    /**
     * Este metodo se ejecuta solo si es publico y sin parametros llamada initialize
     */
    @FXML
    public void initStage(Parent root) {
        // TODO
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.setTitle("Movimientos");
        stage.setOnShowing(this::handleWindowShowing);
        //Label de error no contendrá texto.
        lbl_mError.setText(" ");
        //Campo nº cuenta habilitado.
        txtf_nCuenta.setDisable(false);
        //Botón mostrar habilitado.
        btn_mostrar.setDisable(false);
        //Tabla movimientos vacio
        //Botón Volver habilitado
        btn_volver.setDisable(false);
        
        
    }
    private void handleWindowShowing(WindowEvent event){
        //Foco campo nºcuenta
        txtf_nCuenta.requestFocus();
    }
    /**
     * Este metodo busca si la cuenta existe o no y muestra los datos en la
     * tabla y tambien controla algunos errores mas sobre la identificación de
     * el ID de la cuenta.
     */
    @FXML
    public void onActionMostrarBuscaCuenta(){
        if(esNumerico(txtf_nCuenta.getText().trim())){
            if(txtf_nCuenta.getText().trim().length()==10){
                try{
                    if(dao.existeCuenta(Long.parseLong(txtf_nCuenta.getText().trim()))){
                       ArrayList <Movement> movimientos= new ArrayList <Movement>();
                       movimientos=dao.getMovimiento(Long.parseLong(txtf_nCuenta.getText()));
                       //FXCollections movimientosFX=FXCollections.observableArrayList(movimientos);
                       //table.setItems(movimientosFX);
                    }else{
                        lbl_mError.setText("Ese edintificador de cuenta no existe");
                    }
                }catch (Exception e){
                    LOGGER.severe(e.getMessage());
                }
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
