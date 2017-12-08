package mobilsafe.a520it.www.dashen4.activity;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.widget.RelativeLayout;
import android.widget.TextView;

import mobilsafe.a520it.www.dashen4.R;

public class SplashActivity extends Activity {
    private RelativeLayout rl_splash_root;
    private TextView  tv_splash_version_name;
    private TextView  tv_splash_version_code;
    private AnimationSet animationSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initView();
        initAnimation();
        initData();
        initEvent();
    }

    private void initView() {
        setContentView(R.layout.activity_main);
        rl_splash_root = (RelativeLayout)findViewById(R.id.rl_splash_root);
        tv_splash_version_name = (TextView)findViewById(R.id.tv_splash_version_name);
        tv_splash_version_code = (TextView)findViewById(R.id.tv_splash_version_code);
    }

    private void initAnimation() {
        RotateAnimation ra = new RotateAnimation(0,360, Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        ra.setDuration(2000);
        ra.setFillAfter(true);
        ScaleAnimation sa = new ScaleAnimation(0.0f,1.0f,0.0f,1.0f,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        sa.setDuration(2000);
        sa.setFillAfter(true);
        AlphaAnimation aa = new AlphaAnimation(0.0f,1.0f);
        aa.setDuration(2000);
        aa.setFillAfter(true);
        animationSet = new AnimationSet(false);
        animationSet.addAnimation(ra);
        animationSet.addAnimation(sa);
        animationSet.addAnimation(aa);
        rl_splash_root.startAnimation(animationSet);
    }

    private void initData() {
        PackageManager pm = getPackageManager();
        try {
            PackageInfo info = pm.getPackageInfo(getPackageName(),0);
            tv_splash_version_code.setText(info.versionCode+"");
            tv_splash_version_name.setText(info.versionName);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    private void initEvent() {
        animationSet.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent = new Intent(SplashActivity.this,HomeActivity.class);
                startActivity(intent);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }






}
