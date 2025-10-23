package view;

public class InkjetPrinter extends Printer {
    int jumlahWarna;

    public InkjetPrinter(String nama, float harga, String merk, String tipe, int jumlahWarna) {
        super(nama, harga, merk, tipe);
        this.jumlahWarna = jumlahWarna;
    }

    public void showInkDetails() {
        System.out.println("Jumlah Warna Tinta: " + this.jumlahWarna);
    }

    @Override
    public void displayPrinterDetails() {
        super.displayPrinterDetails();
    }
}