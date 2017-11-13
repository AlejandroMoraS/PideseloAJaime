package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProduct extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);
        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_beerRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();


        Product product1 = new Product(getResources().getDrawable(R.drawable.imagen_corona_clara), "Corona 355ml", "$11.50");
        Product product2 = new Product(getResources().getDrawable(R.drawable.imagen_mammoth), "Mammoth 355ml", "$12.50");
        Product product3 = new Product(getResources().getDrawable(R.drawable.imagen_heineken), "Heineken 355ml", "$15.50");
        Product product4 = new Product(getResources().getDrawable(R.drawable.imagen_sol), "Sol 355ml", "$10.50");
        Product product5 = new Product(getResources().getDrawable(R.drawable.imagen_indio), "Indio 355ml", "$10.00");
        Product product6 = new Product(getResources().getDrawable(R.drawable.imagen_budweiser), "Budweiser 355ml", "$12.50");
        Product product7 = new Product(getResources().getDrawable(R.drawable.imagen_stella), "Stella 355ml", "$11.50");
        Product product8 = new Product(getResources().getDrawable(R.drawable.imagen_minerva), "Minerva 355ml", "$13.50");
        Product product9 = new Product(getResources().getDrawable(R.drawable.imagen_samueladams), "Samuel Adams 355ml", "$12.50");
        Product product10 = new Product(getResources().getDrawable(R.drawable.imagen_budlight), "Bud Light 355ml", "$10.50");
        Product product11 = new Product(getResources().getDrawable(R.drawable.imagen_modelo), "Modelo Oscura 355ml", "$13.00");


        myDataSet.add(product1);
        myDataSet.add(product2);
        myDataSet.add(product3);
        myDataSet.add(product4);
        myDataSet.add(product5);
        myDataSet.add(product6);
        myDataSet.add(product7);
        myDataSet.add(product8);
        myDataSet.add(product9);
        myDataSet.add(product10);
        myDataSet.add(product11);



        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);


    }


    @Override
    public void onClick(View v) {
        //toolbar.
    }
}


