package fragment;

import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.edibca.diabetescomplicationst2.R;

import Class_General.General;
import Interfaces.IntMenuSelector;

/**
 * Created by DIEGO CASALLAS on 12/02/2016.
 */
public class FragmentMenuDialog extends DialogFragment implements View.OnClickListener {
    private ListView listView;
    private TextView textView;
    private ImageView imageView;
    private ImageView iBtnPrevious;
    private ArrayAdapter<String> arrayAdapter;
    private Dialog dialog;
    private View view;
    private IntMenuSelector myCallback;

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            myCallback = (IntMenuSelector) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()+ " must implement MyCallback");
        }
    }
    public FragmentMenuDialog(){


    }
    public static FragmentMenuDialog newInstance(){
        FragmentMenuDialog fragmentMenuDialog =new FragmentMenuDialog();
        return fragmentMenuDialog;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
         view = inflater.inflate(R.layout.container_menu, container);

        loadFragment();

        return view;
    }
    public void  loadFragment(){

        listView=(ListView)view.findViewById(R.id.listView);
        arrayAdapter=new ArrayAdapter<>(getActivity(),android.R.layout.simple_list_item_1, General.slistView);
        listView.setAdapter(arrayAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String selectedSweet = listView.getItemAtPosition(position).toString();
                Toast.makeText(getActivity(), "Selected item: " + selectedSweet + " - " + position, Toast.LENGTH_SHORT).show();
                myCallback.SelectionMenuItem(0);
            }
        });
        textView=(TextView)view.findViewById(R.id.textTitleDialog);
        textView.setText(General.sTitleDialog);

        imageView=(ImageView)view.findViewById(R.id.imgSection);
        imageView.setImageResource(General.iDiImage);

        iBtnPrevious=(ImageView)view.findViewById(R.id.imgPrevious);
        iBtnPrevious.setOnClickListener(this);




    }
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        dialog = super.onCreateDialog(savedInstanceState);
        dialog.getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        return dialog;
    }

    @Override
    public void onClick(View v) {

    }
}
