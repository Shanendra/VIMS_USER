package com.example.vims_user.ui.gallery;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.vims_user.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class GalleryFragment extends Fragment {

    RecyclerView convoRecycler,vitsonbeatsRecycler,collegefestRecycler,horizonRecycler,independencedayRecycler,othereventRecycler;
    GalleryAdapter adapter;
    DatabaseReference reference;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_gallery, container, false);

        convoRecycler = view.findViewById(R.id.convocation);
        vitsonbeatsRecycler = view.findViewById(R.id.vitsonbeats);
        collegefestRecycler = view.findViewById(R.id.collegefest);
        horizonRecycler = view.findViewById(R.id.horizon);
        independencedayRecycler = view.findViewById(R.id.indepenenceday);
        othereventRecycler = view.findViewById(R.id.othereventa);


        reference = FirebaseDatabase.getInstance().getReference().child("Gallery");


        convoRecycler();
        vitsonbeatsRecycler();
        collegefestRecycler();
        horizonRecycler();
        independencedayRecycler();
        othereventRecycler();




        return view;
    }

    private void othereventRecycler() {
        reference.child("Other Event").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                othereventRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                othereventRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void independencedayRecycler() {
        reference.child("Independence Day").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                independencedayRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                independencedayRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void horizonRecycler() {
        reference.child("HORIZON").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                horizonRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                horizonRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void collegefestRecycler() {
        reference.child("College Fest").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                collegefestRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                collegefestRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void vitsonbeatsRecycler() {
            reference.child("VITS ON BEATS").addValueEventListener(new ValueEventListener() {
                List<String> imageList = new ArrayList<>();
                @Override
                public void onDataChange(@NonNull DataSnapshot snapshot) {
                    for (DataSnapshot snapshot1: snapshot.getChildren()){
                        String data = (String)snapshot1.getValue();
                        imageList.add(data);
                    }

                    adapter = new GalleryAdapter(getContext(),imageList);
                    vitsonbeatsRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                    vitsonbeatsRecycler.setAdapter(adapter);

                }

                @Override
                public void onCancelled(@NonNull DatabaseError error) {
                    Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

                }
            });
    }

    private void convoRecycler() {

        reference.child("Convocation").addValueEventListener(new ValueEventListener() {
            List<String> imageList = new ArrayList<>();
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                for (DataSnapshot snapshot1: snapshot.getChildren()){
                    String data = (String)snapshot1.getValue();
                    imageList.add(data);
                }

                adapter = new GalleryAdapter(getContext(),imageList);
                convoRecycler.setLayoutManager(new GridLayoutManager(getContext(),3));
                convoRecycler.setAdapter(adapter);

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), "Something Went Wrong!", Toast.LENGTH_SHORT).show();

            }
        });

    }
}

