package com.example.lab91;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class CustomGridAdapter extends BaseAdapter {
    private Context mContext;
    private String[] mItemNames = {"Apple", "Banana", "Grapes", "Kiwi"};
    private int[] mImageIds = {R.drawable.apple, R.drawable.banana, R.drawable.grapes, R.drawable.kiwi};

    public CustomGridAdapter(Context context) {
        mContext = context;
    }

    @Override
    public int getCount() {
        return mItemNames.length;
    }

    @Override
    public Object getItem(int position) {
        return mItemNames[position];
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridView;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridView = inflater.inflate(R.layout.main_items, null);

            ImageView imageView = gridView.findViewById(R.id.imageView);
            TextView textView = gridView.findViewById(R.id.textView);
            Button buyButton = gridView.findViewById(R.id.button);

            final String itemName = mItemNames[position];
            final int imageId = mImageIds[position];

            imageView.setImageResource(imageId);
            textView.setText(itemName);

            buyButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(mContext, "Bought: " + itemName, Toast.LENGTH_SHORT).show();
                }
            });
        } else {
            gridView = convertView;
        }

        return gridView;
    }
}

