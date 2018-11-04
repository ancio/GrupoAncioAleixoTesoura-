package at.ancio.empregosociomatico.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import at.ancio.empregosociomatico.R;
import at.ancio.empregosociomatico.models.Vagas;
import at.ancio.empregosociomatico.adapters.RecyclerViewAdapter;
import at.ancio.empregosociomatico.models.Vagas;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "http://emprego.sociomatico.com/wp-json/wp/v2/";
   private JsonArrayRequest request;
     private RequestQueue requestQueue;
     private List<Vagas> fvaga;
     private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fvaga = new ArrayList<>();
        recyclerView = findViewById(R.id.recyclerviewid);
        jsonrequest();
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {

            @Override
            public void onResponse(JSONArray response) {


                JSONObject jsonObject =null;

                for(int i=0; i <response.length();i++){
                    try {
                        jsonObject = response.getJSONObject(i);
                        Vagas vagas = new Vagas();
                        vagas.getNome(jsonObject.getString( name: "name"));
                         vagas.getDescription(jsonObject.getString( name: "Description"));
                         vagas.getEmpresa(jsonObject.getString(name:"empresa");
                         vagas.getDisponibilidade(jsonObject.getString(name: "disponibilidade"));
                         vagas.getData(jsonObject.getString(name: "date"));
                         vagas.getImage(jsonObject.getString(name: "imag"));
                        fvaga.add(vagas);

                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
           setuprecyclerview(fvaga);

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });
requestQueue = Volley.newRequestQueue(MainActivity.this);
   requestQueue.add(request);
    }

    private void setuprecyclerview(List<Vagas> fvaga) {
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,fvaga);
           recyclerView.setLayoutManager(new LinearLayoutManager(this));
    recyclerView.setAdapter(adapter);
    }
}
