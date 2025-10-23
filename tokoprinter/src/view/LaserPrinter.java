package view;

public class LaserPrinter extends Printer {
    int kecepatanCetak;

    public LaserPrinter(String nama, float harga, String merk, String tipe, int kecepatanCetak) {
        super(nama, harga, merk, tipe);
        this.kecepatanCetak = kecepatanCetak;
    }

    public void showLaserDetails() {
        System.out.println("Kecepatan Cetak: " + this.kecepatanCetak + " ppm");
    }

    @Override
    public void displayPrinterDetails() {
        super.displayPrinterDetails();
    }
}