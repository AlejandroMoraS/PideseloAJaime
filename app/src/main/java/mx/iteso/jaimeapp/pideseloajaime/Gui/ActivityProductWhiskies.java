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

public class ActivityProductWhiskies extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> whiskiesDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_whiskies);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_whiskies_recycler);

        Log.d("tanto", "onCreate: " + recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        whiskiesDataSet = new ArrayList<Product>();

        Resources res = getResources();
        whiskiesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_whisky_buchanans), "Buchanan's Deluxe \n750 ml", 1530.00));
        whiskiesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_whisky_jack_daniels), "Jack Daniel's \n700 ml\n", 360.00));
        whiskiesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_whisky_johnnie_walker_black_label), "Johnnie Walker Black Label \n750 ml", 725.00));
        whiskiesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_whisky_johnnie_walker_red_label), "Johnnie Walker Red Label \n750 ml", 360.00));

        mAdapter = new AdapterProduct(this, whiskiesDataSet);
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
