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
        this.merk = merk;
    }

    void setGaransi(LocalDate garansi) {
        if (garansi.isBefore(LocalDate.now())) {
            System.out.println("Tanggal garansi tidak valid");
        } else {
            this.garansi = garansi;
        }
    }

    void setMerk(String merk) {
        this.merk = merk;
    }

    LocalDate getGaransi() {
        return garansi;
    }

    String getMerk() {
        return merk;
    }

    @Override
    void infoProduk() {
        System.out.println("ID: " + super.getId());
        System.out.println("Nama: " + super.getNama());
        System.out.println(
            "Harga: Rp " + String.format("%,.0f", super.getHarga())
        );
        System.out.println("Stok: " + super.getStok());
        System.out.println("Kategori: " + super.getKategori());
        System.out.println("Merk: " + merk);
        System.out.println("Garansi: " + garansi);
    }
}
