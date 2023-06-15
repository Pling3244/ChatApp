package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.stereotype.Service;

import com.example.demo.model.Meeting;
import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.CollectionReference;
import com.google.cloud.firestore.DocumentReference;
import com.google.cloud.firestore.DocumentSnapshot;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.QuerySnapshot;
import com.google.cloud.firestore.WriteResult;
import com.google.firebase.cloud.FirestoreClient;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MeetingServiceImpl implements MeetingService {

	public static final String COLLECTION_NAME="Meeting";
	
	@Override
	public List<Meeting> getMeetingList() {
		Firestore firestore = FirestoreClient.getFirestore();
		CollectionReference collectionReference = firestore.collection(COLLECTION_NAME);
        ApiFuture<QuerySnapshot> querySnapshot = collectionReference.get();
        List<Meeting> meetingList = new ArrayList<>();;

        try {
			for (DocumentSnapshot document : querySnapshot.get().getDocuments()) {
				Meeting meeting = document.toObject(Meeting.class);
				meetingList.add(meeting);
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
        return meetingList;
    }

	@Override
	public String insertMeeting(Meeting meeting) {
		Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document().set(meeting);
        try {
			return apiFuture.get().getUpdateTime().toString();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
		return null;
		
	}

	@Override
	public Meeting getOneMeeting(String id) {
		Firestore firestore = FirestoreClient.getFirestore();
        DocumentReference documentReference = firestore.collection(COLLECTION_NAME).document(id);
        ApiFuture<DocumentSnapshot> apiFuture = documentReference.get();
        DocumentSnapshot documentSnapshot = null;
		try {
			documentSnapshot = apiFuture.get();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} catch (ExecutionException e) {
			e.printStackTrace();
		}
        Meeting meeting = null;

        if(documentSnapshot.exists()) {
        	meeting = documentSnapshot.toObject(Meeting.class);
                return meeting;
        } else {
                return null;
        }
	}
	
	@Override
    public String deleteMeeting(String id) {
           Firestore firestore = FirestoreClient.getFirestore();
           ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(id).delete();         
           return "Meeting id :" + id + " delete";
    }
	
	@Override
	public String updateMeeting(String id, Meeting meeting) {
		Firestore firestore = FirestoreClient.getFirestore();
        ApiFuture<WriteResult> apiFuture = firestore.collection(COLLECTION_NAME).document(id).set(meeting);
        try {
			return apiFuture.get().getUpdateTime().toString();
		} catch (InterruptedException | ExecutionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}

//	@Override
//	public void insertUserinmeeting(Userinmeeting userinmeeting) {
//		// TODO Auto-generated method stub
//		
//	}
//
//	@Override
//	public Userinmeeting getOneUserinmeeting(String userinmeeting_val) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<User> getChatMemberList(int meeting_id) {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public void deleteUserinmeeting(String email, int meeting_id) {
		// TODO Auto-generated method stub
		
	}

		
}
