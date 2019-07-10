package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class PlaceholderFragment extends Fragment {

    public View ret,load;
    public RecyclerView mRecyclerView;
    private myAdapter myAdapter1;
    public static final String[] Cars={"Benz","Audio","BMW","Tesla","Lamborghini","chevrolet","Volkswagen","TOYOTA"};
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        ret = inflater.inflate(R.layout.fragment_placeholder, container, false);
        load=ret.findViewById(R.id.animation_load);
        mRecyclerView=ret.findViewById(R.id.rl_list);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        mRecyclerView.setVisibility(View.INVISIBLE);
        myAdapter1 = new myAdapter();
        mRecyclerView.setAdapter(myAdapter1);
        List<Data> list = new ArrayList<>();
        for(int i = 0; i < Cars.length; ++ i) {
            Data data = new Data(Cars[i]);
            list.add(data);
        }
        myAdapter1.setData(list);
        myAdapter1.notifyDataSetChanged();
        myAdapter1.setOnItemClickListener (new myAdapter.OnItemClickListener (){
            @Override
            public void onItemClickListener(View view, int position) {

                Toast.makeText(null, "no."+position + " clicked", Toast.LENGTH_SHORT).show();
            }
        });
        return ret;}

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setVisibility(View.VISIBLE);
                ObjectAnimator alpha=ObjectAnimator.ofFloat(load,"alpha",1,0.0f);
                alpha.setDuration(1000);
                ObjectAnimator alpha2=ObjectAnimator.ofFloat(mRecyclerView,"alpha",0.0f,1f);
                alpha2.setDuration(1000);

                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(alpha,alpha2);
                animatorSet.start();

                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
