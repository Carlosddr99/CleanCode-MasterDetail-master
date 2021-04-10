package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;
import java.util.List;

import es.ulpgc.eite.cleancode.catalog.app.CategorySelect;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public interface CategoryContract {

    interface View {
        void injectPresenter(Presenter presenter);

        void onDataUpdated(CategoryViewModel viewModel);

        void navigateToNextScreen();
    }

    interface Presenter {
        void injectView(WeakReference<View> view);

        void injectModel(Model model);
        void obtenerCategorias();

        void onResume();

        void onStart();

        void onRestart();



        void onPause();

        void onDestroy();
    }

    interface Model {

        List<CategorySelect> obtenerLasCategorias();
    }

}