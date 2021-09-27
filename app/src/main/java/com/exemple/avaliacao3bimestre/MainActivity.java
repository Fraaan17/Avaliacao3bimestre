package com.exemple.avaliacao3bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Button btnInserir;
    private TextView lblNome;
    private TextView lblNota1;
    private TextView lblNota2;
    private TextView lblmedia;
    private ListView listaAlunos;

    private ArrayList<Aluno> alunos = new ArrayList<>();

    private  AdapterAluno adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnInserir = findViewById(R.id.btnInserir);
        lblNome = findViewById(R.id.lblNome);
        lblNota1 = findViewById(R.id.lblNota1);
        lblNota2 = findViewById(R.id.lblNota2);
        lblmedia = findViewById(R.id.lblmedia);
        listaAlunos = findViewById(R.id.listaAlunos);


        // chamando o escutador

        btnInserir.setOnClickListener(new EscutadorBotao());

        adaptador = new AdapterAluno( this, alunos);

        listaAlunos.setAdapter(adaptador);



    }

    public class  EscutadorBotao implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent i1 = new Intent(getApplicationContext(), OutraActivity.class);

            startActivityForResult(i1,1);

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {
        Toast.makeText(MainActivity.this, "voltou", Toast.LENGTH_LONG).show();
        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                lblNome.setText(i.getStringExtra("nome"));
                lblNota1.setText(i.getStringExtra("nota1"));
                lblNota2.setText(i.getStringExtra("nota2"));
                lblmedia.setText(i.getStringExtra("media"));


                String nome, nota1, nota2, Media;

                // pegando as informações que foram digitadas pelo usuario
                nome = lblNome.getText().toString();
                nota1 = lblNota1.getText().toString();
                nota2= lblNota2.getText().toString();
                Media = lblmedia.getText().toString();



                Aluno a = new Aluno(nome, nota1, nota2,Media);
                // inserindo no ArrayList
                alunos.add(a);

                // avisando o adapter que os dados foram atualizados
                adaptador.notifyDataSetChanged();



            }

        }


    }


}