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

import java.util.Objects;

public class FragmentLec extends Fragment implements org.techtown.tmaptest.onBackPressedListener {
    public FragmentLec(){
    }
    private View view;
   // private ImageButton btn_lec;
    private Button button01,button02,button03,button04,button05,button06,button07,button08,button09,button10;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_lecturerooom,container,false);
        //btn_lec = view.findViewById(R.id.btn_lec);

        //강의동 이름 클릭
        button01 = view.findViewById(R.id.button01);
        button01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_1 room1= new FragmentRoom_1();
                transaction.replace(R.id.tmap,room1);
                transaction.commit();
            }
        });

        button02 = view.findViewById(R.id.button02);
        button02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_2 room2= new FragmentRoom_2();
                transaction.replace(R.id.tmap,room2);
                transaction.commit();
            }
        });

        button03 = view.findViewById(R.id.button03);
        button03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_3 room3= new FragmentRoom_3();
                transaction.replace(R.id.tmap,room3);
                transaction.commit();
            }
        });

        button04 = view.findViewById(R.id.button04);
        button04.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_4 room4= new FragmentRoom_4();
                transaction.replace(R.id.tmap,room4);
                transaction.commit();
            }
        });

        button05 = view.findViewById(R.id.button05);
        button05.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_5 room5= new FragmentRoom_5();
                transaction.replace(R.id.tmap,room5);
                transaction.commit();
            }
        });

        button06 = view.findViewById(R.id.button06);
        button06.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_6 room6= new FragmentRoom_6();
                transaction.replace(R.id.tmap,room6);
                transaction.commit();
            }
        });

        button07 = view.findViewById(R.id.button07);
        button07.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_7 room7= new FragmentRoom_7();
                transaction.replace(R.id.tmap,room7);
                transaction.commit();
            }
        });

        button08 = view.findViewById(R.id.button08);
        button08.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_8 room8= new FragmentRoom_8();
                transaction.replace(R.id.tmap,room8);
                transaction.commit();
            }
        });

        button09 = view.findViewById(R.id.button09);
        button09.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_9 room9= new FragmentRoom_9();
                transaction.replace(R.id.tmap,room9);
                transaction.commit();
            }
        });

        button10 = view.findViewById(R.id.button10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentRoom_10 room10= new FragmentRoom_10();
                transaction.replace(R.id.tmap,room10);
                transaction.commit();
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
        fragmentManager.beginTransaction().remove(org.techtown.tmaptest.FragmentLec.this).commit();
        fragmentManager.popBackStack();
    }
}
