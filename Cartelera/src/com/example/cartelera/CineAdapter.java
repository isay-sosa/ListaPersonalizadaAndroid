package com.example.cartelera;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CineAdapter extends ArrayAdapter<String> {
	private final LayoutInflater mInflater;
	private final String[] titulos, generos, clasificacion, duracion, fechas;
	private final int[] imagenes;

	public CineAdapter(Context context, int[] imagenes, String[] titulos,
			String[] generos, String[] clasificacion, String[] duracion,
			String[] fechas) {
		super(context, R.layout.row, titulos);

		mInflater = LayoutInflater.from(context);
		this.imagenes = imagenes;
		this.titulos = titulos;
		this.generos = generos;
		this.clasificacion = clasificacion;
		this.duracion = duracion;
		this.fechas = fechas;
	}

	static class ViewHolder {
		public TextView titulo, genero, fecha, duracion, clasificacion;
		public ImageView img;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View row = convertView;
		ViewHolder viewHolder = null;

		if (row == null) {
			row = mInflater.inflate(R.layout.row, null);
			viewHolder = new ViewHolder();

			viewHolder.img = (ImageView) row.findViewById(R.id.img);
			viewHolder.titulo = (TextView) row.findViewById(R.id.lblTitulo);
			viewHolder.genero = (TextView) row.findViewById(R.id.lblGenero);
			viewHolder.clasificacion = (TextView) row
					.findViewById(R.id.lblClasificacion);
			viewHolder.duracion = (TextView) row.findViewById(R.id.lblDuracion);
			viewHolder.fecha = (TextView) row.findViewById(R.id.lblFecha);

			row.setTag(viewHolder);
		} else
			viewHolder = (ViewHolder) row.getTag();

		viewHolder.img.setImageResource(imagenes[position]);
		viewHolder.titulo.setText(titulos[position]);
		viewHolder.genero.setText("Género: " + generos[position]);
		viewHolder.clasificacion.setText("Clasificación: "
				+ clasificacion[position]);
		viewHolder.duracion.setText("Duración: " + duracion[position]);
		viewHolder.fecha.setText("Fecha: " + fechas[position]);

		return row;
	}

}
