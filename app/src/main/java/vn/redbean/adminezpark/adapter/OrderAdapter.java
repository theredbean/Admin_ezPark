package vn.redbean.adminezpark.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.redbean.adminezpark.R;
import vn.redbean.adminezpark.model.Data;

public class OrderAdapter extends RecyclerView.Adapter<OrderAdapter.ViewHolder> {

    private List<Data> lstData = new ArrayList<>();

    public OrderAdapter(List<Data> lstData) {
        this.lstData = lstData;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Data data = lstData.get(position);
        holder.txtDriverName.setText(data.getCustomerName());
        holder.txtDriverPhone.setText(data.getCustomerPhoneNumber());
        holder.txtGarageName.setText(data.getParkingName());
        holder.txtGaragePhone.setText(data.getParkingPhoneNumber());
    }

    @Override
    public int getItemCount() {
        return lstData.size();
    }

    public void clear() {
        this.lstData.clear();
        notifyDataSetChanged();
    }

    public void newList(List<Data> lstData) {
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
