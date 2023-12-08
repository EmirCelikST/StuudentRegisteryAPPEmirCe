import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class HocaKayitForm {
    private Main mainApp;

    public HocaKayitForm(Main mainApp) {
        this.mainApp = mainApp;
    }

    public void show() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Hoca Kayıt Formu");

        Label labelHocaAdi = new Label("Hoca Adı:");

        TextField hocaAdiField = new TextField();

        Button kaydetButton = new Button("Kaydet");
        kaydetButton.setOnAction(e -> {
            Hoca yeniHoca = new Hoca(hocaAdiField.getText());
            mainApp.getDersList().add(new Ders("BOŞ", "BOŞ", "BOŞ", yeniHoca)); // Hoca, Ders sınıfına eklendi
            mainApp.saveDersList();
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(labelHocaAdi, hocaAdiField, kaydetButton);

        Scene scene = new Scene(layout, 300, 150);
        window.setScene(scene);
        window.showAndWait();
    }
}
