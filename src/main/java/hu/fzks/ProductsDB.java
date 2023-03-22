package hu.fzks;

import javax.imageio.spi.ServiceRegistry;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ProductsDB {
    private Connection conn;
    public static String DB_DRIVER = "mysql";
    public static String DB_HOST = "localhost";
    public static String DB_PORT = "3306";
    public static String DB_NAME = "almaskosar_webshop_v2";
    public static String DB_USER = "root";
    public static String DB_PASSWORD = "";

    public ProductsDB() throws SQLException {
        String url = "jdbc:" + DB_DRIVER + "://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;
        conn = DriverManager.getConnection(url, DB_USER, DB_PASSWORD);
    }

    public List<Product> productsToListFromDB() throws SQLException {
        List<Product> products = new ArrayList<>();
        Statement stmt = conn.createStatement();
        String sql = "SELECT * FROM products";
        ResultSet resultSet = stmt.executeQuery(sql);
        while (resultSet.next()){
            int id = resultSet.getInt("id");
            int categoryId = resultSet.getInt("category_id");
            String model = resultSet.getString("model");
            String color = resultSet.getString("color");
            int storage = resultSet.getInt("storage");
            int price = resultSet.getInt("price");
            int stock = resultSet.getInt("stock");
            String image = resultSet.getString("image");
            products.add(new Product(id, categoryId, model, color, storage, price, stock, image));
        }
        return products;
    }

    public void addProductToDB(Product product) throws SQLException {
        String sql = "INSERT INTO products(category_id, model, color, storage, price, stock, image) VALUES" +
                "(?,?,?,?,?,?,?)";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, product.getCategoryId());
        stmt.setString(2, product.getModel());
        stmt.setString(3, product.getColor());
        stmt.setInt(4, product.getStorage());
        stmt.setInt(5, product.getPrice());
        stmt.setInt(6, product.getStock());
        stmt.setString(7, product.getImage());
        stmt.execute();
    }

    public void deleteProductFromDB(int id) throws SQLException {
        String sql = "DELETE FROM products WHERE id = ?";
        PreparedStatement stmt = conn.prepareStatement(sql);
        stmt.setInt(1, id);
        if (stmt.executeUpdate() > 0)
            System.out.println("A termék törlése sikeres!");
        else
            System.out.println("Ilyen azonosítóval nem található termék!");
    }
}
