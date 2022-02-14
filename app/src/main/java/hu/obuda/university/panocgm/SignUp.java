package hu.obuda.university.panocgm;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        EditText email = findViewById(R.id.signup_activity_emailtext);
        EditText pass1 = findViewById(R.id.sign_up_activity_passwod1);
        EditText pass2 = findViewById(R.id.signup_activity_pass2);
        Button signupbutton = findViewById(R.id.signup_activity_button);




        signupbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth mauth = FirebaseAuth.getInstance();
                mauth.createUserWithEmailAndPassword(email.getText().toString(),pass2.getText().toString()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()){
                            SignUp.this.finish();
                        }
                        else{
                            Toast.makeText(SignUp.this,task.getException().getMessage(),3).show();
                        }
                    }
                });

            }
        });
    }
}