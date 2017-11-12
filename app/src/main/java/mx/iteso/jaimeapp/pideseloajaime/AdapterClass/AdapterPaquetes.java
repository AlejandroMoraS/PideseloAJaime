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

import mx.iteso.jaimeapp.pideseloajaime.Beans.PaquetesCategories;
import mx.iteso.jaimeapp.pideseloajaime.R;


public class AdapterPaquetes extends RecyclerView.Adapter<AdapterPaquetes.ViewHolder> implements View.OnClickListener{
    private ArrayList<PaquetesCategories> dataSet;
    private Context context;

    public AdapterPaquetes(Context context, ArrayList<PaquetesCategories> dataSet){
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

        PaquetesCategories mpaquetes = dataSet.get(position);

        String PaquetesName = mpaquetes.getPaquetesName();
        Drawable PaquetesImage = mpaquetes.getPaquetesImage();

        TextView name = holder.paquetesName;
        name.setText(PaquetesName);

        ImageView picture = holder.paquetesImage;
        picture.setImageDrawable(PaquetesImage);


        ((ViewHolder)holder).paquetesImage.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v){
                Intent intent;
                switch (position){
                    case 0:
                        Toast.makeText(context, "Diste click a la posision " +
                                position, Toast.LENGTH_SHORT).show();
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
        private ImageView paquetesImage;
        private TextView paquetesName;

        public ViewHolder(View itemView) {
            super(itemView);

            paquetesImage = (ImageView) itemView.findViewById(R.id.fragment_imageCategory);
            paquetesName = (TextView) itemView.findViewById(R.id.fragment_textCategory);

        }
    }


}