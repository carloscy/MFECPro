package ec.marcafut.marcafut0011;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class ResultadosActivity extends AppCompatActivity {

    private TextView neqLocal1,neqLocal2,neqLocal3,neqLocal4,neqLocal5,neqLocal6,neqLocal7,neqLocal8;
    private TextView meqVisita1,meqVisita2,meqVisita3,meqVisita4,meqVisita5,meqVisita6,meqVisita7,meqVisita8;
    private TextView mresultado1,mresultado2,mresultado3,mresultado4,mresultado5,mresultado6,mresultado7,mresultado8;
    private TextView mtxtFecha;

    private DatabaseReference mDatabase; //para mostrar datos de la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        neqLocal1= (TextView)findViewById(R.id.eqLocal1);
        neqLocal2= (TextView)findViewById(R.id.eqLocal2);
        neqLocal3= (TextView)findViewById(R.id.eqLocal3);
        neqLocal4= (TextView)findViewById(R.id.eqLocal4);
        neqLocal5= (TextView)findViewById(R.id.eqLocal5);
        neqLocal6= (TextView)findViewById(R.id.eqLocal6);
        neqLocal7= (TextView)findViewById(R.id.eqLocal7);
        neqLocal8= (TextView)findViewById(R.id.eqLocal8);

        meqVisita1 = (TextView)findViewById(R.id.eqVisita1);
        meqVisita2 = (TextView)findViewById(R.id.eqVisita2);
        meqVisita3 = (TextView)findViewById(R.id.eqVisita3);
        meqVisita4 = (TextView)findViewById(R.id.eqVisita4);
        meqVisita5 = (TextView)findViewById(R.id.eqVisita5);
        meqVisita6 = (TextView)findViewById(R.id.eqVisita6);
        meqVisita7 = (TextView)findViewById(R.id.eqVisita7);
        meqVisita8 = (TextView)findViewById(R.id.eqVisita8);

        mresultado1=(TextView)findViewById(R.id.resultado1);
        mresultado2=(TextView)findViewById(R.id.resultado2);
        mresultado3=(TextView)findViewById(R.id.resultado3);
        mresultado4=(TextView)findViewById(R.id.resultado4);
        mresultado5=(TextView)findViewById(R.id.resultado5);
        mresultado6=(TextView)findViewById(R.id.resultado6);
        mresultado7=(TextView)findViewById(R.id.resultado7);
        mresultado8=(TextView)findViewById(R.id.resultado8);

        mtxtFecha=(TextView)findViewById(R.id.txtFecha); //Título

        mDatabase = FirebaseDatabase.getInstance().getReference();//Hace referencia al nodo principa de la BD
        //NOMBRES DE EQUIPOS
        mDatabase.child("resultados").child("equiposr").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //validación para saber si el objeto existe
                if (dataSnapshot.exists()){
                    String equipr01 = dataSnapshot.child("equipr01").getValue().toString();
                    neqLocal1.setText(equipr01);
                    String equipr02 = dataSnapshot.child("equipr02").getValue().toString();
                    meqVisita1.setText(equipr02);
                    String resul01 = dataSnapshot.child("resul01").getValue().toString();
                    mresultado1.setText(resul01);

                    String equipr03 = dataSnapshot.child("equipr03").getValue().toString();
                    neqLocal2.setText(equipr03);
                    String equipr04 = dataSnapshot.child("equipr04").getValue().toString();
                    meqVisita2.setText(equipr04);
                    String resul02 = dataSnapshot.child("resul02").getValue().toString();
                    mresultado2.setText(resul02);

                    String equipr05 = dataSnapshot.child("equipr05").getValue().toString();
                    neqLocal3.setText(equipr05);
                    String equipr06 = dataSnapshot.child("equipr06").getValue().toString();
                    meqVisita3.setText(equipr06);
                    String resul03 = dataSnapshot.child("resul03").getValue().toString();
                    mresultado3.setText(resul03);

                    String equipr07 = dataSnapshot.child("equipr07").getValue().toString();
                    neqLocal4.setText(equipr07);
                    String equipr08 = dataSnapshot.child("equipr08").getValue().toString();
                    meqVisita4.setText(equipr08);
                    String resul04 = dataSnapshot.child("resul04").getValue().toString();
                    mresultado4.setText(resul04);

                    String equipr09 = dataSnapshot.child("equipr09").getValue().toString();
                    neqLocal5.setText(equipr09);
                    String equipr10 = dataSnapshot.child("equipr10").getValue().toString();
                    meqVisita5.setText(equipr10);
                    String resul05 = dataSnapshot.child("resul05").getValue().toString();
                    mresultado5.setText(resul05);

                    String equipr11 = dataSnapshot.child("equipr11").getValue().toString();
                    neqLocal6.setText(equipr11);
                    String equipr12 = dataSnapshot.child("equipr12").getValue().toString();
                    meqVisita6.setText(equipr12);
                    String resul06 = dataSnapshot.child("resul06").getValue().toString();
                    mresultado6.setText(resul06);

                    String equipr13 = dataSnapshot.child("equipr13").getValue().toString();
                    neqLocal7.setText(equipr13);
                    String equipr14 = dataSnapshot.child("equipr14").getValue().toString();
                    meqVisita7.setText(equipr14);
                    String resul07 = dataSnapshot.child("resul07").getValue().toString();
                    mresultado7.setText(resul07);

                    String equipr15 = dataSnapshot.child("equipr15").getValue().toString();
                    neqLocal8.setText(equipr15);
                    String equipr16 = dataSnapshot.child("equipr16").getValue().toString();
                    meqVisita8.setText(equipr16);
                    String resul08 = dataSnapshot.child("resul08").getValue().toString();
                    mresultado8.setText(resul08);


                    String atitulo = dataSnapshot.child("atitulo").getValue().toString();
                    mtxtFecha.setText(atitulo);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
