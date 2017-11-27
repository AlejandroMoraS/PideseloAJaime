package mx.iteso.jaimeapp.pideseloajaime.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import mx.iteso.jaimeapp.pideseloajaime.Beans.BeverageCategories;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductWines;
import mx.iteso.jaimeapp.pideseloajaime.R;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductBeer;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductJuices;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductSodas;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductTequilas;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductVodkas;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductWhiskies;

public class AdapterBeverages extends RecyclerView.Adapter<AdapterBeverages.BeverageViewHolder> {

    private static final String DEBUG_TAG = "AdapterBeverages";

    private ArrayList<BeverageCategories> dataSet;
    private Context context;

    public AdapterBeverages(Context context, ArrayList<BeverageCategories> dataSet) {
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public BeverageViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories, parent, false);
        BeverageViewHolder mviewHolder = new BeverageViewHolder(view);
        return mviewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterBeverages.BeverageViewHolder holder, final int position) {

        BeverageCategories mcategories = dataSet.get(position);

        String categoryName = mcategories.getBeverageName();
        Drawable categoryImage = mcategories.getBeverageImage();

        TextView name = holder.categoryName;
        name.setText(categoryName);

        ImageView picture = holder.categoryImage;
        picture.setImageDrawable(categoryImage);
    }

    @Override
    public int getItemCount() {
        if (dataSet.isEmpty()) {
            return 0;
        } else {
            return dataSet.size();
        }
    }

    public class BeverageViewHolder extends RecyclerView.ViewHolder {
        private ImageView categoryImage;
        private TextView categoryName;

        public BeverageViewHolder(View itemView) {
            super(itemView);

            categoryImage = itemView.findViewById(R.id.fragment_imageCategory);
            categoryName = itemView.findViewById(R.id.fragment_textCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int requestCode = getAdapterPosition();
                    Intent intent;
                    BeverageCategories beverageCategories = dataSet.get(requestCode);
                    Log.d(DEBUG_TAG, "AdapterBeverages itemView listener for adapter position: " + requestCode);
                    String beverageName = beverageCategories.getBeverageName();
                    Bundle bundle = new Bundle();
                    bundle.putString("beverage_name", beverageName);

                    switch (requestCode) {
                        case 0:
                            intent = new Intent(context, ActivityProductBeer.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(context, ActivityProductSodas.class);
                            context.startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(context, ActivityProductJuices.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(context, ActivityProductTequilas.class);
                            context.startActivity(intent);
                            break;
                        case 4:
                            intent = new Intent(context, ActivityProductVodkas.class);
                            context.startActivity(intent);
                            break;
                        case 5:
                            intent = new Intent(context, ActivityProductWhiskies.class);
                            context.startActivity(intent);
                            break;
                        case 6:
                            intent = new Intent(context, ActivityProductWines.class);
                            context.startActivity(intent);
                            break;
                    }

                    //Intent intent = new Intent(context, ActivityProductBeer.class);
                    //intent.putExtras(bundle);
                    //context.startActivity(intent);
                }
            });
        }
    }

}

