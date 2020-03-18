package com.example.busappver13.ui.home;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.busappver13.R;
import com.example.busappver13.ui.bus.BusItems;

import java.util.ArrayList;

public class HomeViewModelAdapter extends ArrayAdapter<BusItems> {

    private Context context;
    private ArrayList<BusItems> list;
    private BusItems bi;
    private int resource;

    public HomeViewModelAdapter(Context context, int resource, ArrayList<BusItems> objects){
        super(context,resource,objects);
        list=objects;
        this.context=context;
        this.resource=resource;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater linf=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        convertView=linf.inflate(resource,null);

        bi=list.get(position);

        TextView text_totalCount=(TextView)convertView.findViewById(R.id.text_totalCount);
        TextView text_nodeNm=(TextView)convertView.findViewById(R.id.text_nodeNm);
        TextView text_vehicleNo=(TextView)convertView.findViewById(R.id.text_vehicleNo);

        if(text_totalCount!=null){
            text_totalCount.setText("총 버스 개수: " + bi.getTotalCount());
        }
        if(text_nodeNm!=null){
            text_nodeNm.setText("정류소: " + bi.getNodeNm());
        }
        if(text_vehicleNo!=null){
            text_vehicleNo.setText("차량 번호: " + bi.getVehicleNo());
        }

        return convertView;
    }
}
