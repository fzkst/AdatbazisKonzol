package hu.fzks;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static ProductsDB db;
    public static void productList() throws SQLException {
        List<Product> products = db.productsToListFromDB();
        products.forEach(System.out::println);
    }

    public static void addProduct() throws SQLException {
        int categoryId = 3;
        String model = "MacBook Air";
        String szin = "ezüst";
        int tarhely = 512;
        int ar = 499999;
        int keszlet = 5;
        String kep = "macbookAir13ezust.jpg";
        Product product = new Product(0, categoryId, model, szin, tarhely, ar, keszlet, kep);
        db.addProductToDB(product);
    }

    public static void addProductFromConsole() throws SQLException {
        String valasz = "i";
        do {
            Scanner sc = new Scanner(System.in);
            System.out.println("Kérem, adja meg a feltöltendő termék adatait!");
            System.out.print("Kategória száma: ");
            int kategoria = Integer.parseInt(sc.nextLine());
            System.out.print("Modell: ");
            String model = sc.nextLine();
            System.out.print("Szín: ");
            String szin = sc.nextLine();
            System.out.print("Tárhely: ");
            int tarhely = Integer.parseInt(sc.nextLine());
            System.out.print("Ár: ");
            int ar = Integer.parseInt(sc.nextLine());
            System.out.print("Készlet: ");
            int keszlet = Integer.parseInt(sc.nextLine());
            System.out.print("Kép: ");
            String kep = sc.nextLine();
            Product product = new Product(0,kategoria, model, szin, tarhely, ar, keszlet, kep);
            db.addProductToDB(product);
            System.out.println("\nA terméket sikeresen hozzáadta az adatbázishoz!");
            System.out.println("Szeretne új terméket feltölteni? i/n");
            valasz = sc.next();
        } while (valasz.equals("i"));
    }

    public static void deleteProduct(int id) throws SQLException {
        db.deleteProductFromDB(id);
    }

    public static void main(String[] args) {
        try {
            db = new ProductsDB();
            //productList();
            //addProduct();
            //deleteProduct(208);
            addProductFromConsole();
        } catch (SQLException e){
            throw new RuntimeException(e);
        }
    }
}