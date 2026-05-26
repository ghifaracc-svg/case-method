public class BuyerQueue {
    BuyerNode front, rear;
    int size = 0;
    int queueCounter = 1;

    boolean isEmpty() {
        return front == null;
    }

    void addQueue(String name, String phoneNumber) {
        Buyer buyer = new Buyer(queueCounter++, name, phoneNumber);
        BuyerNode newNode = new BuyerNode(buyer);

        if (isEmpty()) {
            front = rear = newNode;
        } else {
            rear.next = newNode;
            newNode.prev = rear;
            rear = newNode;
        }

        size++;

        System.out.println("Queue has been successfully added with number: "
                + buyer.queueNumber);
    }

    Buyer removeQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return null;
        }

        Buyer removedBuyer = front.data;
        front = front.next;

        if (front != null) {
            front.prev = null;
        } else {
            rear = null;
        }

        size--;
        return removedBuyer;
    }

    void printQueue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!");
            return;
        }

        System.out.println("\n===== QUEUE LIST =====");

        BuyerNode current = front;

        while (current != null) {
            System.out.println("Queue Number : " + current.data.queueNumber);
            System.out.println("Buyer Name   : " + current.data.name);
            System.out.println("Phone Number : " + current.data.phoneNumber);
            System.out.println("--------------------------------");

            current = current.next;
        }

        System.out.println("Total Queue : " + size);
    }
}