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


        Product product1 = new Product(getResources().getDrawable(R.drawable.imagen_corona_clara), "Corona 355ml", "$11.50");
        Product product2 = new Product(getResources().getDrawable(R.drawable.imagen_mammoth), "Mammoth 355ml", "$15.50");
        Product product3 = new Product(getResources().getDrawable(R.drawable.imagen_minerva), "Mammoth 355ml", "$15.50");
        Product product4 = new Product(getResources().getDrawable(R.drawable.imagen_heineken), "Mammoth 355ml", "$15.50");
        Product product5 = new Product(getResources().getDrawable(R.drawable.imagen_sol), "Mammoth 355ml", "$15.50");
        Product product6 = new Product(getResources().getDrawable(R.drawable.imagen_indio), "Mammoth 355ml", "$15.50");
        Product product7 = new Product(getResources().getDrawable(R.drawable.imagen_budweiser), "Mammoth 355ml", "$15.50");
        Product product8 = new Product(getResources().getDrawable(R.drawable.imagen_stella), "Mammoth 355ml", "$15.50");
        myDataSet.add(product1);
        myDataSet.add(product2);
        myDataSet.add(product3);
        myDataSet.add(product4);
        myDataSet.add(product5);
        myDataSet.add(product6);
        myDataSet.add(product7);
        myDataSet.add(product8);


        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);


    }


}


