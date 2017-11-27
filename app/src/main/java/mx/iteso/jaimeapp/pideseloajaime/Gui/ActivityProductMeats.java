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

public class ActivityProductMeats extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> meatsDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_meats);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_meats_recycler);

        Log.d("tanto", "onCreate: " + recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        meatsDataSet = new ArrayList<Product>();

        Resources res = getResources();
        meatsDataSet.add(new Product(res.getDrawable(R.drawable.imagen_carnes_peinecillo), "Peinecillo \n1 kg", 154.00));
        meatsDataSet.add(new Product(res.getDrawable(R.drawable.imagen_carnes_rib_eye), "Rib Eye \n1 kg", 244.00));
        meatsDataSet.add(new Product(res.getDrawable(R.drawable.imagen_carnes_costillitas), "Costillitas BBQ \n1 kg", 246.00));
        meatsDataSet.add(new Product(res.getDrawable(R.drawable.imagen_carnes_alitas), "Alitas\n20 pzas", 149.00));

        mAdapter = new AdapterProduct(this, meatsDataSet);
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