package com.example.suthayakumar.testapputhaya;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.suthayakumar.testapputhaya.data.SummaryInfo;
import com.example.suthayakumar.testapputhaya.data.SessionDataManager;

public class Tab1Lessons extends Fragment {

    GridView grid;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.tab1lessons, container, false);
        if (getActivity() == null)
            return rootView;

        CustomGrid adapter = new CustomGrid(getActivity(), SessionDataManager.catalog);
        grid = rootView.findViewById(R.id.catalog);
        grid.setAdapter(adapter);
        grid.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                SessionDataManager.getInstance().save(SessionDataManager.CLIENT_ID,
                        position);

                Intent intent = new Intent(getActivity(), LessonsInfoActivity.class);
                startActivity(intent);
            }
        });

        return rootView;
    }

    private class CustomGrid extends BaseAdapter {
        private final String[][] deliveredClients;
        LayoutInflater inflater;

        CustomGrid(Context c, String[][] deliveredClients) {
            this.deliveredClients = deliveredClients;
            inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }

        @Override
        public int getCount() {
            return deliveredClients.length;
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View grid = convertView;
            RecordHolder holder;

            if (convertView == null) {
                grid = inflater.inflate(R.layout.grid_lessons_item, null);


                holder = new RecordHolder();

                holder.name = grid.findViewById(R.id.client_name);
                holder.date = grid.findViewById(R.id.date);
                holder.coordGps = grid.findViewById(R.id.coord_gps);

                grid.setTag(holder);
            } else {
                holder = (RecordHolder) grid.getTag();
            }

            holder.name.setText(deliveredClients[position][SummaryInfo.name.getValue()]);
            holder.date.setText(deliveredClients[position][SummaryInfo.date.getValue()]);
            holder.coordGps.setText(deliveredClients[position][SummaryInfo.coordGprs.getValue()]);

            return grid;
        }
    }

    private static class RecordHolder {
        TextView name;
        TextView date;
        TextView coordGps;
    }

}