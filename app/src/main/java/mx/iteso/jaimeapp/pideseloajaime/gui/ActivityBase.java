package mx.iteso.jaimeapp.pideseloajaime.gui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import mx.iteso.jaimeapp.pideseloajaime.R;

public abstract class ActivityBase extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{
    protected Toolbar mToolbar;
    protected String[] mActivitiesTitles;
    protected DrawerLayout mDrawerLayout;
    protected NavigationView mNavigationView;
    protected ImageView mPhoto;
    protected TextView mName;
    protected TextView mCorreo;
    protected View mNavHeader;

    protected void onCreateDrawer(){
        mActivitiesTitles = getResources().getStringArray(R.array.titles);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        mToolbar = (Toolbar) findViewById(R.id.toolbarBase);
        setSupportActionBar(mToolbar);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawerLayout, mToolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawerLayout.setDrawerListener(toggle);
        toggle.syncState();
        mNavigationView.setNavigationItemSelectedListener(this);

        mNavHeader = mNavigationView.getHeaderView(0);


        mPhoto = (ImageView)mNavHeader.findViewById(R.id.logo);
        mName = (TextView)mNavHeader.findViewById(R.id.nombre_usuario);
        mCorreo = (TextView) mNavHeader.findViewById(R.id.correo_electronico) ;

        loadNavHeader();

    }
    private void loadNavHeader() {
        // name, website
        Bitmap photo = BitmapFactory.decodeResource(this.getResources(),
                R.drawable.logo);

        mName.setText("Nombre de usuario");
        mCorreo.setText("uncorreo@hotmail.com");
    }
    @Override
    public void setTitle(CharSequence title) {
        getSupportActionBar().setTitle(title);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        Intent intent;
        switch (item.getItemId()){
            case R.id.sidebar_tienda:
                intent = new Intent(this, ActivityTienda.class);
                startActivity(intent);
                break;

        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



}
