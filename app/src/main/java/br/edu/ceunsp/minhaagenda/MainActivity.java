package br.edu.ceunsp.minhaagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AppDatabase db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "database-name").allowMainThreadQueries().build();

        List<User> users = db.userDao().getAll();

        scrollView = findViewById(R.id.scrollView2);

        TableLayout tableLayout = new TableLayout(this);

        for (User u: users) {
            TableRow tableRow = new TableRow(this);
            TextView tv = new TextView(this);
            tv.setPadding(10,10,10,10);
           // tv.setGravity(Gravity.CENTER);
            tv.setText(u.uid + " " + u.firstName + " " + u.lastName);
            tableRow.addView(tv);
            tableLayout.addView(tableRow);

            View v = new View(this);
            v.setLayoutParams(new TableRow.LayoutParams(
                    TableRow.LayoutParams.MATCH_PARENT, 1));
            tableLayout.addView(v);
        }

        scrollView.addView(tableLayout);
    }

    public void onClick(View view) {

        Intent intent = new Intent(MainActivity.this, AddUser.class);
        startActivity(intent);

    }
}