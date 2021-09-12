package com.example.dynamicfragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class FragmentA extends Fragment {
RecyclerView recyclerView;
Button mBtnMessi;
List<ResponseModel>list = new ArrayList<>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_a, container, false);
    }

    @Override
    public void onViewCreated(@NonNull  View view, @Nullable  Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initviews(view);
    }

    private void initviews(View view) {
    mBtnMessi = view.findViewById(R.id.btnGetData);
    recyclerView = view.findViewById(R.id.recyclerView);
    mBtnMessi.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            callApi();
        }

        private void callApi() {
            ApiService apiService = Network.getInstance().create(ApiService.class);
            apiService.getUser().enqueue(new Callback<List<ResponseModel>>() {
                @Override
                public void onResponse(Call<List<ResponseModel>> call, Response<List<ResponseModel>> response) {
         list = response.body();
         setRecycleview();
                }

                private void setRecycleview() {
                    Adapter adapter = new Adapter(list);
                    LinearLayoutManager manager = new LinearLayoutManager(getContext());
                    recyclerView.setLayoutManager(manager);
                    recyclerView.setAdapter(adapter);
                }

                @Override
                public void onFailure(Call<List<ResponseModel>> call, Throwable t) {

                }
            });
        }
    });
    }

}