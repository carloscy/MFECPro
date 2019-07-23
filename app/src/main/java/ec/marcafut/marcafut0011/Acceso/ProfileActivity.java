package ec.marcafut.marcafut0011.Acceso;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import ec.marcafut.marcafut0011.R;

public class ProfileActivity extends AppCompatActivity {

    private Button mButtonSignOut;
    private TextView mTextViewName;
    private TextView mTexViewEmail;
    private FirebaseAuth mAuth;
    private DatabaseReference mDatabase; //para mostrar datos de la base de datos


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference(); //

        mButtonSignOut = (Button) findViewById(R.id.btnSignout);
        mTextViewName = (TextView) findViewById(R.id.texViewName);
        mTexViewEmail = (TextView) findViewById(R.id.texViewEmail);


        mButtonSignOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();  //Se cierra la sesión
                startActivity(new Intent(ProfileActivity.this,RegistroActivity.class)); //Se inicia la actividad registro
                finish();
            }
        });

        //Necesario llamar al metodo
        getUserInfo();
    }

    public void getUserInfo(){
        String id = mAuth.getCurrentUser().getUid(); //con esto se obtiene el id del user
        mDatabase.child("Users").child(id).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                if (dataSnapshot.exists()){
                    String name = dataSnapshot.child("name").getValue().toString();
                    String email = dataSnapshot.child("email").getValue().toString();

                    //pasar a los textview
                    mTextViewName.setText(name);
                    mTexViewEmail.setText(email);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }
}
