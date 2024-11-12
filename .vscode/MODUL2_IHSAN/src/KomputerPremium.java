class KomputerPremium extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean ruangPrivat;
    
    // To do: Buatlah constructor pada class KomputerPremium
    public KomputerPremium(boolean ruangPrivat, String namaWarnet, int jumlahKomputer, Float hargaPerJam) {
        super(namaWarnet, jumlahKomputer, hargaPerJam);
        this.ruangPrivat = ruangPrivat;
    }
    
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    @Override
    public void Informasi() {
        super.Informasi();
        if(ruangPrivat) {
            System.out.println("Status : " + ruangPrivat);
            System.out.println();
            System.out.println("Benefit ruang Premium : ");
            System.out.println("- Ruang ac pribadi");
            System.out.println("- Sofa gaming");
            System.out.println("- Komputer spek tinggi");
            System.out.println("- Koneksi gacor");
        }
        else {
            System.out.println("Status : " + ruangPrivat);
            System.out.println();
            System.out.println("- Ruang gerah");
            System.out.println("- Kursi kondangan");
            System.out.println("- komputer spek kentang");
            System.out.println("- Koneksi 0.5 Mbps");
        }
    }
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)

    
    // To do: Buatlah method Pesan sesuai dengan ketentuan
    public void Pesan(int nomorKomputer) {
        System.out.println("memesan Komputer : " + nomorKomputer);
    }
    
    // To do: Buatlah method TambahLayanan sesuai dengan ketentuan
    public void TambahLayanan(String makanan) {
        System.out.println("Menambah layanan makanan : " + makanan);
    }
    
    // To do: Buatlah method TambahLayanan memakai Polymorphism Overloading sesuai dengan ketentuan

    public void TambahLayanan(String makanan, String minuman) {
        System.out.println("Menambah layanan makanan : " + makanan + " dan minuman : " + minuman);
    }

    
}
