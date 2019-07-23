package ec.marcafut.marcafut0011;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Tabla extends AppCompatActivity {

    private TextView mtablaEquipo1,mtablaEquipo2,mtablaEquipo3,mtablaEquipo4,mtablaEquipo5,mtablaEquipo6,
            mtablaEquipo7,mtablaEquipo8,mtablaEquipo9,mtablaEquipo10,mtablaEquipo11,mtablaEquipo12,mtablaEquipo13,
            mtablaEquipo14,mtablaEquipo15,mtablaEquipo16;

    private TextView mtablaPj1,mtablaPj2,mtablaPj3,mtablaPj4,mtablaPj5,mtablaPj6,mtablaPj7,mtablaPj8,mtablaPj9,mtablaPj10,
            mtablaPj11,mtablaPj12,mtablaPj13,mtablaPj14,mtablaPj15,mtablaPj16;

    private TextView mtablaGd1,mtablaGd2,mtablaGd3,mtablaGd4,mtablaGd5,mtablaGd6,mtablaGd7,mtablaGd8,mtablaGd9,mtablaGd10,
            mtablaGd11,mtablaGd12,mtablaGd13,mtablaGd14,mtablaGd15,mtablaGd16;

    private TextView mtablaPts1,mtablaPts2,mtablaPts3,mtablaPts4,mtablaPts5,mtablaPts6,mtablaPts7,mtablaPts8,mtablaPts9,
            mtablaPts10,mtablaPts11,mtablaPts12,mtablaPts13,mtablaPts14,mtablaPts15,mtablaPts16;

    private DatabaseReference mDatabase; //para mostrar datos de la base de datos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabla);
//NOMBRE DE LOS EQUIPOS
        mtablaEquipo1 = (TextView)findViewById(R.id.tablaEquipo1);
        mtablaEquipo2 = (TextView)findViewById(R.id.tablaEquipo2);
        mtablaEquipo3 = (TextView)findViewById(R.id.tablaEquipo3);
        mtablaEquipo4 = (TextView)findViewById(R.id.tablaEquipo4);
        mtablaEquipo5 = (TextView)findViewById(R.id.tablaEquipo5);
        mtablaEquipo6 = (TextView)findViewById(R.id.tablaEquipo6);
        mtablaEquipo7 = (TextView)findViewById(R.id.tablaEquipo7);
        mtablaEquipo8 = (TextView)findViewById(R.id.tablaEquipo8);
        mtablaEquipo9 = (TextView)findViewById(R.id.tablaEquipo9);
        mtablaEquipo10 = (TextView)findViewById(R.id.tablaEquipo10);
        mtablaEquipo11 = (TextView)findViewById(R.id.tablaEquipo11);
        mtablaEquipo12 = (TextView)findViewById(R.id.tablaEquipo12);
        mtablaEquipo13 = (TextView)findViewById(R.id.tablaEquipo13);
        mtablaEquipo14 = (TextView)findViewById(R.id.tablaEquipo14);
        mtablaEquipo15 = (TextView)findViewById(R.id.tablaEquipo15);
        mtablaEquipo16 = (TextView)findViewById(R.id.tablaEquipo16);
//PARTIDOS JUGADOS
        mtablaPj1 = (TextView)findViewById(R.id.tablaPj1);
        mtablaPj2 = (TextView)findViewById(R.id.tablaPj2);
        mtablaPj3 = (TextView)findViewById(R.id.tablaPj3);
        mtablaPj4 = (TextView)findViewById(R.id.tablaPj4);
        mtablaPj5 = (TextView)findViewById(R.id.tablaPj5);
        mtablaPj6 = (TextView)findViewById(R.id.tablaPj6);
        mtablaPj7 = (TextView)findViewById(R.id.tablaPj7);
        mtablaPj8 = (TextView)findViewById(R.id.tablaPj8);
        mtablaPj9 = (TextView)findViewById(R.id.tablaPj9);
        mtablaPj10 = (TextView)findViewById(R.id.tablaPj10);
        mtablaPj11 = (TextView)findViewById(R.id.tablaPj11);
        mtablaPj12 = (TextView)findViewById(R.id.tablaPj12);
        mtablaPj13 = (TextView)findViewById(R.id.tablaPj13);
        mtablaPj14 = (TextView)findViewById(R.id.tablaPj14);
        mtablaPj15 = (TextView)findViewById(R.id.tablaPj15);
        mtablaPj16 = (TextView)findViewById(R.id.tablaPj16);
        //Goles de diferencia
        mtablaGd1 = (TextView)findViewById(R.id.tablaGd1);
        mtablaGd2 = (TextView)findViewById(R.id.tablaGd2);
        mtablaGd3 = (TextView)findViewById(R.id.tablaGd3);
        mtablaGd4 = (TextView)findViewById(R.id.tablaGd4);
        mtablaGd5 = (TextView)findViewById(R.id.tablaGd5);
        mtablaGd6 = (TextView)findViewById(R.id.tablaGd6);
        mtablaGd7 = (TextView)findViewById(R.id.tablaGd7);
        mtablaGd8 = (TextView)findViewById(R.id.tablaGd8);
        mtablaGd9 = (TextView)findViewById(R.id.tablaGd9);
        mtablaGd10 = (TextView)findViewById(R.id.tablaGd10);
        mtablaGd11 = (TextView)findViewById(R.id.tablaGd11);
        mtablaGd12 = (TextView)findViewById(R.id.tablaGd12);
        mtablaGd13 = (TextView)findViewById(R.id.tablaGd13);
        mtablaGd14 = (TextView)findViewById(R.id.tablaGd14);
        mtablaGd15 = (TextView)findViewById(R.id.tablaGd15);
        mtablaGd16 = (TextView)findViewById(R.id.tablaGd16);
        //PUNTOS
        mtablaPts1= (TextView)findViewById(R.id.tablaPts1);
        mtablaPts2= (TextView)findViewById(R.id.tablaPts2);
        mtablaPts3= (TextView)findViewById(R.id.tablaPts3);
        mtablaPts4= (TextView)findViewById(R.id.tablaPts4);
        mtablaPts5= (TextView)findViewById(R.id.tablaPts5);
        mtablaPts6= (TextView)findViewById(R.id.tablaPts6);
        mtablaPts7= (TextView)findViewById(R.id.tablaPts7);
        mtablaPts8= (TextView)findViewById(R.id.tablaPts8);
        mtablaPts9= (TextView)findViewById(R.id.tablaPts9);
        mtablaPts10= (TextView)findViewById(R.id.tablaPts10);
        mtablaPts11= (TextView)findViewById(R.id.tablaPts11);
        mtablaPts12= (TextView)findViewById(R.id.tablaPts12);
        mtablaPts13= (TextView)findViewById(R.id.tablaPts13);
        mtablaPts14= (TextView)findViewById(R.id.tablaPts14);
        mtablaPts15= (TextView)findViewById(R.id.tablaPts15);
        mtablaPts16= (TextView)findViewById(R.id.tablaPts16);


        mDatabase = FirebaseDatabase.getInstance().getReference();//Hace referencia al nodo principa de la BD
        //NOMBRES DE EQUIPOS
        mDatabase.child("equipos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //validación para saber si el objeto existe
                if (dataSnapshot.exists()){
                    String equipo01 = dataSnapshot.child("equipo01").getValue().toString();
                    mtablaEquipo1.setText(equipo01);
                    String equipo02 = dataSnapshot.child("equipo02").getValue().toString();
                    mtablaEquipo2.setText(equipo02);
                    String equipo03 = dataSnapshot.child("equipo03").getValue().toString();
                    mtablaEquipo3.setText(equipo03);
                    String equipo04 = dataSnapshot.child("equipo04").getValue().toString();
                    mtablaEquipo4.setText(equipo04);
                    String equipo05 = dataSnapshot.child("equipo05").getValue().toString();
                    mtablaEquipo5.setText(equipo05);
                    String equipo06 = dataSnapshot.child("equipo06").getValue().toString();
                    mtablaEquipo6.setText(equipo06);
                    String equipo07 = dataSnapshot.child("equipo07").getValue().toString();
                    mtablaEquipo7.setText(equipo07);
                    String equipo08 = dataSnapshot.child("equipo08").getValue().toString();
                    mtablaEquipo8.setText(equipo08);
                    String equipo09 = dataSnapshot.child("equipo09").getValue().toString();
                    mtablaEquipo9.setText(equipo09);
                    String equipo10 = dataSnapshot.child("equipo10").getValue().toString();
                    mtablaEquipo10.setText(equipo10);
                    String equipo11 = dataSnapshot.child("equipo11").getValue().toString();
                    mtablaEquipo11.setText(equipo11);
                    String equipo12 = dataSnapshot.child("equipo12").getValue().toString();
                    mtablaEquipo12.setText(equipo12);
                    String equipo13 = dataSnapshot.child("equipo13").getValue().toString();
                    mtablaEquipo13.setText(equipo13);
                    String equipo14 = dataSnapshot.child("equipo14").getValue().toString();
                    mtablaEquipo14.setText(equipo14);
                    String equipo15 = dataSnapshot.child("equipo15").getValue().toString();
                    mtablaEquipo15.setText(equipo15);
                    String equipo16 = dataSnapshot.child("equipo16").getValue().toString();
                    mtablaEquipo16.setText(equipo16);
                }


            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //PARTIDOS JUGADOS
        mDatabase.child("pjugadosa").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                String pjequip01 = dataSnapshot.child("pjequip01").getValue().toString();
                    mtablaPj1.setText(pjequip01);
                String pjequip02 = dataSnapshot.child("pjequip02").getValue().toString();
                    mtablaPj2.setText(pjequip02);
                String pjequip03 = dataSnapshot.child("pjequip03").getValue().toString();
                    mtablaPj3.setText(pjequip03);
                String pjequip04 = dataSnapshot.child("pjequip04").getValue().toString();
                    mtablaPj4.setText(pjequip04);
                String pjequip05 = dataSnapshot.child("pjequip05").getValue().toString();
                    mtablaPj5.setText(pjequip05);
                String pjequip06 = dataSnapshot.child("pjequip06").getValue().toString();
                    mtablaPj6.setText(pjequip06);
                String pjequip07 = dataSnapshot.child("pjequip07").getValue().toString();
                    mtablaPj7.setText(pjequip07);
                String pjequip08 = dataSnapshot.child("pjequip08").getValue().toString();
                    mtablaPj8.setText(pjequip08);
                String pjequip09 = dataSnapshot.child("pjequip09").getValue().toString();
                    mtablaPj9.setText(pjequip09);
                String pjequip10 = dataSnapshot.child("pjequip10").getValue().toString();
                    mtablaPj10.setText(pjequip10);
                String pjequip11 = dataSnapshot.child("pjequip11").getValue().toString();
                    mtablaPj11.setText(pjequip11);
                String pjequip12 = dataSnapshot.child("pjequip12").getValue().toString();
                    mtablaPj12.setText(pjequip12);
                String pjequip13 = dataSnapshot.child("pjequip13").getValue().toString();
                    mtablaPj13.setText(pjequip13);
                String pjequip14 = dataSnapshot.child("pjequip14").getValue().toString();
                    mtablaPj14.setText(pjequip14);
                String pjequip15 = dataSnapshot.child("pjequip15").getValue().toString();
                    mtablaPj15.setText(pjequip15);
                String pjequip16 = dataSnapshot.child("pjequip16").getValue().toString();
                    mtablaPj16.setText(pjequip16);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


        //GOLES DE DIFERENCIA
        mDatabase.child("gdiferencia").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String gdequip01 = dataSnapshot.child("gdequip01").getValue().toString();
                    mtablaGd1.setText(gdequip01);
                    String gdequip02 = dataSnapshot.child("gdequip02").getValue().toString();
                    mtablaGd2.setText(gdequip02);
                    String gdequip03 = dataSnapshot.child("gdequip03").getValue().toString();
                    mtablaGd3.setText(gdequip03);
                    String gdequip04 = dataSnapshot.child("gdequip04").getValue().toString();
                    mtablaGd4.setText(gdequip04);
                    String gdequip05 = dataSnapshot.child("gdequip05").getValue().toString();
                    mtablaGd5.setText(gdequip05);
                    String gdequip06 = dataSnapshot.child("gdequip06").getValue().toString();
                    mtablaGd6.setText(gdequip06);
                    String gdequip07 = dataSnapshot.child("gdequip07").getValue().toString();
                    mtablaGd7.setText(gdequip07);
                    String gdequip08 = dataSnapshot.child("gdequip08").getValue().toString();
                    mtablaGd8.setText(gdequip08);
                    String gdequip09 = dataSnapshot.child("gdequip09").getValue().toString();
                    mtablaGd9.setText(gdequip09);
                    String gdequip10 = dataSnapshot.child("gdequip10").getValue().toString();
                    mtablaGd10.setText(gdequip10);
                    String gdequip11 = dataSnapshot.child("gdequip11").getValue().toString();
                    mtablaGd11.setText(gdequip11);
                    String gdequip12 = dataSnapshot.child("gdequip12").getValue().toString();
                    mtablaGd12.setText(gdequip12);
                    String gdequip13 = dataSnapshot.child("gdequip13").getValue().toString();
                    mtablaGd13.setText(gdequip13);
                    String gdequip14 = dataSnapshot.child("gdequip14").getValue().toString();
                    mtablaGd14.setText(gdequip14);
                    String gdequip15 = dataSnapshot.child("gdequip15").getValue().toString();
                    mtablaGd15.setText(gdequip15);
                    String gdequip16 = dataSnapshot.child("gdequip16").getValue().toString();
                    mtablaGd16.setText(gdequip16);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

        //PUNTOS
        mDatabase.child("puntos").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String pts01 = dataSnapshot.child("pts01").getValue().toString();
                    mtablaPts1.setText(pts01);
                    String pts02 = dataSnapshot.child("pts02").getValue().toString();
                    mtablaPts2.setText(pts02);
                    String pts03 = dataSnapshot.child("pts03").getValue().toString();
                    mtablaPts3.setText(pts03);
                    String pts04 = dataSnapshot.child("pts04").getValue().toString();
                    mtablaPts4.setText(pts04);
                    String pts05 = dataSnapshot.child("pts05").getValue().toString();
                    mtablaPts5.setText(pts05);
                    String pts06 = dataSnapshot.child("pts06").getValue().toString();
                    mtablaPts6.setText(pts06);
                    String pts07 = dataSnapshot.child("pts07").getValue().toString();
                    mtablaPts7.setText(pts07);
                    String pts08 = dataSnapshot.child("pts08").getValue().toString();
                    mtablaPts8.setText(pts08);
                    String pts09 = dataSnapshot.child("pts09").getValue().toString();
                    mtablaPts9.setText(pts09);
                    String pts10 = dataSnapshot.child("pts10").getValue().toString();
                    mtablaPts10.setText(pts10);
                    String pts11 = dataSnapshot.child("pts11").getValue().toString();
                    mtablaPts11.setText(pts11);
                    String pts12 = dataSnapshot.child("pts12").getValue().toString();
                    mtablaPts12.setText(pts12);
                    String pts13 = dataSnapshot.child("pts13").getValue().toString();
                    mtablaPts13.setText(pts13);
                    String pts14 = dataSnapshot.child("pts14").getValue().toString();
                    mtablaPts14.setText(pts14);
                    String pts15 = dataSnapshot.child("pts15").getValue().toString();
                    mtablaPts15.setText(pts15);
                    String pts16 = dataSnapshot.child("pts16").getValue().toString();
                    mtablaPts16.setText(pts16);

                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });


    }


}
