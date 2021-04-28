package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import com.skt.Tmap.TMapPoint;

import java.util.ArrayList;

//각 좌표 수동 입력
public class FragmentTimetable extends Fragment implements onBackPressedListener {
    public FragmentTimetable(){
    }
    private View view;
    // private ImageButton btn_lec;
    private Button busStop1,busStop2,busStop3,busStop4,busStop5,busStop6,btn_etc1,btn_etc2;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_timetable,container,false);
        return view;
    }
    @Override
    public void onBackPressed() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(FragmentTimetable.this).commit();
        fragmentManager.popBackStack();
    }
}
