package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;

public class BeverageCategories {
    protected String beverageName;
    protected Drawable beverageImage;

    public BeverageCategories(String beverageName, Drawable beverageImage) {
        this.beverageName = beverageName;
        this.beverageImage = beverageImage;
    }

    public String getBeverageName() {
        return beverageName;
    }

    public void setBeverageName(String beverageName) {
        this.beverageName = beverageName;
    }

    public Drawable getBeverageImage() {
        return beverageImage;
    }

    public void setBeverageImage(Drawable beverageImage) {
        this.beverageImage = beverageImage;
    }

}
