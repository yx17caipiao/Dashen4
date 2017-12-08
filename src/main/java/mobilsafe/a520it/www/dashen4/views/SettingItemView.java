package mobilsafe.a520it.www.dashen4.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mobilsafe.a520it.www.dashen4.R;

/**
 * Created by u on 2017/11/29.
 */

public class SettingItemView extends RelativeLayout {

    private TextView tv_name;
    private ImageView iv_setting_toggle;

    public SettingItemView(Context context) {
        super(context);
    }

    public SettingItemView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
        initData(attrs);
    }

    private void initData(AttributeSet attrs) {
        String desc = attrs.getAttributeValue("http://schemas.android.com/apk/res-auto","desc");
        tv_name.setText(desc);
    }

    private void initView(){
        View view = View.inflate(getContext(), R.layout.view_setting_item,this);
        tv_name = (TextView)findViewById(R.id.tv_name);
        iv_setting_toggle = (ImageView)findViewById(R.id.iv_setting_toggle);
    }
}
