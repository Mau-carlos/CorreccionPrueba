package fisei.vasconez.prueba_vasconez_mopositacrespo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class tercera_Activity extends AppCompatActivity {

    Button btnCerrar;
    TextView txtNombre;
    TextView txtBase;

    EditText txtApellido;
    EditText txtExponente;
    EditText txtNumero ;


    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tercera);

        btnCerrar = findViewById(R.id.Activi3buttonCerrar);
        txtNombre = findViewById(R.id.activity3textViewNombre);
        txtBase = findViewById(R.id.activity3textViewBase);
        txtApellido = findViewById(R.id.editTextApellidoActiv3);
        txtExponente = findViewById(R.id.editTextExponenteActivy3);
        txtNumero = findViewById(R.id.editTextNumeroActivi3);





        /*
         *  Recibir los datos de la anterior activity a travez del intent
         */
        Bundle datosActivitySegunda = getIntent().getExtras();

        /*
         *   key_nombre Creado en la activity primera para poder extraer los datos
         */
        String nombre = datosActivitySegunda.getString("key_nombre");
        String base = datosActivitySegunda.getString("key_base");

        this.txtNombre.setText(nombre.toUpperCase());
        this.txtBase. setText(base.toUpperCase());


    }

    public void Cerrar (View view){
       // Intent intent = new Intent(this, MainActivity.class);
        Intent intent2 = new Intent(this, SegundaActivity.class);
        String Estado = "1";
        String Apellido = txtApellido.getText().toString();
        String Exponente = txtExponente.getText().toString();
        String Numero = txtNumero.getText().toString();
        String Nombre = txtNombre.getText().toString();
        String Base =txtBase.getText().toString();
        String [] datos = {Apellido,Exponente,Numero,Nombre, Base};
//        intent.putExtra("apellido",Apellido);
//        intent.putExtra("exponente",Exponente);
//        intent.putExtra("numero",Numero);
//        intent.putExtra("nombre",Nombre);
//        intent.putExtra("base",Base);

        intent2.putExtra("estado", Estado);
        intent2.putExtra("activ3", datos);

        startActivity(intent2);
        //finish();
    }
}