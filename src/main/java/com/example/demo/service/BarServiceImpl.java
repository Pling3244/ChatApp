package com.example.demo.service;

import org.springframework.stereotype.Service;

import com.example.demo.model.Bar;
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
		    public Bar getBarDetail(String id) throws Exception {
		           Firestore firestore = FirestoreClient.getFirestore();
		           DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
		           ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
		           DocumentSnapshot documentSnapshot = apiFuture.get();
		           Bar bar = null;

		           if(documentSnapshot.exists()) {
		        	   bar = documentSnapshot.toObject(Bar.class);
		                   return bar;
		           } else {
		                   return null;
		           }
		    }		
}
