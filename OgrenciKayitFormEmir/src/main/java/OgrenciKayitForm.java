import javafx.collections.FXCollections;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class OgrenciKayitForm {
    private Main mainApp;
    private List<Ders> dersList;
    private String selectedFileType;

    public OgrenciKayitForm(Main mainApp, List<Ders> dersList, String selectedFileType) {
        this.mainApp = mainApp;
        this.dersList = dersList;
        this.selectedFileType = selectedFileType;
    }

    public void show() {
        Stage window = new Stage();
        window.initModality(Modality.APPLICATION_MODAL);
        window.setTitle("Öğrenci Kayıt Formu");

        Label labelOgrenciNo = new Label("Öğrenci No:");
        Label labelOgrenciAd = new Label("Öğrenci Adı:");
        Label labelOgrenciSoyad = new Label("Öğrenci Soyadı:");
        Label labelOgrenciBolum = new Label("Öğrenci Bölümü:");
        Label labelOgrenciDersler = new Label("Öğrenci Dersleri:");
        Label labelDanismanHoca = new Label("Danışman Hoca:");

        TextField ogrenciNoField = new TextField();
        TextField ogrenciAdField = new TextField();
        TextField ogrenciSoyadField = new TextField();
        TextField ogrenciBolumField = new TextField();

        ComboBox<Ders> dersComboBox = new ComboBox<>(FXCollections.observableArrayList(dersList));
        ComboBox<Ders> danismanHocaComboBox = new ComboBox<>(FXCollections.observableArrayList(dersList));

        Button kaydetButton = new Button("Kaydet");
        kaydetButton.setOnAction(e -> {
            Ogrenci yeniOgrenci = new Ogrenci(Integer.parseInt(ogrenciNoField.getText()),
                    ogrenciAdField.getText(), ogrenciSoyadField.getText(), ogrenciBolumField.getText());
            yeniOgrenci.addDers(dersComboBox.getValue());
            yeniOgrenci.setDanismanHoca(danismanHocaComboBox.getValue());

            mainApp.getOgrenciList().add(yeniOgrenci);
            mainApp.saveOgrenciList();
            window.close();
        });

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(labelOgrenciNo, ogrenciNoField, labelOgrenciAd, ogrenciAdField,
                labelOgrenciSoyad, ogrenciSoyadField, labelOgrenciBolum, ogrenciBolumField,
                labelOgrenciDersler, dersComboBox, labelDanismanHoca, danismanHocaComboBox, kaydetButton);

        Scene scene = new Scene(layout, 400, 350);
        window.setScene(scene);
        window.showAndWait();
    }
}
