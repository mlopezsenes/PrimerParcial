package ar.edu.utn.fra.lab5.a1erparcial.Inicio;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import ar.edu.utn.fra.lab5.a1erparcial.MainActivity;
import ar.edu.utn.fra.lab5.a1erparcial.R;

/**
 * Created by lkdml on 8/5/2017.
 */

public class ViewManager implements View.OnClickListener {

    private Activity activity;
    private TextView mail;
    private TextView clave;
    private Button ingresar;


    public ViewManager(Activity activity) {
        this.activity = activity;
        this.mail = (TextView) this.activity.findViewById(R.id.IL_Mail);
        this.clave = (TextView) this.activity.findViewById(R.id.IL_Clave);
        this.ingresar = (Button) this.activity.findViewById(R.id.IL_LogIn);
        this.ingresar.setOnClickListener(this);
    }

    public Activity getActivity() {
        return activity;
    }

    public void setActivity(Activity activity) {
        this.activity = activity;
    }


    @Override
    public void onClick(View v) {
        if  (this.ingresar.getId() == v.getId()){
            //TODO: Completar con funcionalidad de recordarme



        }

    }
}
