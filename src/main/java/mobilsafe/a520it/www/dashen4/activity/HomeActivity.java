package mobilsafe.a520it.www.dashen4.activity;

import android.animation.ObjectAnimator;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import mobilsafe.a520it.www.dashen4.R;

/**
 * Created by SaRo on 2017/11/1.
 */

public class HomeActivity extends Activity {
    private ImageView iv_home_logo;
    private ImageView iv_home_setting;
    private GridView gv_home;
    private static final String names[] = {"aaa", "bbb", "ccc", "ddd", "eee", "fff", "ggg", "hhh"};
    private static final String desc[] = {"111", "222", "333", "444", "555", "666", "777", "888"};
    private static final int icons[] = {R.drawable.a, R.drawable.b,
            R.drawable.c, R.drawable.d,
            R.drawable.e, R.drawable.f,
            R.drawable.h, R.drawable.j};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initAnimation();
        initData();
        initEvent();
    }

    private void initView(){
        setContentView(R.layout.activity_home);
        iv_home_logo = (ImageView)findViewById(R.id.iv_home_logo);
        iv_home_setting = (ImageView)findViewById(R.id.iv_home_setting);
        gv_home = (GridView)findViewById(R.id.gv_home);

    }
    private void initAnimation(){
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(iv_home_logo,"rotationY",0,40,80,120,160,200,240,280,320,360);
        objectAnimator.start();
        objectAnimator.setDuration(2000);
        objectAnimator.setRepeatCount(objectAnimator.INFINITE);
    }
    private void initData(){
        HomeAdapter adapter = new HomeAdapter();
        gv_home.setAdapter(adapter);
    }
    private void initEvent(){
        iv_home_setting.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(HomeActivity.this,SettingActivity.class);
                startActivity(intent);
            }
        });
        gv_home.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                switch (position){
                    case 0:
                        showSetPasswordDialog();
                        break;
                    case 1:
                        break;
                    case 2:
                        break;
                    case 3:
                        break;
                    case 4:
                        break;
                    case 5:
                        break;
                }
            }
        });
    }


    private void showSetPasswordDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(HomeActivity.this);
        View view = View.inflate(getApplicationContext(),R.layout.alter_set_pass,null);

        builder.setView(view);
        builder.show();
    }

    class HomeAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View view = View.inflate(getApplicationContext(),R.layout.item_home,null);
            ImageView iv_icon = (ImageView)view.findViewById(R.id.iv_item_icon);
            TextView tv_name = (TextView)view.findViewById(R.id.tv_item_name);
            TextView tv_desc = (TextView)view.findViewById(R.id.tv_item_desc);
            iv_icon.setImageResource(icons[position]);
            tv_name.setText(names[position]);
            tv_desc.setText(desc[position]);
            return view;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }


    }
}
