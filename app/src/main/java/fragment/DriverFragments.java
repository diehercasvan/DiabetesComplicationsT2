package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.edibca.diabetescomplicationst2.*;
import java.util.zip.Inflater;

/**
 * Created by DIEGO CASALLAS on 16/02/2016.
 */
public class DriverFragments extends Fragment implements View.OnClickListener {
    private View view;
    private ImageView imageView;
    public int iSrc = 0;
    public int iSelectionFragment = 0;


    public DriverFragments() {


    }
    public  View createView(){
        imageView = (ImageView) view.findViewById(R.id.imageFragment);
        imageView.setImageResource(iSrc);
        return  view;
    }

    @Nullable
     /*@Override
   public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        view = inflater.inflate(R.layout.image_fragments, container, false);
        if (iSelectionFragment == 0) {
            loadViewImage();
        }
        return view;
    }*/

    public void loadViewImage() {


        imageView = (ImageView) view.findViewById(R.id.imageFragment);
        imageView.setImageResource(iSrc);

    }

    public void loadViewImageText() {


    }

    public void loadViewMultipleImageText() {


    }

    @Override
    public void onClick(View v) {

    }
}
