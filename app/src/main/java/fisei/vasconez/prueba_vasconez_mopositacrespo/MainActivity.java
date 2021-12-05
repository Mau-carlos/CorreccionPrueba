package fisei.vasconez.prueba_vasconez_mopositacrespo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    Button siguienteButton ;
    Button Resultadosbutton;
    TextView txtNombre;
    TextView txtApellido;
    TextView txtBase;
    TextView txtExponente;
    TextView txtFactorial ;
    TextView txtPotencia;
    TextView txtNumero;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        siguienteButton=findViewById(R.id.activitybuttonSiguiente);
        Resultadosbutton = findViewById(R.id.buttonMostrarResultados);
        txtNombre = findViewById(R.id.ActivitytextViewNombre);
        txtApellido  =findViewById(R.id.ActivitytextViewApellido);
        txtBase = findViewById(R.id.ActivitytextViewBase);
        txtExponente = findViewById(R.id.activityTextViewExponente);
        txtFactorial = findViewById(R.id.ActivitytextViewFactorial);
        txtPotencia = findViewById(R.id.ActivitytextViewPotencia);
        txtNumero = findViewById(R.id.Activity_textView_Numero);
        /*
         *  Recibir los datos de la anterior activity a travez del intent
         */
        Bundle datosActivityTercera= getIntent().getExtras();
        if(datosActivityTercera != null){
            System.out.println("VIENE DATOS   DKDKDKD");
            String datos [] = datosActivityTercera.getStringArray("datos");
            String Nombre = datos[3].toUpperCase();
            String Apellido = datos[0].toUpperCase();
            String Base = datos[4];
            String Exponente = datos[1];
            String Numero = datos[2];
            txtNombre.setText(Nombre);
            txtApellido.setText(Apellido);
            txtBase.setText(Base);
            txtExponente.setText(Exponente);
            txtNumero.setText(Numero);
            Resultadosbutton.setEnabled(true);

          

        }


        Resultadosbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double nu =Double.parseDouble(txtBase.getText().toString());
                Double nu2 = Double.parseDouble(txtExponente.getText().toString());
                int Numero = Integer.parseInt( txtNumero.getText().toString());
                Double r = potencia(nu, nu2 );
                System.out.println("NUMERO "+Numero);
                int r2 = factorial(Numero);
                txtPotencia.setText(r.toString());
               txtFactorial.setText(String.valueOf(r2));


            }
        });


    }


    public void onClickSiguiente(View view){
        //Trabajar con actividades
        Intent intent = new Intent(this, SegundaActivity.class );
        this.startActivity(intent);//Hace visible la actividad Segunda
    }



    private double potencia(double base , double exponente){
        return Math.pow(base , exponente);
    }


    public  int factorial(int n) {
        int resultado = 1;
        for (int i = 1; i <= n; i++) {
            resultado *= i;
        }
        return resultado;
    }
}