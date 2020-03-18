package com.example.busappver13.ui.home;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.busappver13.R;
import com.example.busappver13.ui.bus.BusItems;

import java.util.ArrayList;


public class HomeFragment extends Fragment {

    private ListView totalListView;
    private String totalCount,nodeNm,vehicleNo;
    private ArrayList<BusItems> list;
    private BusItems bi;
    private HomeViewModelAdapter hAdapter;
    private boolean isListFilled=false;


    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_home, container, false);

        //객체 검색
        totalListView=(ListView)root.findViewById(R.id.totalListView);

        //리스트뷰의 오버스크롤 제거
        totalListView.setOverScrollMode(View.OVER_SCROLL_NEVER);

        list = new ArrayList<BusItems>();


        hAdapter=null;

        new HomeAsyncTask().execute();



        return root;
    }

    public ArrayList<BusItems> requestBundle(ArrayList<BusItems> busItems){
        Bundle b=getArguments();
        if(b!=null){
            totalCount=b.getString("totalCount");
            nodeNm=b.getString("nodeNm");
            vehicleNo=b.getString("vehicleNo");

            bi=new BusItems();
            bi.setTotalCount(totalCount);
            bi.setNodeNm(nodeNm);
            bi.setVehicleNo(vehicleNo);

            if(bi.getTotalCount()!=null && bi.getNodeNm()!=null && bi.getVehicleNo()!=null){
                isListFilled=true;
            }
            android.util.Log.d("KDJ","---------------BR에서 데이터 넘겨받기--------------- ");
            android.util.Log.d("KDJ","totalcount: "+totalCount);
            android.util.Log.d("KDJ","nodeNm: "+nodeNm);
            android.util.Log.d("KDJ","vehicleNo: "+vehicleNo);
            busItems.add(bi);


        }
        return busItems;
    }


    class HomeAsyncTask extends AsyncTask<String, String, ArrayList<BusItems>> {
        @Override
        protected ArrayList<BusItems> doInBackground(String... strings) {
            return requestBundle(list);
        }

        @Override
        protected void onPostExecute(ArrayList<BusItems> BusItems) {
            super.onPostExecute(BusItems);

            if (hAdapter == null) {
                hAdapter = new HomeViewModelAdapter(getActivity(),R.layout.fragment_home, BusItems);

                //리스트 뷰에 스크롤 리스너 등록
                //totalListView.setOnScrollListener(scrollListener);

                //리스트 뷰에 adapter 세팅
                totalListView.setAdapter(hAdapter);

                //리스트뷰의 변경사항 갱신
                hAdapter.notifyDataSetChanged();
                android.util.Log.d("KDJ","---------------변경사항 갱신--------------- ");

                //Listnotify();
            }
        }
    }

    private void Listnotify(){
        if(isListFilled==true){
            isListFilled=false;
            android.util.Log.d("KDJ","---------------데이터 유지 시작--------------- ");
            Intent i=new Intent(getActivity(), HomeRequestActivity.class);

            i.putParcelableArrayListExtra("lists",list);
            startActivity(i);

            //setFlag 메소드를 이용하여 지정한다
            i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP);

            //Intent.FLAG_ACTIVITY_CLEAR_TOP
            // - Activity 호출 스택에 호출하려는 Activity의 인스턴스가 이미 존재하고 있다면 가장 위에로 가져온다
            //   가져올 당시 스택 위에 있는 Activity들은 모두 종료시키며 가져온다.

            //Intent.FLAG_ACTIVITY_SINGLE_TOP
            // - Activity를 호출할 경우 호출된 Activity가 현재 최상단에 존재하고 있다면 새로운 인스턴스를 생성하지 않는다.
            android.util.Log.d("KDJ","---------------데이터 보냄--------------- ");
            list=requestLists();
            android.util.Log.d("KDJ","---------------데이터 유지 완료--------------- ");
        }
    }

    private ArrayList<BusItems> requestLists(){
        Bundle bundle=getArguments();
        ArrayList<BusItems> busItems=new ArrayList<BusItems>();
        if(bundle!=null){
            android.util.Log.d("KDJ","---------------HR에서 데이터 넘겨받기--------------- ");
            busItems=bundle.getParcelableArrayList("lists");
        }

        return busItems;
    }
}