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

public class TablagoleadoresActivity extends AppCompatActivity {

    private TextView mtJugador1,mtJugador2,mtJugador3,mtJugador4,mtJugador5,mtJugador6,mtJugador7,mtJugador8,mtJugador9,mtJugador10;
    private TextView mtClub1,mtClub2,mtClub3,mtClub4,mtClub5,mtClub6,mtClub7,mtClub8,mtClub9,mtClub10;
    private TextView mtGoles1,mtGoles2,mtGoles3,mtGoles4,mtGoles5,mtGoles6,mtGoles7,mtGoles8,mtGoles9,mtGoles10;

    private DatabaseReference mDatabase; //para mostrar datos de la base de datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tablagoleadores);

        mtJugador1 = (TextView)findViewById(R.id.tJugador1);
        mtJugador2 = (TextView)findViewById(R.id.tJugador2);
        mtJugador3 = (TextView)findViewById(R.id.tJugador3);
        mtJugador4 = (TextView)findViewById(R.id.tJugador4);
        mtJugador5 = (TextView)findViewById(R.id.tJugador5);
        mtJugador6 = (TextView)findViewById(R.id.tJugador6);
        mtJugador7 = (TextView)findViewById(R.id.tJugador7);
        mtJugador8 = (TextView)findViewById(R.id.tJugador8);
        mtJugador9 = (TextView)findViewById(R.id.tJugador9);
        mtJugador10 = (TextView)findViewById(R.id.tJugador10);
        //CLUBES
        mtClub1 = (TextView)findViewById(R.id.tClub1);
        mtClub2 = (TextView)findViewById(R.id.tClub2);
        mtClub3 = (TextView)findViewById(R.id.tClub3);
        mtClub4 = (TextView)findViewById(R.id.tClub4);
        mtClub5 = (TextView)findViewById(R.id.tClub5);
        mtClub6 = (TextView)findViewById(R.id.tClub6);
        mtClub7 = (TextView)findViewById(R.id.tClub7);
        mtClub8 = (TextView)findViewById(R.id.tClub8);
        mtClub9 = (TextView)findViewById(R.id.tClub9);
        mtClub10 = (TextView)findViewById(R.id.tClub10);
        //
        mtGoles1 = (TextView)findViewById(R.id.tGoles1);
        mtGoles2 = (TextView)findViewById(R.id.tGoles2);
        mtGoles3 = (TextView)findViewById(R.id.tGoles3);
        mtGoles4 = (TextView)findViewById(R.id.tGoles4);
        mtGoles5 = (TextView)findViewById(R.id.tGoles5);
        mtGoles6 = (TextView)findViewById(R.id.tGoles6);
        mtGoles7 = (TextView)findViewById(R.id.tGoles7);
        mtGoles8 = (TextView)findViewById(R.id.tGoles8);
        mtGoles9 = (TextView)findViewById(R.id.tGoles9);
        mtGoles10 = (TextView)findViewById(R.id.tGoles10);


        mDatabase = FirebaseDatabase.getInstance().getReference();//Hace referencia al nodo principa de la BD
        //NOMBRES DE EQUIPOS
        mDatabase.child("goleadores").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //validación para saber si el objeto existe
                if (dataSnapshot.exists()){
                    String gol01 = dataSnapshot.child("gol01").getValue().toString();
                    mtJugador1.setText(gol01);
                    String gol02 = dataSnapshot.child("gol02").getValue().toString();
                    mtJugador2.setText(gol02);
                    String gol03 = dataSnapshot.child("gol03").getValue().toString();
                    mtJugador3.setText(gol03);
                    String gol04 = dataSnapshot.child("gol04").getValue().toString();
                    mtJugador4.setText(gol04);
                    String gol05 = dataSnapshot.child("gol05").getValue().toString();
                    mtJugador5.setText(gol05);
                    String gol06 = dataSnapshot.child("gol06").getValue().toString();
                    mtJugador6.setText(gol06);
                    String gol07 = dataSnapshot.child("gol07").getValue().toString();
                    mtJugador7.setText(gol07);
                    String gol08 = dataSnapshot.child("gol08").getValue().toString();
                    mtJugador8.setText(gol08);
                    String gol09 = dataSnapshot.child("gol09").getValue().toString();
                    mtJugador9.setText(gol09);
                    String gol10 = dataSnapshot.child("gol10").getValue().toString();
                    mtJugador10.setText(gol10);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //
        mDatabase.child("golescan").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //validación para saber si el objeto existe
                if (dataSnapshot.exists()){
                    String numgol01 = dataSnapshot.child("numgol01").getValue().toString();
                    mtGoles1.setText(numgol01);
                    String numgol02 = dataSnapshot.child("numgol02").getValue().toString();
                    mtGoles2.setText(numgol02);
                    String numgol03 = dataSnapshot.child("numgol03").getValue().toString();
                    mtGoles3.setText(numgol03);
                    String numgol04 = dataSnapshot.child("numgol04").getValue().toString();
                    mtGoles4.setText(numgol04);
                    String numgol05 = dataSnapshot.child("numgol05").getValue().toString();
                    mtGoles5.setText(numgol05);
                    String numgol06 = dataSnapshot.child("numgol06").getValue().toString();
                    mtGoles6.setText(numgol06);
                    String numgol07 = dataSnapshot.child("numgol07").getValue().toString();
                    mtGoles7.setText(numgol07);
                    String numgol08 = dataSnapshot.child("numgol08").getValue().toString();
                    mtGoles8.setText(numgol08);
                    String numgol09 = dataSnapshot.child("numgol09").getValue().toString();
                    mtGoles9.setText(numgol09);
                    String numgol10 = dataSnapshot.child("numgol10").getValue().toString();
                    mtGoles10.setText(numgol10);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
        //
        mDatabase.child("equipgoles").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                //validación para saber si el objeto existe
                if (dataSnapshot.exists()){
                    String goleaequi01 = dataSnapshot.child("goleaequi01").getValue().toString();
                    mtClub1.setText(goleaequi01);
                    String goleaequi02 = dataSnapshot.child("goleaequi02").getValue().toString();
                    mtClub2.setText(goleaequi02);
                    String goleaequi03 = dataSnapshot.child("goleaequi03").getValue().toString();
                    mtClub3.setText(goleaequi03);
                    String goleaequi04 = dataSnapshot.child("goleaequi04").getValue().toString();
                    mtClub4.setText(goleaequi04);
                    String goleaequi05 = dataSnapshot.child("goleaequi05").getValue().toString();
                    mtClub5.setText(goleaequi05);
                    String goleaequi06 = dataSnapshot.child("goleaequi06").getValue().toString();
                    mtClub6.setText(goleaequi06);
                    String goleaequi07 = dataSnapshot.child("goleaequi07").getValue().toString();
                    mtClub7.setText(goleaequi07);
                    String goleaequi08 = dataSnapshot.child("goleaequi08").getValue().toString();
                    mtClub8.setText(goleaequi08);
                    String goleaequi09 = dataSnapshot.child("goleaequi09").getValue().toString();
                    mtClub9.setText(goleaequi09);
                    String goleaequi10 = dataSnapshot.child("goleaequi10").getValue().toString();
                    mtClub10.setText(goleaequi10);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }
}
