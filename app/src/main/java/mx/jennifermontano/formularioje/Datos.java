package mx.jennifermontano.formularioje;

import android.Manifest;
import android.content.Intent;
import android.icu.util.Calendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

public class Datos extends AppCompatActivity implements View.OnClickListener {

    private DatePicker datePickers;
    private Calendar calendario;
    private TextView fecha;
    private int year, month, day;
    TextView etiNombre, etiTelefono, etiEmail, etiDescripcion;
    private Button btnEditar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_datos);

        fecha = (TextView) findViewById(R.id.et_fechan);
        year = calendario.get(Calendar.YEAR);

        month = calendario.get(Calendar.MONTH);
        day = calendario.get(Calendar.DAY_OF_MONTH);
        showDate(year, month+1, day);


        btnEditar.setOnClickListener(this);

        etiNombre = (TextView) findViewById(R.id.et_nombre);
        etiTelefono=(TextView)findViewById(R.id.et_telefono);
        etiEmail=(TextView)findViewById(R.id.et_correo);
        etiDescripcion=(TextView)findViewById(R.id.et_descripcion);


        Intent intent = getIntent();
        Bundle extras = intent.getExtras();

        if (extras != null) {

            String dataName = (String) extras.get("@string/hint_nombreusuario");
            String dataPhone=(String)extras.get("@string/hint_numerotelefono");
            String dataEmail=(String)extras.get("@string/hint_correoelectronico");
            String dataDescrip=(String)extras.get("@string/hint_descripcion");



            etiNombre.setText(dataName);
            etiTelefono.setText(dataPhone);
            etiEmail.setText(dataEmail);
            etiDescripcion.setText(dataDescrip);


        }
    }

    private void showDate(int year, int i, int day) {
        fecha.setText(new StringBuilder().append(day).append("/")
                .append(month).append("/").append(year));

    }

    @Override
    public void onClick(View v) {
        Intent intent;
        intent = new Intent(this,MainActivity.class);

        String  auxNombre=etiNombre.getText().toString();
        String  auxTelefono=etiTelefono.getText().toString();
        String  auxEmail=etiEmail.getText().toString();
        String  auxDescripcion=etiDescripcion.getText().toString();

        intent.putExtra("Nombre",auxNombre);
        intent.putExtra("Teléfono",auxTelefono);
        intent.putExtra("Email",auxEmail);
        intent.putExtra("Descripción",auxDescripcion);

        startActivity(intent);

    }
}
