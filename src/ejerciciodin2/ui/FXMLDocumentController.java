/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejerciciodin2.ui;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import practica0.ConexionPool;
import practica0.DAO;
import practica0.Movement;


/**
 *
 * @author 2dam
 */
public class FXMLDocumentController{
    private String configFile = "practica0.configFile";
    ConexionPool poolBD = new ConexionPool("jdbc:mysql://localhost:3306/bankdb", "root", "1234");
    
    private String[] prueba = {"Cheese", "Pepperoni", "Black Olives","sfdfsdgsg"};
    
    
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
        String id_cuenta =txtf_nCuenta.getText();
        
        if(id_cuenta.length()!=0 && id_cuenta.length()<=20 ){
            if(esNumerico(id_cuenta)){
                try {
                    if(new DAO(poolBD, configFile).existeCuenta(Long.parseLong(id_cuenta))){
                        ArrayList <Movement> movimientos = new ArrayList <Movement>();
                       // movimientos = new DAO().getMovimiento(id_cuenta);

                        movimientos = new DAO(poolBD, configFile).getMovimiento(Long.parseLong(id_cuenta));
                        for(Movement movement : movimientos){
                            movement.getDatos();
                        }
                        if(movimientos.size() == 0){
                            lbl_mError.setText("Esta cuenta no tiene movimientos");
                        }
                    }
                    else{
                        lbl_mError.setText("Esta cuenta no existe");
                    }
                } catch (Exception ex) {
                    Logger.getLogger(FXMLDocumentController.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else
                lbl_mError.setText("Id erroneo");
        }
    }
    @FXML
    private void volver(ActionEvent event) {
        Platform.exit();
                
    }
     
    public void initStage(Parent root){
        //Create scene an set document for it
        Scene scene=new Scene(root);
        //Set scene in stage and show it.
        stage.setScene(scene);
        stage.setOnShowing(this::onWindowShowing);
        stage.show();
    }
    private void onWindowShowing(WindowEvent e){
         table.setEditable(true);
         table.getItems().add(prueba);
         
         
        //Foco campo nºcuenta
        lbl_nCuenta.requestFocus();
 
        //Label de error no contendrá texto.
        lbl_mError.setText("");
    }

    private boolean esNumerico(String id_cuenta) {
        boolean resultado = true;
        try{
            Long.parseLong(id_cuenta);
        }catch (NumberFormatException excepcion) {
            resultado = false;
        }
        return resultado;
    }

    public void setStage(Stage stage) {
        this.stage=stage;
    }
}
