package com.ulp.conersorii;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private EditText etDolares;
    private EditText etEuros;
    private RadioButton rbDolares;
    private RadioButton rbEuros;
    private EditText etCambio;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        etDolares = (EditText) findViewById(R.id.etDolares);
        etEuros = (EditText) findViewById(R.id.etEuros);
        etCambio = (EditText) findViewById(R.id.etCambio);

        rbDolares = (RadioButton)findViewById(R.id.rbDolar);
        rbEuros = (RadioButton)findViewById(R.id.rbEuro);

        etDolares.setEnabled(false);
        etEuros.setEnabled(false);
    }

    // creamos el metodo para convertir

    public void Convertir(View view){

        String dolares = etDolares.getText().toString();
        String euros = etEuros.getText().toString();

        if(rbDolares.isChecked()) {

            double numero1 = Double.parseDouble(dolares); // parseamos los string a int para la conversion

            double convertir = numero1 * 0.84;

            String cambio = String.valueOf(convertir);//parseamos de int a String la conversion
            Toast.makeText(this, "Valor u$s 0.84 por Euro.. !", Toast.LENGTH_SHORT).show();

            etCambio.setText(cambio);

        }else if(rbEuros.isChecked()){
            double numero1 = Double.parseDouble(euros); // parseamos los string a int para la conversion

            double convertir = numero1 * 1.18;

            String cambio = String.valueOf(convertir);//parseamos de int a String la conversion
            Toast.makeText(this, "Valor € 1.18 por Dólar.. !", Toast.LENGTH_SHORT).show();

            etCambio.setText(cambio);
        }else{
            Toast.makeText(this, "Debes Ingresar moneda y el Valor a convertir.. !", Toast.LENGTH_SHORT).show();
        }
    }

    //

    public void CargarMoneda(View v){
        if(rbDolares.isChecked()){
            etDolares.setEnabled(true);
            etDolares.setSelected(true);
            etEuros.setEnabled(false);
            etEuros.setText("");
        }else{
            etEuros.setEnabled(true);
            etDolares.setEnabled(false);
            etDolares.setText("");
        }

    }
}