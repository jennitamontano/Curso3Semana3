package mx.jennifermontano.formularioje;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnAceptar;
    private TextInputEditText ediNombre, ediTelefono,ediEmail,ediDescripcion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAceptar=(Button)findViewById(R.id.btnAceptar);

        ediNombre=(TextInputEditText) findViewById(R.id.et_nombre);
        ediTelefono=(TextInputEditText)findViewById(R.id.et_telefono);
        ediEmail=(TextInputEditText)findViewById(R.id.et_correo);
        ediDescripcion=(TextInputEditText)findViewById(R.id.et_descripcion);


        btnAceptar.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        Intent explicit_intent;
        explicit_intent = new Intent(this,Datos.class);

        String  auxNombre=ediNombre.getText().toString();
        String  auxTelefono=ediTelefono.getText().toString();
        String  auxEmail=ediEmail.getText().toString();
        String  auxDescripcion=ediDescripcion.getText().toString();


        explicit_intent.putExtra("Nombre",auxNombre);
        explicit_intent.putExtra("Teléfono",auxTelefono);
        explicit_intent.putExtra("Email",auxEmail);
        explicit_intent.putExtra("Descripción",auxDescripcion);

        startActivity(explicit_intent);
    }
}
