package com.example.dynamicfragment;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import org.jetbrains.annotations.NotNull;
import org.w3c.dom.Text;

public class UserViewHolder extends RecyclerView.ViewHolder {
    private ImageView mIvImage;
    private TextView mTvText1;
    private TextView mTvText2;

    public UserViewHolder(@NonNull View itemView) {
        super(itemView);
initview(itemView);

    }

    private void initview(View itemView) {
    mIvImage =itemView.findViewById(R.id.IvImage);
    mTvText1 = itemView.findViewById(R.id.tvTitle);
    mTvText2 = itemView.findViewById(R.id.tvSubTitle);
    }
    public void setData(ResponseModel responseModel){
        Glide.with(mIvImage).load(responseModel.getImage()).into(mIvImage);
        mTvText1.setText(responseModel.getTitle());
        mTvText2.setText(responseModel.getSubTitle());

    }
}
