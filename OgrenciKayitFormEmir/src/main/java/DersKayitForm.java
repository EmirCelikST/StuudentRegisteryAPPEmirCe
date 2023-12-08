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

public class DersKayitForm {
    private Main mainApp;
    private String selectedFileType;

    public DersKayitForm(Main mainApp, String selectedFileType) {
        this.mainApp = mainApp;
        this.selectedFileType = selectedFileType;
    }

    public void show() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Ders Kayıt Formu");

        Label labelDersKodu = new Label("Ders Kodu:");
        Label labelDersAd = new Label("Ders Adı:");
        Label labelDersDonem = new Label("Ders Dönemi:");
        Label labelDanismanHoca = new Label("Danışman Hoca:");

        TextField dersKoduField = new TextField();
        TextField dersAdField = new TextField();
        TextField dersDonemField = new TextField();
        TextField danismanHocaField = new TextField();

        Button kaydetButton = new Button("Kaydet");
        kaydetButton.setOnAction(e -> {
            Ders yeniDers = new Ders(dersKoduField.getText(), dersAdField.getText(), dersDonemField.getText());
            String danismanHocaAdi = danismanHocaField.getText();
            if (!danismanHocaAdi.isEmpty()) {
                Hoca danismanHoca = new Hoca(danismanHocaAdi);
                yeniDers.setDanismanHoca(danismanHoca);
            }
            mainApp.getDersList().add(yeniDers);
            mainApp.saveDersList();
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(labelDersKodu, dersKoduField, labelDersAd, dersAdField,
                labelDersDonem, dersDonemField, labelDanismanHoca, danismanHocaField, kaydetButton);

        Scene scene = new Scene(layout, 300, 250);
        window.setScene(scene);
        window.showAndWait();
    }
}
