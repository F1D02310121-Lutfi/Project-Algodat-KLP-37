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

    public String getID(){
        return this.idPengiriman;
    }

    public String getNama(){
        return this.namaObat;
    }

    public int getJumlah(){
        return this.jumlahObat;
    }

    public String getTujuan(){
        return this.apotekTujuan;
    }

    public String getInformasi(){
        return "ID Pengiriman: " + idPengiriman + ", Apotek Tujuan: " + apotekTujuan;
    }
}
    