package com.appgem.ejerciciorecyclerview;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Usuario on 20/02/2017.
 */


public class ContactoAdaptador extends RecyclerView.Adapter<ContactoAdaptador.ContactoViewHolder> {



    //  La lista almacenada en contactos se pasa al objeto global contactos, definido en la linea de abajo

    ArrayList<Contacto> contactos;
    Activity    activity;




    //  Cuando se llame la clase ContactoAdaptador, se invoca el constructor ContactoAdaptador que
    //  recibe ArrayList de contactos en el adaptador contactos, activando los tres metodos: onCreateViewHolder,
    //  onBindViewHolder y getItemCount.

    public ContactoAdaptador(ArrayList<Contacto> contactos,Activity activity){

        this.contactos  =   contactos;
        this.activity   =   activity;
    }



    @Override
    public ContactoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        // Infla Layout y lo pasa al viewholder para que obtenga cada elemento (los views)
        // Define Cual es el Layout que estará reciclando el RecyclerView

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_contacto,parent,false);
        return new ContactoViewHolder(v);

    }

    @Override
    public void onBindViewHolder(ContactoViewHolder contactoViewHolder, int position) {

        // Asocia cada elemento de la lista a cada View

        //  Recibe lista de contactos y la pasa a cada uno de los elementos definidos en
        //  ContactoViewHolder: imgNombre, tvNombreCV, tvTelefonoCV

        final Contacto contacto   =   contactos.get(position);

        //Fijo foto del objeto contacto
        contactoViewHolder.imgFoto.setImageResource(contacto.getFoto());
        //Fijo nombre del objeto contacto
        contactoViewHolder.tvNombreCV.setText(contacto.getNombre());
        //Fijo telefono del objeto contacto
        contactoViewHolder.tvTelefonoCV.setText(contacto.getTelefono());


        contactoViewHolder.imgFoto.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Toast.makeText(activity,contacto.getNombre(),Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity,DetalleContacto.class);
                intent.putExtra("nombre",contacto.getNombre());
                intent.putExtra("telefono",contacto.getTelefono());
                intent.putExtra("email",contacto.getEmail());
                activity.startActivity(intent);

            }

        });

        contactoViewHolder.btnLike.setOnClickListener(new View.OnClickListener(){

            public void onClick(View view){

                Toast.makeText(activity,"Sacre Visage, diste Like a "+contacto.getNombre()+"!!!.",Toast.LENGTH_SHORT).show();

            }
        }
        );

    }

    @Override
    public int getItemCount() { // Cantidad de elementos que contiene la lista de contactos
        return contactos.size();
    }


    /*

    AQUI LA LISTA DE CONTACTO PASA CADA UNO DE LOS ELEMENTOS: IMAGEN, NOMBRE Y TELEFONO A
    LAS ETIQUETAS DEFINIDAS ABAJO.

     */

    public static class ContactoViewHolder extends RecyclerView.ViewHolder{

        /*
            DEFINO TODOS LOS VIEWS QUE TENGO DENTRO DE CARDVIEW_CONTACTO JUSTO ABAJO A CONTINUACIÓN
        */

        private ImageView   imgFoto;
        private TextView    tvNombreCV;
        private TextView    tvTelefonoCV;
        private ImageButton btnLike;

        public ContactoViewHolder(View itemView) {
            super(itemView);

            /*
                Asocio cada objeto definido (imgFoto, tvNombreCV, tvTelefonoCV con su respectivo view)
            */

            imgFoto         =   (ImageView) itemView.findViewById(R.id.imgFoto);
            tvNombreCV      =   (TextView) itemView.findViewById(R.id.tvNombreCV);
            tvTelefonoCV    =   (TextView) itemView.findViewById(R.id.tvTelefonoCV);
            btnLike         =   (ImageButton) itemView.findViewById(R.id.btnLike);

        }
    }



}
