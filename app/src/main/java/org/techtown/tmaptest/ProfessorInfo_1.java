package org.techtown.tmaptest;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;
import java.util.HashMap;

public class ProfessorInfo_1 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_LECTURE = "lecture";
    private static final String TAG_PHONE = "phone";
    private static final String TAG_MAIL = "mail";
    ArrayList<String[]> proList = new ArrayList<String[]>();

    //추후에 리스트뷰로 구현 예정
    private TextView cancleBtn;
    //ListView proInfo_content;
    private TextView naviBtn;
    public ProfessorInfo_1(){

    }
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro1,container,false);

        proList.add(new String[]{"이름", "강의동", "전화번호", "이메일"});
        proList.add(new String[]{"권기현", "8209", "031-249-9666", "khkwon@kgu.ac.kr"});
        proList.add(new String[]{"전준철", "8212", "031-249-9668", "jcchun@kyonggi.ac.kr"});
        proList.add(new String[]{"김인철", "8208", "031-249-9669", "kic@kyonggi.ac.kr"});
        proList.add(new String[]{"김광훈", "8210", "031-249-9679", "kwang@kyonggi.ac.kr"});
        proList.add(new String[]{"이은정", "8213", "031-249-9671", "ejlee@kyonggi.ac.kr"});
        proList.add(new String[]{"권준희", "8313", "031-249-9675", "kwonjh@kyonggi.ac.kr"});
        proList.add(new String[]{"안진호", "8314", "031-249-9674", "jhahn@kyonggi.ac.kr"});
        proList.add(new String[]{"김남기", "8312", "031-249-9662", "ngkim@kyonggi.ac.kr"});
        proList.add(new String[]{"김희열", "8211", "031-249-9607", "heeyoul.kim@kgu.ac.kr"});
        proList.add(new String[]{"이병대", "8217", "031-249-9676", "blee@kyonggi.ac.kr"});
        proList.add(new String[]{"배상원", "8309", "031-249-9677", "swbae@kyonggi.ac.kr"});
        proList.add(new String[]{"정경용", "8320", "031-249-1382", "kychung@kyonggi.ac.kr"});
        proList.add(new String[]{"김도훈", "8316", "031-249-1364", "karmy01@kyonggi.ac.kr"});
        proList.add(new String[]{"윤원현", "8109", "031-249-1306", "einstein@kgu.ac.kr"});
        proList.add(new String[]{"윤익준", "8116", "031-249-9642", "ijyoon@kyonggi.ac.kr"});

        TextView mTextView = (TextView) view.findViewById(R.id.proInfo_content);
        mTextView.setMovementMethod(new ScrollingMovementMethod());
        ArrayList<HashMap<String, String>> mArrayList = new ArrayList<>();

        for (int i = 0; i < proList.size(); i++) {
            HashMap<String, String> hashMap = new HashMap<>();

            hashMap.put(TAG_NAME, proList.get(i)[0]);
            hashMap.put(TAG_LECTURE, proList.get(i)[1]);
            hashMap.put(TAG_PHONE, proList.get(i)[2]);
            hashMap.put(TAG_MAIL, proList.get(i)[3]);

            mArrayList.add(hashMap);
        }


        for (int i = 0; i < proList.size(); i++) {

            HashMap<String, String> outputHashMap = mArrayList.get(i);
            String name = outputHashMap.get("name");
            String lecture = outputHashMap.get("lecture");
            String phone = outputHashMap.get("phone");
            String mail = outputHashMap.get("mail");

            String str = String.format(getResources()
                    .getString(R.string.textview_message), name, lecture, phone, mail);
            mTextView.append(str);
        }

        //취소 버튼 이벤트
        cancleBtn = view.findViewById(R.id.cancelBtn);
        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentProfessor fragmentpro= new FragmentProfessor();
                transaction.replace(R.id.tmap,fragmentpro);
                transaction.commit();
            }
        });

        //길찾기 버튼
        naviBtn= view.findViewById(R.id.naviBtn);
        naviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusProvider.getInstance().post(new BusEvent(0));
                goToMain();
            }
        });

        return view;
    }
    @Override
    public void onBackPressed() {
        FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
        FragmentProfessor Fpro = new FragmentProfessor();
        transaction.replace(R.id.tmap, Fpro);
        transaction.commit();
    }

    //프래그먼트 종료
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(ProfessorInfo_1.this).commit();
        fragmentManager.popBackStack();
    }

}
