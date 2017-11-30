package ar.edu.utn.fra.lab5.a1erparcial.Inicio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import ar.edu.utn.fra.lab5.a1erparcial.R;


public class Inicio_Login extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio__login);

        ViewManager vm = new ViewManager(this);

    }
}
