package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class ActivityProductSodas extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> sodaDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_sodas);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_sodas_recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        sodaDataSet = new ArrayList<Product>();

        Resources res = getResources();
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_coca), "Coca Cola \n3L", 25.00));
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_coca_light), "Coca Cola Light 1.5L", 19.50));
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_fanta), "Fanta 1.5L", 11.00));
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_sidral), "Sidral 2L", 21.50));
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_sprite), "Sprite 2L", 20.50));
        sodaDataSet.add(new Product(res.getDrawable(R.drawable.imagen_refrescos_squirt), "Squirt 2L", 17.50));

        mAdapter = new AdapterProduct(this, sodaDataSet);
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
