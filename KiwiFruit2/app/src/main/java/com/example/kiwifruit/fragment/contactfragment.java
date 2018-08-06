package com.example.kiwifruit.fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.kiwifruit.R;

public class contactfragment extends Fragment {

    View view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_contactfragment, container, false);
        for(int i=R.id.tel1;i<=R.id.tel4;i++) {
            final TextView telview;
            telview = view.findViewById(i);
            telview.getPaint().setFlags(Paint. UNDERLINE_TEXT_FLAG );
            telview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    callPhone(telview.getText().toString());
                }
            });
        }
        return view;
    }

    public void callPhone(String phoneNum) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        Uri data = Uri.parse("tel:" + phoneNum);
        intent.setData(data);
        startActivity(intent);
    }


}