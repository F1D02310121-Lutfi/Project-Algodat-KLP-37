public class PengirimanNode {
    String idPengiriman;
    String apotekTujuan;
    String namaObat;
    int jumlahObat;
    PengirimanNode next;

    public PengirimanNode(String idPengiriman, String apotekTujuan, String namaObat, int jumlahObat) {
        this.idPengiriman = idPengiriman;
        this.apotekTujuan = apotekTujuan;
        this.namaObat = namaObat;
        this.jumlahObat = jumlahObat;
        this.next = null;
    }
}
    