public class NodeQueue {
    String idPengiriman;
    NodeQueue next;

    NodeQueue(String idPengiriman) {
        this.idPengiriman = idPengiriman;
        this.next = null;
    }
}