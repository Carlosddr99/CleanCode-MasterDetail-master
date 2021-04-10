package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;

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
        String getStoredData();

        void onDataFromNextScreen(String data);

        void onRestartScreen(String data);

        void onDataFromPreviousScreen(String data);
    }

}