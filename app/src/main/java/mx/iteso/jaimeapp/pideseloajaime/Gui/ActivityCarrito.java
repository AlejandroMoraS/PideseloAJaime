package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import java.util.HashMap;

import mx.iteso.jaimeapp.pideseloajaime.Beans.Carrito;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityCarrito extends ActivityAbstract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito);
        onCreateDrawer();

        HashMap<Product, Integer> products = Carrito.getInstance().getProducts();
        final TableLayout tl = (TableLayout)findViewById(R.id.activity_carrito_table);
        double t = 0;
        for (final Product p : products.keySet()) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            final TableRow rowView = (TableRow)inflater.inflate(R.layout.display_carrito, null);
            TextView tv_product = (TextView)rowView.getChildAt(0);
            tv_product.setText(p.getProductName());
            TextView tv_cost = (TextView)rowView.getChildAt(1);
            tv_cost.setText("$" + p.getProductPrice());
            EditText et_quantity = (EditText)rowView.getChildAt(2);
            et_quantity.setText(products.get(p) + "");

            tl.addView(rowView);

            ImageButton btn = (ImageButton)rowView.getChildAt(3);
            btn.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v) {
                    tl.removeView(rowView);
                    Carrito.getInstance().removeProduct(p);
                }
            });
            t += p.getProductPrice() * products.get(p);

        }
        TextView tv_total = (TextView)findViewById(R.id.activity_carrito_total);
        tv_total.setText(t + "");
        //TextView tv_total = (TextView)findViewById(R.id.activity_carrito_total);
        //tv_total.setText(Carrito.getInstance().getCost() + "");

    }
    public void onClick(View v) {
        Intent intent = new Intent(ActivityCarrito.this, ActivityMaps.class);
        startActivity(intent);
        finish();
    }
}
