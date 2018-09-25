package com.kenjin.hotelapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kenjin.hotelapp.R;
import com.kenjin.hotelapp.model.Pesanan;

import java.util.List;

/**
 * Created by kenjin on 5/27/2016.
 */
public class PesananAdapter extends BaseAdapter
{
    static class Holder
    {
        TextView nama,lamapesan;
        ImageView thumb;

    }

    private LayoutInflater inflater;
    private List<Pesanan> listPesanans;

    public PesananAdapter(Context context, List<Pesanan> pesanan)
    {
        inflater = LayoutInflater.from(context);
        this.listPesanans = pesanan;
    }

    @Override
    public int getCount()
    {
        return listPesanans.size();
    }

    @Override
    public Object getItem(int position)
    {
        return listPesanans.get(position);
    }

    @Override
    public long getItemId(int position)
    {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent)
    {
        Holder holder;
        if (convertView == null)
        {
            convertView = inflater.inflate(R.layout.list_pesanan, null);

            holder = new Holder();
            holder.nama = (TextView) convertView.findViewById(R.id.name_contact);
            holder.thumb = (ImageView) convertView
                    .findViewById(R.id.thumb_contact);
            holder.lamapesan= (TextView) convertView.findViewById(R.id.lama_pesan);

            convertView.setTag(holder);
        } else
        {
            holder = (Holder) convertView.getTag();
        }

        holder.nama.setText("Nama: "+listPesanans.get(position).getNama());
        holder.thumb.setBackgroundResource(R.drawable.img_hotel);
        holder.lamapesan.setText("Durasi :"+listPesanans.get(position).getLamainap()+" hari");

        return convertView;
    }
}
