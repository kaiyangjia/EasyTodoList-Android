package com.jiakaiyang.easytodo.common;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jiakaiyang.easytodo.R;
import com.jiakaiyang.easytodo.utils.TypeUtils;

import java.util.List;
import java.util.Map;

/**
 * Created by kaiyangjia on 2016/3/3.
 *
 */
public abstract class CommonRecyclerViewAdapter extends RecyclerView.Adapter<CommonViewHolder> {
    private Context context;
    private List<Object> data;

    public CommonRecyclerViewAdapter(Context context, List<Object> data) {
        this.context = context;
        this.data = data;
    }

    @Override
    public CommonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context).inflate(getItemLayout(), parent, false);
        CommonViewHolder holder = new CommonViewHolder(itemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(CommonViewHolder holder, int position) {
        Object bean = data.get(position);
        Map map = TypeUtils.getMapFromBean(bean);
        TextView tvName = holder.getView(R.id.item_name);
        TextView tvAge = holder.getView(R.id.item_age);
        tvName.setText((String) map.get("name"));
        tvAge.setText((String) map.get("age"));
    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    abstract public int getItemLayout();
}
