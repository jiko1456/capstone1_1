package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.skt.Tmap.TMapPoint;

import java.util.ArrayList;
import java.util.Objects;

//각 좌표 수동 입력
public class FragmentEtc extends Fragment implements org.techtown.tmaptest.onBackPressedListener {
    public FragmentEtc(){
    }
    private View view;
    // private ImageButton btn_lec;
    private Button busStop1,busStop2,busStop3,busStop4,busStop5,busStop6,btn_etc1,btn_etc2;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_etc,container,false);
        ArrayList<TMapPoint> arrPoint = new ArrayList<>();
        arrPoint.add(0, new TMapPoint(37.2985, 127.0396));  //기숙사정류장
        arrPoint.add(1, new TMapPoint(37.3017, 127.0340));  //매표소정류장
        arrPoint.add(2, new TMapPoint(37.3012, 127.0344));  //경기탑 정류장
        arrPoint.add(3, new TMapPoint(37.2988, 127.0371));  //테니스장 정류장
        arrPoint.add(4, new TMapPoint(37.3035, 127.0340));  //9강 정류장
        arrPoint.add(5, new TMapPoint(37.3007, 127.0444));  //광교역 정류장
        arrPoint.add(6, new TMapPoint(37.3005, 127.0371));  //e스퀘어
        arrPoint.add(7, new TMapPoint(37.3011, 127.0361));  //감성코어

        //정류장
        busStop1 = view.findViewById(R.id.busStop1);
        busStop1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,0);
                goToMain();
            }
        });

        busStop2 = view.findViewById(R.id.busStop2);
        busStop2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,1);
                goToMain();
            }
        });

        busStop3 = view.findViewById(R.id.busStop3);
        busStop3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,2);
                goToMain();
            }
        });

        busStop4 = view.findViewById(R.id.busStop4);
        busStop4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,3);
                goToMain();
            }
        });

        busStop5 = view.findViewById(R.id.busStop5);
        busStop5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,4);
                goToMain();
            }
        });

        busStop6 = view.findViewById(R.id.busStop6);
        busStop6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,5);
                goToMain();
            }
        });

        //학교식당
        btn_etc1 = view.findViewById(R.id.btn_etc1);
        btn_etc1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,6);
                goToMain();
            }
        });

        btn_etc2 = view.findViewById(R.id.btn_etc2);
        btn_etc2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).getPoint(arrPoint,7);
                goToMain();
            }
        });

        return view;
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(org.techtown.tmaptest.FragmentEtc.this).commit();
        fragmentManager.popBackStack();
    }
}
