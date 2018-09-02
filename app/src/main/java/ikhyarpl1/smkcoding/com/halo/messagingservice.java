package ikhyarpl1.smkcoding.com.halo;

import android.util.Log;
import android.widget.Toast;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.messaging.FirebaseMessagingService;
import com.google.firebase.messaging.RemoteMessage;

import java.util.HashMap;
import java.util.Map;

public class messagingservice extends FirebaseMessagingService {
    @Override
    public void onNewToken(String s) {
        Log.d("NEW_TOKEN", s);
    }

    @Override
    public void onMessageReceived(RemoteMessage remoteMessage) {
        if (remoteMessage.getData().size() > 0) {

            // Mengambil data dalam bentuk Map
            Map<String, String> data = remoteMessage.getData();

            if (data.containsKey("pengirim") && data.containsKey("pesan")) {
                String sender = data.get("pengirim");
                String message = data.get("pesan");

                Log.d("NOTIF_SENDER", sender);
                Log.d("NOTIF_MESSAGE", message);
            }

            // TODO print jika data memiliki "title" dan "content"
            if (data.containsKey("title") && data.containsKey("content")) {
                String title = data.get("title");
                String content = data.get("content");

                Log.d("NOTIF_TITLE", title);
                Log.d("NOTIF_CONTENT", content);
            }

        }

        super.onMessageReceived(remoteMessage);
    }
}
