public class LinkedListPengiriman {
    PengirimanNode head;

    public void tambahPengiriman(String id, String apotek, String obat, int jumlah) {
        PengirimanNode newNode = new PengirimanNode(id, apotek, obat, jumlah);
        if (head == null) {
            head = newNode;
        } else {
            PengirimanNode current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
    }

    public void hapusPengiriman(String id) {
        if (head == null) return;

        if (head.idPengiriman.equals(id)) {
            head = head.next;
            return;
        }

        PengirimanNode current = head;
        while (current.next != null && !current.next.idPengiriman.equals(id)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public PengirimanNode cariApotek(String apotek) {
        PengirimanNode current = head;
        while (current != null) {
            if (current.apotekTujuan.equals(apotek)) {
                return current;
            }
            current = current.next;
        }
        return null;
    }

    public void cetakPengiriman() {
        PengirimanNode current = head;
        while (current != null) {
            System.out.println("ID Pengiriman: " + current.idPengiriman + ", Apotek Tujuan: " + current.apotekTujuan + ", Obat: " + current.namaObat + " (jumlah : " + current.jumlahObat + ")");
            current = current.next;
        }
    }
}
