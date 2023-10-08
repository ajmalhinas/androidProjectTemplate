package school.searchUI;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.androix.AbstractSearchUI;
import com.androix.NPersistence;
import com.androix.SearchUIModel;

import java.sql.SQLException;
import java.util.Map;

import school.app.F;
import school.app.R;

/**
 * A generic search ui for entity models
 */
public class ModelSearchUI extends AbstractSearchUI {
    protected static Class itemsClazz;
    protected static String query;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        super.onCreateView(inflater, container, savedInstanceState);
        Map createParams = allCreateParams.get(thisUITag);
        if (createParams != null) {
            ModelSearchUI.itemsClazz = (Class) createParams.get("itemsClazz");
            ModelSearchUI.query = (String) createParams.get("query");
            if (itemsClazz != null) {
                title = itemsClazz.getSimpleName();
            }

        }
        return inflater.inflate(R.layout.search_ui, container, false);
    }

    public static void registerSearchUI(String tag, int searchUIId, int cardLayoutId, Class rowClazz, Class itemsClazz, Class nextUI, String query, int columns) {
        registerSearchUI(tag, searchUIId, R.menu.menu_search, R.id.txtsearch, R.id.rvRowHolder,
                cardLayoutId, rowClazz, nextUI, columns);
        Map createParams = allCreateParams.get(tag);
        createParams.put("itemsClazz", itemsClazz);
        createParams.put("query", query);
        ModelSearchUI.itemsClazz = itemsClazz;
        ModelSearchUI.query = query;
    }

    public static void registerSearchUI(String tag, int searchUIId, int cardLayoutId, Class rowClazz, Class itemsClazz, Class nextUI, int columns) {
        registerSearchUI(tag, searchUIId, cardLayoutId, rowClazz, itemsClazz, nextUI, null, columns);
    }


    public void setup() {
        try {
            searchUIModel = new SearchUIModel(this, cardLayoutId, rowClazz);
            recyclerView.setAdapter(searchUIModel);
            if (query == null) {
                setItems(F.retriveAll(itemsClazz)); //items showed in the list is all items from an entityModel
            } else if (itemsClazz == null) {
                setItems(NPersistence.retrieve(query).getRows()); //items showed in the list is from a custom query
            } else {
                setItems(NPersistence.retrieve(itemsClazz, query));  //items showed in the list is from  query which filtered by a query
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    /**
     * Useful to apply filter an already created ModelSearchUI
     */
    public void filter(String query) {
        this.query = query;
        reload();
    }

    /**
     * Reload the items from db
     */
    public void reload() {
        try {
            if (query == null) {
                setItems(F.retriveAll(itemsClazz));
            } else if (itemsClazz == null) {
                setItems(NPersistence.retrieve(query).getRows());
            } else {
                setItems(NPersistence.retrieve(itemsClazz, query));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public void onShow() {
        Map createParams = allCreateParams.get(thisUITag);
        if (createParams != null) {
            ModelSearchUI.itemsClazz = (Class) createParams.get("itemsClazz");
            ModelSearchUI.query = (String) createParams.get("query");
        }
        super.onShow();
    }

}