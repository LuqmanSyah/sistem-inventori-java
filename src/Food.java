import java.time.LocalDate;

public class Food extends Product {

    private LocalDate tglKadaluarsa;

    public Food(String id, String nama, double harga, String kategori) {
        super(id, nama, harga, kategori);
    }

    public void setTglKadaluarsa(LocalDate tglKadaluarsa) {
        if (tglKadaluarsa == null) {
            System.out.println("Tanggal kadaluarsa tidak boleh null");
            return;
        }
        if (tglKadaluarsa.isBefore(LocalDate.now())) {
            System.out.println("Tanggal kadaluarsa tidak valid");
        } else {
            this.tglKadaluarsa = tglKadaluarsa;
        }
    }

    public LocalDate getTglKadaluarsa() {
        return tglKadaluarsa;
    }

    @Override
    public void infoProduk() {
        super.infoProduk();
        System.out.println("Tanggal Kadaluarsa: " + tglKadaluarsa);
    }
}
