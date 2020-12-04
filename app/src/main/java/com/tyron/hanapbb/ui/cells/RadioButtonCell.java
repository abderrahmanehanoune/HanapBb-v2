package com.tyron.hanapbb.ui.cells;

import android.content.Context;
import android.graphics.Canvas;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.View;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.FrameLayout;
import android.widget.TextView;

import com.tyron.hanapbb.messenger.AndroidUtilities;
import com.tyron.hanapbb.ui.actionbar.BottomSheet;
import com.tyron.hanapbb.ui.actionbar.Theme;
import com.tyron.hanapbb.ui.components.LayoutHelper;
import com.tyron.hanapbb.ui.components.RadioButton;


public class RadioButtonCell extends FrameLayout {

    private TextView textView;
    private TextView valueTextView;
    private RadioButton radioButton;
    private boolean needDivider;

    public RadioButtonCell(Context context) {
        this(context, false);
    }

    public RadioButtonCell(Context context, boolean dialog) {
        super(context);

        radioButton = new RadioButton(context);
        radioButton.setSize(AndroidUtilities.dp(20));
        if (dialog) {
            radioButton.setColor(Theme.getColor(Theme.key_dialogRadioBackground), Theme.getColor(Theme.key_dialogRadioBackgroundChecked));
        } else {
            radioButton.setColor(Theme.getColor(Theme.key_radioBackground), Theme.getColor(Theme.key_radioBackgroundChecked));
        }
        addView(radioButton, LayoutHelper.createFrame(22, 22, (BottomSheet.LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, (BottomSheet.LocaleController.isRTL ? 0 : 20), 10, (BottomSheet.LocaleController.isRTL ? 20 : 0), 0));

        textView = new TextView(context);
        if (dialog) {
            textView.setTextColor(Theme.getColor(Theme.key_dialogTextBlack));
        } else {
            textView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteBlackText));
        }
        textView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 16);
        textView.setLines(1);
        textView.setMaxLines(1);
        textView.setSingleLine(true);
        textView.setGravity((BottomSheet.LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.CENTER_VERTICAL);
        addView(textView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, (BottomSheet.LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, (BottomSheet.LocaleController.isRTL ? 23 : 61), 10, (BottomSheet.LocaleController.isRTL ? 61 : 23), 0));

        valueTextView = new TextView(context);
        if (dialog) {
            valueTextView.setTextColor(Theme.getColor(Theme.key_dialogTextGray2));
        } else {
            valueTextView.setTextColor(Theme.getColor(Theme.key_windowBackgroundWhiteGrayText2));
        }
        valueTextView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, 13);
        valueTextView.setGravity(BottomSheet.LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT);
        valueTextView.setLines(0);
        valueTextView.setMaxLines(0);
        valueTextView.setSingleLine(false);
        valueTextView.setPadding(0, 0, 0, AndroidUtilities.dp(12));
        addView(valueTextView, LayoutHelper.createFrame(LayoutHelper.WRAP_CONTENT, LayoutHelper.WRAP_CONTENT, (BottomSheet.LocaleController.isRTL ? Gravity.RIGHT : Gravity.LEFT) | Gravity.TOP, (BottomSheet.LocaleController.isRTL ? 17 : 61), 35, (BottomSheet.LocaleController.isRTL ? 61 : 17), 0));
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(MeasureSpec.makeMeasureSpec(MeasureSpec.getSize(widthMeasureSpec), MeasureSpec.EXACTLY), View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));
    }

    public void setTextAndValue(String text, String value, boolean divider, boolean checked) {
        textView.setText(text);
        valueTextView.setText(value);
        radioButton.setChecked(checked, false);
        needDivider = divider;
    }

    public void setChecked(boolean checked, boolean animated) {
        radioButton.setChecked(checked, animated);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (needDivider) {
            canvas.drawLine(AndroidUtilities.dp(BottomSheet.LocaleController.isRTL ? 0 : 60), getHeight() - 1, getMeasuredWidth() - AndroidUtilities.dp(BottomSheet.LocaleController.isRTL ? 60 : 0), getHeight() - 1, Theme.dividerPaint);
        }
    }

    @Override
    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo info) {
        super.onInitializeAccessibilityNodeInfo(info);
        info.setClassName("android.widget.RadioButton");
        info.setCheckable(true);
        info.setChecked(radioButton.isChecked());
    }
}
