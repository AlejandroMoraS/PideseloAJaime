package mx.iteso.jaimeapp.pideseloajaime.Gui;

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
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProductBeer extends AppCompatActivity implements View.OnClickListener {

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
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_corona_clara), "Corona \n355 ml", 11.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_mammoth), "Mammoth \n355 ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_heineken), "Heineken \n355 ml", 15.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_sol), "Sol \n355 ml", 10.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_indio), "Indio \n355 ml", 10.00));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_budweiser), "Budweiser \n355 ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_stella), "Stella \n355 ml", 11.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_minerva), "Minerva \n355 ml", 13.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_samuel_adams), "Samuel Adams \n355 ml", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_budlight), "Bud Light \n355 ml", 10.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_cervezas_modelo), "Modelo Oscura 355 ml", 13.00));

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
