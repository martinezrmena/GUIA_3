package org.dev4u.hv.guia3_ejemplo;

import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Date;

public class MensajeActivity extends AppCompatActivity {

    private EditText txbMensaje;
    private AdaptadorMensaje adaptadorMensaje;
    private ArrayList<Mensaje> lstMensaje;
    private FloatingActionButton btnEnviar;
    private ListView lstMensajes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mensaje);

        //inicializo las variables
        txbMensaje = findViewById(R.id.txbEntrada);
        btnEnviar = findViewById(R.id.btnEnviar);
        lstMensajes = findViewById(R.id.lstMensajes);
        //creo la lista
        lstMensaje = new ArrayList<>();
        //creo el adaptador
        adaptadorMensaje = new AdaptadorMensaje(this, lstMensaje );
        //le establezco el adaptador al Listview
        lstMensajes.setAdapter(adaptadorMensaje);
        btnEnviar.setVisibility(View.INVISIBLE);

        txbMensaje.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                if (!txbMensaje.getText().toString().isEmpty()){
                    btnEnviar.setVisibility(View.VISIBLE);
                }else{
                    btnEnviar.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });

    }


    public void btnEnviarClick(View v){
        if (!txbMensaje.getText().toString().isEmpty()){
            Mensaje m = new Mensaje(new Date(), txbMensaje.getText().toString());
            txbMensaje.setText("");
            //TODO agrego a la lista y luego actualizo el adaptador, de lo contrario no se mostraria el cambio
            lstMensaje.add(m);
            adaptadorMensaje.notifyDataSetChanged();
        }

    }
}
