package mx.iteso.jaimeapp.pideseloajaime.AdapterClass;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.Beans.FoodCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class FoodAdapter extends RecyclerView.Adapter<FoodAdapter.FoodViewholder> {

    private Context context;
    private ArrayList<FoodCategories> mFoodList;

    public FoodAdapter(Context context, ArrayList<FoodCategories> mFoodList) {
        this.context = context;
        this.mFoodList = mFoodList;
    }

    @Override
    public FoodViewholder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater li = LayoutInflater.from(parent.getContext());
        View v = li.inflate(R.layout.row_food_categories, parent, false);
        return new FoodAdapter.FoodViewholder(v);
    }

    @Override
    public void onBindViewHolder(FoodViewholder holder, int position) {
        FoodCategories mFoodCategories = mFoodList.get(position);

        String foodName = mFoodCategories.getFoodName();
        Drawable foodPicture = mFoodCategories.getFoodPicture();

        TextView name = holder.mFoodName;
        name.setText(foodName);

        ImageView picture = holder.mFoodPicture;
        picture.setImageDrawable(foodPicture);
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