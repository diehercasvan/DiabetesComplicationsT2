package Class_General;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;

import java.io.File;
import com.edibca.diabetescomplicationst2.*;
import models.ModelDialog;
import models.ModelFragments;

/**
 * Created by DIEGO CASALLAS on 16/02/2016.
 */
public class General {

    public  final static String URI_WEB="file:///android_asset/";
    public static Activity ACTIVITY;
    public static Context CONTEXT;
    public static int []iD_SrcImage;
    public static String[] sTitlePage;
    public static int[] iSrcImage;
    public static String[] sTitleImages;
    public static String sFIleWebView;
    public static int iD_Layout[];

    public static String[] slistView;
    public static String  sTitleDialog;
    public static int  iDiImage;
    public static String sRouteDownload;
    public static Drawable DRAWABLE;

    public static String []CONTAINER_SHARE;
    public static String NAME_FOLDER_SHARE;
    public static String ROUTE;
    public static String NAME_FILE;
    public static  String NAME_ROUTE_DOWNLOAD;

    public static final String PASSWORD = "sanofi";

    public static int iIDLogo;

    public General(Activity activity, Context context,String route) {

        this.ACTIVITY = activity;
        this.CONTEXT = context;
        this.NAME_FOLDER_SHARE=ACTIVITY.getResources().getString(R.string.folderApp);
        this.ROUTE=route+"/"+NAME_FOLDER_SHARE+"/";
        this.CONTAINER_SHARE= new String []{"",ACTIVITY.getResources().getString(R.string.app_name),""};
        this.iIDLogo=R.raw.logos;
        this.NAME_ROUTE_DOWNLOAD="http://creative-med.com/sanofi/Descargas_Android/Pdf/";
    }




    public static void LoadFragmentSlidePage(ModelFragments modelFragments) {

        iD_SrcImage = modelFragments.getiSrcImage();//They are the id image
        sTitlePage = modelFragments.getsTitlePage();//Are the titles of the page
        iSrcImage = modelFragments.getiSrcImages();//Ids are  images
        sTitleImages = modelFragments.getsTitleImages();//Are the titles of the images
        sFIleWebView = modelFragments.getsFileWebViews();//Are the uri of the page web
        iD_Layout = modelFragments.getiD_Layout();//They are the id layout

    }

    public static void LoadFragmentDialog(ModelDialog modelDialog) {

        slistView = modelDialog.getSlistView();//They are the id image
        sTitleDialog = modelDialog.getsTitleDialog();//Are the titles of the page
        iDiImage = modelDialog.getiDiImage();//Ids are  images       sTitleImages = modelDialog.getSlistView();//Are the titles of the images
        sRouteDownload = modelDialog.getsRouteDownload();//Are the uri of the page web


    }

    public static void deleteCache(Context context) {
        try {
            File dir = context.getCacheDir();
            if (dir != null && dir.isDirectory()) {
                deleteDir(dir);
            }
        } catch (Exception e) {}
    }

    public static boolean deleteDir(File dir) {
        if (dir != null && dir.isDirectory()) {
            String[] children = dir.list();
            for (int i = 0; i < children.length; i++) {
                boolean success = deleteDir(new File(dir, children[i]));
                if (!success) {
                    return false;
                }
            }
        }
        return dir.delete();
    }
}
