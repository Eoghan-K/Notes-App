package com.eoghan.note;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.storage.StorageReference;

import utilities.NoteApi;

public class PostNoteActivity extends AppCompatActivity implements View.OnClickListener {
    private Button saveButton;
    private ProgressBar progressBar;
    private ImageView addPhotoButton;
    private EditText titleEditText;
    private EditText noteEditText;
    private TextView currentUserTextView;

    private String currentUserId;
    private String currentUsername;

    private FirebaseAuth firebaseAuth;
    private FirebaseAuth.AuthStateListener authStateListener;
    private FirebaseUser user;

    // Connection to Firestore
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private StorageReference storageReference;
    private CollectionReference collectionReference = db.collection("Notes");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_post_note);

        firebaseAuth = FirebaseAuth.getInstance();
        progressBar = findViewById(R.id.postProgressBar);
        titleEditText = findViewById(R.id.postTitleEditText);
        noteEditText = findViewById(R.id.postBodyEditText);
        currentUserTextView = findViewById(R.id.postUsernameTextView);
        saveButton = findViewById(R.id.postSaveNoteButton);
        saveButton.setOnClickListener(this);
        addPhotoButton = findViewById(R.id.postCameraButton);
        addPhotoButton.setOnClickListener(this);

        if (NoteApi.getInstance() != null){
            currentUserId = NoteApi.getInstance().getUserId();
            currentUsername = NoteApi.getInstance().getUsername();

            currentUserTextView.setText(currentUsername);
        }

        authStateListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                user = firebaseAuth.getCurrentUser();
            }
        };
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.postSaveNoteButton:
                // Save Note
                break;
            case R.id.postCameraButton:
                // Get Photo
                break;
        }
    }
}
