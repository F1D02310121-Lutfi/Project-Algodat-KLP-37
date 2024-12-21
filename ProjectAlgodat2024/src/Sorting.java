public class Sorting {
    public void sortPengiriman(LinkedListPengiriman list) {
        if (list.head == null) return;

        PengirimanNode current = list.head;
        while (current != null) {
            PengirimanNode index = current.next;
            while (index != null) {
                if (current.jumlahObat > index.jumlahObat) {
                    // Swap data
                    String tempNama = current.namaObat;
                    int tempJumlah = current.jumlahObat;
                    String tempApotek = current.apotekTujuan;
                    String tempId = current.idPengiriman;

                    current.namaObat = index.namaObat;
                    current.jumlahObat = index.jumlahObat;
                    current.apotekTujuan = index.apotekTujuan;
                    current.idPengiriman = index.idPengiriman;

                    index.namaObat = tempNama;
                    index.jumlahObat = tempJumlah;
                    index.apotekTujuan = tempApotek;
                    index.idPengiriman = tempId;
                }
                index = index.next;
            }
            current = current.next;
        }
    }
}