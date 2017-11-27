package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProductSodaPack extends AppCompatActivity  {

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_soda_pack);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.soda_packs_recycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> sodaPacksDataSet = new ArrayList<Product>();

        Resources res = getResources();
        sodaPacksDataSet.add(new Product(res.getDrawable(R.drawable.imagen_paquete_refrescos_fiesta_coca), "Fiesta Pack Coca Cola 8 pzas 2 L", 156.00));
        sodaPacksDataSet.add(new Product(res.getDrawable(R.drawable.imagen_paquete_refrescos_familia_pepsi), "Refresco Pepsi Mix 6 pack 3 L", 132.00));
        sodaPacksDataSet.add( new Product(res.getDrawable(R.drawable.imagen_paquete_refrescos_pepsi), "Refresco Pepsi 24 pzas 355 ml", 145.00));
        sodaPacksDataSet.add(new Product(res.getDrawable(R.drawable.imagen_paquete_refrescos_lata), "Surtido Coca Cola 7 pzas 355 ml", 70.00));
        sodaPacksDataSet.add(new Product(res.getDrawable(R.drawable.imagen_paquete_refrescos_squirt), "Refresco Squirt 6 pzas 3 L", 129.00));

        mAdapter = new AdapterProduct(this, sodaPacksDataSet);
        recyclerView.setAdapter(mAdapter);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home){
            this.finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
