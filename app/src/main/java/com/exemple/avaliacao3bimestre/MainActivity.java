package com.exemple.avaliacao3bimestre;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    //atributos
    private Button btnInserir;

    private ListView listaAlunos;

    private ArrayList<Aluno> alunos = new ArrayList<>();

    private  AdapterAluno adaptador;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // referencianado
        setContentView(R.layout.activity_main);
        btnInserir = findViewById(R.id.btnInserir);
        listaAlunos = findViewById(R.id.listaAlunos);


        // chamando o escutador

        btnInserir.setOnClickListener(new EscutadorBotao());

        adaptador = new AdapterAluno( this, alunos);

        listaAlunos.setAdapter(adaptador);

        listaAlunos.setOnItemClickListener(new EscutadorLista());

        listaAlunos.setOnItemLongClickListener(new EscutadorLista());

    }

    public class  EscutadorBotao implements View.OnClickListener{
        @Override
        public void onClick(View v) {
            Intent i1 = new Intent(getApplicationContext(), OutraActivity.class);

            startActivityForResult(i1,1);

        }
    }

    public void onActivityResult(int requestCode, int resultCode, Intent i) {

        super.onActivityResult(requestCode, resultCode, i);

        if (requestCode == 1) {

            if (resultCode == RESULT_OK) {

                String nome=i.getStringExtra("nome");
                String nota1=i.getStringExtra("nota1");
                String nota2=i.getStringExtra("nota2");
                String Media=i.getStringExtra("media");

                Aluno a = new Aluno(nome, nota1, nota2,Media);
                alunos.add(a);
                adaptador.notifyDataSetChanged();
            }

        }


    }

    private class EscutadorLista implements AdapterView.OnItemClickListener, AdapterView.OnItemLongClickListener {

        @Override
        public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
            Toast.makeText(MainActivity.this, "Dados do Aluno: " + " \nNome: "+alunos.get(i).getNome()
                    + "\n Nota 1: "+ alunos.get(i).getNota1() + "\n Nota 2: "+alunos.get(i).getNota2() + "\n Média: "+ alunos.get(i).getMedia(),
                    Toast.LENGTH_SHORT).show();
        }


        @Override
        public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {

            alunos.remove( i );

            adaptador.notifyDataSetChanged();

            Toast.makeText(MainActivity.this, "O aluno foi deletado!", Toast.LENGTH_LONG).show();
            return true;
        }

    }
}