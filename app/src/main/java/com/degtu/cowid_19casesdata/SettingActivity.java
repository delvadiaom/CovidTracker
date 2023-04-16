package com.degtu.cowid_19casesdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.degtu.cowid_19casesdata.databinding.ActivitySettingBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class SettingActivity extends AppCompatActivity {

    ActivitySettingBinding binding;
    FirebaseDatabase database;
    Uri selectedImage;
    ProgressDialog dialog;
    FirebaseStorage storage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivitySettingBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        binding.savebtn.setVisibility(View.INVISIBLE);

        dialog = new ProgressDialog(this);
        dialog.setMessage("Updating Profile Picture...");
        dialog.setCancelable(false);

        database = FirebaseDatabase.getInstance();
        storage = FirebaseStorage.getInstance();

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        binding.precautionsrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PrecautionsActivity.class);
                startActivity(intent);
            }
        });

        binding.aboutusrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),AboutUsActivity.class);
                startActivity(intent);
            }
        });

        binding.privacyrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),PrivacyPolicyActivity.class);
                startActivity(intent);
            }
        });

        binding.contactusrelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),ContactUsActivity.class);
                startActivity(intent);
            }
        });

        database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                if (snapshot.exists()){
                    try {
                        User user = snapshot.getValue(User.class);
                        assert user != null;
                        Picasso.get().load(user.getProfileImage()).placeholder(R.drawable.profilepic3).into(binding.proimg);
                        binding.username.setText(user.getName());
                        binding.phonenumber.setText(user.getPhone());
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        binding.proimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,75);
                binding.savebtn.setVisibility(View.VISIBLE);
            }
        });

        binding.savebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (selectedImage!=null){
                    dialog.show();
                        StorageReference reference = storage.getReference().child("Profiles").child(FirebaseAuth.getInstance().getUid());
                        reference.putFile(selectedImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                            @Override
                            public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                                if (task.isSuccessful()){
                                    reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                        @Override
                                        public void onSuccess(Uri uri) {
                                            String imageUrl = uri.toString();
                                            String phone = FirebaseAuth.getInstance().getCurrentUser().getPhoneNumber();
                                            String name = binding.username.getText().toString();
                                            User user = new User(name,phone,imageUrl);
                                            database.getReference().child("Users").child(FirebaseAuth.getInstance().getUid()).setValue(user).addOnSuccessListener(new OnSuccessListener<Void>() {
                                                @Override
                                                public void onSuccess(Void aVoid) {
                                                    dialog.dismiss();
                                                    Toast.makeText(SettingActivity.this, "Profile picture updated", Toast.LENGTH_SHORT).show();
                                                }
                                            });

                                        }
                                    });
                                }
                            }
                        });
                }else {
                    Toast.makeText(SettingActivity.this, "No profile image selected", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null){
            if (data.getData()!=null){
                binding.proimg.setImageURI(data.getData());
                selectedImage = data.getData();
            }
        }
    }
}