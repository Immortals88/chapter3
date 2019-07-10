package com.example.chapter3.homework;


import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class PlaceholderFragment extends Fragment {

    public View ret,load;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ret = inflater.inflate(R.layout.fragment_placeholder, container, false);
        load=ret.findViewById(R.id.animation_load);
        // TODO ex3-3: 修改 fragment_placeholder，添加 loading 控件和列表视图控件
        return ret;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        getView().postDelayed(new Runnable() {
            @Override
            public void run() {
                ObjectAnimator alpha=ObjectAnimator.ofFloat(load,"alpha",1,0.0f);
                alpha.setDuration(1000);


                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.playTogether(alpha);
                animatorSet.start();
                // 这里会在 5s 后执行
                // TODO ex3-4：实现动画，将 lottie 控件淡出，列表数据淡入
            }
        }, 5000);
    }
}
