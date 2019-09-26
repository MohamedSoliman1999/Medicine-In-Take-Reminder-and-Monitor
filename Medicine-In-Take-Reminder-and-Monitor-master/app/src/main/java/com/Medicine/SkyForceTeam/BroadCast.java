package com.Medicine.SkyForceTeam;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.provider.Settings;

import androidx.core.app.NotificationCompat;

public class BroadCast extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {

       final Notify notify = new Notify(context);

       final MediaPlayer mediaPlayer = MediaPlayer.create(context , Settings.System.DEFAULT_RINGTONE_URI);

       mediaPlayer.start();

       mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {

           int played = 1;

           @Override
           public void onCompletion(MediaPlayer mp) {

               if (played<=4){
                   played++;
                   mediaPlayer.start();
                   mediaPlayer.seekTo(0);
               }
               else {
                   played = 1;
                   mediaPlayer.seekTo(0);


                   NotificationCompat.Builder np = notify.getChannelN("success","success");
                   notify.getManager().notify(1,np.build());
               }

           }
       });


    }
}
