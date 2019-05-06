# 目录

<!-- TOC -->
- [CustomTitleBar通用标题栏](#CustomTitleBar 通用标题栏)
    - [自定义属性](#自定义属性)
    - [如何使用](#如何使用)
    - [常用api](#常用api)
- [AGUIDialog](#AGUIDialog)
    - [内置的dialog类型](#2.1内置的dialog类型)
    - [如何使用](#2.2如何使用)
    - [常用api](#常用api)


# CustomTitleBar 通用标题栏

## 自定义属性

    <!-- 标题的位置，只支持靠左或居中显示 -->
    <attr format="enum" name="titlebar_title_gravity">
        <enum name="left_center" value="19"/>
        <enum name="center" value="17"/>
    </attr>
    <!-- 底部是否显示分割线 -->
    <attr format="boolean" name="titlebar_show_divider"/>
    <!-- 底部分割线的颜色 -->
    <attr format="color" name="titlebar_divider_color"/>
    <!-- 底部分割线的高度 -->
    <attr format="dimension" name="titlebar_divider_height"/>
    <!-- 标题栏的背景色 -->
    <attr format="color" name="titlebar_bg_color"/>
    <!-- 返回按钮的图标资源id -->
    <attr format="reference" name="titlebar_left_back_drawable_id"/>
    <!-- 标题的字体大小 -->
    <attr format="dimension" name="titlebar_title_text_size"/>
    <!-- 标题和副标题的字体大小 -->
    <attr format="dimension" name="titlebar_title_text_size_with_subtitle"/>
    <!-- 副标题的字体大小 -->
    <attr format="dimension" name="titlebar_subtitle_text_size"/>
    <!-- 标题的字体颜色 -->
    <attr format="color" name="titlebar_title_color"/>
    <!-- 副标题字体颜色 -->
    <attr format="color" name="titlebar_subtitle_color"/>
    <!-- 没有按钮时标题的水平间距 -->
    <attr format="dimension" name="titlebar_title_margin_horizontal_when_no_btn_aside"/>
    <!-- 标题的水平内边距 -->
    <attr format="dimension" name="titlebar_title_container_padding_horizontal"/>
    <!-- 图标的宽度 -->
    <attr format="dimension" name="titlebar_image_btn_width"/>
    <!-- 图标的高度 -->
    <attr format="dimension" name="titlebar_image_btn_height"/>
    <!-- 文字按钮的水平内边距 -->
    <attr format="dimension" name="titlebar_text_btn_padding_horizontal"/>
    <!-- 文字按钮的颜色 -->
    <attr format="reference" name="titlebar_text_btn_color_state_list"/>
    <!-- 文字按钮的字体大小 -->
    <attr format="dimension" name="titlebar_text_btn_text_size"/>
    <!-- 标题栏的高度 -->
    <attr format="dimension" name="titlebar_height"/>
    <!-- 按钮的背景设置 -->
    <attr format="reference" name="titlebar_button_background_selector"/>
    
## 如何使用

在xml文件中添加

    <com.xjj.AGUI.widget.CustomTitleBar
        android:id="@+id/titleBar"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:titlebar_bg_color="@color/colorPrimary"
        app:titlebar_height="52dp"
        app:titlebar_title_color="@color/white"
        app:titlebar_title_gravity="center"/>
        
在java代码中

        titleBar = (CustomTitleBar) findViewById(R.id.titleBar);
        titleBar.setTitle("CustomTitleBar");
        titleBar.addLeftBackImageButton().setOnClickListener(this);

        titleBar1 = (CustomTitleBar) findViewById(R.id.titleBar1);
        titleBar1.addLeftBackImageButton();
        titleBar1.setTitle("标题靠左");

        titleBar2 = (CustomTitleBar) findViewById(R.id.titleBar2);
        titleBar2.setTitle("标题靠左");

        titleBar3 = (CustomTitleBar) findViewById(R.id.titleBar3);
        titleBar3.addLeftBackImageButton();
        titleBar3.setTitle("标题居中");

        titleBar4 = (CustomTitleBar) findViewById(R.id.titleBar4);
        titleBar4.addLeftBackImageButton();
        titleBar4.setTitle("标题居中");
        titleBar4.addLeftImageButton(R.mipmap.icon_message, R.id.titlebar_item_left_button);

        titleBar5 = (CustomTitleBar) findViewById(R.id.titleBar5);
        titleBar5.addLeftBackImageButton();
        titleBar5.setTitle("标题靠左");
        titleBar5.addRightImageButton(R.mipmap.add, R.id.titlebar_item_right_button1);
        titleBar5.addRightImageButton(R.mipmap.search, R.id.titlebar_item_right_button2);

        titleBar6 = (CustomTitleBar) findViewById(R.id.titleBar6);
        titleBar6.addLeftBackImageButton();
        titleBar6.setTitle("标题靠左");
        titleBar6.addRightTextButton("按钮", R.id.titlebar_item_right_text1);
        
在添加左右或者右边的按钮时应该为每个按钮设置不同的viewid，目前可使用的viewid如下，可以根据需要自行添加：
 
    <item name="titlebar_item_left_back" type="id"/> // 默认作为返回按钮的viewid
    <item name="titlebar_item_left_button" type="id"/>
    <item name="titlebar_item_right_button1" type="id"/>
    <item name="titlebar_item_right_button2" type="id"/>
    <item name="titlebar_item_right_text1" type="id"/>
    <item name="titlebar_item_right_text2" type="id"/>
    <item name="titlebar_item_left_text1" type="id"/>
    <item name="titlebar_item_left_text2" type="id"/>
    
## 常用api

    setBackgroundDividerEnabled(boolean enabled) // 是否显示底部分割线
    setCenterView(View view) // 在titlebar的中间添加自定义view
    setTitle(String title) // 设置标题
    setSubTitle(String subTitle) // 设置副标题
    setTitleGravity(int gravity) // 设置标题的位置，靠左或居中
    addLeftView() // 添加左边自定义view
    addRightView() // 添加右边自定义view
    addRightImageButton() // 添加右边按钮
    addLeftImageButton() // 添加左边按钮
    addLeftTextButton() // 添加左边文字按钮
    addRightTextButton() // 添加右边文字按钮
    addLeftBackImageButton() // 添加一个返回按钮图标
    
# AGUIDialog

## 2.1内置的dialog类型

    /** 提示类型的dialog */
    public static final int DIALOG_TIPS = 1;
    /** 单选列表类型的dialog */
    public static final int DIALOG_SINGLE_CHOICE_LIST = 2;
    /** 底部弹起类型的dialog */
    public static final int DIALOG_SINGLE_CHOICE_BOTTOM_UP = 3;
    /** 提示正在加载类型的dialog */
    public static final int DIALOG_LOADING = 4;
    /** 带水平进度条的dialog */
    public static final int DIALOG_HORIZONTAL_PROGRESSBAR = 5;
    /** 带圆形进度条的dialog */
    public static final int DIALOG_CIRCLE_PROGRESSBAR = 6;
    /** 提示操作失败的dialog */
    public static final int DIALOG_FAILED_TIPS = 7;
    
## 2.2如何使用

    new AGUIDialog.Builder(this).setContent("测试").setNegativeButton(new IDialog.OnClickListener() {
            @Override
            public void onClick(IDialog dialog) {
                dialog.dismiss();
            }
        }).setPositiveButton(new IDialog.OnClickListener() {
            @Override
            public void onClick(IDialog dialog) {
                dialog.dismiss();
            }
        }).setCancelableOutSide(true).setCancelable(true).setTitle("提示").asType(AGUIDialog.DIALOG_TIPS).show();
        
    如果内置的类型不满足需求可以使用自定布局 setDialogView()，同时通过设定setBuildChildListener(IDialog.OnBuildListener listener)来监听已构建好的子布局，从而实现
    自己的业务逻辑
    
## 常用api

    setProgress(int progress)  // 设置进度，当type为DIALOG_HORIZONTAL_PROGRESSBAR和DIALOG_CIRCLE_PROGRESSBAR时有效
    setDialogView() // 设置自定义布局
    setScreenWidthP(float percentage) // 设置dialog宽度占屏幕宽度的百分比，值为0.0 ~ 1.0
    setScreenHeightP(float percentage) // 设置dialog的高度占屏幕高度的百分比，值为0.0 ~ 1.0
    setOnDismissListener(IDialog.OnDismissListener dismissListener) // 设置dialog消失时的监听器
    setOnItemClickListener(IDialog.OnItemClickListener itemClickListener) // 设置多选项选择时被选择的item监听
    setWidth(int width) // 设置dialog的宽度
    setHeight(int height) // 设置dialog的高度
    setWindowBackgroundP(float percentage) // 设置背景的透明透明度，值为0.0 ~ 1.0，1.0则完全不透明
    setGravity(int gravity) // 设置dialog的Gravity
    setCancelableOutSide(boolean cancelableOutSide) // 设置点击dialog外部是否消失
    setCancelable(boolean cancelable) // 设置点击返回键是否消失
    setBuildChildListener(IDialog.OnBuildListener listener) // 设置自定义布局的监听
    setAnimStyle(int animStyle) // 设置动画
    setPositiveButton(IDialog.OnClickListener onclickListener) // 设置确定按钮的监听
    setPositiveButton(String btnStr, IDialog.OnClickListener onclickListener) // 设置确定按钮的监听，同时指定按钮的text
    setNegativeButton(IDialog.OnClickListener onclickListener) // 设置取消按钮的监听
    setNegativeButton(String btnStr, IDialog.OnClickListener onclickListener) // 设置取消按钮的监听，同时指定按钮的text
    setTitle(String title) // 设置标题
    setContent(String content) // 设置内容
    asType(int type) // 设置需显示的dialog的类型，如不满足则使用自定义
    setItems() // 设置多选条目时的数据源
    setTitleTextColor(int colorid) // 设置标题字体颜色
    setContentTextColor(int colorid) // 设置内容字体颜色
    setPositiveTextColor(int colorid) // 设置确定按钮字体颜色
    setNegativeTextColor(int colorid) // 设置取消按钮字体颜色
    setTitleTextSize(int sp) // 设置标题字体大小
    setContentTextSize(int sp) // 设置内容字体大小
    setPositiveTextSize(int sp) // 设置确定按钮字体大小
    setNegativeTextSize(int sp) // 设置取消按钮字体大小
    
# 3、AGUIPopupWindow

## 3.1、支持可选的类型

    /** 显示在view的左下方 */
    public static final int SHOW_DOWN_LEFT_BY_VIEW           = 1;
    /** 显示在view的右下方 */
    public static final int SHOW_DOWN_RIGHT_BY_VIEW          = 2;
    /** 显示在view的左上方 */
    public static final int SHOW_UP_LEFT_BY_VIEW             = 3;
    /** 显示在view右上方 */
    public static final int SHOW_UP_RIGHT_BY_VIEW            = 4;
    /** 显示在view的下方并居中 */
    public static final int SHOW_DOWN_CENTER_BY_VIEW         = 5;
    /** 显示在view的下方并居中 */
    public static final int SHOW_UP_CENTER_BY_VIEW           = 6;
    /** 显示在view的下方且左对齐 */
    public static final int SHOW_ALIGN_LEFT_DOWN_BY_VIEW     = 7;
    /** 显示在view的上方且左对齐 */
    public static final int SHOW_ALIGN_LEFT_UP_BY_VIEW       = 8;
    /** 显示在view的下方且右对齐 */
    public static final int SHOW_ALIGN_RIGHT_DOWN_BY_VIEW    = 9;
    /** 显示在view的上方且右对齐 */
    public static final int SHOW_ALIGN_RIGHT_UP_BY_VIEW      = 10;
    /** 显示在屏幕的左上角 */
    public static final int SHOW_START_AND_TOP_BY_PARENT     = 11;
    /** 显示在屏幕左下角 */
    public static final int SHOW_START_AND_BOTTOM_BY_PARENT  = 12;
    /** 显示在屏幕的左边且垂直居中 */
    public static final int SHOW_START_AND_CENTER_BY_PARENT  = 13;
    /** 显示在屏幕的右上角 */
    public static final int SHOW_END_AND_TOP_BY_PARENT       = 14;
    /** 显示在屏幕的右下角 */
    public static final int SHOW_END_AND_BOTTOM_BY_PARENT    = 15;
    /** 显示在屏幕的右边且垂直居中 */
    public static final int SHOW_END_AND_CENTER_BY_PARENT    = 16;
    /** 显示在屏幕的顶部且水平居中 */
    public static final int SHOW_TOP_AND_CENTER_BY_PARENT    = 17;
    /** 显示在屏幕的底部且水平居中 */
    public static final int SHOW_BOTTOM_AND_CENTER_BY_PARENT = 18;
    /** 显示在屏幕中间 */
    public static final int SHOW_CENTER_BY_PARENT            = 19;
    
## 3.2、如何使用

    // 显示在目标view的正下方
    AGUIPopupWindow popupWindow = new AGUIPopupWindow.Builder(this).setView(R.layout.popup_left_or_right).setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, 0).setWindowBackgroundP((float) 0.8).create();
    popupWindow.show(view, AGUIPopupWindow.SHOW_DOWN_CENTER_BY_VIEW, 0, 0);

    // 根据按下的坐标显示
    AGUIPopupWindow popupWindow = new AGUIPopupWindow.Builder(this)
            .setView(R.layout.popup_left_or_right)
            .setWidthAndHeight(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
            .setWindowBackgroundP((float) 0.8)
            .setViewOnclickListener(new AGUIPopupWindow.ViewInterface() {
                @Override
                public void getChildView(View view, final PopupWindow popupWindow) {
                    TextView tvLike = view.findViewById(R.id.tv_like);
                    tvLike.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            AGUIToast.normal(getApplicationContext(), "赞一个");
                            popupWindow.dismiss();
                        }
                    });
                }
            })
            .create();
        popupWindow.showEverywhereByPointxy(view, mLastX, mLastY);
        
## 3.3、常用api

    setView() // 设置需要显示的view或布局id
    setViewOnclickListener(ViewInterface listener) // 设置view点击事件的监听
    setWidthAndHeight(int width, int height) // 设置view的宽高
    setWindowBackgroundP(float level) // 设置背景变暗，值为0.0~1.0，1.0为不暗
    setOutsideTouchable(boolean touchable) // 设置点击view外部view是否可消失
    setAnimationStyle(int animationStyle) // 设置动画
    show(View view, int locationType, int offX, int offY) // view的显示
    showEverywhereByPointxy(View view, int touchX, int touchY) // view跟随按下的坐标显示
    
# 4、AGUIProgressBar

## 4.1、自定义属性

        <!-- 进度条的类型，type_rect为长条方形，type_circle为圆形，type_round_rect为倒角水平 -->
        <attr name="progressBar_type" format="enum">
            <enum name="type_rect" value="0"/>
            <enum name="type_circle" value="1"/>
            <enum name="type_round_rect" value="2"/>
        </attr>
        <!-- 进度显示的颜色 -->
        <attr name="progressBar_progress_color" format="color"/>
        <!-- 进度条背景色 -->
        <attr name="progressBar_background_color" format="color"/>
        <!-- 进度最大值 -->
        <attr name="progressBar_max_value" format="integer"/>
        <!-- 初始进度 -->
        <attr name="progressBar_value" format="integer"/>
        <!-- 边框宽度 -->
        <attr name="progressBar_stroke_width" format="dimension"/>
        <!-- 进度边框是否倒角 -->
        <attr name="progressBar_stroke_round_cap" format="boolean"/>
        <!-- 进度文字显示字体大小 -->
        <attr name="android:textSize"/>
        <!-- 进度文字显示字体颜色 -->
        <attr name="android:textColor"/>
        
## 4.2、如何使用

    xml
    <com.xjj.AGUI.widget.AGUIProgressBar
        android:id="@+id/progressBar"
        android:layout_width="250dp"
        android:layout_height="20dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="15dp"
        android:textColor="@color/white"
        android:textSize="14sp"
        app:progressBar_background_color="@color/config_color_gray_9"
        app:progressBar_max_value="100"
        app:progressBar_progress_color="@color/colorPrimary"
        app:progressBar_stroke_round_cap="true"
        app:progressBar_type="type_round_rect"
        app:progressBar_value="0"/>
        
    <com.xjj.AGUI.widget.AGUIProgressBar
        android:id="@+id/circleProgressBar"
        android:layout_width="90dp"
        android:layout_height="90dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="15dp"
        android:textColor="#525a66"
        android:textSize="14sp"
        app:progressBar_background_color="@color/config_color_gray_9"
        app:progressBar_max_value="100"
        app:progressBar_progress_color="@color/colorPrimary"
        app:progressBar_stroke_round_cap="true"
        app:progressBar_stroke_width="10dp"
        app:progressBar_type="type_circle"
        app:progressBar_value="0"/>
        
    java
        // 水平进度条
        mProgressBar = (AGUIProgressBar) findViewById(R.id.progressBar);
        mProgressBar.setProgress(50, true);
        // 显示进度，不设置将不显示文字进度
        mProgressBar.setAGUIProgressBarTextGenerator(new AGUIProgressBar.AGUIProgressBarTextGenerator() {
            @Override
            public String generateText(AGUIProgressBar progressBar, int value, int maxValue) {
                return value + "%";
            }
        });

        mCircleProgressBar = (AGUIProgressBar) findViewById(R.id.circleProgressBar);
        mCircleProgressBar.setProgress(50, true);
        mCircleProgressBar.setAGUIProgressBarTextGenerator(new AGUIProgressBar.AGUIProgressBarTextGenerator() {
            @Override
            public String generateText(AGUIProgressBar progressBar, int value, int maxValue) {
                return value + "%";
            }
        });
        
## 4.3、常用api说明

    setType(int type) // 设置进度条类型
    setBarColor(int backgroundColor, int progressColor) // 设置进度条的背景色和进度色
    setTextSize(int textSize) // 设置字体大小
    setTextColor(int textColor) // 设置字体颜色
    setAGUIProgressBarTextGenerator(AGUIProgressBarTextGenerator QMUIProgressBarTextGenerator) // 设置进度文案，不设置将不会显示
    getProgress() // 获取进度
    setProgress(int progress) // 设置进度
    setProgress(int progress, boolean animated) // 设置进度，同时指定是否有动画效果
    getMaxValue() // 获取进度最大值
    setMaxValue(int maxValue) // 设置进度最大值
    
# 5、AGUIRoundButton 自定义圆角按钮

## 5.1、自定义属性

        <!-- 指定按钮的背景色，如果在xml中设置，只支持color值 -->
        <attr name="RoundButton_backgroundColor"/>
        <!-- 指定边界的颜色值 -->
        <attr name="RoundButton_borderColor"/>
        <!-- 指定边界的宽度 -->
        <attr name="RoundButton_borderWidth"/>
        <!-- 圆角是否要自适应为 View 高度的一半 -->
        <attr name="RoundButton_isRadiusAdjustBounds"/>
        <!-- 同时指定四个方向的圆角大小 -->
        <attr name="RoundButton_radius"/>
        <!-- 指定左上方圆角的大小 -->
        <attr name="RoundButton_radiusTopLeft"/>
        <!-- 指定右上方圆角的大小 -->
        <attr name="RoundButton_radiusTopRight"/>
        <!-- 指定左下方圆角的大小 -->
        <attr name="RoundButton_radiusBottomLeft"/>
        <!-- 指定右下方圆角的大小 -->
        <attr name="RoundButton_radiusBottomRight"/>
        
## 5.2、如何使用

    xml
    <com.xjj.AGUI.widget.AGUIRoundButton
        android:id="@+id/roundButton2"
        android:layout_width="90dp"
        android:layout_height="40dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"
        android:gravity="center"
        android:text="圆角按钮"
        android:textColor="@color/colorPrimary"
        app:RoundButton_backgroundColor="@color/config_color_white"
        app:RoundButton_isRadiusAdjustBounds="false"
        app:RoundButton_radius="10dp"/>
        
# 6、AGUICheckBox 复选框

## 6.1、自定义属性

        <!-- 大小 -->
        <attr name="size" format="dimension" />
        <!-- 边框颜色 -->
        <attr name="color_border" format="color" />
        <!-- 背景色 -->
        <attr name="color_background" format="color" />
        
## 6.2、如何使用

    <com.xjj.AGUI.widget.AGUICheckBox
        android:id="@+id/checkbox"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"
        app:color_background="@color/colorPrimary"
        app:color_border="@color/config_color_gray_9"
        app:size="30dp"/>

        mCheckBox.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox.isChecked()) {
                    mCheckBox.setChecked(false, true);
                } else {
                    mCheckBox.setChecked(true, true);
                }
            }
        });
        
# 7、AGUIRoundedImageView

## 7.1、自定义属性

        <!-- 四周倒角半径 -->
        <attr format="dimension" name="riv_corner_radius"/>
        <!-- 左上角倒角半径 -->
        <attr format="dimension" name="riv_corner_radius_top_left"/>
        <!-- 右上角倒角半径 -->
        <attr format="dimension" name="riv_corner_radius_top_right"/>
        <!-- 左下角倒角半径 -->
        <attr format="dimension" name="riv_corner_radius_bottom_left"/>
        <!-- 右下角倒角半径 -->
        <attr format="dimension" name="riv_corner_radius_bottom_right"/>
        <!-- 边框宽度 -->
        <attr format="dimension" name="riv_border_width"/>
        <!-- 边框颜色 -->
        <attr format="color" name="riv_border_color"/>
        <!-- 是否启用倒角，默认开启 -->
        <attr format="boolean" name="riv_mutate_background"/>
        <!-- 是否显示为圆形，默认为false -->
        <attr format="boolean" name="riv_oval"/>
        <attr name="android:scaleType"/>
        
## 7.2、如何使用

    <com.xjj.AGUI.widget.AGUIRoundedImageView
        android:id="@+id/RoundedImageView2"
        android:layout_width="50dp"
        android:layout_height="50dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"
        android:background="@mipmap/beer"
        app:riv_border_color="@color/config_color_red"
        app:riv_border_width="1dp"
        app:riv_corner_radius="10dp"
        app:riv_oval="false"/>
        
# 8、AGUICircleImageView 圆形ImageView

## 8.1、如何使用

     <com.xjj.AGUI.widget.AGUICircleImageView
        android:id="@+id/CircleImageView"
        android:layout_width="70dp"
        android:layout_height="70dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"
        android:src="@mipmap/beer"/>
        
# 9、AGUISwitchButton 开关按钮

## 9.1、自定义属性

        <!-- 阴影半径 -->
        <attr format="reference|dimension" name="sb_shadow_radius"/>
        <!-- 阴影偏移 -->
        <attr format="reference|dimension" name="sb_shadow_offset"/>
        <!-- 阴影颜色 -->
        <attr format="reference|color" name="sb_shadow_color"/>
        <!-- 关闭颜色 -->
        <attr format="reference|color" name="sb_uncheck_color"/>
        <!-- 开启颜色 -->
        <attr format="reference|color" name="sb_checked_color"/>
        <!-- 边框宽度 -->
        <attr format="reference|dimension" name="sb_border_width"/>
        <!-- 开启指示器颜色 -->
        <attr format="reference|color" name="sb_checkline_color"/>
        <!-- 开启指示器线宽 -->
        <attr format="reference|dimension" name="sb_checkline_width"/>
        <!-- 关闭指示器颜色 -->
        <attr format="reference|color" name="sb_uncheckcircle_color"/>
        <!-- 关闭指示器线宽 -->
        <attr format="reference|dimension" name="sb_uncheckcircle_width"/>
        <!-- 关闭指示器半径 -->
        <attr format="reference|dimension" name="sb_uncheckcircle_radius"/>
        <!-- 是否选中 -->
        <attr format="reference|boolean" name="sb_checked"/>
        <!-- 是否启用阴影 -->
        <attr format="reference|boolean" name="sb_shadow_effect"/>
        <!-- 动画时间，默认300ms -->
        <attr format="reference|integer" name="sb_effect_duration"/>
        <!-- 按钮颜色 -->
        <attr format="reference|color" name="sb_button_color"/>
        <!-- 是否显示指示器，默认true：显示 -->
        <attr format="reference|boolean" name="sb_show_indicator"/>
        <!-- 背景色，默认白色 -->
        <attr format="reference|color" name="sb_background"/>
        <!-- 是否启用特效，默认true -->
        <attr format="reference|boolean" name="sb_enable_effect"/>
        
## 9.2、如何使用

    <com.xjj.AGUI.widget.AGUISwitchButton
        android:id="@+id/switchButton1"
        android:layout_width="70dp"
        android:layout_height="35dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"/>
        
        switchButton1.setOnCheckedChangeListener(new AGUISwitchButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(AGUISwitchButton view, boolean isChecked) {
                if (isChecked) {
                    showToast("打开", AGUIToast.TOAST_TYPE_NORMAL);
                } else {
                    showToast("关闭", AGUIToast.TOAST_TYPE_NORMAL);
                }
            }
        });
        
# 10、AGUITextDrawable 根据输入的字符串的第一个或最后一个字符生成一张图片

## 10.1、如何使用

    circleImageView = (AGUICircleImageView) findViewById(R.id.circleImageView);
    // 显示第一个字符
    circleImageView.setBackground(new AGUITextDrawable("LXK", getResources().getColor(R.color.colorPrimary), true));
    
## 10.2、api

    /**
     * 初始化TextDrawable
     *
     * @param name 需要显示的字符串
     * @param backgroundColor 设置背景色
     */
    public AGUITextDrawable(String name, int backgroundColor) {
        this(name, DEFAULT_TEXT_SIZE_PERCENTAGE, DEFAULT_PLACEHOLDER_STRING, backgroundColor, false);
    }

    /**
     * 初始化TextDrawable
     *
     * @param name 需要显示的字符串
     * @param backgroundColor 设置背景色
     * @param isFirst 是否显示第一个字母，默认显示最后一个
     */
    public AGUITextDrawable(String name, int backgroundColor, boolean isFirst) {
        this(name, DEFAULT_TEXT_SIZE_PERCENTAGE, DEFAULT_PLACEHOLDER_STRING, backgroundColor, isFirst);
    }

    /**
     * 初始化TextDrawable
     *
     * @param name 需要显示的字符串
     * @param backgroundColor 设置背景色
     * @param textSizePercentage 设置字母的大小
     * @param isFirst 是否显示第一个字母，默认显示最后一个
     */
    public AGUITextDrawable(String name, @IntRange int textSizePercentage, int backgroundColor, boolean isFirst) {
        this(name, textSizePercentage, DEFAULT_PLACEHOLDER_STRING, backgroundColor, isFirst);
    }

    /**
     * 初始化TextDrawable
     *
     * @param name 需要显示的字符串
     * @param backgroundColor 设置背景色
     * @param defaultString 默认显示
     * @param isFirst 是否显示第一个字母，默认显示最后一个
     */
    public AGUITextDrawable(String name, @NonNull String defaultString, int backgroundColor, boolean isFirst) {
        this(name, DEFAULT_TEXT_SIZE_PERCENTAGE, defaultString, backgroundColor, isFirst);
    }
    
    
# 11、TimePickerDialog 时间选择器
    
## 11.1、如何使用

        // 选择日期和时间
        new TimePickerDialog.Builder(TimePickerActivity.this).setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                        Date             date   = new Date(millseconds);
                        String           time   = format.format(date);
                        showToast(time, AGUIToast.TOAST_TYPE_NORMAL);
                    }
        }).setType(Type.ALL).build().show(TimePickerActivity.this.getSupportFragmentManager(), "all");
        
        // 选择日期
        new TimePickerDialog.Builder(TimePickerActivity.this).setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                        Date             date   = new Date(millseconds);
                        String           time   = format.format(date);
                        showToast(time, AGUIToast.TOAST_TYPE_NORMAL);
                    }
                }).setType(Type.YEAR_MONTH_DAY).build().show(TimePickerActivity.this.getSupportFragmentManager(), "date");
          
        // 选择时间      
        new TimePickerDialog.Builder(TimePickerActivity.this).setCallBack(new OnDateSetListener() {
                    @Override
                    public void onDateSet(TimePickerDialog timePickerView, long millseconds) {
                        SimpleDateFormat format = new SimpleDateFormat("HH:mm:ss");
                        Date             date   = new Date(millseconds);
                        String           time   = format.format(date);
                        showToast(time, AGUIToast.TOAST_TYPE_NORMAL);
                    }
                }).setType(Type.HOURS_MINS).build().show(TimePickerActivity.this.getSupportFragmentManager(), "time");
                
# 12、AGUISuperEditText
    一个可自动显示清除按钮和显示隐藏密码的edittext，可以通过xml自定义属性设置不同的样式。
    
## 12.1、自定义属性

        <!--清除按钮图片资源-->
        <attr format="reference" name="clearDrawable"/>
        <!--显示密码按钮图片资源-->
        <attr format="reference" name="visibleDrawable"/>
        <!--隐藏密码按钮图片资源-->
        <attr format="reference" name="invisibleDrawable"/>
        <!--按钮宽度大小-->
        <attr format="dimension" name="BtnWidth"/>
        <!-- 边框宽度 -->
        <attr format="dimension" name="stroke_width"/>
        <!--按钮间距大小-->
        <attr format="dimension" name="BtnSpacing"/>
        <!--边框颜色和样式-->
        <attr format="color" name="strokeColor"/>
        <attr format="enum" name="borderStyle">
            <enum name="rectangle" value="1"/>
            <enum name="halfRect" value="3"/>
            <enum name="roundRect" value="2"/>
            <enum name="animator" value="4"/>
            <enum name="normal" value="5"/>
        </attr>
        <!-- 是否显示清除按钮，默认显示 -->
        <attr format="reference|boolean" name="isShowClearBtn"/>
        
## 12.2、如何使用

    <com.xjj.AGUI.widget.AGUISuperEditText
        android:id="@+id/editText5"
        android:layout_width="300dp"
        android:layout_height="wrap_content"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="10dp"
        android:minHeight="40dp"
        android:paddingBottom="0dp"
        android:paddingStart="10dp"
        android:paddingTop="0dp"
        android:textColor="@color/colorPrimary"
        app:borderStyle="normal"
        app:isShowClearBtn="true"
        app:strokeColor="@color/config_color_red"
        app:stroke_width="2dp"/>
        
# 13、AGUISideBarView 边沿字符导航

## 13.1、自定义属性

        <!-- sidebar字体颜色 -->
        <attr format="color|reference" name="sidebarTextColor"/>
        <!-- sidebar背景色 -->
        <attr format="color|reference" name="sidebarBackgroundColor"/>
        <!-- sidebar选中字体颜色 -->
        <attr format="color|reference" name="sidebarChooseTextColor"/>
        <!-- sidebar字体大小 -->
        <attr format="dimension" name="sidebarTextSize"/>
        <!-- sidebar圆球字体大小 -->
        <attr format="dimension" name="sidebarLargeTextSize"/>
        <!-- sidebar半径 -->
        <attr format="dimension" name="sidebarRadius"/>
        <!-- sidebar圆球半径 -->
        <attr format="dimension" name="sidebarBallRadius"/>
        
## 13.2、如何使用

    // xml中
    <com.xjj.AGUI.widget.AGUISideBarView
        android:id="@+id/sideBar"
        android:layout_width="match_parent"
        android:layout_height="match_parent"/>
      
    // java代码中设置监听  
    sideBar.setOnTouchLetterChangeListener(new AGUISideBarView.OnTouchLetterChangeListener() {
            @Override
            public void onLetterChange(String letter) {
                showToast(letter, AGUIToast.TOAST_TYPE_NORMAL);
            }
    });
    
# 14、AGUISeekBar

    这是一个可以支持显示进度气泡的seekbar，并且支持自定义进度条颜色、大小等属性。
    
## 14.1、自定义属性

        <!-- 设置最小值, default: 0.0f-->
        <attr format="float|reference" name="bsb_min"/>
        <!-- 设置最大值, default: 100.0f-->
        <attr format="float|reference" name="bsb_max"/>
        <!-- 设置当前进度值, default: min-->
        <attr format="float|reference" name="bsb_progress"/>
        <!-- 气泡显示支持浮点数显示，默认不支持 -->
        <attr format="boolean" name="bsb_is_float_type"/>
        <!-- 进度条高度, default: 2dp -->
        <attr format="dimension|reference" name="bsb_track_size"/>
        <!-- 二级进度条高度, default: 2dp higher than right-track's height-->
        <attr format="dimension|reference" name="bsb_second_track_size"/>
        <!-- 滑块半径, default: 2dp higher than left-track's height-->
        <attr format="dimension|reference" name="bsb_thumb_radius"/>
        <!-- 拖拽时滑块半径, default: 2 times of left-track's height-->
        <attr format="dimension|reference" name="bsb_thumb_radius_on_dragging"/>
        <!-- 进度条颜色, default: R.color.colorPrimary-->
        <attr format="color|reference" name="bsb_track_color"/>
        <!-- 二级进度条颜色, default: R.color.colorAccent-->
        <attr format="color|reference" name="bsb_second_track_color"/>
        <!-- 滑块颜色, default: same as left-track's color-->
        <attr format="color|reference" name="bsb_thumb_color"/>
        <!-- 滑块进度显示字体大小, default: 14sp-->
        <attr format="dimension|reference" name="bsb_thumb_text_size"/>
        <!-- 是否在滑块底部显示实时进度, default: false-->
        <attr format="boolean" name="bsb_show_thumb_text"/>
        <!-- 底部滑块实时进度显示字体颜色, default: same as left-track's color-->
        <attr format="color|reference" name="bsb_thumb_text_color"/>
        <!-- 气泡颜色, default: same as left-track's color-->
        <attr format="color|reference" name="bsb_bubble_color"/>
        <!--气泡显示实时进度字体大小, default: 14sp-->
        <attr format="dimension|reference" name="bsb_bubble_text_size"/>
        <!--气泡显示实时进度字体颜色, default: #ffffffff-->
        <attr format="color|reference" name="bsb_bubble_text_color"/>
        <!--动画时长, default: 200ms-->
        <attr format="integer" name="bsb_anim_duration"/>
        <!--始终显示气泡, default: false-->
        <attr format="boolean" name="bsb_always_show_bubble"/>
        <!--延时显示气泡, default: 200ms-->
        <attr format="integer" name="bsb_always_show_bubble_delay"/>
        <!--隐藏气泡, default: false-->
        <attr format="boolean" name="bsb_hide_bubble"/>
        <!--使能进度条, default: false-->
        <attr name="android:enabled"/>
        <!--使能触摸任意位置设置进度, default: false-->
        <attr format="boolean" name="bsb_touch_to_seek"/>
        
## 14.2、如何使用

    // xml
    <com.xjj.AGUI.widget.seekbar.AGUISeekBar
        android:id="@+id/seekBar"
        android:layout_width="300dp"
        android:layout_height="16dp"
        android:layout_gravity="center_horizontal"
        android:layout_marginTop="70dp"
        android:enabled="true"
        app:bsb_always_show_bubble="false"
        app:bsb_bubble_color="@color/colorPrimary"
        app:bsb_max="100"
        app:bsb_thumb_color="@color/colorPrimary"
        app:bsb_touch_to_seek="true"
        app:bsb_second_track_color="@color/config_color_black"
        app:bsb_second_track_size="3dp"
        app:bsb_is_float_type="true"
        app:bsb_show_thumb_text="true"/>
        
    seekBar.setOnProgressChangedListener(new AGUISeekBar.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(AGUISeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }

            @Override
            public void getProgressOnActionUp(AGUISeekBar bubbleSeekBar, int progress, float progressFloat) {
                showToast(String.valueOf(progress), AGUIToast.TOAST_TYPE_NORMAL);
            }

            @Override
            public void getProgressOnFinally(AGUISeekBar bubbleSeekBar, int progress, float progressFloat, boolean fromUser) {

            }
        });
        
# 15、AGUIBottomNavLayout 底部导航栏

    支持动态添加tab，每个tab可分别设置名称、图标的选中和未选中状态，可根据实际需求是否显示角标或小红点，图标支持网络地址。
    
## 15.1、如何使用

    // xml
    <com.xjj.AGUI.layout.AGUIBottomNavLayout
        android:id="@+id/tabview"
        android:layout_width="match_parent"
        android:layout_height="60dp"
        android:layout_alignParentBottom="true"/>
        
    // java
    // 设置tab数据源，分别指定各个tab的名称、未选中和选中的图标
    List<BottomNavTab> navTabs = new ArrayList<>();
    navTabs.add(new BottomNavTab("附近", "https://ss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=3684637897,1666891143&fm=26&gp=0.jpg", "https://ss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=3452337509,3387281103&fm=26&gp=0.jpg"));
    navTabs.add(new BottomNavTab("动态", R.mipmap.icon_nearby, R.mipmap.icon_nearby_selected));
    navTabs.add(new BottomNavTab("消息", R.mipmap.icon_nearby, R.mipmap.icon_nearby_selected));
    navTabs.add(new BottomNavTab("发现", R.mipmap.icon_nearby, R.mipmap.icon_nearby_selected));
    navTabs.add(new BottomNavTab("我的", R.mipmap.icon_nearby, R.mipmap.icon_nearby_selected));
    // 初始化
    tabLayoutView.setDataSource(navTabs, 0);
    tabLayoutView.setTabIconStyle(25, 25);
    tabLayoutView.setTabNameStyle(12, R.color.config_color_gray_3, R.color.colorPrimary);
    tabLayoutView.build(); // 必须调用
    // 设置角标
    tabLayoutView.setBadgeCount(0, 100);
    tabLayoutView.setBadgeCount(1, 0);
    tabLayoutView.setBadgeCount(2, 3);
    tabLayoutView.setBadgeCount(3, 0);
    tabLayoutView.setRedDots(4, true);
    
## 15.2、api说明

    setDataSource(List<BottomNavTab> tabs, int currentIndex) // 设置数据源及默认选中的tab索引
    setTabIconStyle(int imgwidth, int imgheight) // 设置tab图标宽高
    setTabNameStyle(int txtsize, int txtColor, int txtSelectedColor) // 设置tab名称的字体大小、颜色及选中的颜色
    setSelectedTab(int index) // 设置选中的tab
    setBadgeCount(int index, int count) // 设置tab的角标
    setRedDots(int index, boolean isShow) // 设置tab是否显示小红点
    setOnItemOnclickListener(OnItemOnclickListener onItemOnclickListener) // 设置tab的点击监听
    
    
# 16、AGUITabLayout

    标签切换指示条支持动画效果，支持原生的Tablayout属性，需和Viewpager配合使用。
    
## 16.1、自定义属性

        <!-- 指示器动画开始的颜色 -->
        <attr format="color|reference" name="indicatorStartColor"/>
        <!-- 指示器结束的颜色 -->
        <attr format="color|reference" name="indicatorEndColor"/>
        <!-- 指示器左边margin -->
        <attr format="dimension|reference" name="indicatorMarginStart"/>
        <!-- 指示器右边margin -->
        <attr format="dimension|reference" name="indicatorMarginEnd"/>
        <!-- 指示器底部margin -->
        <attr format="dimension|reference" name="indicatorMarginBottom"/>
        
## 16.2、如何使用

    // xml
    <com.xjj.AGUI.layout.tablayout.AGUITabLayout
        android:id="@+id/tablayout"
        android:layout_width="match_parent"
        android:layout_height="40dp"
        android:layout_gravity="center_horizontal"
        app:indicatorEndColor="@color/colorPrimary"
        app:indicatorMarginBottom="0dp"
        app:indicatorMarginEnd="30dp"
        app:indicatorMarginStart="30dp"
        app:indicatorStartColor="@color/colorPrimary"
        app:tabBackground="@android:color/white"
        app:tabGravity="center"
        app:tabIndicatorHeight="3dp"
        app:tabMode="scrollable"
        app:tabSelectedTextColor="@color/colorPrimary"/>
        
    // java
    fragmentPages = new ArrayList<>();
    fragmentPage1 = new FragmentPage();
    fragmentPage2 = new FragmentPage();
    fragmentPage3 = new FragmentPage();
    fragmentPage4 = new FragmentPage();
    fragmentPage5 = new FragmentPage();

    fragmentPages.add(fragmentPage1);
    fragmentPages.add(fragmentPage2);
    fragmentPages.add(fragmentPage3);
    fragmentPages.add(fragmentPage4);
    fragmentPages.add(fragmentPage5);

    ArrayList<String> titles = new ArrayList<>();
    titles.add("附近");
    titles.add("发现");
    titles.add("你的");
    titles.add("我的");
    titles.add("他的");

    viewPagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), fragmentPages, titles);
    viewPager.setAdapter(viewPagerAdapter);
    // adpter
    public class ViewPagerAdapter extends FragmentPagerAdapter {
        private List<String> mTitles;
        private List<Fragment> fragments;

        public ViewPagerAdapter(FragmentManager fm, List<Fragment> fragments, List<String> list_Title) {
            super(fm);
            this.fragments = fragments;
            this.mTitles = list_Title;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }

        @Nullable
        @Override
        public CharSequence getPageTitle(int position) {
            if (mTitles != null && mTitles.size() > 0) {
                return mTitles.get(position % mTitles.size());
            } else {
                return "";
            }
        }
    }
    
# 17、AGUIPageIndicatorView

    页面指示器，支持自定义小圆点的颜色、大小、动画效果等，需配合Viewpager使用。
    
## 17.1、自定义属性

        <!-- 指示器方向 -->
        <attr name="piv_orientation">
            <enum name="horizontal" value="0"/>
            <enum name="vertical" value="1"/>
        </attr>
        <!-- 为指示器绑定viewpager的id，绑定之后则无需在代码中设置 -->
        <attr format="reference" name="piv_viewPager"/>
        <!-- 默认选中的页面位置 -->
        <attr format="integer" name="piv_select"/>
        <!-- 指示器的个数 -->
        <attr format="integer" name="piv_count"/>
        <!-- 指示器是否使用动画效果 -->
        <attr format="boolean" name="piv_dynamicCount"/>
        <!-- 指示器的半径 -->
        <attr format="dimension" name="piv_radius"/>
        <!-- 指示器内边距 -->
        <attr format="dimension" name="piv_padding"/>
        <!-- 指示器边框宽度 -->
        <attr format="dimension" name="piv_strokeWidth"/>
        <!-- 指示器缩放因子 -->
        <attr format="float" name="piv_scaleFactor"/>
        <attr format="boolean" name="piv_autoVisibility"/>
        <!-- 指示器未选中的颜色 -->
        <attr format="color" name="piv_unselectedColor"/>
        <!-- 指示器选中的颜色 -->
        <attr format="color" name="piv_selectedColor"/>

        <attr format="boolean" name="piv_fadeOnIdle"/>
        <attr format="integer" name="piv_idleDuration"/>

        <attr format="boolean" name="piv_interactiveAnimation"/>
        <!-- 指示器动画时长 -->
        <attr format="integer" name="piv_animationDuration"/>
        <!-- 指示器动画类型 -->
        <attr name="piv_animationType">
            <enum name="none" value="0"/>
            <enum name="color" value="1"/>
            <enum name="scale" value="2"/>
            <enum name="worm" value="3"/>
            <enum name="slide" value="4"/>
            <enum name="fill" value="5"/>
            <enum name="thinWorm" value="6"/>
            <enum name="drop" value="7"/>
            <enum name="swap" value="8"/>
            <enum name="scale_down" value="9"/>
        </attr>
        <attr name="piv_rtl_mode">
            <enum name="on" value="0"/>
            <enum name="off" value="1"/>
            <enum name="auto" value="2"/>
        </attr>
        
# 17.2、如何使用

    // xml
    <com.xjj.AGUI.widget.pageIndicator.AGUIPageIndicatorView
        android:id="@+id/pageIndicatorView"
        android:layout_width="wrap_content"
        android:layout_height="wrap_content"
        android:layout_alignParentBottom="true"
        android:layout_centerHorizontal="true"
        android:layout_marginBottom="20dp"
        app:piv_animationDuration="200"
        app:piv_animationType="thinWorm"
        app:piv_dynamicCount="true"
        app:piv_interactiveAnimation="true"
        app:piv_selectedColor="@color/colorPrimary"
        app:piv_unselectedColor="@color/config_color_gray_5"
        app:piv_viewPager="@+id/viewpager"
        attrs:piv_padding="10dp"
        attrs:piv_radius="8dp"/>
    由于指定了Viewpager的id（app:piv_viewPager="@+id/viewpager"），可以无需在代码中页面切换时调用setSelected(int position)和setCount(int count)，当然
    如果不在xml中指定Viewpager，也可以在代码中进行设置setViewPager(@Nullable ViewPager pager)。
    
## 17.3、常用api使用说明

    setViewPager(@Nullable ViewPager pager) // 设置需联动的Viewpager
    setSelected(int position) // 设置选中的位置
    setClickListener(@Nullable DrawController.ClickListener listener) // 设置小圆点的点击事件监听
    setCount(int count) // 设置小圆点的数量
    
# 18、AGUIFlowLayout 流式布局

## 18.1、自定义属性

        <!-- 是否使用流式布局，默认开启 -->
        <attr format="boolean" name="flFlow"/>
        <!-- 每个子view的水平间距，默认0dp -->
        <attr format="enum|dimension" name="flChildSpacing">
            <enum name="auto" value="-65536"/>
        </attr>
        <!-- 子view间最小的水平间距 -->
        <attr format="dimension" name="flMinChildSpacing"/>
        <!-- 最后一行子view的水平间距，默认为自适应，如果不设置将使用 flChildSpacing 的值 -->
        <attr format="enum|dimension" name="flChildSpacingForLastRow">
            <enum name="auto" value="-65536"/>
            <enum name="align" value="-65537"/>
        </attr>
        <!-- 行间距-->
        <attr format="enum|dimension" name="flRowSpacing">
            <enum name="auto" value="-65536"/>
        </attr>
        <!-- 设置排列方向，true则从右到左排列，反之则从左到右排列 -->
        <attr format="boolean" name="flRtl"/>
        <!-- 最大行数 -->
        <attr format="integer" name="flMaxRows"/>
        <!-- 垂直位置 -->
        <attr format="enum" name="flRowVerticalGravity">
            <enum name="auto" value="-65536"/>
            <enum name="top" value="0x30"/>
            <enum name="center" value="0x10"/>
            <enum name="bottom" value="0x50"/>
        </attr>
        <attr name="android:gravity"/>
        
## 18.2、如何使用

    <com.xjj.AGUI.layout.AGUIFlowLayout
        android:id="@+id/flowLayout"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        app:flChildSpacing="auto"
        app:flFlow="true"
        app:flChildSpacingForLastRow="align"
        app:flRowSpacing="10dp"
        app:flMaxRows="3"
        app:flMinChildSpacing="5dp"
        app:flRowVerticalGravity="center"
        app:flRtl="false">

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="计算"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="技术"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="间术"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="技回家"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="技回家"/>

        <Button
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:text="技回家时"/>
    </com.xjj.AGUI.layout.AGUIFlowLayout>
    
# 19、AGUIToast 吐司

## 19.1、类型

    /** 通用式 */
    public final static int TOAST_TYPE_NORMAL = 1;
    /** 警告式 */
    public final static int TOAST_TYPE_WARNING = 2;
    /** 成功式 */
    public final static int TOAST_TYPE_SUCCESS = 3;
    /** 错误式 */
    public final static int TOAST_TYPE_ERROR = 4;
    /** 信息式 */
    public final static int TOAST_TYPE_INFO = 5;
    
## 19.2、如何使用

    AGUIToast.normal(getApplicationContext(), "normal");
    AGUIToast.info(getApplicationContext(), "info");
    AGUIToast.error(getApplicationContext(), "error");
    AGUIToast.warning(getApplicationContext(), "warning");
    AGUIToast.success(getApplicationContext(), "success");
    AGUIToast.showToast(getApplicationContext(), "success", AGUIToast.TOAST_TYPE_SUCCESS);
    
# 20、AGUIEmptyView

    这是一个方便在数据加载时通过不同的加载状态来显示不同的view，如加载失败、网络异常等，如果内置的view类型不满足需求，则可以使用自定义布局。
    
## 20.1、自定义属性

        <!-- 正在加载布局 -->
        <attr format="reference" name="loading"/>
        <!-- 网络错误布局 -->
        <attr format="reference" name="network_poor"/>
        <!-- 数据为空布局 -->
        <attr format="reference" name="empty"/>
        <!-- 错误布局 -->
        <attr format="reference" name="error"/>
        <!-- 自定义布局 -->
        <attr format="reference" name="specified"/>
        
## 20.2、如何使用

    /**
     * 默认的 view 的类型
     */
    public class ViewType {
        // 加载中视图
        public static final int TYPE_LOADING      = 0x01;
        // 网络异常视图
        public static final int TYPE_NETWORK_POOR = 0x02;
        // 空数据视图
        public static final int TYPE_EMPTY        = 0x03;
        // 页面加载失败视图
        public static final int TYPE_ERROR        = 0x04;
        // 自定义视图
        public static final int TYPE_SPECIFIED    = 0x05;
    }

    // xml
    <com.xjj.AGUI.layout.emptyview.AGUIEmptyView
        android:id="@+id/emptyView"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:layout_below="@+id/titleBar"/>
        
    // java
    emptyView.showView(AGUIEmptyView.ViewType.TYPE_NETWORK_POOR, this);
    emptyView.showView(AGUIEmptyView.ViewType.TYPE_EMPTY);
    emptyView.showView(AGUIEmptyView.ViewType.TYPE_ERROR, this);
    emptyView.showView(AGUIEmptyView.ViewType.TYPE_LOADING);
    emptyView.dimiss(); // 隐藏
    同时实现ViewHandler接口，在点击重试时实现自己的业务逻辑。
    
# 20、AGUIBadgeView

    支持设置角标、小红点、可拖拽清除角标，注意不能在xml中使用。
    
## 20.1、如何使用

        // 设置角标
        AGUIBadgeView badgeView2 = new AGUIBadgeView(this);
        badgeView2.bindTarget(imageView);
        badgeView2.setBadgeNumber(200).setBadgeGravity(Gravity.TOP | Gravity.END).setGravityOffset(0, true);
        // 设置小红点
        AGUIBadgeView badgeView3 = new AGUIBadgeView(this);
        badgeView3.bindTarget(imageView1);
        badgeView3.setBadgeText("").setBadgeGravity(Gravity.TOP | Gravity.END).setGravityOffset(10, 3, true);
        // 设置可拖拽的
        AGUIBadgeView badgeView4 = new AGUIBadgeView(this);
        badgeView4.bindTarget(imageView2);
        badgeView4.setBadgeText("NEW").setBadgeGravity(Gravity.TOP | Gravity.END).setGravityOffset(0, 0, true).setOnDragStateChangedListener(new Badge.OnDragStateChangedListener() {
            @Override
            public void onDragStateChanged(int dragState, Badge badge, View targetView) {
                if ( dragState == Badge.OnDragStateChangedListener.STATE_SUCCEED) {
                    AGUIToast.success(getApplicationContext(), "清除成功");
                }
            }
        });
        
## 20.2、常用api说明

    bindTarget(final View targetView) // 绑定需显示角标的目标view
    hide(boolean animate) // 隐藏角标
    setBadgeNumber(int badgeNumber) // 设置角标数量
    setBadgeText(String badgeText) // 设置角标字符串
    setExactMode(boolean isExact) // 设置是否显示真实数量，默认超过100则显示99+
    setShowShadow(boolean showShadow) // 是否支持阴影效果
    setBadgeBackgroundColor(int color) // 设置角标背景色
    stroke(int color, float width, boolean isDpValue) // 设置角标边框
    setBadgeTextColor(int color) // 设置角标字体颜色
    setBadgeTextSize(float size, boolean isSpValue) // 设置角标字体大小
    setBadgePadding(float padding, boolean isDpValue) // 设置角标内边距
    setBadgeGravity(int gravity) // 设置角标显示的位置，仅支持 Gravity.START | Gravity.TOP , Gravity.END | Gravity.TOP ,Gravity.START | Gravity.BOTTOM , Gravity.END | Gravity.BOTTOM ,Gravity.CENTER , Gravity.CENTER | Gravity.TOP , Gravity.CENTER | Gravity.BOTTOM ,Gravity.CENTER | Gravity.START , Gravity.CENTER | Gravity.END
    setGravityOffset(float offsetX, float offsetY, boolean isDpValue) // 设置角标偏移量
    setOnDragStateChangedListener(OnDragStateChangedListener l) // 监听角标拖拽状态，如需支持拖拽需设置此监听器
