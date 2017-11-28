package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.JsonObjectRequest;
import org.json.JSONArray;
import org.json.JSONObject;
import mx.iteso.jaimeapp.pideseloajaime.R;

public class ActivityMisPedidos extends ActivityAbstract {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mis_pedidos);
        //Crea el botón del navigation drawer
        onCreateDrawer();
        RequestQueue mRequestQueue;

        // Instantiate the cache
        Cache cache = new DiskBasedCache(getCacheDir(), 1024 * 1024); // 1MB cap

        // Set up the network to use HttpURLConnection as the HTTP client.
        Network network = new BasicNetwork(new HurlStack());

        // Instantiate the RequestQueue with the cache and network.
        mRequestQueue = new RequestQueue(cache, network);

        // Start the queue
        mRequestQueue.start();

        String url = "http://198.199.64.189:4567/pedidos";

        final ActivityAbstract self = this;

        JsonObjectRequest jsObjRequest = new JsonObjectRequest
                (Request.Method.GET, url, null, new Response.Listener<JSONObject>() {

                    @Override
                    public void onResponse(JSONObject response) {
                        try {

                            JSONArray items = (JSONArray)response.get("items");

                            final TableLayout tl = (TableLayout)findViewById(R.id.activity_mis_pedidos_table);
                            double t = 0;
                            for (int i = 0; i < items.length(); i++) {
                                LayoutInflater inflater = (LayoutInflater) self.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                                final TableRow rowView = (TableRow) inflater.inflate(R.layout.display_record, null);

                                TextView tv_product = (TextView) rowView.getChildAt(0);
                                tv_product.setText(items.getJSONObject(i).get("fecha").toString());
                                TextView tv_cost = (TextView) rowView.getChildAt(1);
                                tv_cost.setText("$ " + items.getJSONObject(i).get("total").toString());
                                TextView et_status = (TextView) rowView.getChildAt(2);
                                et_status.setText(items.getJSONObject(i).get("status").toString());

                                tl.addView(rowView);
                            }

                            DrawerLayout dl = (DrawerLayout)findViewById(R.id.drawer_layout);
                            dl.invalidate();
                            dl.requestLayout();
                            Log.d("Respuestaaaa", "onResponse: " + response.get("items").toString());

                        } catch (Exception e) {
                            Log.d("Resp", "onResponse: Parsing" + e);
                        }
                    }
                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        // TODO Auto-generated method stub
                        Log.d("error", "onErrorResponse: " + error);

                    }
                });

        mRequestQueue.add(jsObjRequest);

    }
}
