package com.exemple.avaliacao3bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class OutraActivity extends AppCompatActivity {
    private EditText txtnome;
    private EditText txtnota1;
    private EditText txtnota2;
    private Button btnOK;
    private Button btnCancelar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_outra);

        txtnome = findViewById(R.id.txtNome);
        txtnota1 = findViewById(R.id.txtNota1);
        txtnota2 = findViewById(R.id.txtNota2);
        btnOK = findViewById(R.id.btnOk);
        btnCancelar = findViewById(R.id.btnCancelar);
        // chamando as funções
        btnCancelar.setOnClickListener(new Cancela());


        btnOK.setOnClickListener(new EnviaDados());

    }

    public class EnviaDados implements View.OnClickListener{

        public void onClick(View view){
            // Criando variáveis para calcular a média:
            double n1, n2, media;

            n1 = Double.parseDouble( txtnota1.getText().toString() );
            // Pegando e convertendo o valor em txtNota2:
            n2 = Double.parseDouble( txtnota2.getText().toString() );
            // Calculando a média:
            media = (n1 + n2)/2;

            String Media;
            Media = String.valueOf(media);
            //

            // variaveis para armazenar os dados a serem enviados
            // para a outra activity
            String nome = "", nota1="", nota2="";

            // criando um Intent para inserir dados
            Intent i = new Intent();

            // inserindo as informacoes no intent
            i.putExtra("nome", nome);
            i.putExtra("nota1", nota1);
            i.putExtra("nota2", nota2);
            i.putExtra("media",Media);



            // definindo o resultado desta activity
            // e indicando quem eh o intent com os dados
            setResult(RESULT_OK, i);


            // "limpando" a interface, para a próxima digitação
            txtnome.setText("");
            txtnota1.setText("");
            txtnota1.setText("");

            // finalizando esta activity, voltando para a anterior
            finish();
        }
    }
    private class Cancela implements View.OnClickListener{

        @Override
        public void onClick(View view) {
            //finish();
            onBackPressed();
        }
    }


}