package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProduct extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_beerRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();


        Product product1 = new Product(getResources().getDrawable(R.drawable.imagen_corona_clara), "Corona 355ml", "$11.50", "add to cart");
        Product product2 = new Product(getResources().getDrawable(R.drawable.icon_beer), "cerveza", "1000", "add to cart");
        myDataSet.add(product1);
        myDataSet.add(product2);

        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);


    }


}


