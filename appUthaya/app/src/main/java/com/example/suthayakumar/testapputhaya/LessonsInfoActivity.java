package com.example.suthayakumar.testapputhaya;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.suthayakumar.testapputhaya.data.SummaryInfo;
import com.example.suthayakumar.testapputhaya.data.SessionDataManager;

public class LessonsInfoActivity extends AppCompatActivity {
	ImageButton buttonExit;
	ImageButton disconnectButton;
	TextView titleToolbar;
	FrameLayout frameLayout;

	String[] client;
	TextView clientCodeTv;
	TextView clientNameTv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lessons_info);

		Toolbar toolbar = findViewById(R.id.toolbar);
		titleToolbar = findViewById(R.id.toolbar_title);
		buttonExit = findViewById(R.id.back_bt);
		disconnectButton = toolbar.findViewById(R.id.disconnect_bt);
		clientNameTv = findViewById(R.id.client_name);
		clientCodeTv = findViewById(R.id.client_code);
		frameLayout = findViewById(R.id.fragmentLayout);

		setSupportActionBar(toolbar);
		if (getSupportActionBar() != null)
			getSupportActionBar().setDisplayShowTitleEnabled(false);

		client = SessionDataManager.catalog[SessionDataManager.getInstance().getInt(SessionDataManager.CLIENT_ID)];
		if(client == null)
			return;

		clientNameTv.setText(client[SummaryInfo.name.getValue()]);
		clientCodeTv.setText(getString(R.string.client_no, client[SummaryInfo.code.getValue()]));

		buttonExit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				Intent otherActivity = new Intent(getApplicationContext(), MainActivity.class);
				startActivity(otherActivity);
			}
		});

		/*disconnectButton.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				Tools.disconnect(LessonsInfoActivity.this);
			}
		});*/

		startNewFragment(getString(R.string.client_info),
				InfoItemLessonsFragment.newInstance());
	}

	public void startNewFragment(String title, Fragment newFragment) {
		//replace current fragment by new one
		FragmentTransaction transaction;
		transaction = getSupportFragmentManager().beginTransaction();
		transaction.replace(R.id.fragmentLayout, newFragment, title);
		transaction.addToBackStack(title);
		transaction.commitAllowingStateLoss();
	}

	@Override
	public void onBackPressed() {
	}
}
