import java.io.Serializable;

public class Hoca implements Serializable {
    private String hocaAdi;

    public Hoca(String hocaAdi) {
        this.hocaAdi = hocaAdi;
    }

    public String getHocaAdi() {
        return hocaAdi;
    }

    @Override
    public String toString() {
        return hocaAdi;
    }
}
