package com.appgem.ejerciciorecyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import static com.appgem.ejerciciorecyclerview.R.id.rvContactos;

public class MainActivity extends AppCompatActivity {

    ArrayList<Contacto> contactos;
    private RecyclerView listaContactos;
    public ContactoAdaptador adaptador;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(miActionBar);

        // ya puedo manipular el RecyclerView que se llama rvContactos
        // porque pasa a ser un objeto.

        listaContactos = (RecyclerView) findViewById(rvContactos);

        LinearLayoutManager llm =   new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        //RecyclerView se comporta como llm
        listaContactos.setLayoutManager(llm);
        inicializarListaContactos();
        inicializarAdaptador();

        /*
        VIENE DEL EJERCICIO ANTERIOR misContactos. ÉSTE EJEMPLO NO MANEJA LISTVIEW, MANEJA RECYCLER VIEW, POR ESO
        APARECE COMENTAREADO.

        ListView lstContactos = (ListView) findViewById(R.id.lstContactos);
        lstContactos.setAdapter(new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,nombresContacto));


        lstContactos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                Intent intent = new Intent(MainActivity.this,DetalleContacto.class);

                intent.putExtra(getResources().getString(R.string.pnombre),contactos.get(position).getNombre());
                intent.putExtra(getResources().getString(R.string.ptelefono),contactos.get(position).getTelefono());
                intent.putExtra(getResources().getString(R.string.pemail),contactos.get(position).getEmail());
                startActivity(intent);
                finish();

            }
        });

        */

    }


    private void inicializarAdaptador (){

        adaptador = new ContactoAdaptador(contactos,this);
        listaContactos.setAdapter(adaptador);
    }

    public void inicializarListaContactos() {

        contactos = new ArrayList<Contacto>();

        contactos.add(new Contacto(R.drawable.robot,"Leo Guerra","83737464832","lguerra@gmail.com"));
        contactos.add(new Contacto(R.drawable.candy,"Paula Cajiao","3144882959","paucajiao@gmail.com"));
        contactos.add(new Contacto(R.drawable.forest_mushroom,"Jean Pier Prado","+573107711128","claroscurojp@gmail.com"));
        contactos.add(new Contacto(R.drawable.yammi_star,"Guillermo Esguerra","+573057533514","gesguerrab@gmail.com"));
        contactos.add(new Contacto(R.drawable.hot_chili,"Monica Gomez","8746363832","monigom@gmail.com"));

    }

}
