package com.example.demo.service;

import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.model.Member;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	
	public static final String COLLECTION_NAME="Member";
	
	@Override
    public String insertMember(Member member) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(member.getId()).set(member);
           return apiFuture.get().getUpdateTime().toString();       
    }
	
	@Override
    public boolean verifyLogin(String id, String pw) {
        Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot;
        try {
            documentSnapshot = apiFuture.get();
            Member member = null;

            if (documentSnapshot.exists()) {
                member = documentSnapshot.toObject(Member.class);
                return member.getPw().equals(pw);
            } else {
                return false;
            }
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
            return false;
        }
    }


    @Override
    public Member getMemberDetail(String id) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
           ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
           DocumentSnapshot documentSnapshot = apiFuture.get();
           Member member = null;

           if(documentSnapshot.exists()) {
                   member = documentSnapshot.toObject(Member.class);
                   return member;
           } else {
                   return null;
           }
    }

    @Override
    public String updateMember(Member member) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(member.getId()).set(member);
           return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteMember(String id) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(id).delete();         
           return "Document id :" + id + " delete";
    }
	
}
