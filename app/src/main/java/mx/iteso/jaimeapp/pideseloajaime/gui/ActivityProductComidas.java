package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import java.util.ArrayList;

import mx.iteso.jaimeapp.pideseloajaime.AdapterClass.AdapterProduct1;
import mx.iteso.jaimeapp.pideseloajaime.Beans.Product;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityProductComidas extends AppCompatActivity{

    private RecyclerView.Adapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private ArrayList<Product> myDataSet;
    private static int columns = 2;
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_comidas);

        toolbar = (Toolbar) findViewById(R.id.toolbarProduct);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.comidasRecycler);

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new GridLayoutManager(this, columns));
        ArrayList<Product> myDataSet = new ArrayList<Product>();

        Product product1 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_sabritas), "Sabritas 35g", "$13.50");
        Product product2 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_rufles), "Rufles 400g", "$40.50");
        Product product3 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_sabritones), "Sabritones 260g", "$25.50");
        Product product4 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_sabritasadobadas), "Sabritas Adobadas 35g", "$13.50");
        Product product5 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_doritos), "Doritos Nacho 35g", "$12.50");
        Product product6 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_sabritaslimon), "Sabritas Limón 35g", "$13.50");
        Product product7 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_paketaxo), "Paquetaxo Queso 213g", "$30.50");
        Product product8 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_cheetoshorneados), "Cheetos Pofs 270g", "$30.50");
        Product product9 = new Product(getResources().getDrawable(R.drawable.imagen_comidas_cheetostorciditos), "Cheetos Torciditos 270g", "$30.50");

        myDataSet.add(product1);
        myDataSet.add(product2);
        myDataSet.add(product3);
        myDataSet.add(product4);
        myDataSet.add(product5);
        myDataSet.add(product6);
        myDataSet.add(product7);
        myDataSet.add(product8);
        myDataSet.add(product9);


        mAdapter = new AdapterProduct1(this, myDataSet);
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
