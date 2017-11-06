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
import android.widget.Toast;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.Beans.Categories;
import mx.iteso.jaimeapp.pideseloajaime.R;
import mx.iteso.jaimeapp.pideseloajaime.gui.ActivityProduct;


public class AdapterCategories extends RecyclerView.Adapter<AdapterCategories.ViewHolder> implements View.OnClickListener{
    private ArrayList<Categories> dataSet;
    private Context context;

    public AdapterCategories(Context context, ArrayList<Categories> dataSet){
        this.dataSet = dataSet;
        this.context = context;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories, parent, false);
        ViewHolder mviewHolder = new ViewHolder(view);
        return mviewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        Categories mcategories = dataSet.get(position);

        String categoryName = mcategories.getCategoryName();
        Drawable categoryImage = mcategories.getCategoryImage();

        TextView name = holder.categoryName;
        name.setText(categoryName);

        ImageView picture = holder.categoryImage;
        picture.setImageDrawable(categoryImage);


        ((ViewHolder)holder).categoryImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent;
                switch (position){
                    case 0:
                        intent = new Intent(v.getContext(), ActivityProduct.class);
                        context.startActivity(intent);
                        break;
                    case 1: Toast.makeText(context, "Diste click a la posision " +
                            position, Toast.LENGTH_SHORT).show();
                        break;
                    case 2: Toast.makeText(context, "Diste click a la posision " +
                            position, Toast.LENGTH_SHORT).show();
                        break;
                }

            }
        });


    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }

    @Override
    public void onClick(View v) {

    }


    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView categoryImage;
        private TextView categoryName;

        public ViewHolder(View itemView) {
            super(itemView);

            categoryImage = (ImageView) itemView.findViewById(R.id.fragment_imageCategory);
            categoryName = (TextView) itemView.findViewById(R.id.fragment_textCategory);

        }
    }


}
