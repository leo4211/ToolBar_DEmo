package test.liuyang.com.toolbar_demo;

import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements Toolbar.OnMenuItemClickListener {


    List<View>  list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
//    将默认的title 取消掉
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        TextView tv_title = (TextView) findViewById(R.id.tv_title);

        tv_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(MainActivity.this,"点击生效",Toast.LENGTH_SHORT).show();
            }
        });

//         toolbar.setTitle();
//        toolbar.setLogo(R.mipmap.ic_launcher);
// Title
//        toolbar.setTitle("My Title");
//// Sub Title
//        toolbar.setSubtitle("Sub title");
//
//        setSupportActionBar(toolbar);

// Navigation Icon 要設定在 setSupoortActionBar 才有作用
// 否則會出現 back button
//        toolbar.setNavigationIcon(R.mipmap.ic_launcher);
//
//        toolbar.inflateMenu(R.menu.menu);
//
//        toolbar.setOnMenuItemClickListener(this);

        // 第一步获取控件

        ViewPager viewpager = (ViewPager) findViewById(R.id.viewpager);

        list=new ArrayList<View>();

        list.add(LayoutInflater.from(this).inflate(R.layout.one,null));
        list.add(LayoutInflater.from(this).inflate(R.layout.t,null));
        View view = LayoutInflater.from(this).inflate(R.layout.three, null);
        list.add(view);

        view.findViewById(R.id.btn_show).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,"页面跳转了",Toast.LENGTH_SHORT).show();
            }
        });

        viewpager.setAdapter(new PagerAdapter() {
            @Override
            public int getCount() {
                return list.size();
            }

            @Override
            public boolean isViewFromObject(View view, Object object) {

                return view==object;
            }

            @Override
            public Object instantiateItem(ViewGroup container, int position) {
                 View view=  list.get(position);
                 container.addView(view);
                return view;
            }


            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {

                View view = list.get(position);

                container.removeView(view);


            }
        });





    }


    @Override
    public boolean onMenuItemClick(MenuItem item) {


        String msg = "";
        switch (item.getItemId()) {
            case R.id.action_edit:
                msg += "Click edit";
                break;
//            case R.id.action_share:
//                msg += "Click share";
//                break;
//            case R.id.action_settings:
//                msg += "Click setting";
//                break;
        }

        if(!msg.equals("")) {
            Toast.makeText(MainActivity.this, msg, Toast.LENGTH_SHORT).show();
        }
        return true;
    }
}
