package mx.iteso.jaimeapp.pideseloajaime.Beans;


import android.graphics.drawable.Drawable;

public class Product {
    protected Drawable productImage;
    protected String productName;
    protected String productPrice;

    public Product(Drawable productImage, String productName, String productPrice) {
        this.productImage = productImage;
        this.productName = productName;
        this.productPrice = productPrice;
    }

    public Drawable getProductImage() {
        return productImage;
    }

    public void setProductImage(Drawable productImage) {
        this.productImage = productImage;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductPrice() {
        return productPrice;
    }

    public void setProductPrice(String productPrice) {
        this.productPrice = productPrice;
    }


}
