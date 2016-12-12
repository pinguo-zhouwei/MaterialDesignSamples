package com.zhouwei.md.materialdesignsamples.toolbar;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.AppBarLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bigkoo.convenientbanner.ConvenientBanner;
import com.bigkoo.convenientbanner.adapter.CBPageAdapter;
import com.bigkoo.convenientbanner.adapter.CBViewHolderCreator;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.zhouwei.md.materialdesignsamples.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * 仿简书 首页效果
 * Created by zhouwei on 16/12/8.
 */

public class JanshuActivity extends AppCompatActivity {
    private ConvenientBanner mConvenientBanner;
    private RecyclerView mRecyclerView;
    private AppBarLayout mAppBarLayout;
    private View mLine;
    private String[] images = {"http://img2.imgtn.bdimg.com/it/u=3093785514,1341050958&fm=21&gp=0.jpg",
            "http://img2.3lian.com/2014/f2/37/d/40.jpg",
            "http://d.3987.com/sqmy_131219/001.jpg",
            "http://img2.3lian.com/2014/f2/37/d/39.jpg",
            "http://www.8kmm.com/UploadFiles/2012/8/201208140920132659.jpg",
            "http://f.hiphotos.baidu.com/image/h%3D200/sign=1478eb74d5a20cf45990f9df460b4b0c/d058ccbf6c81800a5422e5fdb43533fa838b4779.jpg",
            "http://f.hiphotos.baidu.com/image/pic/item/09fa513d269759ee50f1971ab6fb43166c22dfba.jpg"
    };
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.janshu_activity_layout);
        initView();
    }

    private void initView() {
        mAppBarLayout = (AppBarLayout) findViewById(R.id.jianshu_appbar_layout);
        mLine = findViewById(R.id.line_divider);
        mConvenientBanner = (ConvenientBanner) findViewById(R.id.banner);
        mRecyclerView = (RecyclerView) findViewById(R.id.vertical_recyclerView);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        manager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(manager);
        MyAdapter myAdapter = new MyAdapter();
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.setData(mockData());
        myAdapter.notifyDataSetChanged();

        mConvenientBanner.setPages(new CBViewHolderCreator<NetworkImageHolderView>() {
            @Override
            public NetworkImageHolderView createHolder() {
                return new NetworkImageHolderView();
            }
        }, Arrays.asList(images));

        mAppBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
                if(Math.abs(verticalOffset) >= mAppBarLayout.getTotalScrollRange()){
                    mLine.setVisibility(View.VISIBLE);
                }else{
                    mLine.setVisibility(View.GONE);
                }
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        mConvenientBanner.startTurning(2000);// 2s 换一张
    }

    @Override
    protected void onPause() {
        super.onPause();
        mConvenientBanner.stopTurning();
    }

    /**
     * 模拟首页数据
     * @return
     */
    private List<JsEntry> mockData(){
        List<JsEntry> data = new ArrayList<>();
        JsEntry jsEntry = new JsEntry();
        jsEntry.comment = 50;
        jsEntry.award = 3;
        jsEntry.like = 460;
        jsEntry.seek = 12504;
        jsEntry.time = "15小时前";
        jsEntry.title = "这些情商的技巧，你是不是都掌握了？";
        jsEntry.authorName = "JayChou";
        jsEntry.label = "心理";
        jsEntry.cover ="http://upload-images.jianshu.io/upload_images/2785318-5306a632b46a8c27.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1020/q/80";
        JsEntry jsEntry2 = new JsEntry();
        jsEntry2.comment = 150;
        jsEntry2.award = 33;
        jsEntry2.like = 1460;
        jsEntry2.seek = 170444;
        jsEntry2.time = "10小时前";
        jsEntry2.title = "除了阴谋，《锦绣未央》里还有哪些温情？";
        jsEntry2.authorName = "菇凉似梦";
        jsEntry2.label = "文化.艺术";
        jsEntry2.cover = "http://upload-images.jianshu.io/upload_images/2881988-b217e714eb05f88e.jpg?imageMogr2/auto-orient/strip|imageView2/2/w/1020/q/80";
        for (int i=0;i<100;i++){
           if(i % 2 == 0){
               data.add(jsEntry);
           }else{
               data.add(jsEntry2);
           }
        }
        return data;
    }
    public static class NetworkImageHolderView implements CBPageAdapter.Holder<String>{
         private ImageView imageView;
        @Override
        public View createView(Context context) {
            imageView = new ImageView(context);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            return imageView;
        }

        @Override
        public void UpdateUI(Context context, int position, String data) {
            ImageLoader.getInstance().displayImage(data,imageView);
        }
    }

    public static class MyAdapter extends RecyclerView.Adapter{
        private List<JsEntry> mData;

        public void setData(List<JsEntry> data) {
            mData = data;
        }

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.jianshu_label_item,null));
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
            MyViewHolder viewHolder = (MyViewHolder) holder;
            JsEntry jsEntry = mData.get(position);
            viewHolder.title.setText(jsEntry.title);
            viewHolder.name.setText(jsEntry.authorName);
            viewHolder.label.setText(jsEntry.label);
            viewHolder.time.setText(jsEntry.time);
            ImageLoader.getInstance().displayImage(jsEntry.cover,viewHolder.cover);
            viewHolder.comment.setText(String.format(viewHolder.comment.getContext().getResources().getString(R.string.js_comment),jsEntry.seek,jsEntry.comment,jsEntry.like,jsEntry.award));
        }

        @Override
        public int getItemCount() {
            return mData == null ? 0:mData.size();
        }
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView title;
        private TextView time;
        private TextView comment;
        private TextView label;
        private TextView name;
        private ImageView cover;
        public MyViewHolder(View itemView) {
            super(itemView);
            title = (TextView) itemView.findViewById(R.id.item_content);
            time = (TextView) itemView.findViewById(R.id.publish_time);
            comment = (TextView) itemView.findViewById(R.id.js_comment);
            label = (TextView) itemView.findViewById(R.id.js_label);
            name = (TextView) itemView.findViewById(R.id.author_name);
            cover = (ImageView) itemView.findViewById(R.id.cover);
        }
    }
}
