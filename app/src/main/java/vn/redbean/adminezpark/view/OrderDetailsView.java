package vn.redbean.adminezpark.view;

import java.util.List;

import vn.redbean.adminezpark.model.Data;

public interface OrderDetailsView {

    void onGettingListOrder();

    void onGetListOrderDetailsSuccess(String message, boolean result, List<Data> list);

    void onSetupControls();

    void onSetupEvents();
}
