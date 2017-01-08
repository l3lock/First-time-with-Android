package app.l3lock.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by CHRIS on 12/26/2016.
 */

public class MyAdapter extends BaseAdapter{

    // Explicit
    private Context context;
    private int[] img;
    private String[] title, detail;

    // Constructor
    public MyAdapter(Context context, int[] img, String[] title, String[] detail) {
        this.context = context;
        this.img = img;
        this.title = title;
        this.detail = detail;
    }

    @Override
    public int getCount() {
        return img.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        // Change Explicit
        int i = position;

        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view1 = layoutInflater.inflate(R.layout.my_listview, parent, false);

        // Bind widget
        ImageView imageView = (ImageView) view1.findViewById(R.id.logo_1);
        TextView title_TextView = (TextView) view1.findViewById(R.id.Title);
        TextView detail_TextView = (TextView) view1.findViewById(R.id.Detail);

        imageView.setImageResource(img[i]);
        title_TextView.setText(title[i]);
        detail_TextView.setText(detail[i]);

        return view1;
    }
}
