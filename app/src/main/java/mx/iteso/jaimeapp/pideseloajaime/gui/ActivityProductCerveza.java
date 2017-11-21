package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Carrito;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProductCerveza extends AppCompatActivity implements View.OnClickListener{

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
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_beerRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();

        Resources res = getResources();
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_corona_clara), "Corona 355ml", 11.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_mammoth), "Mammoth 355ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_heineken), "Heineken 355ml", 15.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_sol), "Sol 355ml", 10.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_indio), "Indio 355ml", 10.00));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_budweiser), "Budweiser 355ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_stella), "Stella 355ml", 11.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_minerva), "Minerva 355ml", 13.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_samueladams), "Samuel Adams 355ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_budlight), "Bud Light 355ml", 10.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_modelo), "Modelo Oscura 355ml", 13.00));

        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onClick(View v) {
        Log.d("tag", "onClick: product?");
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        Log.d("tag", "onClick: product?");
        return super.onOptionsItemSelected(item);
    }
}


