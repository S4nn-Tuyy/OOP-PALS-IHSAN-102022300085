public class perkutuk extends hewan {
  private String warnaBulu;

  public perkutuk(String nama, int umur, String warnaBulu) {
    super(nama, umur);
    this.warnaBulu = warnaBulu;
  }
  @Override
  public void suara() {
    System.out.println(nama + " berkicau 'cicicuit'");
  }
  @Override
  public void infoHewan() {
    super.infoHewan();
    System.out.println("Warna Bulu: " + warnaBulu);
  }
  
}
