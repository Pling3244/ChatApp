package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Board;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {

	public static final String COLLECTION_NAME="Board";
	
    @Override
	public String insertBoard(Board board) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document().set(board);
           return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public Board getBoardDetail(String id) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
           ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
           DocumentSnapshot documentSnapshot = apiFuture.get();
           Board board = null;

           if(documentSnapshot.exists()) {
        	   board = documentSnapshot.toObject(Board.class);
                   return board;
           } else {
                   return null;
           }
    }

    @Override
    public String updateBoard(Board board) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document().set(board);
           return apiFuture.get().getUpdateTime().toString();
    }

    @Override
    public String deleteBoard(String id) throws Exception {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(id).delete();         
           return "Document id :" + id + " delete";
    }
	
}
