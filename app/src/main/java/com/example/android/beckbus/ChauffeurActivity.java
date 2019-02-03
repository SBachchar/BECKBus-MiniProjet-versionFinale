package com.example.android.beckbus;

import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;

public class ChauffeurActivity extends AppCompatActivity {

    private Button MonProfil, Controler, Deconnexion, Pannes;

    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chauffeur);

        MonProfil = (Button) findViewById(R.id.profil);
        Controler = (Button) findViewById(R.id.controle);
        Deconnexion = (Button) findViewById(R.id.deconnexion);
        Pannes = (Button) findViewById(R.id.pannes);

        mAuth = FirebaseAuth.getInstance();

        MonProfil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent settingsIntent = new Intent(ChauffeurActivity.this,SettingsActivity.class);
                startActivity(settingsIntent);
            }
        });

        Controler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Uri addressUri = Uri.parse("https://www.the-qrcode-generator.com/scan");
                Intent intent = new Intent(Intent.ACTION_VIEW, addressUri);
                startActivity(intent);
            }
        });

        Deconnexion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAuth.signOut();
                Intent loginIntent = new Intent(ChauffeurActivity.this,MainActivity.class);
                startActivity(loginIntent);
            }
        });

        Pannes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ChauffeurActivity.this, PannesActivity.class);
                startActivity(intent);
            }
        });

    }
}
