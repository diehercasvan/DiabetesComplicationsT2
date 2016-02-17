package Class_General;

import android.app.Activity;
import android.content.Context;

import java.io.File;

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

    public static void LoadFragmentSlidePage(ModelFragments modelFragments) {

        iD_SrcImage = modelFragments.getiSrcImage();//They are the id image
        sTitlePage = modelFragments.getsTitlePage();//Are the titles of the page
        iSrcImage = modelFragments.getiSrcImages();//Ids are  images
        sTitleImages = modelFragments.getsTitleImages();//Are the titles of the images
        sFIleWebView = modelFragments.getsFileWebViews();//Are the uri of the page web
        iD_Layout = modelFragments.getiD_Layout();//They are the id layout

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