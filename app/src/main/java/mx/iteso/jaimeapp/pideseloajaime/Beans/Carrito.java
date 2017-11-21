package mx.iteso.jaimeapp.pideseloajaime.Beans;

import java.util.HashMap;

public class Carrito {
    int image;
    double cost;
    int quantity;
    private static Carrito carrito;
    HashMap<Product, Integer> products;

    public Carrito() {
        products = new HashMap<>();
    }

    public static Carrito getInstance() {
        if(carrito == null) {
            carrito = new Carrito();
        }
        return carrito;

    }

    public void addProduct(Product product, int quantity) {
        if(products.get(product) != null) {
            products.put(product, products.get(product) + quantity);
        } else {
            products.put(product, quantity);
        }
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public double getCost() {
        double cost = 0;
        for (Product p: products.keySet()) {
            cost += p.getProductPrice() * products.get(p);
        }
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantify) {
        this.quantity = quantify;
    }

}
