package com.example.myapplication;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.internal.api.FirebaseNoSignedInUserException;
import com.google.firebase.ktx.Firebase;

import java.util.Collection;

public class Util {

    static CollectionReference getcollectionreference(){
        FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
        return FirebaseFirestore.getInstance().collection("notes").document(user.getUid()).collection("mynotes");

    }
}
