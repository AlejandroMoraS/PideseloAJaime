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

public class ActivityProductJuices extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> juicesDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_juices);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_juices_recycler);

        Log.d("tanto", "onCreate: " + recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> juicesDataSet = new ArrayList<Product>();

        Resources res = getResources();
        juicesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_jugos_durazno), "Jumex Durazno \n1 L", 20.00));
        juicesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_jugos_mango), "Jumex Mango \n1 L", 20.00));
        juicesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_jugos_manzana), "Jumex Manzana \n1 L", 20.00));
        juicesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_jugos_pinia), "Jumex Piña \n1 L", 20.00));
        juicesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_jugos_tomate), "Jumex Tomate \n1 L", 20.00));

        mAdapter = new AdapterProduct(this, juicesDataSet);
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
