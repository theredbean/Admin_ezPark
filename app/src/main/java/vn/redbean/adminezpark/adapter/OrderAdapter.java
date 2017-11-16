package vn.redbean.adminezpark.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.redbean.adminezpark.R;
import vn.redbean.adminezpark.model.OrderDetail;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<OrderDetail> lstData = new ArrayList<>();

    public OrderAdapter(List<OrderDetail> lstData) {
        this.lstData = lstData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        OrderDetail orderDetail = lstData.get(position);
        holder.txtDriverName.setText(orderDetail.getCustomerName());
        holder.txtDriverPhone.setText(orderDetail.getCustomerPhoneNumber());
        holder.txtGarageName.setText(orderDetail.getParkingName());
        holder.txtGaragePhone.setText(orderDetail.getParkingPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void newList(List<OrderDetail> lstData) {
        lstData.clear();
        this.lstData = lstData;
        notifyDataSetChanged();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDriverName;
        private TextView txtDriverPhone;
        private TextView txtGarageName;
        private TextView txtGaragePhone;

        ViewHolder(View view) {
            super(view);
            txtDriverName = view.findViewById(R.id.txtDriverName);
            txtDriverPhone = view.findViewById(R.id.txtDriverPhone);
            txtGarageName = view.findViewById(R.id.txtGarageName);
            txtGaragePhone = view.findViewById(R.id.txtGaragePhone);
        }
    }
}
