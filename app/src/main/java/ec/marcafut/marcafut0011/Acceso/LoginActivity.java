package ec.marcafut.marcafut0011.Acceso;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import ec.marcafut.marcafut0011.MainActivity;
import ec.marcafut.marcafut0011.R;

public class LoginActivity extends AppCompatActivity {


    private EditText mEditTextEmail, mEditTextPassword;
    private Button mButtonLogin, mButtonResetPassword;

    private String email= "";
    private String password= "";

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        mAuth = FirebaseAuth.getInstance();

        mEditTextEmail = (EditText)findViewById(R.id.editTextEmail);
        mEditTextPassword = (EditText)findViewById(R.id.editTextPassword);
        mButtonLogin = (Button)findViewById(R.id.btnLogin);
        mButtonResetPassword = (Button)findViewById(R.id.btnSendToResetPassword);


        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                email = mEditTextEmail.getText().toString();  //Email es igual a lo que el usuario ingrese en este campo
                password = mEditTextPassword.getText().toString();

                if (!email.isEmpty() && !password.isEmpty()){
                    loginUser();
                }
                else{
                    Toast.makeText(LoginActivity.this, "Complete los campos", Toast.LENGTH_SHORT).show();
                }
            }
        });


        mButtonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(LoginActivity.this,ResetPasswordActivity.class ));
            }
        });
    }
    private void loginUser(){
        mAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    startActivity(new Intent(LoginActivity.this, MainActivity.class)); //Actividad destino despues de autenticar
                    finish();
                }
                else{
                    Toast.makeText(LoginActivity.this, "No se puedo iniciar sesión compruebe los datos",
                            Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
