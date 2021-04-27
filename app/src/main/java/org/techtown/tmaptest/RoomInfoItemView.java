package org.techtown.tmaptest;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class RoomInfoItemView extends LinearLayout {

    TextView floor;
    ImageView floorPic1, floorPic2, floorPic3, floorPic4, floorPic5;

    public RoomInfoItemView(Context context) {
        super(context);
        init(context);
    }

    public RoomInfoItemView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    private void init(Context context) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.roominfo_item_list,this, true);

        floor = (TextView) findViewById(R.id.floor);
        floorPic1 = (ImageView) findViewById(R.id.floorPic1);
        floorPic2 = (ImageView) findViewById(R.id.floorPic2);
        floorPic3 = (ImageView) findViewById(R.id.floorPic3);
        floorPic4 = (ImageView) findViewById(R.id.floorPic4);
        floorPic5 = (ImageView) findViewById(R.id.floorPic5);
    }

    public void setFloor(String floorN) {
        floor.setText(floorN);
    }
    public void setFloorPic1(int floorPic1N) {
        floorPic1.setImageResource(floorPic1N);
    }
    public void setFloorPic2(int floorPic2N) {
        floorPic2.setImageResource(floorPic2N);
    }
    public void setFloorPic3(int floorPic3N) {
        floorPic3.setImageResource(floorPic3N);
    }
    public void setFloorPic4(int floorPic4N) {
        floorPic4.setImageResource(floorPic4N);
    }
    public void setFloorPic5(int floorPic5N) {
        floorPic5.setImageResource(floorPic5N);
    }
}
