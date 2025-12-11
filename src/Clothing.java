public class Clothing extends Product {

    private char ukuran;
    private String warna;

    public Clothing(
        String id,
        String nama,
        double harga,
        String kategori,
        String warna
    ) {
        super(id, nama, harga, kategori);
        this.warna = warna;
    }

    void setUkuran(char ukuran) {
        if (ukuran != 'S' && ukuran != 'M' && ukuran != 'L' && ukuran != 'X') {
            System.out.println("Ukuran tidak valid");
        } else {
            this.ukuran = ukuran;
        }
    }

    void setWarna(String warna) {
        this.warna = warna;
    }

    char getUkuran() {
        return ukuran;
    }

    String getWarna() {
        return warna;
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
        System.out.println("Warna: " + warna);
        System.out.println("Ukuran: " + ukuran);
    }
}
