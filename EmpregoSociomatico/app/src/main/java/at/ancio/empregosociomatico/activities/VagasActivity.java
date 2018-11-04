package at.ancio.empregosociomatico.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class VagasActivity  extends AppCompatActivity{

    @Override
    protected  void  onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_vagas);


        getSupportActionBar().hide();


        String nome = getIntent().getExtras().getString(key: "vagas_name");
        String Empresa = getIntent().getExtras().getString(key: "vagas_Empresa");
        String Disponibilidade = getIntent().getExtras().getString(key: "Vagas_Disponibilidade");
        String Data = getIntent().getExtras().getString(key: "vagas_Data");
        String Descricao = getIntent().getExtras().getString(key: "Vagas_Descricao");
        String imagem = getIntent().getExtras().getString(key: "Vagas_imagem");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView  = findViewById(R.aavaga);
        TextView t
    }




}
