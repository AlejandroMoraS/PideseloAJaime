package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
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
        TableLayout tl = (TableLayout)findViewById(R.id.activity_carrito_table);
        for (Product p : products.keySet()) {
            LayoutInflater inflater = (LayoutInflater) this.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            TableRow rowView = (TableRow)inflater.inflate(R.layout.display_carrito, null);
            TextView tv_product = (TextView)rowView.getChildAt(0);
            tv_product.setText(p.getProductName());
            TextView tv_cost = (TextView)rowView.getChildAt(1);
            tv_cost.setText("$" + p.getProductPrice());
            tl.addView(rowView);
            /*

            TableRow tr = (TableRow)findViewById(R.id.activity_carrito_row);
            TextView tv_product = tr.findViewById(R.id.activity_carrito_producto);
            tv_product.setText(p.getProductName());
            tl.addView(tr);
            */
        }
    }
}
