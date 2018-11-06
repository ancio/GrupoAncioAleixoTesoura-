package at.ancio.empregosociomatico.activities;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import at.ancio.empregosociomatico.R;

public class login extends AppCompatActivity {
Button btnLogin;
  EditText  etSenha;
    EditText  etUsuario;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(at.ancio.empregosociomatico.R.layout.activity_login);

        etUsuario =(EditText) findViewById(R.id.etUsuario);
        etSenha =(EditText) findViewById(R.id.etSenha);
        btnLogin = (Button) findViewById(R.id.btnLogin);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String Username =etUsuario.getText()+"";
                        String Password = etSenha.getText()+"";

                        if(Username.length()==0 || Password.length()==0){
                            Toast.makeText(context,"Inserir Usuario e Senha", Toast.LENGTH_SHORT).Show();
                            return;

                        }
            }
        });
    }
}
