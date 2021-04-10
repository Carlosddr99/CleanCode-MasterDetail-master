package es.ulpgc.eite.cleancode.catalog.category;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategorySelect;
import es.ulpgc.eite.cleancode.catalog.app.ProductItem;

public class CategoryPresenter implements CategoryContract.Presenter {

    public static String TAG = CategoryPresenter.class.getSimpleName();

    private WeakReference<CategoryContract.View> view;
    private CategoryState state;
    private CategoryContract.Model model;
    private CatalogMediator mediator;

    public CategoryPresenter(CatalogMediator mediator) {
        this.mediator = mediator;
        state = mediator.getCategoryState();
    }

    @Override
    public void onStart() {
        // Log.e(TAG, "onStart()");

        // initialize the state if is necessary
        if (state == null) {
            state = new CategoryState();
        }

        // call the model and update the state
        //state.data = model.getStoredData();

        // use passed state if is necessary


    }

    @Override
    public void onRestart() {
        // Log.e(TAG, "onRestart()");

        // update the model if is necessary
        //model.onRestartScreen(state.data);
    }

    @Override
    public void onResume() {
        // Log.e(TAG, "onResume()");

        // use passed state if is necessary


        // call the model and update the state
        //state.data = model.getStoredData();

        // update the view
        view.get().onDataUpdated(state);

    }



    @Override
    public void onPause() {
        // Log.e(TAG, "onPause()");
    }

    @Override
    public void onDestroy() {
        // Log.e(TAG, "onDestroy()");
    }



   private void goToListProducts(CategorySelect state) {
        mediator.setCategoryToProducts(state);
    }
    @Override
    public void obtenerCategorias(){
        state.categories = model.obtenerLasCategorias();

        view.get().onDataUpdated(state);

    }
    @Override
    public void seleccionaCategoria(CategorySelect categoria) {
        //router.passDataToProductDetailScreen(item);
        goToListProducts(categoria);
        //router.navigateToProductDetailScreen();
        view.get().navigateToNextScreen();
    }



    @Override
    public void injectView(WeakReference<CategoryContract.View> view) {
        this.view = view;
    }

    @Override
    public void injectModel(CategoryContract.Model model) {
        this.model = model;
    }

}
