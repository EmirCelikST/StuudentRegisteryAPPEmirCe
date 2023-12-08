import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main extends Application {

    private List<Ders> dersList = new ArrayList<>();
    private List<Ogrenci> ogrenciList = new ArrayList<>();

    private ChoiceBox<String> fileTypeChoiceBox;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Proje Menü");

        fileTypeChoiceBox = new ChoiceBox<>();
        fileTypeChoiceBox.getItems().addAll(".dat", ".json", ".csv");

        Button dersKayitButton = new Button("Ders Kayıt Formu");
        Button ogrenciKayitButton = new Button("Öğrenci Kayıt Formu");
        Button hocaKayitButton = new Button("Hoca Kayıt Formu");

        dersKayitButton.setOnAction(e -> showDersKayitForm());
        ogrenciKayitButton.setOnAction(e -> showOgrenciKayitForm());
        hocaKayitButton.setOnAction(e -> showHocaKayitForm());

        VBox layout = new VBox(10);
        layout.setPadding(new Insets(20, 20, 20, 20));
        layout.getChildren().addAll(fileTypeChoiceBox, dersKayitButton, ogrenciKayitButton, hocaKayitButton);

        Scene scene = new Scene(layout, 300, 200);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void showDersKayitForm() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            DersKayitForm dersKayitForm = new DersKayitForm(this, selectedFileType);
            dersKayitForm.show();
        } else {
            System.out.println("Lütfen bir dosya türü seçin.");
        }
    }

    private void showOgrenciKayitForm() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            OgrenciKayitForm ogrenciKayitForm = new OgrenciKayitForm(this, dersList, selectedFileType);
            ogrenciKayitForm.show();
        } else {
            System.out.println("Lütfen bir dosya türü seçin.");
        }
    }

    private void showHocaKayitForm() {
        HocaKayitForm hocaKayitForm = new HocaKayitForm(this);
        hocaKayitForm.show();
    }

    public List<Ders> getDersList() {
        return dersList;
    }

    public List<Ogrenci> getOgrenciList() {
        return ogrenciList;
    }

    public void saveDersList() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("dersler" + selectedFileType))) {
                oos.writeObject(dersList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveOgrenciList() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("ogrenciler" + selectedFileType))) {
                oos.writeObject(ogrenciList);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadDersList() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("dersler" + selectedFileType))) {
                dersList = (List<Ders>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }

    public void loadOgrenciList() {
        String selectedFileType = fileTypeChoiceBox.getValue();
        if (selectedFileType != null) {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("ogrenciler" + selectedFileType))) {
                ogrenciList = (List<Ogrenci>) ois.readObject();
            } catch (IOException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
