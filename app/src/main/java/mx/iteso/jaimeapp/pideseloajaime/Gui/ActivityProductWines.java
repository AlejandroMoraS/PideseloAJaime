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

public class ActivityProductWines extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> winesDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_wines);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_wines_recycler);

        Log.d("tanto", "onCreate: " + recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        winesDataSet = new ArrayList<Product>();

        Resources res = getResources();
        winesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_vinos_casillero_del_diablo), "Vino Tinto Casillero del Diablo \n750 ml", 288.00));
        winesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_vinos_xa), "Vino Tinto \nXA Domecq \n375 ml\n", 56.00));
        winesDataSet.add(new Product(res.getDrawable(R.drawable.imagen_vinos_gato_negro), "Vino Blanco \nGato Negro \n750 ml", 100.00));

        mAdapter = new AdapterProduct(this, winesDataSet);
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
