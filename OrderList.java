public class OrderList {
    OrderNode head, tail;
    int totalRevenue = 0;

    boolean isEmpty() {
        return head == null;
    }

    void addOrder(Order order) {
        OrderNode newNode = new OrderNode(order);

        if (isEmpty()) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }

        totalRevenue += order.price;
    }

    void sortOrder() {
        if (isEmpty()) {
            return;
        }

        boolean swapped;

        do {
            swapped = false;

            OrderNode current = head;

            while (current.next != null) {

                if (current.data.orderName.compareToIgnoreCase(
                        current.next.data.orderName) > 0) {

                    Order temp = current.data;
                    current.data = current.next.data;
                    current.next.data = temp;

                    swapped = true;
                }

                current = current.next;
            }

        } while (swapped);
    }

    void printReport() {
        if (isEmpty()) {
            System.out.println("No order data!");
            return;
        }

        sortOrder();

        System.out.println("====================================");
        System.out.println("ORDER REPORT");
        System.out.println("====================================");

        System.out.printf("%-10s %-20s %-10s\n",
                "Code", "Order Name", "Price");

        OrderNode current = head;

        while (current != null) {

            System.out.printf("%-10d %-20s %-10d\n",
                    current.data.orderCode,
                    current.data.orderName,
                    current.data.price);

            current = current.next;
        }

        System.out.println("------------------------------------");
        System.out.println("Total Revenue : Rp " + totalRevenue);
    }
}