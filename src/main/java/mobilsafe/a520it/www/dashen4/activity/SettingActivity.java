package mobilsafe.a520it.www.dashen4.activity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import mobilsafe.a520it.www.dashen4.R;

/**
 * Created by u on 2017/11/28.
 */

public class SettingActivity extends Activity {

    private RelativeLayout rv_setting_update;
    private RelativeLayout rv_setting_blackinterface;
    private ImageView iv_setting_update;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    private void initData() {

    }

    private void initEvent() {
        rv_setting_update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                iv_setting_update.setImageResource(R.drawable.b);
            }
        });
    }

    private void initView() {
        setContentView(R.layout.activity_setting);
        rv_setting_update = (RelativeLayout)findViewById(R.id.rv_setting_update);
        rv_setting_blackinterface = (RelativeLayout)findViewById(R.id.rv_setting_blackinterface);
        iv_setting_update = (ImageView)findViewById(R.id.iv_setting_update);
    }
}
