
import java.util.Scanner;

// Don't delete any comments below!!!
// Todo: Import Scanner

public class Main {
    public static void main(String[] args) {
        // Todo : Create ManajemenInventaris Object and Scanner
        ManajemenInventaris Makanan = new ManajemenInventaris();
        Scanner scanner = new Scanner(System.in);

        // Todo : Create Loop list menu
        while (true) {
            System.out.println("=== Menu utama ====");
            System.out.println("1. Tambah Makanan Kering");
            System.out.println("2. Tambah Makanan Basah");
            System.out.println("3. Tampilkan Semua Makanan");
            System.out.println("4. Exit");
            System.out.println("pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1 :
                    Makanan.tambahMakananKering();
                    break;
                case 2 : 
                    Makanan.tambahMakananBasah();
                    break;
                    case 3 : 
                    Makanan.tampilkanSemuaMakanan();
                    break;
                case 4 :
                    System.out.println("Terimakasih");
                    System.exit(0);
                default:
                    throw new AssertionError();
            }
        }
        
    }
}
