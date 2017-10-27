package mx.iteso.jaimeapp.pideseloajaime.Beans;

import android.graphics.drawable.Drawable;

public class FoodCategories {

    private String foodName;
    private Drawable foodPicture;

    public FoodCategories() {
    }

    public FoodCategories(String foodName, Drawable foodPicture) {
        this.foodName = foodName;
        this.foodPicture = foodPicture;
    }

    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Drawable getFoodPicture() {
        return foodPicture;
    }

    public void setFoodPicture(Drawable foodPicture) {
        this.foodPicture = foodPicture;
    }
}