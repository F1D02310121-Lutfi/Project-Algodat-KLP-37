public class Main {
    public static void main(String[] args) throws Exception {
        LinkedListPengiriman pengirimanList = new LinkedListPengiriman();
        Stack stackObat = new Stack();
        Sorting sorting = new Sorting();
        Graph graph = new Graph();
        Queue queuePengiriman = new Queue();

        // Tambah data pengiriman
        pengirimanList.tambahPengiriman("100", "Apotek Farma 1", "Paracetamol", 10);
        queuePengiriman.enqueue("100");
        pengirimanList.tambahPengiriman("200", "Apotek Farma 2", "Acetylcysteine", 5);
        queuePengiriman.enqueue("200");
        pengirimanList.tambahPengiriman("300", "Apotek Farma 3", "Chlorphenamine Maleate", 12);
        queuePengiriman.enqueue("300");
        pengirimanList.tambahPengiriman("400", "Apotek Farma 4", "Vitamin C", 14);
        queuePengiriman.enqueue("400");
        pengirimanList.tambahPengiriman("500", "Apotek Farma 5", "Bodrex Flu & Batuk", 6);
        queuePengiriman.enqueue("500");

        // Tambah data stack obat
        stackObat.push("Paracetamol", 10);
        stackObat.push("Acetylcysteine", 5);
        stackObat.push("Chlorphenamine Maleate", 12);
        stackObat.push("Vitamin C", 14);
        stackObat.push("Bodrex Flu & Batuk", 6);

        System.out.println("== WELCOME TO MEDSUPPLY! ==");
        System.out.println("\n=> DAFTAR INFORMASI PENGIRIMAN AWAL (linked list)");
        pengirimanList.cetakPengiriman();

        System.out.println("\n=> DAFTAR INFORMASI OBAT AWAL (stack)");
        stackObat.cetakStack();

        System.out.println("\n=> DAFTAR URUTAN OBAT SESUAI JUMLAH (sorting)");
        sorting.sortPengiriman(pengirimanList);
        pengirimanList.cetakPengiriman();

        System.out.println("\n=> MENCARI \"Apotek Farma 1\"...");
        PengirimanNode hasil = pengirimanList.cariApotek("Apotek Farma 1");
        if (hasil != null) {
            System.out.println("Apotek ditemukan: " + hasil.apotekTujuan);
        } else {
            System.out.println("Apotek tidak ditemukan.");
        }

        graph.addNode("Apotek Farma 1");
        graph.addNode("Apotek Farma 2");
        graph.addNode("Apotek Farma 3");
        graph.addNode("Apotek Farma 4");
        graph.addNode("Apotek Farma 5");
        graph.addEdge("Apotek Farma 1", "Apotek Farma 2", 5);
        graph.addEdge("Apotek Farma 1", "Apotek Farma 3", 10);
        graph.addEdge("Apotek Farma 2", "Apotek Farma 4", 3);
        graph.addEdge("Apotek Farma 3", "Apotek Farma 4", 1);
        graph.addEdge("Apotek Farma 4", "Apotek Farma 5", 2);

        System.out.println("\n=> MENGHITUNG JARAK TERDEKAT DARI \"Apotek Farma 1\"...");
        graph.dijkstra("Apotek Farma 1");

        // Proses pengiriman dengan Queue
        System.out.println("\n=> PROSES PENGIRIMAN DENGAN ANTRIAN (queue):");

        // Mengambil ID pengiriman pertama dari queue dan memprosesnya
        NodeQueue pengiriman = queuePengiriman.dequeue();
        if (pengiriman != null) {
            System.out.println("Memproses pengiriman ID: " + pengiriman.idPengiriman);
            pengirimanList.hapusPengiriman(pengiriman.idPengiriman);
            stackObat.hapusObat("Paracetamol"); // Misalnya menghapus Paracetamol sesuai dengan ID
        }

        // Cetak status setelah pengiriman
        System.out.println("\n=> DAFTAR INFORMASI PENGIRIMAN SETELAH PENGIRIMAN (linked list)");
        pengirimanList.cetakPengiriman();

        System.out.println("\n=> DAFTAR INFORMASI OBAT SETELAH PENGIRIMAN (stack)");
        stackObat.cetakStack();
    }
}