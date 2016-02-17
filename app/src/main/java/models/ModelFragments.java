package models;

import android.text.Layout;

/**
 * Created by DIEGO CASALLAS on 16/02/2016.
 */
public class ModelFragments {
    private int []iSrcImage;
    private String[] sTitlePage;
    private int[] iSrcImages;
    private String[] sTitleImages;
    private String sFileWebViews;
    private int[] iD_Layout;

    public int[] getiD_Layout() {
        return iD_Layout;
    }

    public void setiD_Layout(int[] iD_Layout) {
        this.iD_Layout = iD_Layout;
    }

    public String[] getsTitlePage() {
        return sTitlePage;
    }

    public void setsTitlePage(String[] sTitlePage) {
        this.sTitlePage = sTitlePage;
    }

    public int[] getiSrcImage() {
        return iSrcImage;
    }

    public void setiSrcImage(int[] iSrcImage) {
        this.iSrcImage = iSrcImage;
    }

    public int[] getiSrcImages() {
        return iSrcImages;
    }

    public void setiSrcImages(int[] iSrcImages) {
        this.iSrcImages = iSrcImages;
    }

    public String[] getsTitleImages() {
        return sTitleImages;
    }

    public void setsTitleImages(String[] sTitleImages) {
        this.sTitleImages = sTitleImages;
    }

    public String getsFileWebViews() {
        return sFileWebViews;
    }

    public void setsFileWebViews(String sFileWebViews) {
        this.sFileWebViews = sFileWebViews;
    }
}
