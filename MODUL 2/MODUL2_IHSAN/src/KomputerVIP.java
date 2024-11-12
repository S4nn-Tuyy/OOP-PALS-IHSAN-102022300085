class KomputerVIP extends Komputer {
    // To do: Buatlah 1 variable sesuai ketentuan
    protected boolean vipCard;
    
    // To do: Buatlah constructor pada class KomputerVIP
    public KomputerVIP(boolean vipCard, String namaWarnet, int jumlahKomputer, Float hargaPerJam) {
        super(namaWarnet, jumlahKomputer, hargaPerJam);
        this.vipCard = vipCard;
    }
    
    // To do: Buatlah Method Informasi memakai Polymorphism Override dengan isi yang sesuai dengan ketentuan 
    @Override
    public void Informasi() {
        super.Informasi();
        if(vipCard) {
            System.out.println("Status : " + vipCard);
            System.out.println();
            System.out.println("Benefit member VIP : ");
            System.out.println("- Diskon 10% untuk bermain selama 3 jam");
            System.out.println("- Gratis minuman untuk bermain selama 4 jam");
            System.out.println("- prioritas Booking komputer");
        }
        else {
            System.out.println("Benefit member VIP : ");
            System.out.println("Jangan ngarep bro");
        }
    }
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)
    
    // To do: Buatlah method Login sesuai dengan ketentuan
    public void Login(String username) {
        System.out.println("Username: " + username);
        System.out.println("Login Berhasil");
    }
    
    // To do: Buatlah method Bermain sesuai dengan ketentuan
    public void Bermain(int jam) {
        System.out.println("Anda bermain selama " + jam + " jam");
    }

    
    // To do: Buatlah method Bermain memakai Polymorphism Overloading sesuai dengan ketentuan
    public void Bermain(int jam, int menitTamabahan) {
        System.out.println("Anda bermain selama " + jam + " jam " + menitTamabahan + " menit");
    }


}