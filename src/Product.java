public class Product {

    private String id;
    private String nama;
    private double harga;
    private int stok;
    private String kategori;

    public Product(String id, String nama, double harga, String kategori) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        this.kategori = kategori;
    }

    void setId(String id) {
        this.id = id;
    }

    void setNama(String nama) {
        this.nama = nama;
    }

    void setHarga(double harga) {
        this.harga = harga;
    }

    void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif");
        } else {
            this.stok = stok;
        }
    }

    void setKategori(String kategori) {
        this.kategori = kategori;
    }

    String getId() {
        return id;
    }

    String getNama() {
        return nama;
    }

    double getHarga() {
        return harga;
    }

    int getStok() {
        return stok;
    }

    String getKategori() {
        return kategori;
    }

    void infoProduk() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp " + String.format("%,.0f", harga));
        System.out.println("Stok: " + stok);
        System.out.println("Kategori: " + kategori);
    }

    void updateStok(int jumlah) {
        if (stok + jumlah < 0) {
            System.out.println("Stok tidak boleh negatif");
        } else {
            stok += jumlah;
        }
    }
}
