package com.example.vims_user.ui.home;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.vims_user.R;
import com.example.vims_user.ui.department.AboutVimrActivity;
import com.example.vims_user.ui.department.AboutVimsActivity;
import com.example.vims_user.ui.department.AboutVitsActivity;

import java.util.ArrayList;


public class HomeFragment extends Fragment  {

    private ImageView map;
    TextView about_vits;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable)
// imageList.add(new SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider =view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);



        map = view.findViewById(R.id.map);
        map.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMap();
            }
        });



        TextView about_vits = view.findViewById(R.id.about_vits);
        about_vits.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment vits = new AboutVitsActivity();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace R.id.container with the ID of the container where you want to replace the fragment
                fm.replace(R.id.container, vits).commit();
            }
        });


        TextView about_vimr = view.findViewById(R.id.about_vimr);
        about_vimr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment vimr = new AboutVimrActivity();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace R.id.container with the ID of the container where you want to replace the fragment
                fm.replace(R.id.container, vimr).commit();
            }
        });


        TextView about_vims = view.findViewById(R.id.about_vims);
        about_vims.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Fragment vims = new AboutVimsActivity();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                // Replace R.id.container with the ID of the container where you want to replace the fragment
                fm.replace(R.id.container, vims).commit();
            }
        });






        return view;





    }

    private void openMap() {

        Uri uri = Uri.parse("geo:0, 0?q= VITS Satna");

        Intent intent = new Intent(Intent.ACTION_VIEW,uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }
}