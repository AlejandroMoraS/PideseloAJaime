package mx.iteso.jaimeapp.pideseloajaime.AdapterClass;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.Beans.PacksCategories;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductBeerPack;
import mx.iteso.jaimeapp.pideseloajaime.Gui.ActivityProductSodaPack;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class AdapterPacks extends RecyclerView.Adapter<AdapterPacks.PacksViewHolder> {

    private static final String DEBUG_TAG = "AdapterPacks";
    private ArrayList<PacksCategories> mPacksList;
    private Context context;

    public AdapterPacks(Context context, ArrayList<PacksCategories> dataSet) {
        this.mPacksList = dataSet;
        this.context = context;
    }

    @Override
    public PacksViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.categories, parent, false);
        PacksViewHolder mviewHolder = new PacksViewHolder(view);
        return mviewHolder;
    }

    @Override
    public void onBindViewHolder(AdapterPacks.PacksViewHolder holder, final int position) {

        PacksCategories mpaquetes = mPacksList.get(position);

        String PaquetesName = mpaquetes.getPackName();
        Drawable PaquetesImage = mpaquetes.getPackImage();

        TextView name = holder.packsName;
        name.setText(PaquetesName);

        ImageView picture = holder.packsImage;
        picture.setImageDrawable(PaquetesImage);
    }

    @Override
    public int getItemCount() {
        if (mPacksList.isEmpty()) {
            return 0;
        } else {
            return mPacksList.size();
        }
    }

    public class PacksViewHolder extends RecyclerView.ViewHolder {
        private ImageView packsImage;
        private TextView packsName;

        public PacksViewHolder(View itemView) {
            super(itemView);

            packsImage = itemView.findViewById(R.id.fragment_imageCategory);
            packsName = itemView.findViewById(R.id.fragment_textCategory);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int requestCode = getAdapterPosition();
                    Intent intent;
                    PacksCategories packsCategories = mPacksList.get(requestCode);
                    Log.d(DEBUG_TAG, "AdapterPacks itemView listener for adapter position: " + requestCode);
                    switch (requestCode) {
                        case 0:
                            intent = new Intent(context, ActivityProductBeerPack.class);
                            context.startActivity(intent);
                            break;
                        case 1:
                            intent = new Intent(context, ActivityProductSodaPack.class);
                            context.startActivity(intent);
                            break;
                        case 2:
                            intent = new Intent(context, ActivityProductBeerPack.class);
                            context.startActivity(intent);
                            break;
                        case 3:
                            intent = new Intent(context, ActivityProductBeerPack.class);
                            context.startActivity(intent);
                            break;

                    }

                }
            });




        }
    }
}