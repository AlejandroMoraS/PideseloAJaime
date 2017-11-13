package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.function.ToLongBiFunction;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProductPaquetes extends AppCompatActivity {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_paquetes);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.paquetesRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();

        Product product1 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_corona), "12x Corona 355ml", "$110.50");
        Product product2 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_vitoria), "12x Victoria 355ml", "$130.50");
        Product product3 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_tecate), "6x Tecate 355ml", "$60.50");
        Product product4 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_indio), "6x Indio 355ml", "$75.50");
        Product product5 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_heineken), "6x Heineken 355ml", "$80.50");
        Product product6 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_tecatelight), "6x Tecate Light 355ml", "$60.50");
        Product product7 = new Product(getResources().getDrawable(R.drawable.imagen_paquetes_modelo), "6x Modelo 355ml", "$70.50");


        myDataSet.add(product1);
        myDataSet.add(product2);
        myDataSet.add(product3);
        myDataSet.add(product4);
        myDataSet.add(product5);
        myDataSet.add(product6);
        myDataSet.add(product7);


        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);
    }
}
