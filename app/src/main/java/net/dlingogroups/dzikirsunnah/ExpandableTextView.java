package net.dlingogroups.dzikirsunnah;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.SpannableStringBuilder;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;
/**
 * User: Bazlur Rahman Rokon
 * Date: 9/7/13 - 3:33 AM
 */
public class ExpandableTextView extends TextView implements View.OnClickListener
{
    private static final int MAX_LINES = 1;
    private int currentMaxLines = Integer.MAX_VALUE;

    public ExpandableTextView(Context context)
    {
        super(context);
        setOnClickListener(this);
    }
    public ExpandableTextView(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
        setOnClickListener(this);
    }

    public ExpandableTextView(Context context, AttributeSet attrs)
    {
        super(context, attrs);
        setOnClickListener(this);
    }

    @Override
    protected void onTextChanged(CharSequence text, int start, int lengthBefore, int lengthAfter)
    {
        /* If text longer than MAX_LINES set DrawableBottom - I'm using '...' icon */
        post(new Runnable()
        {
            public void run()
            {
                if (getLineCount()>MAX_LINES)
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, R.drawable.moreicon, 0);
                else
                    setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);

                setMaxLines(MAX_LINES);
            }
        });
    }


    @Override
    public void setMaxLines(int maxLines)
    {
        currentMaxLines = maxLines;
        super.setMaxLines(maxLines);
    }

    /* Custom method because standard getMaxLines() requires API > 16 */
    public int getMyMaxLines()
    {
        return currentMaxLines;
    }

    @Override
    public void onClick(View v)
    {
        /* Toggle between expanded collapsed states */
        if (getMyMaxLines() == Integer.MAX_VALUE)
            setMaxLines(MAX_LINES);
        else
            setMaxLines(Integer.MAX_VALUE);
    }

}
//public class ExpandableTextView extends android.support.v7.widget.AppCompatTextView {
//    private static final int DEFAULT_TRIM_LENGTH = 200;
//    private static final String ELLIPSIS = ".....";
//
//    private CharSequence originalText;
//    private CharSequence trimmedText;
//    private BufferType bufferType;
//    private boolean trim = true;
//    private int trimLength;
//
//    public ExpandableTextView(Context context) {
//        this(context, null);
//    }
//
//    public ExpandableTextView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//
//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.ExpandableTextView);
//        this.trimLength = typedArray.getInt(R.styleable.ExpandableTextView_trimLength, DEFAULT_TRIM_LENGTH);
//        typedArray.recycle();
//
//        setOnClickListener(new OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                trim = !trim;
//                setText();
//                requestFocusFromTouch();
//            }
//        });
//    }
//
//    private void setText() {
//        super.setText(getDisplayableText(), bufferType);
//    }
//
//    private CharSequence getDisplayableText() {
//        return trim ? trimmedText : originalText;
//    }
//
//    @Override
//    public void setText(CharSequence text, BufferType type) {
//        originalText = text;
//        trimmedText = getTrimmedText(text);
//        bufferType = type;
//        setText();
//    }
//
//    private CharSequence getTrimmedText(CharSequence text) {
//        if (originalText != null && originalText.length() > trimLength) {
//            return new SpannableStringBuilder(originalText, 0, trimLength + 1).append(ELLIPSIS);
//        } else {
//            return originalText;
//        }
//    }
//
//    public CharSequence getOriginalText() {
//        return originalText;
//    }
//
//    public void setTrimLength(int trimLength) {
//        this.trimLength = trimLength;
//        trimmedText = getTrimmedText(originalText);
//        setText();
//    }
//
//    public int getTrimLength() {
//        return trimLength;
//    }
//}