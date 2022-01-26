package com.example.foodprorestaurant;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {
    Button btn;
    FirebaseDatabase database;
    DatabaseReference restdbref;
    EditText name, email, restaurantname, location;
    String s_name, s_email, s_restaurantname, s_location;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = findViewById(R.id.Name);
        email = findViewById(R.id.email);
        restaurantname = findViewById(R.id.Restaurantname);
        location = findViewById(R.id.location);

        btn = findViewById(R.id.nextbutton);

        database = FirebaseDatabase.getInstance();
        restdbref = database.getReference().child("Restaurant");


        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                s_name = name.getText().toString().trim();
                s_email = email.getText().toString().trim();
                s_restaurantname = restaurantname.getText().toString().trim();
                s_location = location.getText().toString().trim();

                Restaurant restaurant;
                restaurant = new Restaurant(s_name, s_email, s_restaurantname, s_location);
                restdbref.push().setValue(restaurant)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                if(task.isSuccessful()){
                                    Toast.makeText(getApplicationContext(), "Data inserted", Toast.LENGTH_SHORT).show();
                                    Intent k = new Intent(getApplicationContext(), Menu.class);
                                    startActivity(k);
                                    finish();
                                } else Toast.makeText(RegisterActivity.this, "Failed to add resturant", Toast.LENGTH_SHORT).show();
                            }
                        });


            }
        });

    }
}