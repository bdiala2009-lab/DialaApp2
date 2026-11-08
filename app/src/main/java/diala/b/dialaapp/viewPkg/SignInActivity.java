package diala.b.dialaapp.viewPkg;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModelProvider;

import java.util.List;

import diala.b.dialaapp.R;
import diala.b.dialaapp.model.MyUserTable.MyUser;
import diala.b.dialaapp.viewmodel.UserViewModel;

public class SignInActivity extends AppCompatActivity {
private EditText etEmail,etPassword;
Button btnSignIn;
Button tvSignUp;
private UserViewModel userViewModel;
    /**
     * يُستدعى عند إنشاء النشاط.
     * يقوم بربط العناصر الرسومية، تهيئة {@link UserViewModel} وتفعيل زر تسجيل الدخول.
     *
     * @param savedInstanceState الحالة المحفوظة للنشاط إن وجدت.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_sign_in);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        btnSignIn = findViewById(R.id.btnSignIn);
        tvSignUp=findViewById(R.id.tvSignUp);
        btnSignIn.setOnClickListener(v -> signInUser());
        tvSignUp.setOnClickListener(v ->{
            Intent intent=new Intent(SignInActivity.this,SignUpActivity.class)
                    startActivity(intent);
        }  );
        userViewModel = new ViewModelProvider(this).get(UserViewModel.class);
    }
    private void signInUser(){
        String email=etEmail.getText().toString().trim();
        String password=etPassword.getText().toString().trim();
        if (email.isEmpty()) {
            etEmail.setError("Email is required");
            etEmail.requestFocus();
            return;
        }
        if (password.isEmpty()) {
            etPassword.setError("Password is required");
            etPassword.requestFocus();
            return;
        }
       MyUser user = userViewModel.checkEmailPassw(email, password);
        if (user != null) {
            Toast.makeText(this, "Welcome, " + user.getFullName(), Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(SignInActivity.this, MainActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(this, "Invalid email or password", Toast.LENGTH_SHORT).show();
        }
    }
}

