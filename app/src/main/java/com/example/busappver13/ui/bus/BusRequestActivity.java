package com.example.busappver13.ui.bus;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.busappver13.R;
import com.example.busappver13.ui.home.HomeFragment;

public class BusRequestActivity extends AppCompatActivity {
    HomeFragment homeFragment;
    private String totalcount,nodeNm,vehicleNo;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_requestbus);

        Intent intent=getIntent();
        totalcount=intent.getStringExtra("totalCount");
        nodeNm=intent.getStringExtra("nodeNm");
        vehicleNo=intent.getStringExtra("vehicleNo");

        homeFragment=new HomeFragment();

        getSupportFragmentManager().beginTransaction().replace(R.id.requestBus,homeFragment).commit();

        Bundle bundle=new Bundle();

        bundle.putString("totalCount",totalcount);
        bundle.putString("nodeNm",nodeNm);
        bundle.putString("vehicleNo",vehicleNo);

        homeFragment.setArguments(bundle);

    }
}
