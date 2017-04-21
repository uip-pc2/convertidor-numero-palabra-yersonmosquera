import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import javax.swing.text.html.parser.Parser;
import java.io.IOException;


public class Controller{

    @FXML
    private Button bt_salir, bt_convertir;

    @FXML
    private TextField txt_numero;
    @FXML
    private TextArea tx_estado;

    public void evento (ActionEvent ev) throws IOException {

         if( ev.getSource() == bt_convertir){
             System.out.println("Convertir ");

             // Desabilitamos el mensaje de estado
             tx_estado.setVisible(false);

             // Obtenemos el numero ingresado en la vista
             String numero =txt_numero.getText().trim();

             // Verificamos que  no este vacio
             if (!numero.equalsIgnoreCase("") && numero != null ){
                 try{
                     String numeroCorvertido = Conversor.convertNumberToLetter(numero);

                     // Preparamos la vista de resultado
                     Stage stage = (Stage) bt_convertir.getScene().getWindow();
                     FXMLLoader loader = new FXMLLoader(getClass().getResource("resultado.fxml"));
                     Parent root = loader.load();

                     Resultado resultado = (Resultado) loader.getController();

                     Scene scene = new Scene(root);

                     stage.setTitle("Resultado de Conversion");
                     stage.setScene(scene);
                     stage.show();

                     // Enviamos  el numero obtenido a la vista de resultado
                     resultado.actualizar(numero, numeroCorvertido);

                 }catch (Exception e){
                     System.out.print("Error al convertir el numero: "+ e.getMessage());
                     // notificamos
                     tx_estado.setVisible(true);
                     tx_estado.setText("*Error "+ e.getMessage());

                 }

             }else{
                 System.out.println("Sin datos  ");

                 // notificamos
                 tx_estado.setVisible(true);
                 tx_estado.setText("* Debe ingresar un numero");
             }
        }else if (ev.getSource() == bt_salir){
             System.out.println("Salir");
             System.exit(1);

         }
    }

}
