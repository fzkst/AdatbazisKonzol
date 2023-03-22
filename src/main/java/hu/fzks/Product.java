package hu.fzks;

public class Product {
    private int id;
    private int categoryId;
    private String model;
    private String color;
    private int storage;
    private int price;
    private int stock;
    private String image;

    public Product(int id, int categoryId, String model, String color, int storage, int price, int stock, String image) {
        this.id = id;
        this.categoryId = categoryId;
        this.model = model;
        this.color = color;
        this.storage = storage;
        this.price = price;
        this.stock = stock;
        this.image = image;
    }


    public int getCategoryId() {
        return categoryId;
    }

    public String getModel() {
        return model;
    }

    public String getColor() {
        return color;
    }

    public int getStorage() {
        return storage;
    }

    public int getPrice() {
        return price;
    }

    public int getStock() {
        return stock;
    }

    public String getImage() {
        return image;
    }

    @Override
    public String toString() {
        return "Termék azonosítója: " + id +
                ", kategória: " + categoryId +
                ", modell: " + model +
                ", szín: " + color +
                ", tárhely: " + storage +
                ", ár: " + price +
                ", készlet: " + stock +
                ", kép: " + image;
    }
}
