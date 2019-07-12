package chapter.android.aweme.ss.com.homework;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ItemAdapter extends RecyclerView.Adapter<ItemAdapter.ViewHolder> {

    private List<Item> mItemList;
    private Context mContext;

    private MyClickListener mMyClickListener;

    public void setMyClickListener(MyClickListener myClickListener) {
        mMyClickListener = myClickListener;
    }

    public ItemAdapter(Context context, List<Item> itemList) {
        mContext = context;
        mItemList = itemList;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.im_list_item, viewGroup, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int i) {
        Item item = mItemList.get(i);
        viewHolder.avatarIV.setImageResource(item.getAvatarId());
        viewHolder.robotNoticeIV.setImageResource(item.getRobotNoticeId());
        viewHolder.descriptionTV.setText(item.getDescription());
        viewHolder.timeTV.setText(item.getTime());
        viewHolder.titleTV.setText(item.getTitle());

        if (mMyClickListener != null) {
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mMyClickListener.onItemClick(viewHolder.itemView, i);
                }
            });
        }

    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView avatarIV;

        ImageView robotNoticeIV;
        TextView descriptionTV;
        TextView titleTV;
        TextView timeTV;
        public ViewHolder(View view) {
            super(view);
            avatarIV = view.findViewById(R.id.iv_avatar);
            robotNoticeIV = view.findViewById(R.id.robot_notice);
            descriptionTV = view.findViewById(R.id.tv_description);
            titleTV = view.findViewById(R.id.tv_title);
            timeTV = view.findViewById(R.id.tv_time);
        }

    }

    public interface MyClickListener {

        void onItemClick(View view, int position);
    }
}
