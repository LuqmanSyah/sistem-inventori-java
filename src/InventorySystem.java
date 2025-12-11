import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class InventorySystem {

    private static Inventory inventory = new Inventory();
    private static Scanner scanner = new Scanner(System.in);
    private static DateTimeFormatter dateFormatter =
        DateTimeFormatter.ofPattern("dd-MM-yyyy");

    public static void main(String[] args) {
        // Menambahkan produk awal sebagai contoh
        Electronics produkE1 = new Electronics(
            "E001",
            "Laptop",
            15000000,
            "Elektronik",
            "Asus"
        );
        produkE1.setStok(10);
        produkE1.setGaransi(LocalDate.of(2026, 12, 31));

        Food produkF1 = new Food("F001", "Roti", 15000, "Makanan");
        produkF1.setStok(50);
        produkF1.setTglKadaluarsa(LocalDate.of(2025, 6, 30));

        Clothing produkC1 = new Clothing(
            "C001",
            "Kaos Polos",
            50000,
            "Pakaian",
            "Hitam"
        );
        produkC1.setStok(25);
        produkC1.setUkuran('L');

        inventory.tambahProduk(produkE1);
        inventory.tambahProduk(produkF1);
        inventory.tambahProduk(produkC1);

        int pilihan;

        do {
            System.out.println("\n================================");
            System.out.println("   SISTEM INVENTORI BARANG");
            System.out.println("================================");
            System.out.println("1. Tambah Barang");
            System.out.println("2. Lihat Semua Barang");
            System.out.println("3. Cari Barang");
            System.out.println("4. Update Stok Barang");
            System.out.println("5. Hapus Barang");
            System.out.println("0. Keluar");
            System.out.println("================================");
            System.out.print("Pilih menu (0-5): ");

            pilihan = getIntInput();

            switch (pilihan) {
                case 1:
                    tambahBarang();
                    break;
                case 2:
                    lihatSemuaBarang();
                    break;
                case 3:
                    cariBarang();
                    break;
                case 4:
                    updateStokBarang();
                    break;
                case 5:
                    hapusBarang();
                    break;
                case 0:
                    System.out.println(
                        "\nTerima kasih telah menggunakan sistem ini!"
                    );
                    System.out.println("Sampai jumpa!");
                    break;
                default:
                    System.out.println(
                        "\n[!] Pilihan tidak valid. Silakan coba lagi."
                    );
            }
        } while (pilihan != 0);

        scanner.close();
    }

    private static void tambahBarang() {
        System.out.println("\n--- TAMBAH BARANG BARU ---");
        System.out.println("Pilih jenis barang:");
        System.out.println("1. Elektronik");
        System.out.println("2. Makanan");
        System.out.println("3. Pakaian");
        System.out.print("Pilihan: ");

        int jenis = getIntInput();

        System.out.print("Masukkan ID Produk: ");
        String id = scanner.nextLine().trim();

        System.out.print("Masukkan Nama Produk: ");
        String nama = scanner.nextLine().trim();

        System.out.print("Masukkan Harga Produk: ");
        double harga = getDoubleInput();

        System.out.print("Masukkan Stok Awal: ");
        int stok = getIntInput();

        switch (jenis) {
            case 1:
                tambahElektronik(id, nama, harga, stok);
                break;
            case 2:
                tambahMakanan(id, nama, harga, stok);
                break;
            case 3:
                tambahPakaian(id, nama, harga, stok);
                break;
            default:
                System.out.println("[!] Jenis barang tidak valid.");
        }
    }

    private static void tambahElektronik(
        String id,
        String nama,
        double harga,
        int stok
    ) {
        System.out.print("Masukkan Merk: ");
        String merk = scanner.nextLine().trim();

        System.out.print("Masukkan Tanggal Garansi (dd-MM-yyyy): ");
        String tglGaransiStr = scanner.nextLine().trim();

        Electronics produk = new Electronics(
            id,
            nama,
            harga,
            "Elektronik",
            merk
        );
        produk.setStok(stok);

        try {
            LocalDate garansi = LocalDate.parse(tglGaransiStr, dateFormatter);
            produk.setGaransi(garansi);
        } catch (DateTimeParseException e) {
            System.out.println(
                "[!] Format tanggal tidak valid, garansi tidak diset."
            );
        }

        inventory.tambahProduk(produk);
        System.out.println("[✓] Produk elektronik berhasil ditambahkan!");
    }

    private static void tambahMakanan(
        String id,
        String nama,
        double harga,
        int stok
    ) {
        System.out.print("Masukkan Tanggal Kadaluarsa (dd-MM-yyyy): ");
        String tglKadaluarsaStr = scanner.nextLine().trim();

        Food produk = new Food(id, nama, harga, "Makanan");
        produk.setStok(stok);

        try {
            LocalDate kadaluarsa = LocalDate.parse(
                tglKadaluarsaStr,
                dateFormatter
            );
            produk.setTglKadaluarsa(kadaluarsa);
        } catch (DateTimeParseException e) {
            System.out.println(
                "[!] Format tanggal tidak valid, tanggal kadaluarsa tidak diset."
            );
        }

        inventory.tambahProduk(produk);
        System.out.println("[✓] Produk makanan berhasil ditambahkan!");
    }

    private static void tambahPakaian(
        String id,
        String nama,
        double harga,
        int stok
    ) {
        System.out.print("Masukkan Warna: ");
        String warna = scanner.nextLine().trim();

        System.out.print("Masukkan Ukuran (S/M/L/X): ");
        String ukuranStr = scanner.nextLine().trim().toUpperCase();
        char ukuran = ukuranStr.isEmpty() ? 'M' : ukuranStr.charAt(0);

        Clothing produk = new Clothing(id, nama, harga, "Pakaian", warna);
        produk.setStok(stok);
        produk.setUkuran(ukuran);

        inventory.tambahProduk(produk);
        System.out.println("[✓] Produk pakaian berhasil ditambahkan!");
    }

    private static void lihatSemuaBarang() {
        System.out.println("\n--- DAFTAR SEMUA BARANG ---");
        inventory.tampilkanSemuaProduk();
    }

    private static void cariBarang() {
        System.out.println("\n--- CARI BARANG ---");
        System.out.print("Masukkan nama barang yang dicari: ");
        String nama = scanner.nextLine().trim();

        System.out.println("\nHasil pencarian:");
        inventory.cariProduk(nama);
    }

    private static void updateStokBarang() {
        System.out.println("\n--- UPDATE STOK BARANG ---");
        System.out.print("Masukkan ID Produk: ");
        String id = scanner.nextLine().trim();

        System.out.print(
            "Masukkan perubahan stok (positif untuk tambah, negatif untuk kurang): "
        );
        int perubahan = getIntInput();

        inventory.updateStokProduk(id, perubahan);
    }

    private static void hapusBarang() {
        System.out.println("\n--- HAPUS BARANG ---");
        System.out.print("Masukkan nama barang yang akan dihapus: ");
        String nama = scanner.nextLine().trim();

        inventory.hapusProdukByNama(nama);
    }

    private static int getIntInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.print("[!] Input tidak valid. Masukkan angka: ");
            }
        }
    }

    private static double getDoubleInput() {
        while (true) {
            try {
                String input = scanner.nextLine().trim();
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("[!] Input tidak valid. Masukkan angka: ");
            }
        }
    }
}
