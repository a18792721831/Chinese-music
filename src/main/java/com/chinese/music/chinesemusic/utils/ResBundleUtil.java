package com.chinese.music.chinesemusic.utils;

import com.intellij.AbstractBundle;
import java.util.ResourceBundle;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.PropertyKey;

/**
 * @author jiayongqi
 * @date 2022/11/03 18:05
 **/
public final class ResBundleUtil {

    @NonNls
    private static final String BUNDLE_NAME = "i18n";

    private static final ResourceBundle BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);

    private ResBundleUtil(){

    }

    public static @Nls String message(@PropertyKey(resourceBundle = BUNDLE_NAME) String key, Object ...params) {
        return AbstractBundle.message(BUNDLE, key, params);
    }
}
