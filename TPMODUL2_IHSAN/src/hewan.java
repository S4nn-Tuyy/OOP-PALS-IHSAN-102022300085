public class hewan {
  protected String nama;
  protected int umur;
  
  public hewan(String nama, int umur) {
    this.nama = nama;
    this.umur = umur;
  }
  public void suara() {
    System.out.println("Hewan bersuara");
  }
  public void makan() {
    System.out.println(nama + " makan");
  }
  public void makan(String makanan) {
    System.out.println(nama + " Sedang makan " + makanan + ".");
  }
  public void infoHewan() {
    System.out.println("Nama Hewan: " + nama);
    System.out.println("Umur Hewan: " + umur + " tahun");
  }
}
