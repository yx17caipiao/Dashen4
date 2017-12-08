package mobilsafe.a520it.www.dashen4.utils;

import android.content.Context;
import android.content.SharedPreferences;

import mobilsafe.a520it.www.dashen4.Constant;

/**
 * Created by SaRo on 2017/10/22.
 */

public class SPUtils {

    public static SharedPreferences getSp(Context context){
        SharedPreferences sp = context.getSharedPreferences(Constant.SPNAME,Context.MODE_PRIVATE);
        return sp;
    }

    public static boolean getBoolean(Context context,String key){
        return getSp(context).getBoolean(key,false);
    }
    public static void putBoolean(Context context,String key,boolean state){

    }
}
