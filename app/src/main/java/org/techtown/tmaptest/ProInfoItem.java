package org.techtown.tmaptest;

public class ProInfoItem {
    String name, phone, email;

    public ProInfoItem(String name, String phone, String email){
        this.name=name;
        this.phone=phone;
        this.email=email;
    }
    // 이름
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name=name;
    }
    //번호
    public String getPhone(){
        return phone;
    }
    public void setPhone(String phone){
        this.phone=phone;
    }
    //이메일
    public String getEmail(){
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }


}
