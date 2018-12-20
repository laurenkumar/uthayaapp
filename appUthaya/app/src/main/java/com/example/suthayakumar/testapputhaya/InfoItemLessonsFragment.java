package com.example.suthayakumar.testapputhaya;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.suthayakumar.testapputhaya.data.SummaryInfo;
import com.example.suthayakumar.testapputhaya.data.SessionDataManager;

public class InfoItemLessonsFragment extends Fragment {

	GridView grid;
	int clientId;

	public static InfoItemLessonsFragment newInstance() {
		return new InfoItemLessonsFragment();
	}

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_info_client, container, false);

        clientId = SessionDataManager.getInstance().getInt(SessionDataManager.CLIENT_ID);

		if(clientId < 0)
			return rootView;

		if (getActivity() == null)
			return rootView;

		CustomGrid adapter = new CustomGrid(getActivity(), SessionDataManager.catalog[clientId]);
		grid = rootView.findViewById(R.id.client_info);
		grid.setAdapter(adapter);

        return rootView;
    }

	private class CustomGrid extends BaseAdapter {
		private final String[] client;
		LayoutInflater inflater;
		String type;
		String[] keys;

		CustomGrid(Context c, String[] client) {
			this.client = client;
			this.type = client[SummaryInfo.type.getValue()];
			this.keys = SessionDataManager.catalogKeys;
			inflater = (LayoutInflater) c.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		}

		@Override
		public int getCount() {
			return keys.length;
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
			RecordHolder holder;

			if (convertView == null) {
				convertView = inflater.inflate(R.layout.grid_info_summary_item, null);

				holder = new RecordHolder();

				holder.label = convertView.findViewById(R.id.label);
				holder.value = convertView.findViewById(R.id.value);

				convertView.setTag(holder);
			} else {
				holder = (RecordHolder) convertView.getTag();
			}

			holder.label.setText(keys[position]);
			holder.value.setText(client[position+4] == null ?
					getString(R.string.not_specified) :client[position+4]);

			return convertView;
		}
	}

	private static class RecordHolder {
		TextView label;
		TextView value;
	}

}
