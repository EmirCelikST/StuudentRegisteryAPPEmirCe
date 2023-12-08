import java.io.Serializable;

public class Ders implements Serializable {
    private String dersKodu;
    private String dersAd;
    private String dersDonem;
    private Hoca danismanHoca;  // Yeni eklenen alan

    public Ders(String dersKodu, String dersAd, String dersDonem) {
        this.dersKodu = dersKodu;
        this.dersAd = dersAd;
        this.dersDonem = dersDonem;
    }

    public Ders(String dersKodu, String dersAd, String dersDonem, Hoca danismanHoca) {
        this(dersKodu, dersAd, dersDonem);
        this.danismanHoca = danismanHoca;
    }

    public String getDersKodu() {
        return dersKodu;
    }

    public String getDersAd() {
        return dersAd;
    }

    public String getDersDonem() {
        return dersDonem;
    }

    public Hoca getDanismanHoca() {
        return danismanHoca;
    }

    public void setDanismanHoca(Hoca danismanHoca) {
        this.danismanHoca = danismanHoca;
    }

    @Override
    public String toString() {
        if (danismanHoca != null) {
            return dersKodu + " - " + dersAd + " (Dönem: " + dersDonem + ", Danışman Hoca: " + danismanHoca.getHocaAdi() + ")";
        } else {
            return dersKodu + " - " + dersAd + " (Dönem: " + dersDonem + ")";
        }
    }
}
