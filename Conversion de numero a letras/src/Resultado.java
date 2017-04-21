import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class Resultado{
    @FXML
    private TextField txt_num;

    @FXML
    private TextArea text_resultado;

    @FXML
    private Button  bt_atras;


    public  void actualizar( String num, String letra){
        txt_num.setText(num);
        text_resultado.setText(letra);
    }

    public void evento(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) bt_atras.getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("home.fxml"));

        Scene scene = new Scene(root);
        stage.setTitle("Aplicacion");
        stage.setScene(scene);
        stage.show();
    }

}
