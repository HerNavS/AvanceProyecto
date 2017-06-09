package com.example.hernandez.avanceproyecto;

import android.app.ProgressDialog;
import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.github.snowdream.android.widget.SmartImageView;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;

public class consultas extends AppCompatActivity {

    private ListView listView;
    private ArrayAdapter <String> adapter;
    ArrayList reg = new ArrayList();
    ArrayList ISBN = new ArrayList();
    ArrayList Nombre = new ArrayList();
    ArrayList Autor = new ArrayList();
    ArrayList Editorial = new ArrayList();
    ArrayList Edicion = new ArrayList();
    ArrayList Año = new ArrayList();





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultas);
        listView=(ListView)findViewById(R.id.listview);
        descargarImagen();
    }

    private void descargarImagen() {
        ISBN.clear();
        Nombre.clear();
        Autor.clear();
        Editorial.clear();
        Edicion.clear();
        Año.clear();


        final ProgressDialog progressdialog = new ProgressDialog(consultas.this);
        progressdialog.setMessage("Cargando Datos...");
        progressdialog.show();

        AsyncHttpClient client = new AsyncHttpClient();
        client.get("http://192.168.1.80/query.php", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, byte[] responseBody) {
                if (statusCode==200){
                    progressdialog.dismiss();
                    try{
                        JSONArray jsonArray = new JSONArray(new String(responseBody));
                        String cadena;
                        for (int i=0; i<jsonArray.length(); i++){
                            ISBN.add(jsonArray.getJSONObject(i).getString("ISBN"));
                            Nombre.add(jsonArray.getJSONObject(i).getString("Nombre"));
                            Autor.add(jsonArray.getJSONObject(i).getString("Autor"));
                            Editorial.add(jsonArray.getJSONObject(i).getString("Editorial"));
                            Edicion.add(jsonArray.getJSONObject(i).getString("Edicion"));
                            Año.add(jsonArray.getJSONObject(i).getString("Año"));

                            cadena= jsonArray.getJSONObject(i).getString("ISBN")+" "+ jsonArray.getJSONObject(i).getString("Nombre")+" "+
                                    jsonArray.getJSONObject(i).getString("Autor")+" "+ jsonArray.getJSONObject(i).getString("Editorial")+" "
                                    + jsonArray.getJSONObject(i).getString("Año");
                            reg.add(cadena);

                        }
                        adapter = new ArrayAdapter<String>(getApplicationContext(),R.layout.personalizado,reg);

                        listView.setAdapter (adapter);
                    }catch (JSONException e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onFailure(int statusCode, Header[] headers, byte[] responseBody, Throwable error) {

            }
        });



    }
    private class ImagenAdapter extends BaseAdapter{
        Context ctx;
        LayoutInflater layoutInflater;
        SmartImageView smartImageView;
        TextView tvISBN, tvNombre, tvAutor, tvEditorial, tvEdicion, tvAño;

        public ImagenAdapter(Context applicationContext) {
            this.ctx= applicationContext;
            layoutInflater=(LayoutInflater)ctx.getSystemService(LAYOUT_INFLATER_SERVICE);


        }

        @Override
        public int getCount() {
            return 0;
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            ViewGroup viewGroup= (ViewGroup)layoutInflater.inflate(R.layout.activity_consultas_item,null);

            tvISBN=(TextView)viewGroup.findViewById(R.id.tvISBN);
            tvNombre=(TextView)viewGroup.findViewById(R.id.tvNombre);
            tvAutor=(TextView)viewGroup.findViewById(R.id.tvAutor);
            tvEditorial=(TextView)viewGroup.findViewById(R.id.tvEditorial);
            tvEdicion=(TextView)viewGroup.findViewById(R.id.tvEdicion);
            tvAño=(TextView)viewGroup.findViewById(R.id.tvAño);


//smartImageView=(SmartImageView)viewGroup.findViewById(R.id.;
            tvISBN.setText(ISBN.get(position).toString());
            tvNombre.setText(Nombre.get(position).toString());
            tvAutor.setText(Autor.get(position).toString());
            tvEditorial.setText(Editorial.get(position).toString());
            tvEdicion.setText(Edicion.get(position).toString());
            tvAño.setText(Año.get(position).toString());




            return viewGroup;
        }
    }
}
