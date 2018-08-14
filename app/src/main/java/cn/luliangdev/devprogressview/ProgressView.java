package cn.luliangdev.devprogressview;

import android.animation.ObjectAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.Animation;

/**
 * ProgressView
 * Created by LuLiang on 2018/8/4.
 */

public class ProgressView extends View {
    float progress = 0;
    float radius = 0;
    long duration = 1000;
    int color = 0xff000000;
    private Paint paint;
    Context context;
    private ObjectAnimator animator;


    public ProgressView(Context context) {
        super(context);
        this.context = context;
        initView();
    }


    public ProgressView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        this.context = context;
        initView();

    }


    public ProgressView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        this.context = context;
        initView();
    }

    private void initView() {
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        animator = new ObjectAnimator();
        //设置动画属性
        animator.setPropertyName("progress");
        //设置执行动画的View
        animator.setTarget(this);
    }


    @SuppressLint({"NewApi", "DrawAllocation"})
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setAntiAlias(true);                  //设置画笔为无锯齿
        paint.setColor(color);                    //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        RectF rectF = new RectF(0, 0, progress, getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }


    /**
     * set view background color
     *
     * @param color
     */
    public void setColor(int color) {
        this.color = color;
    }


    /**
     * set view round radius
     *
     * @param radius
     */
    public void setRadius(float radius) {
        this.radius = radius;
    }

    /**
     * set anim duration
     *
     * @param duration
     */
    public void setDuration(long duration) {
        this.duration = duration;
    }

    public float getProgress() {
        return progress;
    }

    /**
     * set progress
     *
     * @param progress
     */
    public void setProgress(float progress) {
        this.progress = progress;
        invalidate();
    }


    /**
     * 返回属性动画实例，可用于动画进度监听做后续操作
     * @return
     */
    public ObjectAnimator getAnimator() {
        return animator;
    }

    //
    public void startAnim() {
        if (animator.isRunning()) animator.end();
        //设置进度数组，  0 - max
        animator.setFloatValues(0, progress);
        //设置动画时间
        animator.setDuration(duration);
        //动画开启
        animator.start();
    }


}
