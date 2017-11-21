package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.content.Intent;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Carrito {
    int image;
    double cost;
    int quantity;
    private static Carrito carrito;
    HashMap<Integer, Product> products;

    public Carrito() {

        products = new HashMap<>();
    }

    public static Carrito getInstance() {
        if(carrito == null) {
            carrito = new Carrito();
        }
        return carrito;

    }

    public int getImage() {
        return image;
    }

    public void addProduct(Product product, int quantity) {
        products.put(quantity, product);
        this.cost += 6;
    }
    public void setImage(int image) {
        this.image = image;
    }

    public double getCost() {
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
