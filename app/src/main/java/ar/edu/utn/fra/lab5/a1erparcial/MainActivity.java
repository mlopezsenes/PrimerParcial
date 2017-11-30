package ar.edu.utn.fra.lab5.a1erparcial;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ItemClickListener, View.OnClickListener{



    Adapter adaptador;
    ImageView imgContacto;
    TextView main_nombre;
    TextView main_telefono;
    List<Modelo> contactos;
    Button btn_llamar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgContacto= (ImageView) this.findViewById(R.id.vh_img);
        main_nombre = (TextView) this.findViewById(R.id.main_nombre);
        main_telefono = (TextView) this.findViewById(R.id.main_telefono);
        btn_llamar = (Button) this.findViewById(R.id.btn_llamar);
        btn_llamar.setOnClickListener(this);

        contactos = new ArrayList<Modelo>();
        //TODO traer los datos del servidor

        RecyclerView rv = (RecyclerView)this.findViewById(R.id.rv1);
        rv.setLayoutManager(new GridLayoutManager(this,2));
        adaptador = new Adapter(this, contactos, this);
        rv.setAdapter(adaptador);

    }



    @Override
    public void onItemClick(View view, int position) {
        this.main_nombre.setText(contactos.get(position).getNombre().toString());
        this.main_telefono.setText(contactos.get(position).getTelefono().toString());
    }

    @Override
    public void onClick(View v) {
        Intent callIntent = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+this.main_telefono.getText()));
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CALL_PHONE}, 0);
        }else{
            startActivity(callIntent);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.salir:
                this.finish();
                break;
            case R.id.nuevo:
                Log.d("Menu:","Nuevo contacto");
                //TODO mostar un mensaje si puede ejecutar esta accion o no
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
