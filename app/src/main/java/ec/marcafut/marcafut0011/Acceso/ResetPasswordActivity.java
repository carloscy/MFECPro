package ec.marcafut.marcafut0011.Acceso;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;

import ec.marcafut.marcafut0011.R;

public class ResetPasswordActivity extends AppCompatActivity {

    private EditText mEditTextEmail;
    private Button mButtonResetPassword;

    private String email = "";
    private FirebaseAuth mAuth;

    private ProgressDialog mDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reset_password);

        mAuth = FirebaseAuth.getInstance();
        mDialog = new ProgressDialog(this);


        mEditTextEmail = (EditText) findViewById(R.id.editTextEmail);
        mButtonResetPassword = (Button) findViewById(R.id.btnResetPassword);

        mButtonResetPassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                email = mEditTextEmail.getText().toString();

                if (!email.isEmpty()){
                    mDialog.setMessage("Espere un momento...");
                    mDialog.setCanceledOnTouchOutside(false);
                    mDialog.show();
                    resetPassword();
                }
                else {
                    Toast.makeText(ResetPasswordActivity.this, "Debe ingresar el email", Toast.LENGTH_SHORT).show();
                }
                resetPassword();
            }
        });
    }
    private void resetPassword(){

        mAuth.setLanguageCode("es"); //idioma del correo
        mAuth.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {

                if (task.isSuccessful()){
                    Toast.makeText(ResetPasswordActivity.this, "Se ha enviado un correo para reestablecer su contraseña",
                            Toast.LENGTH_SHORT).show();

                }
                else {
                    Toast.makeText(ResetPasswordActivity.this, "No se puedo enviar el correo de reestablecer contraseña", Toast.LENGTH_SHORT).show();
                }

                mDialog.dismiss(); // se oculta el dialogo al finalizar el proceso
            }
        });

    }
}
