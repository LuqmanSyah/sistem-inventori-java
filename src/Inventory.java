import java.util.ArrayList;

public class Inventory {

    private ArrayList<Product> daftarProduk;

    public void tambahProduk(Product produk) {
        if (daftarProduk == null) {
            daftarProduk = new ArrayList<>();
        }
        daftarProduk.add(produk);
    }

    public void hapusProduk(Product produk) {
        if (daftarProduk != null) {
            daftarProduk.remove(produk);
        }
    }

    public void cariProduk(String nama) {
        if (daftarProduk != null) {
            for (Product produk : daftarProduk) {
                if (produk.getNama().equalsIgnoreCase(nama)) {
                    produk.infoProduk();
                    return;
                }
            }
            System.out.println(
                "Produk dengan nama " + nama + " tidak ditemukan."
            );
        } else {
            System.out.println("Daftar produk kosong.");
        }
    }

    public void tampilkanSemuaProduk() {
        if (daftarProduk != null && !daftarProduk.isEmpty()) {
            for (Product produk : daftarProduk) {
                produk.infoProduk();
                System.out.println("-----------------------");
            }
        } else {
            System.out.println("Daftar produk kosong.");
        }
    }

    public void updateStokProduk(String id, int stokBaru) {
        if (daftarProduk != null) {
            for (Product produk : daftarProduk) {
                if (produk.getId().equals(id)) {
                    produk.updateStok(stokBaru);
                    System.out.println(
                        "Stok produk dengan ID " + id + " telah diperbarui."
                    );
                    return;
                }
            }
            System.out.println("Produk dengan ID " + id + " tidak ditemukan.");
        } else {
            System.out.println("Daftar produk kosong.");
        }
    }

    public void hapusProdukByNama(String nama) {
        if (daftarProduk != null) {
            for (int i = 0; i < daftarProduk.size(); i++) {
                if (daftarProduk.get(i).getNama().equalsIgnoreCase(nama)) {
                    daftarProduk.remove(i);
                    System.out.println(
                        "Produk dengan nama \"" + nama + "\" telah dihapus."
                    );
                    return;
                }
            }
            System.out.println(
                "Produk dengan nama \"" + nama + "\" tidak ditemukan."
            );
        } else {
            System.out.println("Daftar produk kosong.");
        }
    }
}
