package models;

/**
 * Created by Sistemas2 on 10/02/2016.
 */
public class ListModels {
    private String sId;
    private String sName;
    private String sDescription;
    private int iImgUrl;

    public String getsId() {
        return sId;
    }

    public void setsId(String sId) {
        this.sId = sId;
    }

    public String getsName() {
        return sName;
    }

    public void setsName(String sName) {
        this.sName = sName;
    }

    public String getsDescription() {
        return sDescription;
    }

    public void setsDescription(String sDescription) {
        this.sDescription = sDescription;
    }

    public int getiImgUrl() {
        return iImgUrl;
    }

    public void setiImgUrl(int  iImgUrl) {
        this.iImgUrl = iImgUrl;
    }
}
