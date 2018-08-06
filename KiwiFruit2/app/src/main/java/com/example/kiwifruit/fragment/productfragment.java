package com.example.kiwifruit.fragment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
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
import com.example.kiwifruit.Activity.MainActivity;
import com.example.kiwifruit.R;
import com.example.kiwifruit.Model.product;

import java.util.ArrayList;
import java.util.List;

public class productfragment extends Fragment {
    private View view;
    private Dialog dialog;
    private ImageView product_image;
    private TextView product_introduce;
    private TextView product_title;
    Dialog dia;
    private List<product> productList = new ArrayList<>();
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        initproduct();

        view=inflater.inflate(R.layout.fragment_productfragment, container, false);
        Toolbar toolbar = getActivity().findViewById(R.id.toolbar);
        product_image=view.findViewById(R.id.product_image);
        product_introduce=view.findViewById(R.id.product_introduce);
        product_title=view.findViewById(R.id.product_title);


        if(toolbar==null)
            Log.d("noe", "onCreateView: ");
        Log.d("noe", "notnull: ");
        String current_title=toolbar.getTitle().toString();
        Log.d("noe",current_title);
        product thisproduct=findproduct(current_title);
        Log.d("s",thisproduct.getProductname() );
        product_title.setText(thisproduct.getProductname());
        Glide.with(getContext()).load(thisproduct.getProduct_image()).into(product_image);
        //Log.d("s",thisproduct.getProduct_image());
        product_introduce.setText(thisproduct.getProductintroduce());
        Log.d("s",thisproduct.getProductintroduce());

        product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               dialog.show();
            }
        });
        product_image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dia.show();
            }
        });

        dia = new Dialog(getContext(), R.style.edit_AlertDialog_style);
        dia.setContentView(R.layout.activity_start_dialog);
        ImageView imageView = (ImageView) dia.findViewById(R.id.start_img);
        imageView.setBackgroundResource(thisproduct.getProduct_image());

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

    public product findproduct(String string)
    {
        int i;
        for(i=0;i<=productList.size()-1;i++) {
            if (productList.get(i).getProductname().equals(string))
                break;
        }
        Log.d("noe", "find: "+i);
        return productList.get(i);
    }

    public void initproduct()
    {
        productList.clear();
        product newproduct=new product("猕猴桃系列","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);
        newproduct=new product("蜂蜜系列","介绍",R.mipmap.honey1);
        productList.add(newproduct);
        newproduct=new product("茶系列","介绍",R.mipmap.tea1);
        productList.add(newproduct);
        newproduct=new product("硒土豆系列","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);
        newproduct=new product("红薯系列","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);
        newproduct=new product("花生","介绍",R.mipmap.fusheng1);
        productList.add(newproduct);
        newproduct=new product("核桃","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);
        newproduct=new product("碰柑","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);
        newproduct=new product("脐橙","介绍",R.mipmap.kiwifruit);
        productList.add(newproduct);

    }

}
