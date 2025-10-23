package view;

public class Product {
    String nama;
    float harga;

    public Product(String nama, float harga) {
        this.nama = nama;
        this.harga = harga;
    }

    public void displayInfo() {
        System.out.println("Nama Produk: " + this.nama);
        System.out.println("Harga: Rp" + this.harga);
    }
}