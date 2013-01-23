package com.example.cartelera;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

public class Main extends ListActivity {
	private ListView mList;
	private TextView mHeader;
	private CineAdapter mAdapter;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		initComponents();
	}

	private void initComponents() {
		mHeader = (TextView) findViewById(R.id.header_title);
		mHeader.setText("Cartelera - Ciclo de Cine 2012");

		mList = getListView();

		int[] imagenes = { R.drawable.batman, R.drawable.brave,
				R.drawable.skyfall, R.drawable.titanic, R.drawable.avengers,
				R.drawable.alvin };

		mAdapter = new CineAdapter(this, imagenes, getResources()
				.getStringArray(R.array.titulos), getResources()
				.getStringArray(R.array.generos), getResources()
				.getStringArray(R.array.clasificacion), getResources()
				.getStringArray(R.array.duracion), getResources()
				.getStringArray(R.array.fechas));
		mList.setAdapter(mAdapter);
	}
}
