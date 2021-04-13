package es.ulpgc.eite.cleancode.catalog.products;

import androidx.fragment.app.FragmentActivity;

import java.lang.ref.WeakReference;

import es.ulpgc.eite.cleancode.catalog.app.CatalogMediator;
import es.ulpgc.eite.cleancode.catalog.app.CategorySelect;

public class ProductListScreen {

  public static void configure(ProductListContract.View view) {

    WeakReference<FragmentActivity> context =
        new WeakReference<>((FragmentActivity) view);

    // call the model

    //CatalogMediator mediator = (CatalogMediator) context.get().getApplication();
    CatalogMediator mediator = CatalogMediator.getInstance();
    //ProductListState state = mediator.getProductListState();

    //ProductListContract.Router router = new ProductListRouter(mediator);
    //ProductListContract.Presenter presenter = new ProductListPresenter(state);
    ProductListContract.Presenter presenter = new ProductListPresenter(mediator);
    CategorySelect savedState = mediator.getCategoria();
    ProductListState state=mediator.getProductListState();
    if (savedState != null) {

      // update the model if is necessary
      state.categoriaSeleccionada=savedState.id;


    }
    ProductListModel model = new ProductListModel( state.categoriaSeleccionada);
    presenter.injectView(new WeakReference<>(view));
    presenter.injectModel(model);
    //presenter.injectRouter(router);
    view.injectPresenter(presenter);

  }

}
