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

import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class AdapterProduct1 extends RecyclerView.Adapter<AdapterProduct1.ViewHolder> {
    private ArrayList<Product> dataSet;
    private Context context;


    public AdapterProduct1(Context context, ArrayList<Product> dataSet){
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public AdapterProduct1.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        ViewHolder mviewHolder = new ViewHolder(view);
        return mviewHolder;

    }
    @Override
    public void onBindViewHolder(AdapterProduct1.ViewHolder holder, int position) {

        Product mproduct = dataSet.get(position);

        String productName = mproduct.getProductName();
        double productPrice = mproduct.getProductPrice();
        Drawable productImage = mproduct.getProductImage();

        holder.productName.setText(productName);

        holder.productPrice.setText("$" + productPrice);


        holder.productImage.setImageDrawable(productImage);
    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;
        public TextView productPrice;
        public ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.fragment_textName);
            productPrice = (TextView) itemView.findViewById(R.id.fragment_textPrice);
            productImage = (ImageView) itemView.findViewById(R.id.fragment_imageProduct);


        }

    }
}