package com.example.softd.yichun201907.home;


import android.app.Fragment;
import android.support.v4.view.ViewPager;

import com.example.library.SimpleOverlayAdapter;
import com.example.softd.yichun201907.R;
import com.example.softd.yichun201907.base.BaseFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class TasksFragment extends BaseFragment {
    private ViewPager vp;
    private String[] imgUrls = new String[]{"https://ss3.bdstatic.com/70cFv8Sh_Q1YnxGkpoWK1HF6hhy/it/u=1638079650,2146947483&fm=27&gp=0.jpg"
            , "https://ss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=1297505592,1789076279&fm=27&gp=0.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094815760&di=1abe539eb4691346c07dd44a6bba7383&imgtype=0&src=http%3A%2F%2Fpic.xoyo.com%2Fbbs%2F2010%2F11%2F30%2F10113010300bdf68f9f96b70e4.jpg"
            , "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3925233323,1705701801&fm=27&gp=0.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094846679&di=fb63907df03214def9e4576149ac1b8e&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2Fc9257b7638df71ad54d17de9cc92034741c86236.jpg"
            , "https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1556094860210&di=56a4eba83e1fa1fee69787b35f5b2806&imgtype=0&src=http%3A%2F%2Fi0.hdslb.com%2Fbfs%2Farticle%2F5d3129cc0cc155f696a68eec5356d9387f4c517d.jpg"};


    public TasksFragment() {
        // Required empty public constructor
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_tasks;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        vp = getContentView().findViewById(R.id.example_vp);
        SimpleOverlayAdapter adapter = new SimpleOverlayAdapter(getContext());
        adapter.setImgUrlsAndBindViewPager(vp, imgUrls, 5);
        vp.setAdapter(adapter);
        vp.setCurrentItem(100000); //伪无限循环
    }

}
