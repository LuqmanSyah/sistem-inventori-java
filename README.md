# Sistem Inventori Barang

Aplikasi Java untuk mengelola inventori barang dengan berbagai kategori seperti Elektronik, Makanan, dan Pakaian.

## 📋 Deskripsi

Sistem Inventori Barang adalah aplikasi berbasis console yang memungkinkan pengguna untuk mengelola data barang secara efisien. Aplikasi ini menggunakan konsep Object-Oriented Programming (OOP) dengan implementasi inheritance dan polymorphism.

## ✨ Fitur

- **Tambah Barang** - Menambahkan barang baru ke dalam inventori
  - Elektronik (dengan info merk dan garansi)
  - Makanan (dengan tanggal kadaluarsa)
  - Pakaian (dengan ukuran dan warna)
- **Lihat Semua Barang** - Menampilkan daftar seluruh barang dalam inventori
- **Cari Barang** - Mencari barang berdasarkan nama
- **Update Stok** - Memperbarui stok barang berdasarkan ID
- **Hapus Barang** - Menghapus barang dari inventori

## 🏗️ Struktur Project

```
final-project/
├── src/
│   ├── Product.java          # Class dasar untuk semua produk
│   ├── Electronics.java      # Class turunan untuk produk elektronik
│   ├── Food.java             # Class turunan untuk produk makanan
│   ├── Clothing.java         # Class turunan untuk produk pakaian
│   ├── Inventory.java        # Class untuk mengelola daftar produk
│   ├── InventorySystem.java  # Class ut
ama dengan menu interaktif
│   └── App.java
├── bin/                      # Compiled output files
├── lib/                      # Dependencies
├── run.ps1
└── README.md
```

## 🔧 Konsep OOP yang Digunakan

1. **Encapsulation** - Semua atribut menggunakan access modifier private dengan getter dan setter
2. **Inheritance** - Class Electronics, Food, dan Clothing mewarisi dari class Product
3. **Polymorphism** - Method `infoProduk()` di-override di setiap subclass

## 🚀 Cara Menjalankan

### Menggunakan VS Code
1. Buka project di VS Code
2. Pastikan Java Extension Pack sudah terinstall
3. Jalankan file `InventorySystem.java`

### Menggunakan Terminal
```bash
# Compile semua file Java
javac -d bin src/*.java

# Jalankan program
java -cp bin InventorySystem
```

### Menggunakan PowerShell Script
```powershell
./run.ps1
```

## 📖 Cara Penggunaan

1. Jalankan program
2. Pilih menu dengan memasukkan angka (0-5):
   - `1` - Tambah Barang
   - `2` - Lihat Semua Barang
   - `3` - Cari Barang
   - `4` - Update Stok Barang
   - `5` - Hapus Barang
   - `0` - Keluar

### Contoh Menambah Barang Elektronik:
```
Pilih menu (0-5): 1
Pilih jenis barang: 1
Masukkan ID Produk: E002
Masukkan Nama Produk: Smartphone
Masukkan Harga Produk: 5000000
Masukkan Stok Awal: 20
Masukkan Merk: Samsung
Masukkan Tanggal Garansi (dd-MM-yyyy): 31-12-2025
```

## 📝 Class Diagram

```
                    ┌─────────────────┐
                    │     Product     │
                    ├─────────────────┤
                    │ - id: String    │
                    │ - nama: String  │
                    │ - harga: double │
                    │ - stok: int     │
                    │ - kategori: String│
                    ├─────────────────┤
                    │ + infoProduk()  │
                    │ + updateStok()  │
                    └────────┬────────┘
                             │
        ┌────────────────────┼────────────────────┐
        │                    │                    │
        ▼                    ▼                    ▼
┌───────────────┐    ┌───────────────┐    ┌───────────────┐
│  Electronics  │    │     Food      │    │   Clothing    │
├───────────────┤    ├───────────────┤    ├───────────────┤
│ - garansi     │    │ - tglKadaluarsa│   │ - ukuran      │
│ - merk        │    └───────────────┘    │ - warna       │
└───────────────┘                         └───────────────┘
```

## 👨‍💻 Teknologi

- Java 11+
- Visual Studio Code

## 📄 Lisensi

Project ini dibuat untuk keperluan pembelajaran Java dan OOP.