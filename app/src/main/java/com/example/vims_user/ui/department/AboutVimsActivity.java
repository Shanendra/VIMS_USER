package com.example.vims_user.ui.department;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.denzcoskun.imageslider.ImageSlider;
import com.denzcoskun.imageslider.constants.ScaleTypes;
import com.denzcoskun.imageslider.models.SlideModel;
import com.example.vims_user.R;

import java.util.ArrayList;


public class AboutVimsActivity extends Fragment {









    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_about_vims, container, false);

        ArrayList<SlideModel> imageList = new ArrayList<>(); // Create image list

// imageList.add(new SlideModel("String Url" or R.drawable)
// imageList.add(new SlideModel("String Url" or R.drawable, "title") You can add title

        imageList.add(new SlideModel("https://bit.ly/2YoJ77H", "The animal population decreased by 58 percent in 42 years.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/2BteuF2", "Elephants and tigers may become extinct.",ScaleTypes.CENTER_CROP));
        imageList.add(new SlideModel("https://bit.ly/3fLJf72", "And people do that.", ScaleTypes.CENTER_CROP));

        ImageSlider imageSlider =view.findViewById(R.id.image_slider);
        imageSlider.setImageList(imageList);









        return view;





    }


}