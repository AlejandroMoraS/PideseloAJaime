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

public class ActivityProductTequilas extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> tequilasDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_tequilas);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.fragment_tequilas_recycler);

        Log.d("tanto", "onCreate: " + recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        tequilasDataSet = new ArrayList<Product>();

        Resources res = getResources();
        tequilasDataSet.add(new Product(res.getDrawable(R.drawable.imagen_tequilas_cuervo_1800), "Tequila Cuervo 1800 \n750 ml", 320.00));
        tequilasDataSet.add(new Product(res.getDrawable(R.drawable.imagen_tequilas_jose_cuervo), "Tequila José Cuervo \n700 ml", 220.00));
        tequilasDataSet.add(new Product(res.getDrawable(R.drawable.imagen_tequilas_don_julio), "Tequila  \nDon Julio \n750 ml", 645.00));
        tequilasDataSet.add(new Product(res.getDrawable(R.drawable.imagen_tequilas_el_jimador), "Tequila \nEl Jimador \n700ml", 210.00));

        mAdapter = new AdapterProduct(this, tequilasDataSet);
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
