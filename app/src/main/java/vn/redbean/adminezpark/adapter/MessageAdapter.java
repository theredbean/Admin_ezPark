package vn.redbean.adminezpark.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import vn.redbean.adminezpark.R;
import vn.redbean.adminezpark.model.Message;

public class MessageAdapter extends RecyclerView.Adapter<MessageAdapter.ViewHolder> {

    private List<Message> lstMessages = new ArrayList<>();

    public MessageAdapter(List<Message> lstMessages) {
        this.lstMessages = lstMessages;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item, parent, false));
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Message message = lstMessages.get(position);
        holder.txtDriverName.setText(message.getDriver().getName());
        holder.txtDriverPhone.setText(message.getDriver().getPhone());
        holder.txtGarageName.setText(message.getGarage().getName());
        holder.txtGaragePhone.setText(message.getGarage().getPhone());
    }

    @Override
    public int getItemCount() {
        return lstMessages.size();
    }

    public void addToTop(Message message) {
        lstMessages.add(0, message);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private TextView txtDriverName;
        private TextView txtDriverPhone;
        private TextView txtGarageName;
        private TextView txtGaragePhone;

        public ViewHolder(View view) {
            super(view);
            txtDriverName = view.findViewById(R.id.txtDriverName);
            txtDriverPhone = view.findViewById(R.id.txtDriverPhone);
            txtGarageName = view.findViewById(R.id.txtGarageName);
            txtGaragePhone = view.findViewById(R.id.txtGaragePhone);
        }
    }
}
