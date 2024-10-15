// Don't delete any comments below!!!
// Todo : Import Arraylist and Scanner
import java.util.ArrayList;
import java.util.Scanner;

public class ManajemenInventaris {
    // Todo : Create ArrayList of MakananKering (daftarMakananKering) and MakananBasah (daftarMakananBasah) to store items

    public ArrayList<MakananKering> daftarMakananKering = new ArrayList<>();
    public ArrayList<MakananBasah> daftarMakananBasah = new ArrayList<>();
    


    public void tambahMakananKering() {
        Scanner scanner = new Scanner(System.in);
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Brand Makanan
        System.out.println("Masukkan nama makanan : ");
        String nama = scanner.nextLine();
        
        System.out.println("Masukkan jumlah makanan : ");
        int jumlah = scanner.nextInt();
        
        System.out.println("Masukkan harga makanan : ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        System.out.println("Masukkan brand makanan : ");
        String brand = scanner.nextLine();
        
        
        
        // Todo : Create a new object for MakananKering
        
        MakananKering kering = new MakananKering(nama, jumlah, harga, brand);
        
        daftarMakananKering.add(kering);
        
        // Todo : Create Print Notifitaction "Makanan kering berhasil ditambahkan"
        System.out.println("Makanan berhasil ditambahkan");
    }
    
    public void tambahMakananBasah() {
        // Todo : Create input for Nama Makanan, Jumlah Makanan, Harga Makanan, and Bahan Makanan
        Scanner scanner = new Scanner(System.in);
        System.out.println("Masukkan nama makanan : ");
        String nama = scanner.nextLine();
        
        System.out.println("Masukkan jumlah makanan : ");
        int jumlah = scanner.nextInt();
        
        System.out.println("Masukkan harga makanan : ");
        double harga = scanner.nextDouble();
        scanner.nextLine();
        
        System.out.println("Masukkan bahan makanan : ");
        String bahan = scanner.nextLine();
        
        // Todo : Create a new object for MakananBasah
        MakananBasah basah = new MakananBasah(nama, jumlah, harga, bahan);
        
        daftarMakananBasah.add(basah);
        
        // Todo :Create Print Notifitaction "Makanan Basah berhasil ditambahkan"
    }

    public void tampilkanSemuaMakanan() {
        if (daftarMakananKering.isEmpty() && daftarMakananBasah.isEmpty()) {
            // Todo : Create Print Notification "Tidak ada makanan disini"
            System.out.println("tidak ada makanan di sini");
        } else {
            // Todo : Create print notification for Makanan Kering
            for (MakananKering kering : daftarMakananKering) {
                System.err.println("==========");
                kering.ShowData();
            }
            // Todo : Create print notification for Makanan Basah
            for (MakananBasah basah : daftarMakananBasah) {
                System.err.println("===========");
                basah.ShowData();
            }
        }
    }
    
}
