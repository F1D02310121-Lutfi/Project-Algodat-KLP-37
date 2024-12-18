public class Queue {
    public NodeQueue front, rear;

    public void enqueue(String id) {
        NodeQueue newNode = new NodeQueue(id);
        if (rear == null) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public NodeQueue dequeue() {
        if (front == null) return null;
        NodeQueue temp = front;
        front = front.next;
        if (front == null) rear = null;
        return temp;
    }

    public void cetakQueue() {
        NodeQueue current = front;
        while (current != null) {
            System.out.println("ID Pengiriman: " + current.idPengiriman);
            current = current.next;
        }
    }
}