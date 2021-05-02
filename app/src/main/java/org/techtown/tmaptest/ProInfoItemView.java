package org.techtown.tmaptest;
import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;

import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class ProInfoItemView extends LinearLayout {

    TextView name, phone, email;

    public ProInfoItemView(Context context){
        super(context);
        init(context); }

    public ProInfoItemView(Context context, @Nullable AttributeSet attrs){
        super(context,attrs);
    }
    private void init(Context context) {
        LayoutInflater inflater=(LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        inflater.inflate(R.layout.proinfo_item_list,this,true);

        name=(TextView) findViewById(R.id.name);
        phone=(TextView) findViewById(R.id.phone);
        email=(TextView) findViewById(R.id.email);

    }
    public void setName(String nameN){
        name.setText(nameN);
    }
    public void setPhone(String phoneN){
        phone.setText(phoneN);
    }
    public void setEmail(String emailN){
        email.setText(emailN);
    }
}
