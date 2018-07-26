package droidtute.simplechatapp.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import droidtute.simplechatapp.R;
import droidtute.simplechatapp.adapter.viewholder.MessageViewHolder;
import droidtute.simplechatapp.model.Message;

public class MessageAdapter extends RecyclerView.Adapter<MessageViewHolder> {


    private List<Message> mConversationList;

    public MessageAdapter(List<Message> conversationList) {
        this.mConversationList = conversationList;
    }

    @NonNull
    @Override
    public MessageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View rowItem = LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_item_conversation, parent, false);
        return new MessageViewHolder(rowItem);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageViewHolder holder, int position) {
        holder.populateData(getItem(position));
    }

    private Message getItem(int position) {
        return mConversationList.get(position);
    }

    @Override
    public int getItemCount() {
        return mConversationList.size();
    }

    public void updateList(List<Message> messages) {
        if (messages != null) {
            this.mConversationList = messages;
            notifyDataSetChanged();
        }
    }
}
