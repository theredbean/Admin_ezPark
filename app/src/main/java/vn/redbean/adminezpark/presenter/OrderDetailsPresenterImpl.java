package vn.redbean.adminezpark.presenter;

import android.support.annotation.NonNull;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import vn.redbean.adminezpark.api.APIClient;
import vn.redbean.adminezpark.api.APIInterface;
import vn.redbean.adminezpark.model.OrderResponse;
import vn.redbean.adminezpark.view.OrderDetailsView;

public class OrderDetailsPresenterImpl implements OrderDetailsPresenter {

    private OrderDetailsView view;
    private APIInterface apiInterface;

    public OrderDetailsPresenterImpl(OrderDetailsView view) {
        this.view = view;
        this.apiInterface = APIClient.getClient().create(APIInterface.class);
    }

    @Override
    public void create() {
        view.onSetupControls();
        view.onSetupEvents();
    }

    @Override
    public void getListOrderDetails() {
        Call<OrderResponse> response = apiInterface.getListOrderDetails();
        response.enqueue(new Callback<OrderResponse>() {
            @Override
            public void onResponse(@NonNull Call<OrderResponse> call, @NonNull Response<OrderResponse> response) {
                if (response.isSuccessful()) {
                    OrderResponse body = response.body();
                    if (body != null)
                        view.onGetListOrderDetails(body.getMessage(), true, body.getLstOrder());
                    else
                        view.onGetListOrderDetails("Lỗi", false, null);
                } else {
                    view.onGetListOrderDetails("Lỗi", false, null);
                }

            }

            @Override
            public void onFailure(@NonNull Call<OrderResponse> call, @NonNull Throwable t) {
                call.cancel();
                view.onGetListOrderDetails("Lỗi", false, null);
            }
        });
    }
}
