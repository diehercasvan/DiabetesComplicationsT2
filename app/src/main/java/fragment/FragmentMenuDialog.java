package fragment;

import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;

import com.edibca.diabetescomplicationst2.R;

/**
 * Created by DIEGO CASALLAS on 12/02/2016.
 */
public class FragmentMenuDialog extends DialogFragment {
    private EditText editText;
    private Dialog dialog;

    public FragmentMenuDialog(){


    }
    public static FragmentMenuDialog newInstance(){
        FragmentMenuDialog fragmentMenuDialog =new FragmentMenuDialog();
        return fragmentMenuDialog;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.container_menu, container);



        return view;
    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }
}
