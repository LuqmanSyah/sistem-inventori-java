import java.time.LocalDate;

public class Food extends Product {

    private LocalDate tglKadaluarsa;

    public Food(String id, String nama, double harga, String kategori) {
        super(id, nama, harga, kategori);
    }

    void setTglKadaluarsa(LocalDate tglKadaluarsa) {
        if (tglKadaluarsa.isBefore(LocalDate.now())) {
            System.out.println("Tanggal kadaluarsa tidak valid");
        } else {
            this.tglKadaluarsa = tglKadaluarsa;
        }
    }

    LocalDate getTglKadaluarsa() {
        return tglKadaluarsa;
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
        System.out.println("Tanggal Kadaluarsa: " + tglKadaluarsa);
    }
}
