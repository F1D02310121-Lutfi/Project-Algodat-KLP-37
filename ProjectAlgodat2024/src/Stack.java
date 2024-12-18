public class Stack {
    private Node top;

    private class Node {
        String namaObat;
        int jumlah;
        Node next;

        Node(String namaObat, int jumlah) {
            this.namaObat = namaObat;
            this.jumlah = jumlah;
            this.next = null;
        }
    }

    public void push(String nama, int jumlah) {
        Node newNode = new Node(nama, jumlah);
        newNode.next = top;
        top = newNode;
    }

    public void hapusObat(String nama) {
        if (top == null) return;

        if (top.namaObat.equals(nama)) {
            top = top.next;
            return;
        }

        Node current = top;
        while (current.next != null && !current.next.namaObat.equals(nama)) {
            current = current.next;
        }

        if (current.next != null) {
            current.next = current.next.next;
        }
    }

    public void swapToTop(String nama) {
        if (top == null || top.namaObat.equals(nama)) return;

        Node prev = null;
        Node current = top;

        while (current != null && !current.namaObat.equals(nama)) {
            prev = current;
            current = current.next;
        }

        if (current != null && prev != null) {
            prev.next = current.next;
            current.next = top;
            top = current;
        }
    }

    public void cetakStack() {
        Node current = top;
        while (current != null) {
            System.out.println("Obat: " + current.namaObat + " (jumlah : " + current.jumlah + ")");
            current = current.next;
        }
    }
}
