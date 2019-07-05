package com.example.softd.yichun201907.home;


import android.app.Fragment;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.View;

import com.example.softd.yichun201907.R;
import com.example.softd.yichun201907.base.BaseFragment;
import com.example.softd.yichun201907.Adapters.DotTimeLineAdapter;
import com.example.softd.yichun201907.DB.Event;
import com.vivian.timelineitemdecoration.itemdecoration.DotItemDecoration;
import com.vivian.timelineitemdecoration.itemdecoration.SpanIndexListener;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class TimelineFragment extends BaseFragment {
    RecyclerView mRecyclerView;

    List<Event> mList = new ArrayList<>();
    DotTimeLineAdapter mAdapter;
    DotItemDecoration mItemDecoration;

    long[] times = {
            1497229200,
            1497240000,
            1497243600,
            1497247200,
            1497249000,
            1497252600
    };
    String[] events = new String[]{
            "去小北门拿快递",
            "跟同事一起聚餐",
            "写文档",
            "和产品开会",
            "整理开会内容",
            "提交代码到git上"
    };



    public TimelineFragment() {
        // Required empty public constructor
    }

    @Override
    protected int initLayout() {
        return R.layout.fragment_timeline;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {
        mRecyclerView = (RecyclerView)getContentView().findViewById(R.id.recycler_view_timeline);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mItemDecoration = new DotItemDecoration
                .Builder(this.getContext())
                .setOrientation(DotItemDecoration.VERTICAL)//if you want a horizontal item decoration,remember to set horizontal orientation to your LayoutManager
                .setItemStyle(DotItemDecoration.STYLE_DRAW)
                .setTopDistance(20)//dp
                .setItemInterVal(10)//dp
                .setItemPaddingLeft(20)//default value equals to item interval value
                .setItemPaddingRight(20)//default value equals to item interval value
                .setDotColor(Color.WHITE)
                .setDotRadius(2)//dp
                .setDotPaddingTop(18)
                .setDotInItemOrientationCenter(false)//set true if you want the dot align center
                .setLineColor(Color.RED)
                .setLineWidth(1)//dp
                .setEndText("END")
                .setTextColor(Color.WHITE)
                .setTextSize(10)//sp
                .setDotPaddingText(2)//dp.The distance between the last dot and the end text
                .setBottomDistance(40)//you can add a distance to make bottom line longer
                .create();
        mItemDecoration.setSpanIndexListener(new SpanIndexListener() {
            @Override
            public void onSpanIndexChange(View view, int spanIndex) {
                Log.i("Info","view:"+view+"  span:"+spanIndex);
                view.setBackgroundResource(spanIndex == 0 ? R.drawable.pop_left : R.drawable.pop_right);
            }
        });
        mRecyclerView.addItemDecoration(mItemDecoration);

        mList.clear();
        for (int i = 0; i < times.length; i++) {
            Event event = new Event();
            event.setTime(times[i]);
            event.setEvent(events[i]);
            mList.add(event);
        }

        mAdapter = new DotTimeLineAdapter(this.getContext(), mList);
        mRecyclerView.setAdapter(mAdapter);
    }


}
