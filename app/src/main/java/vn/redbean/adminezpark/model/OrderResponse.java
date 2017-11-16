package vn.redbean.adminezpark.model;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class OrderResponse {

    @SerializedName("error")
    @Expose
    private Integer error;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("data")
    @Expose
    private List<OrderDetail> lstOrder = null;

    public OrderResponse() {
    }

    public OrderResponse(Integer error, String message, List<OrderDetail> lstOrder) {
        super();
        this.error = error;
        this.message = message;
        this.lstOrder = lstOrder;
    }

    public Integer getError() {
        return error;
    }

    public void setError(Integer error) {
        this.error = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<OrderDetail> getLstOrder() {
        return lstOrder;
    }

    public void setLstOrder(List<OrderDetail> lstOrder) {
        this.lstOrder = lstOrder;
    }
}