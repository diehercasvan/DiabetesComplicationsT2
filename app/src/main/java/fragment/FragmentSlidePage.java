package fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.edibca.diabetescomplicationst2.*;
import java.util.ArrayList;
import java.util.List;
import Class_General.General;
import adapters.ListAdapter;
import models.ListModels;


/**
 * Created by Sistemas2 on 9/02/2016.
 */
public class FragmentSlidePage extends Fragment {
    private DriverFragments driverFragments;

    /**
     * The argument key for the page number this fragment represents.
     */
    public static final String ARG_PAGE = "page";

    /**
     * The fragment's page number, which is set to the argument value for {@link #ARG_PAGE}.
     */
    private int mPageNumber;


    private static ViewGroup rootView;
    private TextView textView;

    private ImageView imageView;
    private static WebView webView;
    private ListView listView;
    private ListAdapter listAdapter;
    private List<ListModels> data;
    private ListModels listModels;

    /**
     * Factory method for this fragment class. Constructs a new fragment for the given page number.
     */


    public static FragmentSlidePage create(int pageNumber) {

        FragmentSlidePage fragment = new FragmentSlidePage();
        Bundle args = new Bundle();
        args.putInt(ARG_PAGE, pageNumber);
        fragment.setArguments(args);
        return fragment;
    }

    public FragmentSlidePage() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        mPageNumber = getArguments().getInt(ARG_PAGE);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout containing a title and body text.
        General.deleteCache(General.CONTEXT);
        switch (mPageNumber) {
            case 0:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 1:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[2], container, false);
                loadViewText(mPageNumber);
                break;
            case 2:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 3:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 4:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 5:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 6:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[1], container, false);
                loadViewMultipleImageText(mPageNumber);
                break;
            case 7:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[0], container, false);
                loadViewImage(mPageNumber);
                break;
            case 8:
                rootView = (ViewGroup) inflater.inflate(General.iD_Layout[2], container, false);
                loadViewText(mPageNumber);
                break;

        }


        Toast.makeText(getActivity(), "Este  es el  valor  :" + mPageNumber, Toast.LENGTH_LONG).show();

        // Set the title view to show the page number.
        // ((TextView) rootView.findViewById(android.R.id.text1)).setText(getString(R.string.title_template_step, mPageNumber + 1));
        loadView(mPageNumber);

        return rootView;
    }

    /**
     * Returns the page number represented by this fragment object.
     */
    public int getPageNumber() {
        return mPageNumber;
    }

    public void loadView(int iTitleSelection) {
        textView = (TextView) rootView.findViewById(R.id.textTitlePage);
        textView.setText(General.sTitlePage[iTitleSelection]);



    }

    public void loadViewImage(int iSelectionPage) {
        imageView = (ImageView) rootView.findViewById(R.id.imageFragment);
        switch (iSelectionPage) {

            case 7:
                imageView.setImageResource(General.iD_SrcImage[0]);
                break;

        }


    }

    public void loadViewText(int iSelectionPage) {

        selectionPageWeb(iSelectionPage);

    }

    public void loadViewMultipleImageText(int iSelectionPage) {

        selectionPageWeb(iSelectionPage);

        selectionImageList(iSelectionPage);

    }

    public void selectionImageList(int iselection) {

        ArrayList<Integer> iIdArrayList =new ArrayList<>();
        ArrayList<String> sTitleArrayList=new ArrayList<>();

        data = new ArrayList<>();
        listView = (ListView) rootView.findViewById(R.id.listViewImages);

        switch (iselection) {

            case 0:
                iIdArrayList.add(General.iSrcImage[0]);
                sTitleArrayList.add(General.sTitleImages[0]);
                break;
            case 2:
                iIdArrayList.add(General.iSrcImage[1]);
                iIdArrayList.add(General.iSrcImage[2]);
                iIdArrayList.add(General.iSrcImage[3]);
                iIdArrayList.add(General.iSrcImage[4]);
                sTitleArrayList.add(General.sTitleImages[1]);
                sTitleArrayList.add(General.sTitleImages[2]);
                sTitleArrayList.add(General.sTitleImages[3]);
                sTitleArrayList.add(General.sTitleImages[4]);
                break;
            case 3:
                iIdArrayList.add(General.iSrcImage[5]);
                sTitleArrayList.add(General.sTitleImages[5]);

                break;
            case 4:
                iIdArrayList.add(General.iSrcImage[6]);
                iIdArrayList.add(General.iSrcImage[7]);
                sTitleArrayList.add(General.sTitleImages[6]);
                sTitleArrayList.add(General.sTitleImages[7]);


                break;
            case 5:
                iIdArrayList.add(General.iSrcImage[8]);
                iIdArrayList.add(General.iSrcImage[9]);
                iIdArrayList.add(General.iSrcImage[10]);
                iIdArrayList.add(General.iSrcImage[11]);
                sTitleArrayList.add(General.sTitleImages[8]);
                sTitleArrayList.add(General.sTitleImages[9]);
                sTitleArrayList.add(General.sTitleImages[10]);
                sTitleArrayList.add(General.sTitleImages[11]);

                break;
            case 6:
                iIdArrayList.add(General.iSrcImage[12]);
                sTitleArrayList.add(General.sTitleImages[12]);

                break;

        }
        for (int i = 0; i < iIdArrayList.size(); i++) {
            listModels = new ListModels();
            listModels.setsName("");
            listModels.setsDescription(sTitleArrayList.get(i));
            listModels.setiImgUrl(iIdArrayList.get(i));
            data.add(listModels);

        }
        listAdapter = new ListAdapter(getActivity(), data);
        listView.setAdapter(listAdapter);
        General.deleteCache(General.CONTEXT);
    }

    public void selectionPageWeb(int iSelectionWeb) {
        String sUri = General.sFIleWebView + "/sec_" + iSelectionWeb + ".html";

        webView = (WebView) rootView.findViewById(R.id.webView);

        webView.setWebChromeClient(new WebChromeClient());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        webView.loadUrl(General.URI_WEB + sUri);

        //webView.removeAllViews();
        //webView.destroy();
    }



}
