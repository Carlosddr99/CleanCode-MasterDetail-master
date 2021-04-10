package es.ulpgc.eite.cleancode.catalog.category;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import es.ulpgc.eite.cleancode.catalog.R;
import es.ulpgc.eite.cleancode.catalog.products.ProductListActivity;

public class CategoryActivity
        extends AppCompatActivity implements CategoryContract.View {

    public static String TAG = CategoryActivity.class.getSimpleName();

    private CategoryContract.Presenter presenter;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Show the title in the action bar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle(getString(R.string.title_category));
        }
        listView = findViewById(R.id.activity_list);


    /*
    if(savedInstanceState == null) {
      AppMediator.resetInstance();
    }
    */

        // do the setup
        CategoryScreen.configure(this);
        presenter.obtenerCategorias();

//        if (savedInstanceState == null) {
//            presenter.onStart();
//
//        } else {
//            presenter.onRestart();
//        }
  }

    @Override
    protected void onResume() {
        super.onResume();

        // load the data
        presenter.onResume();
    }



    @Override
    protected void onPause() {
        super.onPause();

        presenter.onPause();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        presenter.onDestroy();
    }

    @Override
    public void onDataUpdated(CategoryViewModel viewModel) {
        //Log.e(TAG, "onDataUpdated()");

        // deal with the data
       // ((TextView) findViewById(R.id.data)).setText(viewModel.data);
    }


    @Override
    public void navigateToNextScreen() {
        Intent intent = new Intent(this, ProductListActivity.class);
        startActivity(intent);
    }

    @Override
    public void injectPresenter(CategoryContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
