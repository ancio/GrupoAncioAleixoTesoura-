package at.ancio.empregosociomatico.activities;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import at.ancio.empregosociomatico.R;

public class VagasActivity  extends AppCompatActivity{

    @Override
    protected  void  onCreate(Bundle savedIntanceState){
        super.onCreate(savedIntanceState);
        setContentView(R.layout.activity_vagas);


        getSupportActionBar().hide();


        String nome = getIntent().getExtras().getString("Vagas_Empresa");
        String Empresa = getIntent().getExtras().getString("vagas_Empresa");
        String Disponibilidade = getIntent().getExtras().getString("Vagas_Disponibilidade");
        String Data = getIntent().getExtras().getString("vagas_Data");
        String Descricao = getIntent().getExtras().getString("Vagas_Descricao");
        String imagem = getIntent().getExtras().getString("Vagas_imagem");

        CollapsingToolbarLayout collapsingToolbarLayout = findViewById(R.id.collapsingtoolbar_id);
        collapsingToolbarLayout.setTitleEnabled(true);

        TextView  vaga_nome = findViewById(R.id.aavaga_nome);
        TextView vaga_empresa = findViewById(R.id.aaEmpresa);
        TextView vaga_disponibilidade = findViewById(R.id.aaDisponibilidade) ;
        TextView vaga_descricao = findViewById(R.id.aa_descricao);
        ImageView vagaimg = findViewById(R.id.aaImage);


        // setting values to each view

        vaga_nome.setText(nome);
        vaga_empresa.setText(Empresa);
        vaga_disponibilidade.setText(Disponibilidade);
        vaga_descricao.setText(Descricao);


        collapsingToolbarLayout.setTitle(nome);


        RequestOptions requestOptions = new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);


        // set image using Glide
        Glide.with(this).load(imagem).apply(requestOptions).into(vagaimg);





    }
    }





