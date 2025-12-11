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

    public void setId(String id) {
        if (id == null || id.trim().isEmpty()) {
            System.out.println("ID tidak boleh kosong");
        } else {
            this.id = id;
        }
    }

    public void setNama(String nama) {
        if (nama == null || nama.trim().isEmpty()) {
            System.out.println("Nama tidak boleh kosong");
        } else {
            this.nama = nama;
        }
    }

    public void setHarga(double harga) {
        if (harga < 0) {
            System.out.println("Harga tidak boleh negatif");
        } else {
            this.harga = harga;
        }
    }

    public void setStok(int stok) {
        if (stok < 0) {
            System.out.println("Stok tidak boleh negatif");
        } else {
            this.stok = stok;
        }
    }

    public void setKategori(String kategori) {
        if (kategori == null || kategori.trim().isEmpty()) {
            System.out.println("Kategori tidak boleh kosong");
        } else {
            this.kategori = kategori;
        }
    }

    public String getId() {
        return id;
    }

    public String getNama() {
        return nama;
    }

    public double getHarga() {
        return harga;
    }

    public int getStok() {
        return stok;
    }

    public String getKategori() {
        return kategori;
    }

    public void infoProduk() {
        System.out.println("ID: " + id);
        System.out.println("Nama: " + nama);
        System.out.println("Harga: Rp " + String.format("%,.0f", harga));
        System.out.println("Stok: " + stok);
        System.out.println("Kategori: " + kategori);
    }

    public void updateStok(int jumlah) {
        if (stok + jumlah < 0) {
            System.out.println("Stok tidak boleh negatif");
        } else {
            stok += jumlah;
        }
    }
}
