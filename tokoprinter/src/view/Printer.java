package view;

public class Printer extends Product {
    String merk;
    String tipe;

    public Printer(String nama, float harga, String merk, String tipe) {
        super(nama, harga);
        this.merk = merk;
        this.tipe = tipe;
    }

    public void displayPrinterDetails() {
        System.out.println("Merk: " + this.merk);
        System.out.println("Tipe: " + this.tipe);
    }

    @Override
    public void displayInfo() {
        super.displayInfo();
    }
}