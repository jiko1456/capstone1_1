package org.techtown.tmaptest;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import java.util.ArrayList;

public class ProInfo7_9 extends Fragment implements onBackPressedListener {

    private View view;
    private static final String TAG_NAME = "name";
    private static final String TAG_PHONE = "call";
    private static final String TAG_MAIL = "mail";
    ListView proInfo_content;
    private TextView major;

    public ProInfo7_9(){

    }


    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_pro_info,container,false);


        proInfo_content=view.findViewById(R.id.proinfo_content);
        ProInfoAdapter adapter= new ProInfoAdapter();
        adapter.addItem(new ProInfoItem("이준성", "031-249-9813", "jslee1@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("이선표", "031-249-9812", "splee@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이신표", "031-249-9814","shinpyo@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김형민", "031-249-9815","pius@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김화수", "031-249-9806", "hskim94@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("이정우", "031-249-9819","j.w.lee@kyonggi.ac.kr"));
        adapter.addItem(new ProInfoItem("김용호", "031-249-1370","at1955@kgu.ac.kr"));
        adapter.addItem(new ProInfoItem("양시영", "031-249-1352","syyang63@kyonggi.ac.kr"));
        proInfo_content.setAdapter(adapter);




        major=view.findViewById(R.id.major);
        major.setText("기계시스템공학");



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
        fragmentManager.beginTransaction().remove(ProInfo7_9.this).commit();
        fragmentManager.popBackStack();
    }
    //리스트뷰 어댑터 구현
    class ProInfoAdapter extends BaseAdapter {
        ArrayList<ProInfoItem> items = new ArrayList<ProInfoItem>();

        public int getCount(){
            return items.size();
        }
        public void addItem(ProInfoItem item){
            items.add(item);
        }
        public Object getItem(int position){
            return items.get(position);
        }
        public long getItemId(int position){
            return position;
        }
        public View getView(int position, View convertView, ViewGroup parent){
            ProInfoItemView proInfoItemView=null;
            if(convertView == null){
                proInfoItemView=new ProInfoItemView(getActivity().getApplicationContext() );
            } else {
                proInfoItemView=(ProInfoItemView) convertView;
            }
            ProInfoItem item= items.get(position);
            proInfoItemView.setName(item.getName());
            proInfoItemView.setPhone(item.getPhone());
            proInfoItemView.setEmail(item.getEmail());
            return proInfoItemView;
        }
    }
}
