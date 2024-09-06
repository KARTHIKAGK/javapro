import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

class Product {
    private String name;
    private double price;
    private int quantity;

    public Product(String name, double price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }
}

class ShoppingCart {
    private List<Product> items;

    public ShoppingCart() {
        items = new ArrayList<>();
    }

    public void addItem(Product product) {
        items.add(product);
    }

    public void viewItems() {
        System.out.println("Items in the cart:");
        for (Product item : items) {
            System.out.println(item.getName() + " - $" + item.getPrice() + " - Quantity: " + item.getQuantity());
        }
    }

    public void buyItems() {
        System.out.println("Items purchased successfully!");
        items.clear();
    }

    public double calculateTotal() {
        double total = 0;
        for (Product item : items) {
            total += item.getPrice() * item.getQuantity();
        }
        return total;
    }
}

public class ShoppingApp {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1. Add Item");
            System.out.println("2. View Cart");
            System.out.println("3. Buy Items");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter product name: ");
                    String name = scanner.next();
                    System.out.print("Enter product price: ");
                    double price = scanner.nextDouble();
                    System.out.print("Enter product quantity: ");
                    int quantity = scanner.nextInt();
                    Product product = new Product(name, price, quantity);
                    cart.addItem(product);
                    break;
                case 2:
                    cart.viewItems();
                    System.out.println("Total: $" + cart.calculateTotal());
                    break;
                case 3:
                    cart.buyItems();
                    break;
                case 4:
                    System.out.println("Thank you for using the shopping app!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}