package vn.redbean.adminezpark.api;

import retrofit2.Call;
import retrofit2.http.GET;
import vn.redbean.adminezpark.model.OrderResponse;

public interface APIInterface {

    @GET("order/list-order-detail")
    Call<OrderResponse> getListOrderDetails();

}
