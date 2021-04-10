package es.ulpgc.eite.cleancode.catalog.category;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.CategorySelect;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class CategoryListAdapter extends ArrayAdapter<CategorySelect> {

    private final List<CategorySelect> itemList;
    private final View.OnClickListener clickListener;


    public CategoryListAdapter(
            Context context, List<CategorySelect> items, View.OnClickListener listener) {

        super(context, 0, items);

        itemList = items;
        clickListener = listener;
    }


    @Override
    public int getCount() {
        return itemList.size();
    }

    @Override
    public CategorySelect getItem(int position) {
        return itemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return getItem(position).id;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View itemView = convertView;

        if (itemView == null) {
            itemView = LayoutInflater
                    .from(parent.getContext())
                    .inflate(R.layout.category_list_content, parent, false);
        }

        itemView.setTag(itemList.get(position));
        itemView.setOnClickListener(clickListener);

        final TextView contentView = itemView.findViewById(R.id.content);
        contentView.setText(itemList.get(position).content);

        return itemView;
    }


}
