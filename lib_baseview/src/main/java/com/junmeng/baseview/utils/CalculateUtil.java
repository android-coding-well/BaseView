package com.junmeng.baseview.utils;

import android.content.Context;
import android.graphics.Paint;
import android.graphics.PointF;
import android.util.TypedValue;

/**
 * Created by HWJ on 2016/12/13.
 */

public class CalculateUtil {

    /**
     * 求a点绕o点旋转rotate度后的点的坐标
     *
     * @param a      原始点
     * @param o      圆点，即围绕的中心点
     * @param rotate 旋转度数，正为顺时针，负为逆时针
     * @return 旋转后的点的坐标
     */
    public static PointF getPointAfterRotate(PointF a, PointF o, float rotate) {
        PointF b = new PointF();
        if (a == null || o == null) {
            return b;
        }
        double angle = Math.toRadians(rotate);//将角度转为弧度
        b.x = (float) ((a.x - o.x) * Math.cos(angle) - (a.y - o.y) * Math.sin(angle) + o.x);
        b.y = (float) ((a.x - o.x) * Math.sin(angle) + (a.y - o.y) * Math.cos(angle) + o.y);
        return b;
    }

    /**
     * 将dp转为px
     * @param context
     * @param dpVal
     * @return
     */
    public int dp2px(Context context,float dpVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dpVal, context.getResources().getDisplayMetrics());
    }

    /**
     * 将sp转为px
     * @param context
     * @param spVal
     * @return
     */
    public int sp2px(Context context,float spVal) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, spVal, context.getResources().getDisplayMetrics());
    }

    /**
     * 计算文字宽度
     *
     * @param paint 画笔，需要先设置好大小：paint.setTextSize()
     * @param str
     * @return
     */
    public static float getTextWidth(Paint paint, String str) {
        float iRet = 0;
        if (str != null && str.length() > 0) {
            int len = str.length();
            float[] widths = new float[len];
            paint.getTextWidths(str, widths);
            for (int j = 0; j < len; j++) {
                iRet +=  Math.ceil(widths[j]);
            }
        }
        return iRet;
    }

    /**
     * 计算文字高度
     *
     * @param paint 画笔，需要先设置好大小：paint.setTextSize()
     * @return
     */
    public static float getTextHeight(Paint paint) {
        return paint.descent() - paint.ascent();
    }
}
