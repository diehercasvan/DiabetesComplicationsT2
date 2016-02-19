package Class_General;

/**
 * Created by Diego Casallas  on  16/04/2015.
 */

import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;
import android.util.Log;

import com.edibca.diabetescomplicationst2.R;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URL;
import java.net.URLConnection;


public final class DownloadFile extends AsyncTask<String,String,String> {
    // Progress Dialog
    private ProgressDialog pDialog;
    // Progress dialog type (0 - for Horizontal progress bar)
    public static final int progress_bar_type = 0;
    private Activity mainActivity = null;
    private Context mainContext = null;
    private String dataDirPath="";
    private String nameArchive="";
    private long  s;
    private File dir;
    public  boolean bValidaDescarga=false;
    public boolean bValidaCancelar=true;
    public Connections ObjConexion;
    private Class_control clase_control=null;
    private boolean bType;

    public DownloadFile(Activity a, Context c, String sRuta, String sNombre, boolean type){
        this.mainActivity = a;
        this.mainContext = c;
        this.dataDirPath=sRuta;
        this.nameArchive=sNombre;
        this.bType=type;
        pDialog = new ProgressDialog(mainContext);
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pDialog.setMessage(mainActivity.getResources().getString(R.string.downloadFile));
        pDialog.setIndeterminate(false);
        pDialog.setMax(100);
        pDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        pDialog.setCancelable(false);
        pDialog.setButton(DialogInterface.BUTTON_NEGATIVE, mainActivity.getResources().getString(R.string.downloadFileCancel), new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                eliminarContenido(dataDirPath+"/"+nameArchive);
                pDialog.setProgress(0);
                bValidaCancelar=false;
                dialog.dismiss();
            }
        });
        pDialog.show();
        pDialog.show();
    }
    @Override
    protected String doInBackground(String... params) {
        int count=0;
        try {
            URL url = new URL(params[0]);
            URLConnection conection = url.openConnection();
            conection.connect();
            // this will be useful so that you can show a typical 0-100%
            int lenghtOfFile = conection.getContentLength();
            // download the file
            InputStream input = new BufferedInputStream(url.openStream(),8192);
               /* Output stream
                * Folder path : http://www.javaquery.com/2013/06/how-to-get-data-directory-path-in.html
                */

            OutputStream output = new FileOutputStream(dataDirPath+"/"+nameArchive);
            byte data[] = new byte[1024];
            long total = 0;

            while (((count = input.read(data)) != -1)&& bValidaCancelar) {
                if(ValidaEstadoConexion()) {
                total += count;
                }
                // publishing the progress....
                // After this onProgressUpdate will be called
               publishProgress("" + (int) ((total * 100) / lenghtOfFile));
                // writing data to file
                s=(int) ((total * 100) / lenghtOfFile);


                output.write(data, 0, count);
            }
            if(total==lenghtOfFile){

                bValidaDescarga=true;
            }
            else{

                pDialog.setProgress(0);
                publishProgress(""+0);
            }
            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {

            Log.e("Error: ", e.getMessage());
        }
        return null;
    }
    /**
     * Updating progress bar
     * */
    protected void onProgressUpdate(String... progress) {
        // setting progress percentage
        this.pDialog.setProgress(Integer.parseInt(progress[0]));
    }

    /**
     * After completing background task Dismiss the progress dialog
     * **/
    //@SuppressWarnings("deprecation")
    @Override
    protected void onPostExecute(String file_url) {
        // dismiss the dialog after the file was downloaded
        pDialog.dismiss();
        String imagePath = dataDirPath+"/"+nameArchive;
        // setting downloaded into image view
        //my_image.setImageDrawable(Drawable.createFromPath(imagePath));
        //dir= new File(imagePath);
        AlertDialog.Builder builder  = new AlertDialog.Builder(mainActivity);

        if(bValidaDescarga && bValidaCancelar){
            // Setting Dialog Title
            builder .setTitle(mainActivity.getResources().getString(R.string.app_name));
            // Setting Dialog Message
            builder .setMessage(mainActivity.getResources().getString(R.string.downloadOk));
            // Setting OK Button
            builder .setPositiveButton(mainActivity.getResources().getString(R.string.downloadFileAccept), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    clase_control = new Class_control(mainActivity);
                    clase_control.executeFile(dataDirPath + "/" + nameArchive, bType);
                }
            });
            AlertDialog alertDialog=builder .create();
            alertDialog.show();


        }

        else{
            // Setting Dialog Title
            builder.setTitle(mainActivity.getResources().getString(R.string.app_name));
            // Setting Dialog Message
            builder.setMessage(mainActivity.getResources().getString(R.string.downloadError));
            // Setting OK Button
            builder.setNegativeButton(mainActivity.getResources().getString(R.string.downloadFileAccept), new DialogInterface.OnClickListener() {
                public void onClick(final DialogInterface dialog,final int which) {


                }
            });
            AlertDialog alertDialog=builder .create();
            alertDialog.show();
            eliminarContenido(imagePath);

        }
        bValidaCancelar=true;
        bValidaDescarga=false;

    }
    public  void eliminarContenido(String sRuta){

        dir= new File(sRuta);
        if(dir.delete()){


        }

    }
    //Valida conexion
    public  boolean ValidaEstadoConexion(){

        ObjConexion=new Connections(mainContext);
        if(ObjConexion.redConexion()==1 || ObjConexion.redConexion()==0){


            return true;

        }
        return false;
    }
}