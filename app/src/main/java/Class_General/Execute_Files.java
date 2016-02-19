package Class_General;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import java.io.File;

import com.edibca.diabetescomplicationst2.*;

/**
 * Created by Diego Casallas on 09/06/2015.
 */
public class Execute_Files {
    private String sFile_Route;
    private Activity activity;
    private Context context;
    private File file;
    private boolean bValidaConexion;
    private DownloadFile downloadFile;
    private DownloadFileDirect downloadFileDirect;
    private Connections connections;
    private Class_control Obj_Class_control;
    private  boolean bType;

    public Execute_Files(){
        context=General.CONTEXT;
        sFile_Route= General.ROUTE;
        activity=General.ACTIVITY;
        Obj_Class_control=new Class_control(activity);
    }

    public  void executeFiles(String route, String name_File,boolean type,boolean typeDownload){

        bType=type;
        String sRoute=sFile_Route+"/"+name_File;

        file=new File(sRoute);
        //Toast.makeText(activity,"Esta es la ruta"+sFile_Route+" o esta"+name_File,Toast.LENGTH_LONG);
        if(file.exists()){
            if(typeDownload) {
                Obj_Class_control.executeFile(sRoute, type);
            }
        }
        else{
            file=new File(sFile_Route);
            if(!file.isDirectory()){
                file.mkdir();
            }
            if(file.exists()){
                if(typeDownload){
                    if(ConnectionValidate()){
                        downloadFile = new DownloadFile(activity, context, sFile_Route, name_File, bType);

                        downloadFile.execute(route);
                    }
                }
                else{
                    if(ConnectionValidate()) {
                        downloadFileDirect = new DownloadFileDirect(activity, context, sFile_Route, name_File);
                        downloadFileDirect.execute(route);
                    }

                }

            }

        }

        /* }
       catch(Exception e)
        {

            Log.i("Create folder ","Error :"+e.getMessage());
        }*/
    }
    //Connection to  validate
    public  boolean  ConnectionValidate(){
        bValidaConexion=false;
        connections=new Connections(activity);
        bValidaConexion=false;
        final AlertDialog.Builder JOptionPane =new AlertDialog.Builder(activity);
        if(connections.redConexion()==0){
            bValidaConexion=true;
        }
        else if(connections.redConexion()==1){
            JOptionPane.setTitle(activity.getResources().getString(R.string.downloadFileTitle));
            JOptionPane.setMessage(activity.getResources().getString(R.string.downloadFileDialog));
            JOptionPane.setPositiveButton(activity.getResources().getString(R.string.downloadFileAccept),new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    bValidaConexion=true;
                }
            });
            JOptionPane.setNegativeButton(activity.getResources().getString(R.string.downloadFileCancel),new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    bValidaConexion =false;
                }
            });

            JOptionPane.create();
            JOptionPane.show();
        }
        else if(connections.redConexion()==2){

            JOptionPane.setTitle(activity.getResources().getString(R.string.downloadFileTitle));
            JOptionPane.setMessage(activity.getResources().getString(R.string.downloadFileError));
            JOptionPane.create();
            JOptionPane.show();
            bValidaConexion=false;
        }
        return bValidaConexion;

    }
}
