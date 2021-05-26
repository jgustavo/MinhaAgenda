package br.edu.ceunsp.minhaagenda;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.google.android.material.textfield.TextInputEditText;

public class AddUser extends AppCompatActivity {

    TextInputEditText textNome;
    TextInputEditText textSobrenome;
    AppDatabase db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_user);

        textNome = findViewById(R.id.nome);
        textSobrenome = findViewById(R.id.sobrenome);

        db = Room.databaseBuilder(getApplicationContext(),AppDatabase.class, "database-name").allowMainThreadQueries().build();


    }

    public void onClick(View view) {

        User user = new User();
        user.firstName = textNome.getText().toString();
        user.lastName = textSobrenome.getText().toString();

        db.userDao().insertAll(user);

        Intent intent = new Intent(AddUser.this, MainActivity.class);
        startActivity(intent);

    }
}