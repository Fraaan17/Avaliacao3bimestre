package com.exemple.avaliacao3bimestre;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class AdapterAluno extends ArrayAdapter<Aluno> {
    // atributos:

    private Context context;

    private ArrayList<Aluno> aluno;

    public AdapterAluno (Context context, ArrayList<Aluno> aluno){
           super(context, R.layout.item_lista, aluno);
            this.context = context;

            this.aluno=aluno;

    }

    public View getView( int position, View convertView, ViewGroup parent) {

        LayoutInflater li = LayoutInflater.from(parent.getContext());


        View itemView = li.inflate(R.layout.item_lista, parent, false);


        TextView lblNome = itemView.findViewById(R.id.lblNome);
        TextView lblNota1 = itemView.findViewById(R.id.lblNota1);
        TextView lblNota2= itemView.findViewById(R.id.lblNota2);
        TextView lblMedia = itemView.findViewById(R.id.lblmedia);


        lblNome.setText(aluno.get(position).getNome());
        lblNota1.setText(aluno.get(position).getNota1());
        lblNota2.setText(aluno.get(position).getNota2());
        lblMedia.setText(aluno.get(position).getMedia());

        // devolvendo
        return itemView;
    }

}
