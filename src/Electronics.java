import java.time.LocalDate;

public class Electronics extends Product {

    private LocalDate garansi;
    private String merk;

    public Electronics(
        String id,
        String nama,
        double harga,
        String kategori,
        String merk
    ) {
        super(id, nama, harga, kategori);
        setMerk(merk);
    }

    public void setGaransi(LocalDate garansi) {
        if (garansi == null) {
            System.out.println("Tanggal garansi tidak boleh null");
            return;
        }
        if (garansi.isBefore(LocalDate.now())) {
            System.out.println("Tanggal garansi tidak valid");
        } else {
            this.garansi = garansi;
        }
    }

    public void setMerk(String merk) {
        if (merk == null || merk.trim().isEmpty()) {
            System.out.println("Merk tidak boleh kosong");
            return;
        }
        this.merk = merk;
    }

    public LocalDate getGaransi() {
        return garansi;
    }

    public String getMerk() {
        return merk;
    }

    @Override
    public void infoProduk() {
        super.infoProduk();
        System.out.println("Merk: " + merk);
        System.out.println("Garansi: " + garansi);
    }
}
