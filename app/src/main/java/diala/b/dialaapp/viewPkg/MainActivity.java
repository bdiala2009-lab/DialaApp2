package diala.b.dialaapp.viewPkg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import diala.b.dialaapp.R;
import diala.b.dialaapp.model.AppDataBase;
import diala.b.dialaapp.model.mySubjectTable.MySubject;
import diala.b.dialaapp.model.mySubjectTable.MySubjectQuery;

public class MainActivity extends AppCompatActivity {
    private Button bntAddNewTask;
    private Button bntRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);

//بناء قاعدة بيانات وارجاع مؤشر عليها1
        AppDataBase db = AppDataBase.getDB(getApplicationContext());
//2 مؤشر لكائن عمليات  لجدول
        MySubjectQuery subjectQuery = db.getMySubjectQuery();
//3  بناء كائن من نوع الجدول وتحديد قيم الصفات
        MySubject s1 = new MySubject();
        s1.setTitle("Math");
        MySubject s2 = new MySubject();
        s2.title = "Computers";
//4 اضافة كائن للجدول
//        subjectQuery.insert(s1);
//        subjectQuery.insert(s2);


        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.LinearLayout), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        bntAddNewTask = findViewById(R.id.btnAddTaskScreen);

        bntAddNewTask.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(i);
            }


        });


        bntRegister = findViewById(R.id.btnRegisterScreen);
        bntRegister.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, SignUpActivity.class);
                startActivity(i);
            }

        });

    }
    /**
    @Override  //بناء قائمة
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override//معالجة حدث اختيار عنصر من القائمة
   public boolean onOptionsItemSelected(MenuItem item) {
    if (item.getItemId() == R.id.itemSettings) {
           Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, Settings.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.itemSignOut) {
           Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(MainActivity.this, SignOut.class);
        startActivity(i);
    }

        if (item.getItemId() == R.id.itemHistory) {
           Toast.makeText(this, "History", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity.this, History.class);
            startActivity(i);
        }

        return true;
    }
    public void showYesNoDialog(){

        //تجهيز بناء شباك ديالوج ستلقى برامت مؤشلا للنشاط (اكتيفيتي)الحالي
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Log out");//تحديد العنوان
        builder.setMessage("Are you sure?");//تحديد فحوى شباك الحوار
        //النص على الزر ومعالج الحدث
        builder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة خدث للموافقة
                Toast.makeText(MainActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //النص على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة خدث للموافقة
                Toast.makeText(MainActivity.this, "Signing out", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
*/
}
