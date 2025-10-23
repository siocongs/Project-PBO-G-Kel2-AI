import view.InkjetPrinter;
import view.LaserPrinter;

public class Main {
    public static void main(String[] args) {
        System.out.println("===== DETAIL PRINTER INKJET =====");
        InkjetPrinter inkjet = new InkjetPrinter("Epson L3210", 2500000.0f, "Epson", "A4 Ink Tank", 4);


        inkjet.displayInfo();
        inkjet.displayPrinterDetails();
        inkjet.showInkDetails();

        System.out.println("\n===== DETAIL PRINTER LASER =====");
        LaserPrinter laser = new LaserPrinter("HP LaserJet M111w", 3150000.0f, "HP", "Monochrome Laser", 20);


        laser.displayInfo();
        laser.displayPrinterDetails();
        laser.showLaserDetails();
    }
}