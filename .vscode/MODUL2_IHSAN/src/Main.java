public class Main {
    public static void main(String[] args) {

        // To do: Buatlah sebuah Objek baru dari class Komputer
        Komputer komputer = new Komputer(null, 0, null);

        // To do: Panggillah Method Informasi dari class Komputer
        komputer.Informasi();
        

        System.out.println();


        // To do: Buatlah sebuah Objek baru dari class KomputerVIP 
        KomputerVIP komputerVIP = new KomputerVIP(true, null, 0, null);

        // To do: Panggillah Method Informasi dari class KomputerVIP
        komputerVIP.Informasi();

        // To do: Panggillah Method Login
        komputerVIP.Login("Kobo");

        // To do: Panggillah Method Bermain 2x agar dapat melakukan polymorphism overloading
        komputerVIP.Bermain(2);
        komputerVIP.Bermain(2, 10);
        

        System.out.println();


        // To do: Buatlah sebuah Objek baru dari class KomputerPremium
        KomputerPremium komputerPremium = new KomputerPremium(true, null, 0, null);

        // To do: Panggillah Method Informasi dari class KomputerPremium
        komputerPremium.Informasi();

        // To do: Panggillah Method Pesan
        komputerPremium.Pesan(10);

        // To do: Panggillah Method TambahLayanan 2x agar dapat melakukan polymorphism overloading
        komputerPremium.TambahLayanan("Mie Ayam");
        komputerPremium.TambahLayanan("Mie Ayam", "Panther");
        
    }
}