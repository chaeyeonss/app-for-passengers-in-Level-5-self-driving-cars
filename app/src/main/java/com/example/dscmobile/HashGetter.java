package com.example.dscmobile;


import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import android.util.Log;

import androidx.annotation.Nullable;

import java.security.MessageDigest;
import java.util.Base64;

public class HashGetter {
    @Nullable
    public static String getHashKey(Context context){
        final String TAG = "KeyHash";
        String keyHash = null;
        try{
            PackageInfo info = context.getPackageManager().getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES);
            for (Signature signature : info.signatures){
                MessageDigest md;
                md = MessageDigest.getInstance("SHA");
                md.update(signature.toByteArray());
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    keyHash = new String(Base64.getEncoder().encodeToString(md.digest()));
                }
                Log.d(TAG,keyHash);
            }
        } catch (Exception e) {
            Log.e("name not found", e.toString());
        }
        if (keyHash != null){
            return keyHash;
        }else{
            return null;
        }
    }
}
