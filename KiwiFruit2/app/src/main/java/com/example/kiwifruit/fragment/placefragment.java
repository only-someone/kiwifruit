package com.example.kiwifruit.fragment;


import android.app.Dialog;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.kiwifruit.Model.product;
import com.example.kiwifruit.R;
import com.example.kiwifruit.Model.place;
import java.util.ArrayList;
import java.util.List;


public class placefragment extends Fragment {
    private View view;
    private ImageView place_image;
    private TextView place_introduce;
    private TextView place_title;
    Dialog dia;
    private List<place> placelist = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initplace();

        view=inflater.inflate(R.layout.fragment_placefragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        place_image=view.findViewById(R.id.place_image);
        if (place_image==null)
            Log.d("s", "onCreateView: ");
        place_introduce=view.findViewById(R.id.place_introduce);
        place_title=view.findViewById(R.id.place_title);

        if(toolbar==null)
            Log.d("noe", "onCreateView: ");
        Log.d("noe", "notnull: ");
        String current_title=toolbar.getTitle().toString();
        place thisplace=findplace(current_title);
        Log.d("no", thisplace.getPlacename());
        Log.d("no", thisplace.getPlaceintroduce());

        place_title.setText(thisplace.getPlacename());

        Glide.with(getContext()).load(thisplace.getPlace_image()).into(place_image);
        place_introduce.setText(thisplace.getPlaceintroduce());
        place_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dia.show();
            }
        });

        dia = new Dialog(getContext(), R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.activity_start_dialog);
        ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
        imageView.setBackgroundResource(thisplace.getPlace_image());
        dia.setCanceledOnTouchOutside(true); // Sets whether this dialog is
        Window w = dia.getWindow();
        WindowManager.LayoutParams lp = w.getAttributes();
        lp.x = 0;
        lp.y = 40;
        dia.onWindowAttributesChanged(lp);
        imageView.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        dia.dismiss();
                    }
                });
        return view;

    }

    public place findplace(String string)
    {
        int i;
        for(i=0;i<=placelist.size()-1;i++) {
            if (placelist.get(i).getPlacename().equals(string))
                break;
        }
        Log.d("noe", "find: "+i);
        return placelist.get(i);
    }

    public void initplace()
    {
        placelist.clear();
        place newplace=new place("猕猴桃基地","介绍",R.mipmap.kiwifoundition1);
        placelist.add(newplace);
        newplace=new place("土豆基地","介绍",R.mipmap.kiwifoundation2);
        placelist.add(newplace);
        newplace=new place("土蜜蜂基地","介绍",R.mipmap.kiwifruitfoundation3);
        placelist.add(newplace);
        newplace=new place("碰柑、脐橙基地","介绍",R.mipmap.kiwifruitfoundation4);
        placelist.add(newplace);
    }


}
