import java.util.Scanner;

public class RoyalDelishMain {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        BuyerQueue queue = new BuyerQueue();
        OrderList orders = new OrderList();

        int menu;

        do {

            System.out.println("\n==============================");
            System.out.println("ROYAL DELISH QUEUE SYSTEM");
            System.out.println("==============================");
            System.out.println("1. Add Queue");
            System.out.println("2. Print Queue");
            System.out.println("3. Remove Queue and Order");
            System.out.println("4. Order Report");
            System.out.println("0. Exit");

            System.out.print("Choose menu : ");
            menu = sc.nextInt();
            sc.nextLine();

            switch (menu) {

                case 1:

                    System.out.print("Buyer Name   : ");
                    String name = sc.nextLine();

                    System.out.print("Phone Number : ");
                    String phone = sc.nextLine();

                    queue.addQueue(name, phone);

                    break;

                case 2:

                    queue.printQueue();

                    break;

                case 3:

                    Buyer servedBuyer = queue.removeQueue();

                    if (servedBuyer != null) {

                        System.out.println("\nServed Buyer:");
                        System.out.println("Queue Number : "
                                + servedBuyer.queueNumber);

                        System.out.println("Buyer Name   : "
                                + servedBuyer.name);

                        System.out.println("Phone Number : "
                                + servedBuyer.phoneNumber);

                        System.out.println("--------------------------------");

                        System.out.print("Order Code : ");
                        int code = sc.nextInt();
                        sc.nextLine();

                        System.out.print("Order Name : ");
                        String orderName = sc.nextLine();

                        System.out.print("Price      : ");
                        int price = sc.nextInt();
                        sc.nextLine();

                        Order order = new Order(code, orderName, price);

                        orders.addOrder(order);

                        System.out.println("Order has been successfully added.");
                    }

                    break;

                case 4:

                    orders.printReport();

                    break;

                case 0:

                    System.out.println("Program finished.");

                    break;

                default:

                    System.out.println("Invalid menu!");
            }

        } while (menu != 0);
    }
}