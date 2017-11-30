package mx.iteso.jaimeapp.pideseloajaime.Gui;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

import mx.iteso.jaimeapp.pideseloajaime.Beans.Carrito;
import mx.iteso.jaimeapp.pideseloajaime.R;

import static com.facebook.FacebookSdk.getApplicationContext;

public class ActivityConfirm extends AppCompatActivity {

    Button confirmar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm);

        Button confirmar = (Button)findViewById(R.id.activity_carrito_confirmar);

        confirmar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new AsyncRequest().execute("");
                Intent intent = new Intent(getApplicationContext(), ActivityTienda.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
                android.os.Process.killProcess(android.os.Process.myPid());
            }
        });

        TextView tv_total = (TextView)findViewById(R.id.activity_confirm_total_pedido);
        tv_total.setText(Carrito.getInstance().getCost() + "");
    }

    public void onClick(View v) {
    }
}

class AsyncRequest extends AsyncTask<Object, Object, Void> {
    private Exception exception;

    protected Void doInBackground(Object... urls) {
        HttpURLConnection con = null;
        String urlString = "http://198.199.64.189:4567/pedidos";

        try {
            URL url = new URL(urlString);
            con = (HttpURLConnection) url.openConnection();
            con.setRequestMethod("POST");
            con.setDoOutput(true);
            OutputStreamWriter wr = new OutputStreamWriter(con.getOutputStream());
            Calendar date = Calendar.getInstance();
            JSONObject data = new JSONObject();
            data.accumulate("status", "Enviado");
            data.accumulate("total", Carrito.getInstance().getCost());
            data.accumulate("fecha",  date.get(Calendar.DAY_OF_MONTH) + "/" + (date.get(Calendar.MONTH) + 1) + "/" + date.get(Calendar.YEAR));
            wr.write(data.toString());
            wr.flush();

            Log.d("Res", "onClick: " + con.getResponseCode());
        } catch(Exception e) {
            Log.d("ventas", "onClick: ventas" + e);
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);
        Toast.makeText(getApplicationContext(), "Tu pedido se ha realizado con éxito", Toast.LENGTH_LONG).show();
    }
}
