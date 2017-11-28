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

public class ActivityProductChips extends AppCompatActivity{

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_chips);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comidasRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        myDataSet = new ArrayList<Product>();

        Resources res = getResources();
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_sabritas), "Sabritas 35g", 13.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_rufles), "Rufles 400g", 40.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_sabritones), "Sabritones 260g", 25.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_sabritas_adobadas), "Sabritas Adobadas 35g", 13.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_doritos), "Doritos Nacho 35g", 12.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_sabritas_limon), "Sabritas Limón 35g", 13.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_paketaxo), "Paquetaxo Queso 213g", 30.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_cheetos_horneados), "Cheetos Pofs 270g", 30.50));
        myDataSet.add(new Product(res.getDrawable(R.drawable.imagen_papas_cheetos_torciditos), "Cheetos Torciditos 270g", 30.50));

        mAdapter = new AdapterProduct(this, myDataSet);
        recyclerView.setAdapter(mAdapter);
    }

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
