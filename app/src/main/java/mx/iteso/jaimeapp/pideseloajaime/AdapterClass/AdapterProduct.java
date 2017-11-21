package mx.iteso.jaimeapp.pideseloajaime.AdapterClass;


import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

import static com.facebook.FacebookSdk.getApplicationContext;
import static mx.iteso.jaimeapp.pideseloajaime.R.layout.product;

public class AdapterProduct extends RecyclerView.Adapter<AdapterProduct.ViewHolder> {
    private ArrayList<Product> dataSet;
    private Context context;


    public AdapterProduct(Context context, ArrayList<Product> dataSet){
        this.dataSet = dataSet;
        this.context = context;
    }

    @Override
    public AdapterProduct.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(product, parent, false);
        ViewHolder mviewHolder = new ViewHolder(view);
        return mviewHolder;

    }
    @Override
    public void onBindViewHolder(final AdapterProduct.ViewHolder holder, final int position) {

        Product mproduct = dataSet.get(position);

        final String productName = mproduct.getProductName();
        final String productPrice = mproduct.getProductPrice();
        final Drawable productImage = mproduct.getProductImage();
        final Button productButton = mproduct.getProductButton();

        holder.productName.setText(productName);

        holder.producPrice.setText(productPrice);

        holder.productImage.setImageDrawable(productImage);

        holder.productButton.setText("Agregar al carrito");

        ((ViewHolder)holder).productButton.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v){
                switch (position){
                    case 0:
                        if (holder.productButton.getText() == "Agregar al carrito"){
                            Toast.makeText(getApplicationContext(),"Producto añadido al carrito", Toast.LENGTH_SHORT).show();
                            holder.productButton.setText("Agregado al Carrito");
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_gray);


                        } else if (holder.productButton.getText() == "Agregado al Carrito"){
                            Snackbar snack = Snackbar.make(v, "Este producto ya esta en tu carrito",Snackbar.LENGTH_SHORT);
                            snack.setAction(R.string.undo_txt, new MyUndoListener());
                            snack.show();
                        }
                        break;

                    case 1:
                        if (holder.productButton.getText() == "Agregar al carrito"){
                            Toast.makeText(getApplicationContext(),"Producto añadido al carrito", Toast.LENGTH_SHORT).show();
                            holder.productButton.setText("Agregado al Carrito");
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_gray);


                        } else if (holder.productButton.getText() == "Agregado al Carrito"){
                            Snackbar snack = Snackbar.make(v, "Este producto ya esta en tu carrito",Snackbar.LENGTH_SHORT);
                            snack.setAction(R.string.undo_txt, new MyUndoListener());
                            snack.show();
                        }
                        break;



                    case 2:
                        if (holder.productButton.getText() == "Agregar al carrito"){
                            Toast.makeText(getApplicationContext(),"Producto añadido al carrito", Toast.LENGTH_SHORT).show();
                            holder.productButton.setText("Agregado al Carrito");
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_gray);


                        } else if (holder.productButton.getText() == "Agregado al Carrito"){
                            Snackbar snack = Snackbar.make(v, "Este producto ya esta en tu carrito",Snackbar.LENGTH_SHORT);
                            snack.setAction(R.string.undo_txt, new MyUndoListener());
                            snack.show();
                        }
                        break;

                }

            }

            class MyUndoListener implements View.OnClickListener{

                @Override
                public void onClick(View v) {
                    switch (position){
                        case 0:
                            holder.productButton.setText(R.string.agregarCarrito_txt);
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_blue);
                            break;

                        case 1:
                            holder.productButton.setText(R.string.agregarCarrito_txt);
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_blue);
                            break;

                        case 2:
                            holder.productButton.setText(R.string.agregarCarrito_txt);
                            holder.productButton.setBackgroundResource(R.drawable.buttonstyle_blue);
                            break;

                    }
                }
            }
        });


    }




    @Override
    public int getItemCount() {
        return dataSet.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;
        public TextView producPrice;
        public ImageView productImage;
        public Button productButton;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = (TextView) itemView.findViewById(R.id.fragment_textName);
            producPrice = (TextView) itemView.findViewById(R.id.fragment_textPrice);
            productImage = (ImageView) itemView.findViewById(R.id.fragment_imageProduct);
            productButton = (Button) itemView.findViewById(R.id.boton_agregarCarrito);


        }

    }

}