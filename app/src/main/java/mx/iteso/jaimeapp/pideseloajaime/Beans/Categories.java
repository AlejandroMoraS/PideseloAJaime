package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;

public class Categories {
    protected String categoryName;
    protected Drawable categoryImage;

    public Categories(String categoryName, Drawable categoryImage) {
        this.categoryName = categoryName;
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Drawable getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Drawable categoryImage) {
        this.categoryImage = categoryImage;
    }

}
