class Komputer {
    protected String namaWarnet;
    protected int jumlahKomputer;
    protected Float hargaPerJam;

    public Komputer(String namaWarnet, int jumlahKomputer, Float hargaPerJam) {
        this.namaWarnet = namaWarnet;
        this.jumlahKomputer = jumlahKomputer;
        this.hargaPerJam = hargaPerJam;
    }

    public void Informasi() {
        System.out.println("INFORMASI KOMPUTER : ");
        System.out.println("Nama Warnet : " + namaWarnet);
        System.out.println("Jumlah Komputer : " + jumlahKomputer);
        System.out.println("Harga Per Jam : " + hargaPerJam);
    }

    
    
    // To do: Buatlah Method Informasi dengan isi yang sesuai dengan ketentuan 
    // (boleh berbeda dengan output jurnal tetapi dengan cangkupan masih sesuai oleh materi modul!)

}