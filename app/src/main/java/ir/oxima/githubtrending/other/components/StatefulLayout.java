package ir.oxima.githubtrending.other.components;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.StringRes;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.TextView;

import ir.oxima.githubtrending.R;


public class StatefulLayout extends FrameLayout {

	public static final String SAVED_INSTANCE_STATE = "instanceState";
	private static final String SAVED_STATE = "stateful_layout_state";
	private int mCustomEmptyDrawableId = 0;
	private int mCustomOfflineDrawableId = 0;
	private State mInitialState;
	private String mCustomEmptyText;
	private String mCustomOfflineText;
	private View mOfflineView, mEmptyView, mProgressView;
	private State mState = null;
	private View mContent;
	private FrameLayout mContainerProgress, mContainerOffline, mContainerEmpty;
	private ViewGroup prg_loading_top, prg_loading_bottom;
	private ProgressBar prg_loading_center;
	private TextView mDefaultEmptyText, mDefaultOfflineText;
	private OnStateChangeListener mOnStateChangeListener;
	private boolean mInitialized;
	private boolean showContent;


	public enum State {
		CONTENT(0), PROGRESSCENTER(1), PROGRESSBOTTOM(2), PROGRESSTOP(3), OFFLINE(4), EMPTY(5);
		int mValue;


		static State fromValue(int value) {
			State[] values = State.values();
			return values[value];
		}


		State(int value) {
			mValue = value;
		}


		public int getValue() {
			return mValue;
		}
	}


	public interface OnStateChangeListener {
		void onStateChange(View v, State state);
	}


	public StatefulLayout(Context context) {
		this(context, null);
	}


	public StatefulLayout(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}


	public StatefulLayout(Context context, AttributeSet attrs, int defStyleAttr) {
		super(context, attrs, defStyleAttr);

		TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.StatefulLayout);
		mOfflineView = LayoutInflater.from(context).inflate(a.getResourceId(R.styleable.StatefulLayout_offlineLayout, R.layout.default_placeholder_offline), null);
		mEmptyView = LayoutInflater.from(context).inflate(a.getResourceId(R.styleable.StatefulLayout_emptyLayout, R.layout.default_placeholder_empty), null);
		mProgressView = LayoutInflater.from(context).inflate(a.getResourceId(R.styleable.StatefulLayout_progressLayout, R.layout.default_placeholder_progress), null);
		prg_loading_top = (ViewGroup) mProgressView.findViewById(R.id.prg_loading_top);
		prg_loading_center = (ProgressBar) mProgressView.findViewById(R.id.prg_loading_center);
		prg_loading_bottom = (ViewGroup) mProgressView.findViewById(R.id.prg_loading_bottom);
		// get custom texts if set
		if(a.hasValue(R.styleable.StatefulLayout_emptyText))
			mCustomEmptyText = a.getString(R.styleable.StatefulLayout_emptyText);
		if(a.hasValue(R.styleable.StatefulLayout_offlineText))
			mCustomOfflineText = a.getString(R.styleable.StatefulLayout_offlineText);

		// get initial state if set
		if(a.hasValue(R.styleable.StatefulLayout_state)) {
			mInitialState = State.fromValue(a.getInt(R.styleable.StatefulLayout_state, State.CONTENT.getValue()));
		}

		if(a.hasValue(R.styleable.StatefulLayout_offlineImageDrawable)) {
			mCustomOfflineDrawableId = a.getResourceId(R.styleable.StatefulLayout_offlineImageDrawable, 0);
		}

		if(a.hasValue(R.styleable.StatefulLayout_emptyImageDrawable)) {
			mCustomEmptyDrawableId = a.getResourceId(R.styleable.StatefulLayout_emptyImageDrawable, 0);
		}

		a.recycle();
	}


	public void setEmptyText(@StringRes int resourceId) {
		setEmptyText(getResources().getString(resourceId));
	}


	public void setEmptyText(CharSequence emptyText) {
		if(mDefaultEmptyText != null)
			mDefaultEmptyText.setText(emptyText);
	}


	public void setOfflineText(@StringRes int resourceId) {
		setOfflineText(getResources().getString(resourceId));
	}


	public void setOfflineText(CharSequence offlineText) {
		if(mDefaultOfflineText != null)
			mDefaultOfflineText.setText(offlineText);
	}


	public void showContent() {
		setState(State.CONTENT);
	}


	public void showProgressCenter() {
		setState(State.PROGRESSCENTER);
	}

	public void showProgressTop(boolean showContent) {
		this.showContent = showContent;
		setState(State.PROGRESSTOP);
	}

	public void showProgressBottom(boolean showContent) {
		this.showContent = showContent;
		setState(State.PROGRESSBOTTOM);
	}

	public void showOffline() {
		setState(State.OFFLINE);
	}


	public void showEmpty() {
		setState(State.EMPTY);
	}


	public State getState() {
		return mState;
	}


	public void setState(State state) {
		mState = state;
		if(mContent != null)
			mContent.setVisibility((state == State.CONTENT || (state == State.PROGRESSBOTTOM && showContent) || (state == State.PROGRESSTOP && showContent) ) ? View.VISIBLE : View.GONE);
		if(mContainerProgress != null){
			mContainerProgress.setVisibility((state == State.PROGRESSCENTER || state == State.PROGRESSBOTTOM || state == State.PROGRESSTOP ) ? View.VISIBLE : View.GONE);
			if(state == State.PROGRESSCENTER){
				prg_loading_bottom.setVisibility(View.GONE);
				prg_loading_top.setVisibility(View.GONE);
				prg_loading_center.setVisibility(View.VISIBLE);
			}

			if(state == State.PROGRESSTOP){
				prg_loading_bottom.setVisibility(View.GONE);
				prg_loading_top.setVisibility(View.VISIBLE);
				prg_loading_center.setVisibility(View.GONE);
			}

			if(state == State.PROGRESSBOTTOM){
				prg_loading_bottom.setVisibility(View.VISIBLE);
				prg_loading_top.setVisibility(View.GONE);
				prg_loading_center.setVisibility(View.GONE);
			}
		}
		if(mContainerOffline != null)
			mContainerOffline.setVisibility(state == State.OFFLINE ? View.VISIBLE : View.GONE);
		if(mContainerEmpty != null)
			mContainerEmpty.setVisibility(state == State.EMPTY ? View.VISIBLE : View.GONE);

		if(mOnStateChangeListener != null) mOnStateChangeListener.onStateChange(this, state);
	}


	public void setOnStateChangeListener(OnStateChangeListener listener) {
		mOnStateChangeListener = listener;
	}


	@Override
	protected void onFinishInflate() {
		super.onFinishInflate();
		if(!mInitialized)
			initialize();
	}


	@Override
	protected Parcelable onSaveInstanceState() {
		Bundle bundle = new Bundle();
		bundle.putParcelable(SAVED_INSTANCE_STATE, super.onSaveInstanceState());
		saveInstanceState(bundle);
		return bundle;
	}


	@Override
	protected void onRestoreInstanceState(Parcelable state) {
		if(state instanceof Bundle) {
			Bundle bundle = (Bundle) state;
			restoreInstanceState(bundle);
			state = bundle.getParcelable(SAVED_INSTANCE_STATE);
		}
		super.onRestoreInstanceState(state);
	}


	public void saveInstanceState(Bundle outState) {
		if(mState != null)
			outState.putInt(SAVED_STATE, mState.getValue());
	}


	public State restoreInstanceState(Bundle savedInstanceState) {
		State state = State.fromValue(savedInstanceState.getInt(SAVED_STATE));
		setState(state);
		return state;
	}


	@Override
	protected void onAttachedToWindow() {
		super.onAttachedToWindow();
	}


	private void initialize() {

		// build layout structure
		mContent = getChildAt(0);
		addView(LayoutInflater.from(getContext()).inflate(R.layout.view_stateful, this, false));
		mContainerProgress = (FrameLayout) findViewById(R.id.container_progress);
		mContainerProgress.addView(mProgressView);
		mContainerOffline = (FrameLayout) findViewById(R.id.container_offline);
		mContainerOffline.addView(mOfflineView);
		mContainerEmpty = (FrameLayout) findViewById(R.id.container_empty);
		mContainerEmpty.addView(mEmptyView);

		// set custom empty text
		mDefaultEmptyText = ((TextView) mEmptyView.findViewById(R.id.state_text));

		// set custom offline text
		mDefaultOfflineText = ((TextView) mOfflineView.findViewById(R.id.state_text));

		if(mInitialState != null)
			setState(mInitialState);
		mInitialized = true;
	}


	public View getProgressView() {
		return mProgressView;
	}


	public View getOfflineView() {
		return mOfflineView;
	}


	public View getEmptyView() {
		return mEmptyView;
	}


	public void setOfflineView(View offlineView) {
		mOfflineView = offlineView;
		if (mInitialized) {
			mContainerOffline.removeAllViews();
			mContainerOffline.addView(mOfflineView);
		}
	}


	public void setEmptyView(View emptyView) {
		mEmptyView = emptyView;
		if (mInitialized) {
			mContainerEmpty.removeAllViews();
			mContainerEmpty.addView(mEmptyView);
		}
	}


	public void setProgressView(View progressView) {
		mProgressView = progressView;
		if (mInitialized) {
			mContainerProgress.removeAllViews();
			mContainerProgress.addView(mProgressView);
		}
	}
}
