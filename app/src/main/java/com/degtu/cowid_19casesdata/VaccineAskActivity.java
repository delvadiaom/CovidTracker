package com.degtu.cowid_19casesdata;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.annotation.SuppressLint;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.degtu.cowid_19casesdata.databinding.ActivityVaccineAskBinding;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

public class VaccineAskActivity extends AppCompatActivity {

    ActivityVaccineAskBinding binding;
    Uri selectedImage;
    FirebaseStorage storage;
    FirebaseDatabase database;
    ProgressDialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityVaccineAskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportActionBar().hide();

        storage = FirebaseStorage.getInstance();
        database = FirebaseDatabase.getInstance();
        dialog = new ProgressDialog(this);
        dialog.setMessage("Uploading..");
        dialog.setCancelable(false);

        database.getReference().child("Certificates").addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                binding.firstcertificatetext.setText("Your vaccine certificate");
                if (snapshot.exists()){
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()){
                        try {
                            Picasso.get().load(snapshot.child(FirebaseAuth.getInstance().getUid()).getValue().toString()).placeholder(R.drawable.certificate).into(binding.firstcertificateimg);
                        }catch (NullPointerException e){
                            e.printStackTrace();
                        }
                    }
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel notificationChannel = new  NotificationChannel("My Noti","My Notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager notificationManager = getSystemService(NotificationManager.class);
            notificationManager.createNotificationChannel(notificationChannel);
        }

        binding.no.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NotificationCompat.Builder builder = new NotificationCompat.Builder(VaccineAskActivity.this,"My Noti");
                builder.setContentTitle("Health is wealth");
                builder.setSmallIcon(R.drawable.ic_baseline_android_24);
                builder.setContentText("You must get vaccinated with your two doses. See other precautions that must be taken by you.");
                builder.setAutoCancel(true);
                Intent intent = new Intent(VaccineAskActivity.this,PrecautionsActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);

                @SuppressLint("UnspecifiedImmutableFlag") PendingIntent pendingIntent =  PendingIntent.getActivity(VaccineAskActivity.this,0,intent,PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                NotificationManagerCompat notificationManagerCompat = NotificationManagerCompat.from(VaccineAskActivity.this);
                notificationManagerCompat.notify(1,builder.build());
            }
        });

        binding.firstcertificateimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setAction(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent,99);
            }
        });

        binding.yes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(VaccineAskActivity.this, "Please upload your vaccination certificate", Toast.LENGTH_SHORT).show();
            }
        });

        binding.upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.show();
                if (selectedImage!=null){
                    StorageReference reference = storage.getReference().child("Certificates").child(FirebaseAuth.getInstance().getUid());
                    reference.putFile(selectedImage).addOnCompleteListener(new OnCompleteListener<UploadTask.TaskSnapshot>() {
                        @Override
                        public void onComplete(@NonNull Task<UploadTask.TaskSnapshot> task) {
                            if (task.isSuccessful()){
                                reference.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                                    @Override
                                    public void onSuccess(Uri uri) {
                                        dialog.dismiss();
                                        String image = uri.toString();
                                        database.getReference().child("Certificates").child(FirebaseAuth.getInstance().getUid()).setValue(image);
                                        Toast.makeText(VaccineAskActivity.this, "Certificate Uploaded Successfully", Toast.LENGTH_SHORT).show();
                                    }
                                });
                            }
                        }
                    });
                }
            }
        });

        binding.back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (data!=null){
            if (data.getData()!=null){
                binding.firstcertificateimg.setImageURI(data.getData());
                selectedImage = data.getData();
            }
        }
    }
}