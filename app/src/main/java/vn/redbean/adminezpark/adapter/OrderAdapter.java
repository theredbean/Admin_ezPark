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
import vn.redbean.adminezpark.utils.DateTimeFormatter;

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
        holder.txtDriverName.setText(data.getCustomerName() != null ? data.getCustomerName() : "N/A");
        holder.txtDriverPhone.setText(data.getCustomerPhoneNumber() != null ? data.getCustomerPhoneNumber() : "N/A");
        holder.txtGarageName.setText(data.getParkingName() != null ? data.getParkingName() : "N/A");
        holder.txtGaragePhone.setText(data.getParkingPhoneNumber() != null ? data.getParkingPhoneNumber() : "N/A");
        holder.txtQrCode.setText(data.getQRCode() != null ? data.getQRCode() : "N/A");
        holder.txtPlate.setText(data.getCustomerCarNumber() != null ? data.getCustomerCarNumber() : "N/A");
        holder.txtDate.setText(DateTimeFormatter.getDateFromString(data.getTimeOrderIn()));
        holder.txtTime.setText(DateTimeFormatter.getTimeFromString(data.getTimeOrderIn()));
        holder.txtStatus.setText(data.getStatus() != null ? data.getStatus() : "N/A");
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

        private TextView txtQrCode;
        private TextView txtPlate;
        private TextView txtDriverName;
        private TextView txtDriverPhone;
        private TextView txtGarageName;
        private TextView txtGaragePhone;
        private TextView txtDate;
        private TextView txtTime;
        private TextView txtStatus;

        ViewHolder(View view) {
            super(view);
            txtDriverName = view.findViewById(R.id.txtDriverName);
            txtDriverPhone = view.findViewById(R.id.txtDriverPhone);
            txtGarageName = view.findViewById(R.id.txtGarageName);
            txtGaragePhone = view.findViewById(R.id.txtGaragePhone);
            txtQrCode = view.findViewById(R.id.txtQrCode);
            txtPlate = view.findViewById(R.id.txtPlate);
            txtDate = view.findViewById(R.id.txtDate);
            txtTime = view.findViewById(R.id.txtTime);
            txtStatus = view.findViewById(R.id.txtStatus);
        }
    }
}
