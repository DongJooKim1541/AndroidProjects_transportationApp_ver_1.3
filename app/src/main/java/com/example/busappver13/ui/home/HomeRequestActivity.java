package com.example.busappver13.ui.home;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.busappver13.R;
import com.example.busappver13.ui.bus.BusItems;

import java.util.ArrayList;

public class HomeRequestActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    private ArrayList<BusItems> list;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requesthome);

        Intent intent=getIntent();


        list=intent.getParcelableArrayListExtra("lists");

        homeFragment=new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.requestHome,homeFragment).commit();

        Bundle bundle=new Bundle();

        bundle.putParcelableArrayList("lists",list);

        homeFragment.setArguments(bundle);
    }
}
