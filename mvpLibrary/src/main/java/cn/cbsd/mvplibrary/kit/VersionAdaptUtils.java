package cn.cbsd.mvplibrary.kit;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.support.v4.content.FileProvider;

import java.io.File;

/**
 * 当前类注释:sdk版本适配工具
 *
 * @author zhenyanjun
 * @date 2018/11/1 14:22
 */
public class VersionAdaptUtils {

    public static Uri getUriFromFile(Intent intent, Context context, File file) {
        Uri fileUri = null;
        //7.0以上
        if (Build.VERSION.SDK_INT >= 24) {
            fileUri = FileProvider.getUriForFile(context, context.getPackageName() +
                    ".fileprovider", file);
            //添加这一句表示对目标应用临时授权该Uri所代表的文件
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
        } else {
            fileUri = Uri.fromFile(file);
        }
        return fileUri;
    }
}
