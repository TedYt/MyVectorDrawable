# MyVectorDrawable

如何是用VectorDrawable 动画
注意事项，请参考pdf文档

1. 准备3个xml文件，两个drawable，一个animator
    两个drawable，第一个drawable：
    
    drawable/square_path.xml
    <vector xmlns:android="http://schemas.android.com/apk/res/android"
        android:width="100dp"
        android:height="100dp"
        android:viewportHeight="200"
        android:viewportWidth="200">

        <path
            android:name="square"
            android:pathData="M50,50 H150 V150 H50z"
            android:strokeColor="#000000"
            android:strokeWidth="3.0"/>

    </vector>
    
    第一个drawable的作用是画出图形，是用的是pathData。这里的name属性是图形的ID。
    这里可以定义多个path
    这个文件可以作为source供控件使用
    
    
    第二个drawable
    
    drawable/anim_square.xml
    <animated-vector xmlns:android="http://schemas.android.com/apk/res/android"
        android:drawable="@drawable/square_path">

        <target
            android:name="square"
            android:animation="@animator/square_animator"/>

    </animated-vector>
    作用是：对drawable/square_path 中ID为saqure的图形使用动画animator/square_animator
    
    animator文件：
    animator/square_animator.xml
    <objectAnimator xmlns:android="http://schemas.android.com/apk/res/android"
        android:repeatCount="infinite"
        android:duration="2000"
        android:propertyName="trimPathEnd"
        android:valueFrom="0"
        android:valueTo="1"
        android:valueType="floatType">

    </objectAnimator>
    
2. 使用第二个drawable
    <ImageView
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#4ccaa6"
        android:onClick="onSquareClick"
        app:srcCompat="@drawable/anim_square"/>
    注意用的是app:srcCompat 而不是android:src

3. 播放动画
    public void onSquareClick(View view){
        ImageView imageView = (ImageView)view;
        Animatable animatable = (Animatable) imageView.getDrawable();
        if (animatable.isRunning()){
            animatable.start();
        }
        animatable.start();
    }
