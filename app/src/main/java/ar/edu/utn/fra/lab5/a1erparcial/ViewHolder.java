package ar.edu.utn.fra.lab5.a1erparcial;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by lkdml on 03/10/2017.
 */

public class ViewHolder  extends RecyclerView.ViewHolder implements  View.OnClickListener{

    TextView nombre;
    TextView apellido;
    TextView telefono;
    ImageView img;
    ItemClickListener listener;

    public ViewHolder(View itemView, ItemClickListener listener) {
        super(itemView);
        //TODO: Completar lo que falta acceder a los elementos view y setear el listener

    }

    @Override
    public void onClick(View v) {
        this.listener.onItemClick(v,getAdapterPosition());
    }
}
