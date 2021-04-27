package org.techtown.tmaptest;

public class RoomInfoItem {
    String floor;
    int floorPic1, floorPic2,floorPic3, floorPic4, floorPic5;

    public RoomInfoItem(String floor, int floorPic1, int floorPic2, int floorPic3, int floorPic4, int floorPic5) {
        this.floor = floor;
        this.floorPic1 = floorPic1;
        this.floorPic2 = floorPic2;
        this.floorPic3 = floorPic3;
        this.floorPic4 = floorPic4;
        this.floorPic5 = floorPic5;
    }

    // 층 수 세팅.
    public String getFloor() {
        return floor;
    }
    public void setFloor(String floor) {
        this.floor = floor;
    }

    // 층 수 별로 미리보기 아이콘 세팅.
    public int getFloorPic1() {
        return floorPic1;
    }
    public int getFloorPic2() {
        return floorPic2;
    }
    public int getFloorPic3() {
        return floorPic3;
    }
    public int getFloorPic4() {
        return floorPic4;
    }
    public int getFloorPic5() {
        return  floorPic5;
    }

    @Override
    public String toString() {
        return "RoomInfoItem{" +
                "floor='" + floor + "\"" + "}";
    }
}
