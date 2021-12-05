package fisei.vasconez.prueba_vasconez_mopositacrespo;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Application;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SegundaActivity extends AppCompatActivity {

    Button btnSiguiente;
    Button btnCerrar;
    EditText text_Edit_Nombre ;
    EditText text_Edit_Base ;
    String datos[];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segunda);


        btnSiguiente = findViewById(R.id.Acti2buttonSiguiente);
        btnCerrar = findViewById(R.id.Activbutton5Cerrar);
        text_Edit_Nombre = findViewById(R.id.Acti2editTextNombre);
        text_Edit_Base = findViewById(R.id.Activity2editTextTextPersonBase);


        Bundle datosActivityTercera= getIntent().getExtras();
        if(datosActivityTercera != null) {
            String Estado = datosActivityTercera.getString("estado");
            String  [] datos3 = datosActivityTercera.getStringArray("activ3");

                datos=datos3;
                text_Edit_Nombre.setText(datos3[3]);
                text_Edit_Base.setText(datos3[4]);

            System.out.println("Estado Actual ++++++ "+ datos[1]);
            //if(Estado == "1"){
                btnCerrar.setEnabled(true);
                btnSiguiente.setEnabled(false);
                //control de botones

            //}


        }


        btnCerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SegundaActivity.this, MainActivity.class);
                    intent.putExtra("datos",datos);
                startActivity(intent);
                finish();

            }
        });

    }



    public void onClickSiguiente(View view){
        String nombre = text_Edit_Nombre.getText().toString(); //Crea una variable de tipo String y captura los datos del Activity
        String base = text_Edit_Base.getText().toString();
        if(!nombre.matches("") && !base.matches("")){
            Intent intent = new Intent(this, tercera_Activity.class);

            intent.putExtra("key_nombre",nombre);
            intent.putExtra("key_base", base);
            startActivity(intent);
        }
        else
        {
            //Mostrar texto como un message
            Toast.makeText(this, "Nombre y Apellido son Obligatorios", Toast.LENGTH_LONG).show();

        }
    }



}


