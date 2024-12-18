public class Supply {
    String nama, jenis;
    int jumlah;

    public Supply(String nama, String jenis, int jumlah) {
        this.nama = nama;
        this.jenis = jenis;
        this.jumlah = jumlah;
    }

    public String toString() {
        return nama + " (" + jumlah + ")";
    }
}
