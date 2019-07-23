package ec.marcafut.marcafut0011.Acceso;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;


import ec.marcafut.marcafut0011.MainActivity;
import ec.marcafut.marcafut0011.R;

public class RegistroActivity extends AppCompatActivity {

    private EditText mEditTextName,mEditTextEmail, mEditTextPassword;
    private Button mButtonRegister, mButtonYala;
    ProgressBar progressBar;
    private FirebaseAuth auth;

    //Variables de los datos a registrar
    private String name= "";
    private String email= "";
    private String password= "";

    FirebaseAuth mAuth;
    DatabaseReference mDatabase; //Objeto para usar la bd en tiempo real


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);

        mAuth = FirebaseAuth.getInstance();
        mDatabase = FirebaseDatabase.getInstance().getReference();

        mEditTextName = (EditText)findViewById(R.id.editTextName);
        mEditTextEmail = (EditText)findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText)findViewById(R.id.editTextPassword);
        mButtonRegister = (Button)findViewById(R.id.btnRegister);
        mButtonYala = (Button)findViewById(R.id.btnYala);


        mButtonRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                name =mEditTextName.getText().toString();
                email =mEditTextEmail.getText().toString();
                password =mEditTextPassword.getText().toString();

                if (!name.isEmpty() && !email.isEmpty() && !password.isEmpty()){

                    if (password.length()>= 6) {
                        registerUser();
                    }
                        else{
                            Toast.makeText(RegistroActivity.this,"La contraseña debe tener al menos 6 caracteres",Toast.LENGTH_SHORT).show();
                    }

                }
                else {
                    Toast.makeText(RegistroActivity.this, "Debe completar los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });
        //Botón cuando el usuario ya tiene cuenta
        mButtonYala.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(RegistroActivity.this,LoginActivity.class);
                startActivity(i);
            }
        });

    }
    //Firebase
    private void registerUser(){
    mAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
        @Override
        public void onComplete(@NonNull Task<AuthResult> task) {
            if (task.isSuccessful()){
             //Se crea mapa de valores

                Map<String, Object> map = new HashMap<>();
                //Se colocan los campos que queremos en la base de datos
                map.put("name",name);
                map.put("email",email);
                map.put("password",password);

                String id = mAuth.getCurrentUser().getUid();  //Da la id de firebase

                mDatabase.child("Users").child(id).setValue(map).addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task2) {
                        if (task2.isSuccessful()){
                            startActivity(new Intent(RegistroActivity.this,LoginActivity.class)); //Al completar el registro envia a Login
                            finish();
                        }
                        else {
                            Toast.makeText(RegistroActivity.this,"no se pudieron crear los datos correctamente",
                                    Toast.LENGTH_SHORT).show();
                        }
                    }
                }); //Se crea el nodo hijo Users al ingresar usuario, pide mapa de valores se crea
            }
            else {
                Toast.makeText(RegistroActivity.this,"No se pudo registrar este usuario",Toast.LENGTH_SHORT).show();
            }
        }
    });
    }

    //Para que no vuelva a pedir inicio de sesión tras cerra la app
    @Override
    protected void onStart() {
        super.onStart();

        if (mAuth.getCurrentUser() != null){
            startActivity(new Intent(RegistroActivity.this, MainActivity.class)); //Clase a la que me me envia al abrir la app despues de que se inicia la sesión
            finish();
        }
    }
}
