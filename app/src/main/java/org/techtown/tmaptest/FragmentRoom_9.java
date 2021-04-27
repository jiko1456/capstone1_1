package org.techtown.tmaptest;

import android.os.Bundle;
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

public class FragmentRoom_9 extends Fragment implements onBackPressedListener {

    private View view;
    private TextView cancleBtn;
    ListView roomInfo_content;
    private TextView naviBtn;
    public FragmentRoom_9(){

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


        // 리스트뷰 클릭.
        roomInfo_content.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                // 각 리스트에 대한 층 수 값 저장.
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

        //취소 버튼 이벤트
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

        //길찾기 버튼
        naviBtn= view.findViewById(R.id.naviBtn);
        naviBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BusProvider.getInstance().post(new BusEvent(8));
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
        fragmentManager.beginTransaction().remove(FragmentRoom_9.this).commit();
        fragmentManager.popBackStack();
    }
    //리스트뷰 어댑터 구현.
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
