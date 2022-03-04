package com.example.bluetoothdemoandroid12;

import android.annotation.SuppressLint;
import android.content.Context;
import android.media.AudioManager;

import org.json.JSONArray;
import org.json.JSONException;

/**
 * Created by Maulik Dadhaniya on 3/3/22.
 */
public class AudioTogglePlugin {
    public static final String ACTION_SET_AUDIO_MODE = "setAudioMode";

    @SuppressLint("WrongConstant")
    public boolean setAudioMode(String mode,Context mContext) {
        AudioManager audioManager =
                (AudioManager) mContext.getSystemService(Context.AUDIO_SERVICE);

        if (mode.equals("earpiece")) {
            audioManager.setMode(AudioManager.MODE_IN_COMMUNICATION);
            audioManager.setSpeakerphoneOn(false);
            audioManager.setBluetoothScoOn(true);
            audioManager.startBluetoothSco();
            return true;
        } else if (mode.equals("speaker")) {
            audioManager.setMode(AudioManager.STREAM_MUSIC);
            audioManager.setSpeakerphoneOn(true);
            audioManager.stopBluetoothSco();
            audioManager.setBluetoothScoOn(false);
            return true;
        }

        return false;
    }

}
