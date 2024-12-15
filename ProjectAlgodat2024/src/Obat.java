public class Obat {
    String nama;
    int jumlah;

    public Obat(String nama, int jumlah) {
        this.nama = nama;
        this.jumlah = jumlah;
    }

    public String toString() {
        return nama + " (" + jumlah + ")";
    }
}
