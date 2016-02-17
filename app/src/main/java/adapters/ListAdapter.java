package adapters;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edibca.diabetescomplicationst2.*;
import com.squareup.picasso.Picasso;

import java.util.List;

import Class_General.General;
import models.ListModels;

/**
 * Created by Sistemas2 on 10/02/2016.
 */
public class ListAdapter extends BaseAdapter {
    private Context context;
    private List<ListModels> data;
    private int iWidthIMG, iHeightIMG;
    private View view;
    private Bitmap bitmap =null;

    public ListAdapter(Context context, List<ListModels> data) {
        this.context = context;
        this.data = data;

        WindowManager windowManager = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();

        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);

        iWidthIMG = display.getWidth();
        iHeightIMG = context.getResources().getDimensionPixelSize(R.dimen.template_img_height);

        view = null;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        view = convertView;

        try {
            if (view == null) {
                LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

                view = layoutInflater.inflate(R.layout.fragement_adapter_image, null);
            }

            //view = View.inflate(context, R.layout.fragement_adapter_image, null);
            ListModels listModels = (ListModels) getItem(position);
            TextView textView = (TextView) view.findViewById(R.id.title);
            textView.setText(listModels.getsName());
            textView = (TextView) view.findViewById(R.id.description);
            textView.setText(listModels.getsDescription());
            ImageView imageView = (ImageView) view.findViewById(R.id.img);
            imageView.setImageBitmap(sizeImage(context.getResources(),listModels.getiImgUrl()));



            //imageView.setImageBitmap(getResizedBitmap(bitmap, imageView.getWidth(), imageView.getHeight()));

            //Picasso.with(context).load(listModels.getiImgUrl()).resize(iWidthIMG, iHeightIMG).centerCrop().into(imageView);
            // imageView.setImageResource(listModels.getiImgUrl());
            //imageView.setOnClickListener(new View.OnClickListener() {
            //  @Override
            //public void onClick(View v) {
            //Toast.makeText(context, "It drawable : " + imageView.getId(), Toast.LENGTH_LONG).show();
            // }
            //});
            return view;
        } catch (Exception e) {
            Toast.makeText(context, "Erro :" + e.getMessage(), Toast.LENGTH_LONG).show();

        }
        return view;
    }
    public Bitmap  sizeImage(Resources resources,int iID){

        BitmapFactory.Options options= new BitmapFactory.Options();
        options.inDither = false;
        options.inJustDecodeBounds = false;
        options.inPreferredConfig = Bitmap.Config.ARGB_8888;
        options.inSampleSize = 3;
        options.inPurgeable = true;
        Bitmap icon = BitmapFactory.decodeResource(resources,iID,options);
        return icon;
    }

}
