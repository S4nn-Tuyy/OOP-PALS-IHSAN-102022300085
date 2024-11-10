public class Main {
    public static void main(String[] args) throws Exception {
        Meow meow = new Meow("Garfiel", 2, "Persia");
        meow.infoHewan();
        meow.suara();
        meow.makan();
        meow.makan("wiskas");

        System.out.println();

        perkutuk perkutuk = new perkutuk("Blu", 2, "biru");
        perkutuk.infoHewan();
        perkutuk.suara();
        perkutuk.makan();
        perkutuk.makan("cacing");
    }
}