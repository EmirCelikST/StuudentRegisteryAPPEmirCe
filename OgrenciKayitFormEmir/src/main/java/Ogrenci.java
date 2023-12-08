import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Ogrenci implements Serializable {
    private int ogrenciNo;
    private String ogrenciAd;
    private String ogrenciSoyad;
    private String ogrenciBolum;
    private Ders danismanHoca;

    private List<Ders> ogrenciDersler;

    public Ogrenci(int ogrenciNo, String ogrenciAd, String ogrenciSoyad, String ogrenciBolum) {
        this.ogrenciNo = ogrenciNo;
        this.ogrenciAd = ogrenciAd;
        this.ogrenciSoyad = ogrenciSoyad;
        this.ogrenciBolum = ogrenciBolum;
        this.ogrenciDersler = new ArrayList<>();
    }

    public void addDers(Ders ders) {
        ogrenciDersler.add(ders);
    }

    public int getOgrenciNo() {
        return ogrenciNo;
    }

    public String getOgrenciAd() {
        return ogrenciAd;
    }

    public String getOgrenciSoyad() {
        return ogrenciSoyad;
    }

    public String getOgrenciBolum() {
        return ogrenciBolum;
    }

    public List<Ders> getOgrenciDersler() {
        return ogrenciDersler;
    }

    public Ders getDanismanHoca() {
        return danismanHoca;
    }

    public void setDanismanHoca(Ders danismanHoca) {
        this.danismanHoca = danismanHoca;
    }
}
