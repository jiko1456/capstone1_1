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
import androidx.fragment.app.FragmentTransaction;

public class ProInfo7 extends Fragment implements onBackPressedListener {
    private View view;
    private Button button1, button2, button3,button4,button5,button6,button7,button8,button9,button10;

    public ProInfo7() {
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro7, container, false);

        //과 클릭
        button1 = view.findViewById(R.id.pro07_01);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_1 pro07_01 = new ProInfo7_1();
                transaction.replace(R.id.tmap, pro07_01);
                transaction.commit();
            }
        });
        button2 = view.findViewById(R.id.pro07_02);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_2 pro07_02 = new ProInfo7_2();
                transaction.replace(R.id.tmap, pro07_02);
                transaction.commit();
            }
        });
        button3 = view.findViewById(R.id.pro07_03);
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_3 pro07_03 = new ProInfo7_3();
                transaction.replace(R.id.tmap, pro07_03);
                transaction.commit();
            }
        });
        button4 = view.findViewById(R.id.pro07_04);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_4 pro07_04 = new ProInfo7_4();
                transaction.replace(R.id.tmap, pro07_04);
                transaction.commit();
            }
        });
        button5 = view.findViewById(R.id.pro07_05);
        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_5 pro07_05 = new ProInfo7_5();
                transaction.replace(R.id.tmap, pro07_05);
                transaction.commit();
            }
        });
        button6 = view.findViewById(R.id.pro07_06);
        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_6 pro07_06 = new ProInfo7_6();
                transaction.replace(R.id.tmap, pro07_06);
                transaction.commit();
            }
        });
        button7 = view.findViewById(R.id.pro07_07);
        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_7 pro07_07 = new ProInfo7_7();
                transaction.replace(R.id.tmap, pro07_07);
                transaction.commit();
            }
        });
        button8 = view.findViewById(R.id.pro07_08);
        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_8 pro07_08 = new ProInfo7_8();
                transaction.replace(R.id.tmap, pro07_08);
                transaction.commit();
            }
        });
        button9 = view.findViewById(R.id.pro07_09);
        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_9 pro07_09 = new ProInfo7_9();
                transaction.replace(R.id.tmap, pro07_09);
                transaction.commit();
            }
        });
        button10 = view.findViewById(R.id.pro07_10);
        button10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                ProInfo7_10 pro07_10 = new ProInfo7_10();
                transaction.replace(R.id.tmap, pro07_10);
                transaction.commit();
            }
        });
        return view;
    }


    public void onBackPressed() {
        goToMain();
    }

    //프래그먼트 종료
    private void goToMain() {
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProInfo7.this).commit();
        fragmentManager.popBackStack();
    }
}





