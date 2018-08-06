package com.example.kiwifruit.fragment;

import android.app.Dialog;
import android.content.Context;
import android.net.Uri;
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
import com.example.kiwifruit.Model.detail;
import com.example.kiwifruit.R;

import java.util.ArrayList;
import java.util.List;


public class detailFragrament extends Fragment {
    private View view;
    private ImageView detail_image;
    private TextView detail_introduce;
    private TextView detail_title;
    Dialog dia;
    private List<detail> detaillist = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initdetail();

        view=inflater.inflate(R.layout.fragment_detail_fragrament, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        detail_image=view.findViewById(R.id.detail_image);
        if (detail_image==null)
            Log.d("s", "onCreateView: ");
        detail_introduce=view.findViewById(R.id.detail_introduce);
        detail_title=view.findViewById(R.id.detail_title);

        if(toolbar==null)
            Log.d("noe", "onCreateView: ");
        Log.d("noe", "notnull: ");
        String current_title=toolbar.getTitle().toString();
        detail thisdetail=finddetail(current_title);
        Log.d("no", thisdetail.getdetailname());
        Log.d("no", thisdetail.getdetailintroduce());

        detail_title.setText(thisdetail.getdetailname());
        Glide.with(getContext()).load(thisdetail.getdetail_image()).into(detail_image);
        detail_introduce.setText(thisdetail.getdetailintroduce());
        detail_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dia.show();
            }
        });

        dia = new Dialog(getContext(), R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.activity_start_dialog);
        ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
        imageView.setBackgroundResource(thisdetail.getdetail_image());
        //选择true的话点击其他地方可以使dialog消失，为false的话不会消失
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

    public detail finddetail(String string)
    {
        int i;
        for(i=0;i<=detaillist.size()-1;i++) {
            if (detaillist.get(i).getdetailname().equals(string))
                break;
        }
        Log.d("noe", "find: "+i);
        return detaillist.get(i);
    }

    public void initdetail()
    {
        detaillist.clear();
        detail newdetail=new detail("合作社社员证图片","介绍",R.mipmap.denification);
        detaillist.add(newdetail);
        newdetail=new detail("合作社购销合同","介绍",R.mipmap.office2);
        detaillist.add(newdetail);
        newdetail=new detail("合作社办公图片","介绍",R.mipmap.office1);//可能以后存列表
        detaillist.add(newdetail);
        newdetail=new detail("合作社种植图片","介绍",R.mipmap.people1);
        detaillist.add(newdetail);
    }

}
