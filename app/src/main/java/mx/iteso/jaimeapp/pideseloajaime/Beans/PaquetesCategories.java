package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;

public class PaquetesCategories {
    protected Drawable PaquetesImage;
    protected String PaquetesName;

    public PaquetesCategories(Drawable paquetesImage, String paquetesName) {
        PaquetesImage = paquetesImage;
        PaquetesName = paquetesName;
    }

    public Drawable getPaquetesImage() {
        return PaquetesImage;
    }

    public void setPaquetesImage(Drawable paquetesImage) {
        PaquetesImage = paquetesImage;
    }

    public String getPaquetesName() {
        return PaquetesName;
    }

    public void setPaquetesName(String paquetesName) {
        PaquetesName = paquetesName;
    }
}
