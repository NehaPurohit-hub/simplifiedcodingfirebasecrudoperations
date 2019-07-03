package com.example.simplifiedcodingfirebasecrudoperations;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
EditText e1;
Spinner s1;
Button b1;
ListView l1;
DatabaseReference db;
List<artist> artistLists;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        e1=(EditText)findViewById(R.id.editText);
        s1=(Spinner)findViewById(R.id.spinner);
        l1=(ListView)findViewById(R.id.list);
        artistLists=new ArrayList<>();
        db= FirebaseDatabase.getInstance().getReference("Artists");
        b1=(Button)findViewById(R.id.button);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
addartist();
            }
        });
    }

    @Override
    protected void onStart() {
        super.onStart();
        db.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                artistLists.clear();
                for(DataSnapshot artistsnapshot:dataSnapshot.getChildren())
                {
                    artist a=artistsnapshot.getValue(artist.class);
                    artistLists.add(a);
                }
             artistlist adapter=new artistlist(MainActivity.this,artistLists);
                l1.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    public void addartist()
    {
        String name=e1.getText().toString();
        String genere=s1.getSelectedItem().toString();
        String id=db.push().getKey();
        artist a=new artist(id,name,genere);
        db.child(id).setValue(a);
        Toast.makeText(this, "Artist added", Toast.LENGTH_SHORT).show();
    }
}
