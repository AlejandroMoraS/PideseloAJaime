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

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<Product> dataSet;
    private Context context;

    public AdapterProduct(Context context, ArrayList<Product> dataSet){
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.product, parent, false);
        ViewHolder mviewHolder = new ViewHolder(view);
        return mviewHolder;

    }
    @Override
    public void onBindViewHolder(AdapterProduct.ViewHolder holder, int position) {

        Product mproduct = dataSet.get(position);

        String productName = mproduct.getProductName();
        String productPrice = mproduct.getProductPrice();
        String productCart = mproduct.getProductCart();
        Drawable productImage = mproduct.getProductImage();

        TextView name = holder.productName;
        name.setText(productName);

        TextView price = holder.producPrice;
        name.setText(productPrice);

        TextView cart = holder.productCart;
        name.setText(productCart);


        ImageView picture = holder.productImage;
        picture.setImageDrawable(productImage);

    }


    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;
        public TextView producPrice;
        public TextView productCart;
        public ImageView productImage;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.fragment_textName);
            producPrice = (TextView) itemView.findViewById(R.id.fragment_textPrice);
            productCart = (TextView) itemView.findViewById(R.id.fragment_textCart);
            productImage = (ImageView) itemView.findViewById(R.id.fragment_imageProduct);


        }



    }



}
