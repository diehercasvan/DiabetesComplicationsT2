package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;
import com.edibca.diabetescomplicationst2.*;

/**
 * Created by Sistemas2 on 9/02/2016.
 */
public class FragmentSlidePage extends Fragment{
    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */
    public static  FragmentSlidePage create(int pageNumber){

        FragmentSlidePage fragment=new FragmentSlidePage();
        Bundle args=new Bundle();
        args.putInt(ARG_PAGE,pageNumber);
        fragment.setArguments(args);
        return fragment;
    }
    public FragmentSlidePage() {
    }
    @Override
    public void onCreate(Bundle savedInstanceState){

        super.onCreate(savedInstanceState);
        mPageNumber=getArguments().getInt(ARG_PAGE);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        ViewGroup rootView ;
        if(mPageNumber>=0 && mPageNumber<=2){
            rootView= (ViewGroup) inflater.inflate(R.layout.fragment_screen_slide_page, container, false);
        }
        else{
            rootView= (ViewGroup) inflater.inflate(R.layout.oter, container, false);
        }

        Toast.makeText(getActivity(), "Este  es el  valor  :" + mPageNumber, Toast.LENGTH_LONG).show();

        // Set the title view to show the page number.
        ((TextView) rootView.findViewById(android.R.id.text1)).setText(getString(R.string.title_template_step, mPageNumber + 1));

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }
}
