package com.android.knowledge.localnotificationsample;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by M1034567 on 3/11/2017.
 */

public class NumberAdapter extends BaseAdapter implements View.OnClickListener {
    private Context mContext;
    private ArrayList<String> mNumbers;
    private onItemClickListener mItemClickListener;
    private NumberViewHolder viewHolder;
    private  View view;

    public NumberAdapter(Context context, ArrayList<String> numbers) {
        mContext = context;
        mNumbers = numbers;
        mItemClickListener = (onItemClickListener) context;
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {
        view = convertView;
        if (view == null) {
            view = LayoutInflater.from(mContext).inflate(R.layout.list_item, parent, false);
            viewHolder = new NumberViewHolder(view);
            view.setTag(viewHolder);
        } else {
            viewHolder = (NumberViewHolder) view.getTag();
        }
        viewHolder.mNumbers.setText(mNumbers.get(position));
        viewHolder.mButton.setTag(position);
        //viewHolder.mButton.setId("" + position);

        //view.setOnClickListener(this);
        /*viewHolder.mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mItemClickListener.onItemClick(position, getItem(position), mNumbers[position], view, true, viewHolder.mButton.getId());
            }
        });*/
        viewHolder.mButton.setOnClickListener(listItemButtonClickListener);
        return view;
    }

    @Override
    public Object getItem(int position) {
        return mNumbers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public int getCount() {
        return mNumbers.size();
    }

    /**
     * View holder
     */
    protected static final class NumberViewHolder {
        private TextView mNumbers;
        private Button mButton;

        /**
         * @param view
         */
        private NumberViewHolder(View view) {
            mNumbers = (TextView) view.findViewById(R.id.rowTextItem);
            mButton = (Button) view.findViewById(R.id.rowButtonItem);
        }

    }

    @Override
    public void onClick(View v) {

    }

    /**
     *
     */

    interface onItemClickListener<T> {
        void onItemClick(int position, T listEntry, String listItem, View view, Boolean state);
    }

    private View.OnClickListener listItemButtonClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int position = (Integer) view.getTag();
            mItemClickListener.onItemClick(position, getItem(position), mNumbers.get(position), view, true);
        }
    };




}
