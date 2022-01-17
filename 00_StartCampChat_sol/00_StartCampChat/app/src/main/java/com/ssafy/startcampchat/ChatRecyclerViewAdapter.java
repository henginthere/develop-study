package com.ssafy.startcampchat;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.text.SimpleDateFormat;
import java.util.List;

public class ChatRecyclerViewAdapter extends RecyclerView.Adapter<ChatRecyclerViewAdapter.MessageHolder> {

    private List<ChatItem> items;
    private String name;

    public ChatRecyclerViewAdapter(List<ChatItem> items, String name) {
        this.items = items;
        this.name = name;
    }

    public List<ChatItem> getItems() {
        return items;
    }

    public void setItems(List<ChatItem> items) {
        this.items = items;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @NonNull
    @Override
    public MessageHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
                .from(parent.getContext())
                .inflate(R.layout.item_chat, parent, false);

        return new MessageHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MessageHolder holder, int position) {
        ChatItem item = getItems().get(position);

        if (item.getName().equals(this.getName())) { // item.getName() == this.getName()
            holder.getMySide().setVisibility(View.VISIBLE);
            holder.getOtherSide().setVisibility(View.GONE);

            holder.getMyUserTextView().setText(item.getName());
            holder.getMyMessageTextView().setText(item.getMessage());
            holder.getMyTimeTextView().setText(new SimpleDateFormat("HH:mm").format(item.getTime()));
        }
        else {
            holder.getMySide().setVisibility(View.GONE);
            holder.getOtherSide().setVisibility(View.VISIBLE);

            holder.getOtherUserTextView().setText(item.getName());
            holder.getOtherMessageTextView().setText(item.getMessage());
            holder.getOtherTimeTextView().setText(new SimpleDateFormat("HH:mm").format(item.getTime()));
        }
    }

    @Override
    public int getItemCount() {
        return this.getItems().size();
    }

    public static class MessageHolder extends RecyclerView.ViewHolder {
        private TextView myUserTextView;        // 내가 보낸 메시지의 닉네임
        private TextView myMessageTextView;     // 내가 보낸 메시지의 채팅내용
        private TextView myTimeTextView;        // 내가 보낸 메시지의 발송시간

        private TextView otherUserTextView;     // 남이 보낸
        private TextView otherMessageTextView;
        private TextView otherTimeTextView;

        private View mySide;
        private View otherSide;

        public MessageHolder(@NonNull View view) {
            super(view);

            myUserTextView = view.findViewById(R.id.my_user_tv);
            myMessageTextView = view.findViewById(R.id.my_message_tv);
            myTimeTextView = view.findViewById(R.id.my_time_tv);

            otherUserTextView = view.findViewById(R.id.other_user_tv);
            otherMessageTextView = view.findViewById(R.id.other_message_tv);
            otherTimeTextView = view.findViewById(R.id.other_time_tv);

            mySide = view.findViewById(R.id.my_side);
            otherSide = view.findViewById(R.id.other_side);
        }

        public TextView getMyUserTextView() {
            return myUserTextView;
        }

        public void setMyUserTextView(TextView myUserTextView) {
            this.myUserTextView = myUserTextView;
        }

        public TextView getMyMessageTextView() {
            return myMessageTextView;
        }

        public void setMyMessageTextView(TextView myMessageTextView) {
            this.myMessageTextView = myMessageTextView;
        }

        public TextView getMyTimeTextView() {
            return myTimeTextView;
        }

        public void setMyTimeTextView(TextView myTimeTextView) {
            this.myTimeTextView = myTimeTextView;
        }

        public TextView getOtherUserTextView() {
            return otherUserTextView;
        }

        public void setOtherUserTextView(TextView otherUserTextView) {
            this.otherUserTextView = otherUserTextView;
        }

        public TextView getOtherMessageTextView() {
            return otherMessageTextView;
        }

        public void setOtherMessageTextView(TextView otherMessageTextView) {
            this.otherMessageTextView = otherMessageTextView;
        }

        public TextView getOtherTimeTextView() {
            return otherTimeTextView;
        }

        public void setOtherTimeTextView(TextView otherTimeTextView) {
            this.otherTimeTextView = otherTimeTextView;
        }

        public View getMySide() {
            return mySide;
        }

        public void setMySide(View mySide) {
            this.mySide = mySide;
        }

        public View getOtherSide() {
            return otherSide;
        }

        public void setOtherSide(View otherSide) {
            this.otherSide = otherSide;
        }
    }
}
