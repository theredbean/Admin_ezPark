package vn.redbean.adminezpark.view;

import java.util.List;

import vn.redbean.adminezpark.model.OrderDetail;

public interface OrderDetailsView {

    void onGetListOrderDetails(String message, boolean result, List<OrderDetail> list);

    void onSetupControls();

    void onSetupEvents();
}
