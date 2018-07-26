package droidtute.simplechatapp.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import droidtute.simplechatapp.R;
import droidtute.simplechatapp.model.Message;
import jp.wasabeef.glide.transformations.CropCircleTransformation;

public class MessageViewHolder extends RecyclerView.ViewHolder {


    private TextView mTvUserName;
    private TextView mTvTimeAgo;
    private TextView mTvMessage;
    private TextView mTvReadCount;
    private ImageView mIvDisplayPicture;

    public MessageViewHolder(View itemView) {
        super(itemView);
        bindHolder();
    }

    private void bindHolder() {
        mTvUserName = itemView.findViewById(R.id.tv_name);
        mTvTimeAgo = itemView.findViewById(R.id.tv_mins_ago);
        mTvMessage = itemView.findViewById(R.id.tv_message);
        mTvReadCount = itemView.findViewById(R.id.tv_count);
        mIvDisplayPicture = itemView.findViewById(R.id.display_thumb);
    }

    public void populateData(Message message) {
        mTvUserName.setText(message.getUserName());
        mTvTimeAgo.setText(message.getTimeAgo());
        mTvMessage.setText(message.getMessage());

        if (message.getReadCount() > 0) {
            mTvReadCount.setVisibility(View.VISIBLE);
            mTvReadCount.setText(String.valueOf(message.getReadCount()));
        } else {
            mTvReadCount.setVisibility(View.GONE);
        }

        Glide.with(itemView.getContext()).
                load(message.getDisplayPicture())
                .apply(new RequestOptions().circleCrop())
                .into(mIvDisplayPicture);
    }
}
