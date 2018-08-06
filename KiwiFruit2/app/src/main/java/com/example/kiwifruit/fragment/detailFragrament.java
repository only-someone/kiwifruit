package com.example.kiwifruit.fragment;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kiwifruit.Model.detail;
import com.example.kiwifruit.R;

import java.util.ArrayList;
import java.util.List;


public class detailFragrament extends Fragment {
    private View view;
    private ImageView detail_image;
    private TextView detail_introduce;
    private TextView detail_title;
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
        detail_image.setImageResource(thisdetail.getdetail_image());
        detail_introduce.setText(thisdetail.getdetailintroduce());
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
