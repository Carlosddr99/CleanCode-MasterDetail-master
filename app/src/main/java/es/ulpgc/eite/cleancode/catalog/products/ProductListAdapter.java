package es.ulpgc.eite.cleancode.catalog.products;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

import static android.content.ContentValues.TAG;

public class ProductListAdapter extends ArrayAdapter<ProductItem> {

  private final List<ProductItem> itemList;
  private final View.OnClickListener clickListener;
  private int categoria;



  public ProductListAdapter(
      Context context,int categoria, List<ProductItem> items, View.OnClickListener listener) {

    super(context, 0, items);

    itemList = items;
    clickListener = listener;
    this.categoria=categoria;

  }


  @Override
  public int getCount() {
    return itemList.size();
  }

  @Override
  public ProductItem getItem(int position) {
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
          .inflate(R.layout.product_list_content, parent, false);
    }

    itemView.setTag(itemList.get(position));
    itemView.setOnClickListener(clickListener);

    final TextView contentView = itemView.findViewById(R.id.content);

      contentView.setText("Product " + categoria+"."+position+1);

    return itemView;
  }


}
