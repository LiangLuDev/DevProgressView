# 自定义`ProgressView`-进度条动画


> 前两天公司需求，实现进度条动画，本来想在网上找找有没有类似的拿来用，想偷懒都不行。就简单自定义`View`进度条动画。实现很简单。

### 动画预览

- 使用在公司项目效果预览

![xz-progressview](http://static.luliangdev.cn/xz_progressview.gif)

- 简洁效果预览

![progressview](http://static.luliangdev.cn/progressview.gif)


### 代码实现
> 动画效果很简单，使用`ObjectAnimator`属性动画来实现，这个官方提供一些Api使用，具体可以查看[官方文档](https://developer.android.com/reference/android/animation/ObjectAnimator)。如果以后需要实现更复杂的动画，可以以此为例进行自定义。这里我会对基础自定义`View`动画实现简单的说明，具体说明在代码注释。如果你们需要的效果跟我的类似，你可以直接把[`ProgressView`](https://github.com/LiangLuDev/DevProgressView/blob/master/app/src/main/java/cn/luliangdev/devprogressview/ProgressView.java)文件拷贝下来使用，需要的属性不够用的话可以直接在里面修改添加。


#### 看代码才是王道

- 自定义`View`-`ProgressView`代码（只展示主要代码）

```
public class ProgressView extends View {

    private void initView() {
        //初始化画笔
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        animator = new ObjectAnimator();
        //设置动画属性
        animator.setPropertyName("progress");
        //设置执行动画的View
        animator.setTarget(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //画笔属性
        paint.setAntiAlias(true);                  //设置画笔为无锯齿
        paint.setColor(color);                    //设置画笔颜色
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(1);
        //圆角形状设置到画布
        RectF rectF = new RectF(0, 0, progress, getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);
    }

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
```
- `xml`添加代码

```
 <cn.luliangdev.devprogressview.ProgressView
        android:id="@+id/progressview"
        android:layout_width="wrap_content"
        android:layout_height="30dp"/>
```

- 代码使用代码
```
//设置颜色
progressview.setColor(getResources().getColor(R.color.colorAccent));
//设置圆角   默认无圆角
progressview.setRadius(6);
//设置进度条长度    默认px
progressview.setProgress(500);
//设置动画时间
progressview.setDuration(500);
//开启动画
progressview.startAnim();

//动画监听
progressview.getAnimator().addListener(new Animator.AnimatorListener() {
    @Override
    public void onAnimationStart(Animator animation) {
        //动画开始
    }

    @Override
    public void onAnimationEnd(Animator animation) {
       //动画结束
    }

    @Override
    public void onAnimationCancel(Animator animation) {
        //动画取消
    }

    @Override
    public void onAnimationRepeat(Animator animation) {
        //动画重复
    }
});
```
### 意见反馈
如果遇到问题或者好的建议，请反馈到：issue、927195249@qq.com 或者LiangLuDev@gmail.com

如果觉得对你有用的话，点一下右上的星星赞一下吧!


