package com.chinese.music.chinesemusic.factory;

import com.chinese.music.chinesemusic.ui.ChineseMusicStatusBarWidget;
import com.chinese.music.chinesemusic.utils.ChineseMusicUtil;
import com.chinese.music.chinesemusic.utils.ResBundleUtil;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.openapi.wm.StatusBarWidget;
import com.intellij.openapi.wm.StatusBarWidgetFactory;
import org.jetbrains.annotations.Nls;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author jiayongqi
 * @date 2022/11/03 17:44
 **/
public class ChineseMusicStatusBarFactory implements StatusBarWidgetFactory {

    @Override
    public @NonNls @NotNull String getId () {
        return ChineseMusicUtil.PLUGIN_ID + "." + ChineseMusicStatusBarFactory.class.getName();
    }

    @Override
    public @Nls @NotNull String getDisplayName () {
        return ResBundleUtil.message("music.status.bar.displayname");
    }

    @Override
    public boolean isAvailable (@NotNull Project project) {
        return true;
    }

    @Override
    public @NotNull StatusBarWidget createWidget (@NotNull Project project) {
        return new ChineseMusicStatusBarWidget();
//        return null;
    }

    @Override
    public void disposeWidget (@NotNull StatusBarWidget widget) {
        Disposer.dispose(widget);
    }

    @Override
    public boolean canBeEnabledOn (@NotNull StatusBar statusBar) {
        return true;
    }
}
