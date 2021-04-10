package es.ulpgc.eite.cleancode.catalog.category;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategorySelect;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class CategoryModel implements CategoryContract.Model {

    public static String TAG = CategoryModel.class.getSimpleName();

    private final List<CategorySelect> itemList = new ArrayList<>();
    private final int COUNT = 15;

    public CategoryModel() {
        // Add some sample items
        for (int index = 1; index <= COUNT; index++) {
            addProduct(createProduct(index));
        }
    }

    @Override
    public List<CategorySelect> obtenerLasCategorias() {
        Log.e(TAG, "Las Categorias()");
        return itemList;
    }

    private void addProduct(CategorySelect item) {
        itemList.add(item);
    }


    private CategorySelect createProduct(int position) {
        String content = "Categoria " + position;

        return new CategorySelect(
                position, content);

    }

}