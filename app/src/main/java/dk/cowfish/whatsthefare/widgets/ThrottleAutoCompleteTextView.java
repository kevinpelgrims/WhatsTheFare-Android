package dk.cowfish.whatsthefare.widgets;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.util.AttributeSet;
import android.widget.AutoCompleteTextView;

public class ThrottleAutoCompleteTextView extends AutoCompleteTextView {
    public ThrottleAutoCompleteTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    private final Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            ThrottleAutoCompleteTextView.super.performFiltering((CharSequence) msg.obj, msg.arg1);
        }
    };

    @Override
    protected void performFiltering(CharSequence text, int keyCode) {
        handler.removeMessages(0);
        handler.sendMessageDelayed(handler.obtainMessage(0, keyCode, 0, text), 500);
    }
}