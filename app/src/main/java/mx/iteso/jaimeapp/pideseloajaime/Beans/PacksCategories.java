package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;

public class PacksCategories {
    protected Drawable packImage;
    protected String packName;

    public PacksCategories() {
    }

    public PacksCategories(Drawable packImage, String packName) {
        this.packImage = packImage;
        this.packName = packName;
    }

    public Drawable getPackImage() {
        return packImage;
    }

    public void setPackImage(Drawable packImage) {
        this.packImage = packImage;
    }

    public String getPackName() {
        return packName;
    }

    public void setPackName(String packName) {
        this.packName = packName;
    }
}
