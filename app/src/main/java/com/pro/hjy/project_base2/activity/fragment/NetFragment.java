package com.pro.hjy.project_base2.activity.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.pro.hjy.project_base2.R;
import com.pro.hjy.project_base2.config.Constants;
import com.pro.hjy.project_base2.protocol.TestProtocol;
import com.pro.hjy.project_base2.utils.F;
import com.trello.rxlifecycle.components.support.RxFragment;

import java.util.HashMap;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.OnClick;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;

/**
 * Created by hjy on 16/6/4.
 */
public class NetFragment extends RxFragment {
    private TestProtocol mTestProtocol;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_nettest,null);
        ButterKnife.bind(this,view);
        return view;
    }
    @OnClick(R.id.btn_post)
    public void doPost()
    {

    }
    @OnClick(R.id.btn_get)
    public void doGet()
    {
//        http://api.haiouxs.com/v1/index?catalog_id=0&size=15&token=&id=0
        Map<String , Object> params = new HashMap<>();
        params.put("catalog_id",0);
        params.put("size",15);
        params.put("id",0);
        mTestProtocol.text_Get(Constants.HOME_PATH,params)                            //  (1)
                .compose(this.<String>bindToLifecycle())    //  (2)
                .observeOn(AndroidSchedulers.mainThread())  //  (3)
                .subscribe(new Action1<String>() {          //  (4)
                    @Override
                    public void call(String data) {         //  (5)

                        F.e(data);

                    }
                }, new Action1<Throwable>() {
                    @Override
                    public void call(Throwable throwable) { //  (6)
                    }
                });
    }

}
