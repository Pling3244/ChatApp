package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Board;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.firebase.cloud.FirestoreClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BarServiceImpl implements BarService {

	public static final String COLLECTION_NAME="FoodApi";
			
			@Override
		    public Board getBarDetail(String id) throws Exception {
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
}
