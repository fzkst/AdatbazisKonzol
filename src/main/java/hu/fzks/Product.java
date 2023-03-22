package hu.fzks;

public class Iphone {
    private int id;

    public Iphone(int id, String model, String color, int storage, int stock, String image) {
        this.id = id;
        this.model = model;
        this.color = color;
        this.storage = storage;
        this.stock = stock;
        this.image = image;
    }

    private String model;
    private String color;
    private int storage;
    private int stock;
    private String image;

    @Override
    public String toString() {
        return "Iphone{" +
                "id=" + id +
                ", model='" + model + '\'' +
                ", color='" + color + '\'' +
                ", storage=" + storage +
                ", stock=" + stock +
                ", image='" + image + '\'' +
                '}';
    }
}
