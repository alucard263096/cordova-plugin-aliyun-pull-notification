package cordova-plugin-aliyun-pull-notification;

import org.apache.cordova.CordovaPlugin;
import org.apache.cordova.CallbackContext;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;
import com.alibaba.sdk.android.callback.InitResultCallback;
import com.alibaba.sdk.android.push.CloudPushService;
import com.alibaba.sdk.android.push.CommonCallback;
import com.alibaba.sdk.android.push.noonesdk.PushServiceFactory;

/**
 * This class echoes a string called from JavaScript.
 */
public class AliyunPullNotification extends CordovaPlugin {
	private static final String TAG = "AliyunPullNotification";
    @Override
    public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
        if (action.equals("startPull")) {
            this.startPull("", callbackContext);
            return true;
        }
        return false;
    }

    private void startPull(String message, CallbackContext callbackContext) {
		try{

			PushServiceFactory.init(this.cordova.getActivity().getApplicationContext());
			CloudPushService pushService = PushServiceFactory.getCloudPushService();
			pushService.register(applicationContext, new CommonCallback() {
				@Override
				public void onSuccess(String response) {
					Log.d(TAG, "init cloudchannel success");
					callbackContext.success("success");
				}
				@Override
				public void onFailed(String errorCode, String errorMessage) {
					Log.d(TAG, "init cloudchannel failed -- errorcode:" + errorCode + " -- errorMessage:" + errorMessage);
					callbackContext.error("Expected one non-empty string argument.");
				}
			});
		}catch(){
            callbackContext.error("Expected one non-empty string argument.");
		}
		
    }
}
