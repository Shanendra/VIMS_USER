package com.example.vims_user.ui.faculity;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.vims_user.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

public class FaculityFragment extends Fragment {

    private RecyclerView BCADepartment, BCOMDepartment, BSCDepartment;
    private LinearLayout BCANodata, BCOMNodata, BSCNodata;
    private DatabaseReference databaseReference, dbRef;
    private StorageReference storageReference;
    private TeacherAdapter adapter1, adapter2, adapter3; // Separate adapters for each department
    private List<TeacherData> list1, list2, list3;



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_faculity, container, false);
        BCANodata = view.findViewById(R.id.BCANodata);
        BCOMNodata =view.findViewById(R.id.BCOMNodata);
        BSCNodata = view.findViewById(R.id.BSCNodata);

        BCADepartment = view.findViewById(R.id.BCADepartment);
        BCOMDepartment =view.findViewById(R.id.BCOMDepartment);
        BSCDepartment =view.findViewById(R.id.BSCDepartment);

        // Firebase Initialization
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Faculity");

        // Set up RecyclerViews and fetch data for each department
        setUpRecyclerView(BCADepartment, "BCA");
        setUpRecyclerView(BCOMDepartment, "BCOM");
        setUpRecyclerView(BSCDepartment, "BSC");

         return view;
    }

    // Method to set up RecyclerView for a department and fetch data
    private void setUpRecyclerView(RecyclerView recyclerView, String department) {
        dbRef = databaseReference.child(department);
        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                List<TeacherData> dataList = new ArrayList<>(); // Initialize list for each department

                if (!snapshot.exists()) {
                    // Show no data layout if no data exists for the department
                    showNoDataLayout(recyclerView, department);
                } else {
                    // Iterate through dataSnapshot and add each faculty member to the list
                    for (DataSnapshot dataSnapshot : snapshot.getChildren()) {
                        TeacherData data = dataSnapshot.getValue(TeacherData.class);
                        dataList.add(data);
                    }
                    // Set up RecyclerView and adapter with the fetched data
                    setUpRecyclerViewWithData(recyclerView, dataList);
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    // Method to show no data layout and hide RecyclerView for a department
    private void showNoDataLayout(RecyclerView recyclerView, String department) {
        switch (department) {
            case "BCA":
                BCANodata.setVisibility(View.VISIBLE);
                break;
            case "BCOM":
                BCOMNodata.setVisibility(View.VISIBLE);
                break;
            case "BSC":
                BSCNodata.setVisibility(View.VISIBLE);
                break;
        }
        recyclerView.setVisibility(View.GONE);
    }



    private void setUpRecyclerViewWithData(RecyclerView recyclerView, List<TeacherData> dataList) {
        if (recyclerView.getId() == R.id.BCADepartment) {
            adapter1 = new TeacherAdapter(dataList, getContext());
            BCADepartment.setLayoutManager(new LinearLayoutManager(getContext()));
            BCADepartment.setAdapter(adapter1);
            BCANodata.setVisibility(dataList.isEmpty() ? View.VISIBLE : View.GONE);
        } else if (recyclerView.getId() == R.id.BCOMDepartment) {
            adapter2 = new TeacherAdapter(dataList, (getContext()));
            BCOMDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
            BCOMDepartment.setAdapter(adapter2);
            BCOMNodata.setVisibility(dataList.isEmpty() ? View.VISIBLE : View.GONE);
        } else if (recyclerView.getId() == R.id.BSCDepartment) {
            adapter3 = new TeacherAdapter(dataList, (getContext()));
            BSCDepartment.setLayoutManager(new LinearLayoutManager(getContext()));
            BSCDepartment.setAdapter(adapter3);
            BSCNodata.setVisibility(dataList.isEmpty() ? View.VISIBLE : View.GONE);
        }
        recyclerView.setVisibility(dataList.isEmpty() ? View.GONE : View.VISIBLE);
    }


}
