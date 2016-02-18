package Class_General;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import android.widget.Toast;

import com.edibca.diabetescomplicationst2.*;

/**
 * Created by DIEGO CASALLAS on 18/02/2016.
 */
public class ShareFiles {


    public ShareFiles() {

    }

    public void share(int iSelection) {
        try {
            Intent sendIntent = new Intent();
            sendIntent.setAction(Intent.ACTION_SEND);
            sendIntent.putExtra(Intent.EXTRA_EMAIL, General.CONTAINER_SHARE[0]);
            sendIntent.putExtra(Intent.EXTRA_SUBJECT, General.CONTAINER_SHARE[1]);
            sendIntent.putExtra(Intent.EXTRA_TEXT, General.CONTAINER_SHARE[2]);

            if (iSelection == 0) {
                sendIntent.setType("image/png");
            } else if (iSelection == 1) {
                sendIntent.setType("application/pdf");
            } else {
                sendIntent.setType("text/plain");
            }

            Uri myUri = Uri.parse("file://" +General.ROUTE+General.NAME_FILE);
            sendIntent.putExtra(Intent.EXTRA_STREAM, myUri);
            General.CONTEXT.startActivity(Intent.createChooser(sendIntent, General.CONTEXT.getString(R.string.share)));

        } catch (Exception e) {

            Log.w("Error :", e.getMessage());
        }

    }
}
