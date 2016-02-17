package adapters;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.edibca.diabetescomplicationst2.*;

import java.util.List;

import models.ListModels;

/**
 * Created by Sistemas2 on 10/02/2016.
 */
public class ListAdapter extends BaseAdapter{
    private Context context;
    private List<ListModels> data;
    private int iWidthIMG,iHeightIMG;

    public ListAdapter(Context context, List<ListModels> data) {
        this.context = context;
        this.data=data;

        WindowManager windowManager=(WindowManager)context.getSystemService(Context.WINDOW_SERVICE);
        Display display=windowManager.getDefaultDisplay();

        DisplayMetrics metrics=new DisplayMetrics();
        display.getMetrics(metrics);

        iWidthIMG=display.getWidth();
        //iHeightIMG=context.getResources().getDimensionPixelSize(R.dimen.template_img_height);
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
        View v;
        if(convertView!=null)
            v=convertView;
        else
        v=View.inflate(context,R.layout.fragement_adapter_image,null);
        ListModels listModels=(ListModels)getItem(position);
        TextView textView=(TextView)v.findViewById(R.id.title);
        textView.setText(listModels.getsName());
        textView=(TextView)v.findViewById(R.id.description);
        textView.setText(listModels.getsDescription());
        final ImageView imageView=(ImageView)v.findViewById(R.id.img);
        imageView.setImageResource(listModels.getiImgUrl());
        imageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context,"It drawable : "+imageView.getId(),Toast.LENGTH_LONG).show();
            }
        });

        return v;
    }
}
