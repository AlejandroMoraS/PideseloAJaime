package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;


public class Categories {
    protected Drawable categoryImage;
    protected String categoryName;

    public Categories(Drawable categoryImage, String categoryName) {
        this.categoryImage = categoryImage;
        this.categoryName = categoryName;
    }




    public Drawable getCategoryImage() {
        return categoryImage;
    }

    public void setCategoryImage(Drawable categoryImage) {
        this.categoryImage = categoryImage;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }


}
