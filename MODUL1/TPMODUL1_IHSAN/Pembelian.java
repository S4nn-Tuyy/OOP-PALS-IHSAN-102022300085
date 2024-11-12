import java.util.ArrayList;
import java.util.Scanner;

public class Pembelian {
    public static void main(String[] args) {
        ArrayList<Penerbangan> daftarPenerbangan = new ArrayList<>();
        ArrayList<Penumpang> daftarPenumpang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarPenerbangan.add(new Penerbangan("GA001", "Soekarno Hatta", "Sultan Hasanuddin", "08:00", "10:00", (float) 150000));
        daftarPenerbangan.add(new Penerbangan("GA002", "Soekarno Hatta", "Husein Sastranegara", "09:00", "11:00", (float) 1200000));

        System.out.println("Selamat datang di EAD Ticket Booking System");

        while (true) {
            System.out.println("\nMenu");
            System.out.println("1. Tampilkan Daftar Penerbangan");
            System.out.println("2. Pesan Tiket");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            int pilihan = scanner.nextInt();
            scanner.nextLine();

            if (pilihan == 1) {
                System.out.println("\nDaftar Penerbangan:");
                for (int i = 0; i < daftarPenerbangan.size(); i++) {
                    System.out.println((i + 1) + ". " + daftarPenerbangan.get(i).getNomorPenerbangan() + " - " +
                                       daftarPenerbangan.get(i).getBandaraKeberangkatan() + " ke " +
                                       daftarPenerbangan.get(i).getBandaraTujuan() + " (Harga: Rp " +
                                       daftarPenerbangan.get(i).getHargaTiket() + ")");
                }

            } else if (pilihan == 2) {
                // Memasukkan data penumpang
                System.out.print("Masukkan NIK: ");
                String NIK = scanner.nextLine();
                System.out.print("Masukkan Nama Depan: ");
                String namaDepan = scanner.nextLine();
                System.out.print("Masukkan Nama Belakang: ");
                String namaBelakang = scanner.nextLine();
                Penumpang penumpang = new Penumpang(NIK, namaDepan, namaBelakang);

                System.out.println("\nPilih penerbangan yang ingin dipesan:");
                for (int i = 0; i < daftarPenerbangan.size(); i++) {
                    System.out.println((i + 1) + ". " + daftarPenerbangan.get(i).getNomorPenerbangan() + " - " +
                                       daftarPenerbangan.get(i).getBandaraKeberangkatan() + " ke " +
                                       daftarPenerbangan.get(i).getBandaraTujuan() + " (Harga: Rp " +
                                       daftarPenerbangan.get(i).getHargaTiket() + ")");
                }
                System.out.print("Masukkan nomor penerbangan: ");
                int nomorPenerbangan = scanner.nextInt();
                scanner.nextLine(); 

                if (nomorPenerbangan > 0 && nomorPenerbangan <= daftarPenerbangan.size()) {
                    Penerbangan penerbanganDipilih = daftarPenerbangan.get(nomorPenerbangan - 1);
                    daftarPenumpang.add(penumpang);

                    System.out.println("\nDetail Pesanan Anda:");
                    penumpang.tampilDaftarPenumpang();
                    penerbanganDipilih.tampilDaftarPenerbangan();
                } else {
                    System.out.println("Nomor penerbangan tidak valid.");
                }

            } else if (pilihan == 3) {
                System.out.println("Terima kasih telah menggunakan EAD Ticket Booking System.");
                break;
            } else {
                System.out.println("Pilihan tidak valid, coba lagi.");
            }
        }

        scanner.close();
    }
}
