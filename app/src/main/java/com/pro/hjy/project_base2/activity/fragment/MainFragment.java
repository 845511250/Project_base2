package com.pro.hjy.project_base2.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pro.hjy.project_base2.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hjy on 16/6/4.
 */
public class MainFragment extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =inflater.inflate(R.layout.fragment_main,null);
        ButterKnife.bind(this,view);
        return view;
    }

    @OnClick(R.id.btn_action1)
    public void action1()
    {
        open(new NetFragment());
    }
    @OnClick(R.id.btn_action2)
    public void action12()
    {
//        open();
    }

    /**
     * 开启新的Fragment
     */
    private void open(android.support.v4.app.Fragment fragment) {
        final String tag = fragment.getClass().toString();
        getActivity().getSupportFragmentManager()
                .beginTransaction()
                .addToBackStack(tag)
                .replace(R.id.main_content, fragment, tag)
                .commit();
    }
}
