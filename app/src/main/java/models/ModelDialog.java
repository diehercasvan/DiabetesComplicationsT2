package models;



/**
 * Created by DIEGO  CASALLAS on 17/02/2016.
 */
public class ModelDialog {
    private String[] slistView;
    private String  sTitleDialog;
    private int  iDiImage;
    private String sRouteDownload;

    public String[] getSlistView() {
        return slistView;
    }

    public void setSlistView(String[] slistView) {
        this.slistView = slistView;
    }

    public String getsTitleDialog() {
        return sTitleDialog;
    }

    public void setsTitleDialog(String sTitleDialog) {
        this.sTitleDialog = sTitleDialog;
    }

    public int getiDiImage() {
        return iDiImage;
    }

    public void setiDiImage(int iDiImage) {
        this.iDiImage = iDiImage;
    }

    public String getsRouteDownload() {
        return sRouteDownload;
    }

    public void setsRouteDownload(String sRouteDownload) {
        this.sRouteDownload = sRouteDownload;
    }
}
