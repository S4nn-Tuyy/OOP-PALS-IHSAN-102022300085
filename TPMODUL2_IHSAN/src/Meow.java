public class Meow extends hewan {
  private String ras;

  public Meow(String nama, int umur, String ras) {
    super(nama, umur);
    this.ras = ras;
  }

  public void suara() {
    System.out.println(nama + " Meow Meow");
  }

  public void infoHewan() {
    super.infoHewan();
    System.out.println("Ras: " + ras);
  }
}