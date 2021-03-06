package org.techtown.tmaptest;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.skt.Tmap.TMapPoint;

import java.util.ArrayList;
import java.util.Objects;

public class FragmentRoom_1 extends Fragment implements onBackPressedListener {

    private View view;
    private TextView cancleBtn;
    ListView roomInfo_content;
    private TextView naviBtn;
    public FragmentRoom_1(){

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.activity_lecturerooom1,container,false);

        roomInfo_content=view.findViewById(R.id.roominfo_content);
        RoomInfoAdapter adapter= new RoomInfoAdapter();
        adapter.addItem(new RoomInfoItem("3F", R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent));
        adapter.addItem(new RoomInfoItem("4F", R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent));
        adapter.addItem(new RoomInfoItem("5F", R.drawable.printer, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent));
        adapter.addItem(new RoomInfoItem("6F", R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent));
        adapter.addItem(new RoomInfoItem("7F", R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent, R.drawable.transparent));
        roomInfo_content.setAdapter(adapter);


        // ???????????? ??????.
        roomInfo_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // ??? ???????????? ?????? ??? ??? ??? ??????.
                String floor = ((RoomInfoItem)adapter.getItem(position)).getFloor();

                Bundle bundle = new Bundle();
                bundle.putString("floor",floor);
                bundle.putInt("lect",1);

                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                RoomInfoPop roomInfoPop = new RoomInfoPop();
                roomInfoPop.setArguments(bundle);
                transaction.replace(R.id.tmap,roomInfoPop);
                transaction.commit();
            }
        });

        //?????? ?????? ?????????
        cancleBtn = view.findViewById(R.id.cancelBtn);
        cancleBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction transaction = getActivity().getSupportFragmentManager().beginTransaction();
                FragmentLec fragmentLec= new FragmentLec();
                transaction.replace(R.id.tmap,fragmentLec);
                transaction.commit();
            }
        });

        //????????? ??????
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
        goToMain();
    }

    //??????????????? ??????
    private void goToMain(){
        FragmentManager fragmentManager = requireActivity().getSupportFragmentManager();
        fragmentManager.beginTransaction().remove(FragmentRoom_1.this).commit();
        fragmentManager.popBackStack();
    }
    //???????????? ????????? ??????.
    class RoomInfoAdapter extends BaseAdapter {
        ArrayList<RoomInfoItem> items = new ArrayList<RoomInfoItem>();

        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(RoomInfoItem item) {
            items.add(item);
        }

        @Override
        public Object getItem(int position) {
            return items.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            RoomInfoItemView roomInfoItemView = null;
            if (convertView == null) {
                roomInfoItemView = new RoomInfoItemView(getActivity().getApplicationContext() );
            } else {
                roomInfoItemView = (RoomInfoItemView) convertView;
            }
            RoomInfoItem item = items.get(position);
            roomInfoItemView.setFloor(item.getFloor());
            roomInfoItemView.setFloorPic1(item.getFloorPic1());
            roomInfoItemView.setFloorPic2(item.getFloorPic2());
            roomInfoItemView.setFloorPic3(item.getFloorPic3());
            roomInfoItemView.setFloorPic4(item.getFloorPic4());
            roomInfoItemView.setFloorPic5(item.getFloorPic5());
            return roomInfoItemView;
        }
    }
}
