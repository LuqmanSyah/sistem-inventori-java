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
        setWarna(warna);
    }

    public void setUkuran(char ukuran) {
        if (ukuran != 'S' && ukuran != 'M' && ukuran != 'L' && ukuran != 'X') {
            System.out.println("Ukuran tidak valid");
        } else {
            this.ukuran = ukuran;
        }
    }

    public void setWarna(String warna) {
        if (warna == null || warna.trim().isEmpty()) {
            System.out.println("Warna tidak boleh kosong");
        } else {
            this.warna = warna;
        }
    }

    public char getUkuran() {
        return ukuran;
    }

    public String getWarna() {
        return warna;
    }

    @Override
    public void infoProduk() {
        super.infoProduk();
        System.out.println("Warna: " + warna);
        System.out.println("Ukuran: " + ukuran);
    }
}
