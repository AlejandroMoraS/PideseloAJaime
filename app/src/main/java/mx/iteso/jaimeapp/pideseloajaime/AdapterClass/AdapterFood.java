package mx.iteso.jaimeapp.pideseloajaime.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.Beans.FoodCategories;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductChips;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductHamburger;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductHotDogs;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductMeats;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class AdapterFood extends RecyclerView.Adapter<AdapterFood.FoodViewholder> {
    private Context context;
    private ArrayList<FoodCategories> mFoodList;

    public AdapterFood(Context context, ArrayList<FoodCategories> mFoodList) {
        this.context = context;
        this.mFoodList = mFoodList;
    }

    @Override
    public FoodViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.row_food_categories, parent, false);
        return new AdapterFood.FoodViewholder(v);
    }

    @Override
    public void onBindViewHolder(FoodViewholder holder, final int position) {

        FoodCategories mFoodCategories = mFoodList.get(position);
        String foodName = mFoodCategories.getFoodName();
        //double foodPrice = mFoodCategories.getFoodPrice();
        Drawable foodPicture = mFoodCategories.getFoodPicture();


        TextView name = holder.mFoodName;
        name.setText(foodName);

        ImageView picture = holder.mFoodPicture;


        picture.setImageDrawable(foodPicture);

        ((FoodViewholder)holder).mFoodPicture.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(v.getContext(), ActivityProductChips.class);
                        context.startActivity(intent);
                        break;
                    case 1:
                        intent = new Intent(v.getContext(), ActivityProductHamburger.class);
                        context.startActivity(intent);
                        break;
                    case 2:
                        intent = new Intent(v.getContext(), ActivityProductHotDogs.class);
                        context.startActivity(intent);
                        break;
                    case 3:
                        intent = new Intent(v.getContext(), ActivityProductMeats.class);
                        context.startActivity(intent);
                        break;
                    case 4:
                        intent = new Intent(v.getContext(), ActivityProductHamburger.class);
                        context.startActivity(intent);
                        break;
                }

            }
        });

    }



    @Override
    public int getItemCount() {
        if (mFoodList.isEmpty()) {
            return 0;
        } else {
            return mFoodList.size();
        }
    }

    public class FoodViewholder extends RecyclerView.ViewHolder {

        private TextView mFoodName;
        private ImageView mFoodPicture;

        public FoodViewholder(View itemView) {
            super(itemView);

            mFoodName = itemView.findViewById(R.id.row_fragment_food_name);
            mFoodPicture = itemView.findViewById(R.id.row_fragment_food_picture);
        }
    }
}