package com.reactnativewechatutil.wechat;

import com.facebook.react.bridge.Promise;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;
import com.tencent.mm.opensdk.modelmsg.SendAuth;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;

public class WeChatUtils extends  ReactContextBaseJavaModule {

    private static ReactApplicationContext reactContext;
    public static Promise promise;
    private final static String NOT_REGISTERED = "registerApp required.";

    private IWXAPI api = null;
    private String appId;

    public WeChatUtils(ReactApplicationContext context) {
        super(context);
        reactContext = context;
    }

    @Override
    public String getName() {
        return "WechatModule";
    }

    // 注册微信appId
    @ReactMethod
    private void registerApp(String appId, Promise promise) {
        WeChatUtils.promise = promise;
        try {
            this.appId = appId;
            api = WXAPIFactory.createWXAPI(reactContext.getApplicationContext(), null, false);
            WeChatUtils.promise.resolve(api.registerApp(appId));
        } catch (Exception e) {
            WeChatUtils.promise.reject("-1", e.getMessage());
        }
    }

    // 判断是否安装客户端
    @ReactMethod
    private void isWxInstalled(Promise promise) {
        WeChatUtils.promise = promise;
        try {
            if (api == null) {
                throw new Exception(NOT_REGISTERED);
            }
            WeChatUtils.promise.resolve(api.isWXAppInstalled());
        } catch (Exception e) {
            WeChatUtils.promise.reject("-1", e.getMessage());
        }
    }

    // 打开微信客户端
    @ReactMethod
    private void openWxApp(Promise promise) {
        WeChatUtils.promise = promise;
        try {
            if (api == null) {
                throw new Exception(NOT_REGISTERED);
            }
            WeChatUtils.promise.resolve(api.openWXApp());
        } catch (Exception e) {
            WeChatUtils.promise.reject("-1", e.getMessage());
        }
    }


    // 获取微信版本号
    @ReactMethod
    private void getAppVersion(Promise promise) {
        WeChatUtils.promise = promise;
        try {
            if (api == null) {
                throw new Exception(NOT_REGISTERED);
            }
            WeChatUtils.promise.resolve(api.getWXAppSupportAPI());
        } catch (Exception e) {
            WeChatUtils.promise.reject("-1", e.getMessage());
        }
    }

    // 微信授权登录
    @ReactMethod
    private void sendAuthRequest(String scope, String state, Promise promise) {
        WeChatUtils.promise = promise;
        try {
            if (api == null) {
                throw new Exception(NOT_REGISTERED);
            }
            SendAuth.Req req = new SendAuth.Req();
            req.scope = scope;
            req.state = state;
            WeChatUtils.promise.resolve(api.sendReq(req));
        } catch (Exception e) {
            WeChatUtils.promise.reject("-1", e.getMessage());
        }
    }
}
