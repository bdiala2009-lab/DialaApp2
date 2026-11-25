package diala.b.dialaapp.viewPkg;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import diala.b.dialaapp.R;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    @Override  //بناء قائمة
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override//معالجة حدث اختيار عنصر من القائمة
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.itemSettings) {
            Toast.makeText(this, "Settings", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity2.this, Settings.class);
            startActivity(i);
        }

        if (item.getItemId() == R.id.itemSignOut) {
           // Toast.makeText(this, "SignOut", Toast.LENGTH_SHORT).show();
         //   Intent i = new Intent(MainActivity2.this, SignOut.class);
         //   startActivity(i);
            showYesNoDialog();
        }

        if (item.getItemId() == R.id.itemHistory) {
            Toast.makeText(this, "History", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(MainActivity2.this, History.class);
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
                Toast.makeText(MainActivity2.this, "Signing out", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(MainActivity2.this, SignInActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //النص على الزر ومعالج الحدث
        builder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //معالجة خدث للموافقة
                Toast.makeText(MainActivity2.this, "Signing out", Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }

        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }
}