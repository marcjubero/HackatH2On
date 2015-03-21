package agbar.hack.watcalite;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Daniil on 21/03/2015.
 */
public class CommentsAdapter extends ArrayAdapter {

    ArrayList<String> comments;

    public CommentsAdapter(Context context, int resource, List objects) {
        super(context, resource, objects);
        comments = (ArrayList)objects;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(this.getContext())
                    .inflate(R.layout.info_cell, parent, false);
        }
        TextView comment_textView = (TextView) convertView.findViewById(R.id.comment_textView);
        String comment = (String) getItem(position);
        comment_textView.setText(comment);
        return convertView;
    }
}
