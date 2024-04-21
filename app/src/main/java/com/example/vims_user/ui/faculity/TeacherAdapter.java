package com.example.vims_user.ui.faculity;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.vims_user.R;

import java.util.List;

public class   TeacherAdapter extends RecyclerView.Adapter<TeacherAdapter.TeacherViewHolder> {

    private List<TeacherData> teacherList;
    private Context context;


    public TeacherAdapter(List<TeacherData> teacherList,Context context) {
        this.teacherList = teacherList;
        this.context = context;
    }

    @NonNull
    @Override
    public TeacherViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.faculity_item_layout, parent, false);
        return new TeacherViewHolder(view);
    }



    @Override
    public void onBindViewHolder(@NonNull TeacherViewHolder holder, int position) {
        TeacherData item = teacherList.get(position);
        holder.name.setText(item.getName());
        holder.email.setText(item.getEmail());
        holder.post.setText(item.getPost());




        try {

                Glide.with(context).load(item.getImage()).placeholder(R.drawable.profile).into(holder.imageView);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


    }









    @Override
    public int getItemCount() {
        return teacherList.size();
    }

    public class TeacherViewHolder extends RecyclerView.ViewHolder {

        private TextView name,email,post;
        private ImageView imageView;
        private TextView teacherSubjectTextView;

        public TeacherViewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.teacherName);
            email = itemView.findViewById(R.id.teacherEmail);
            post = itemView.findViewById(R.id.teacherPost);
            imageView = itemView.findViewById(R.id.teacherImage);
        }


    }
}

