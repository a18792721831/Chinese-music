package com.chinese.music.chinesemusic.factory;

import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import org.jetbrains.annotations.NotNull;

/**
 * @author jiayongqi
 * @date 2022/11/02 15:20
 **/
public class ChineseMusicToolWindowFactory implements ToolWindowFactory {
    @Override
    public boolean isApplicable (@NotNull Project project) {
        return ToolWindowFactory.super.isApplicable(project);
    }

    @Override
    public void createToolWindowContent (@NotNull Project project, @NotNull ToolWindow toolWindow) {

    }

    @Override
    public void init (@NotNull ToolWindow toolWindow) {
        ToolWindowFactory.super.init(toolWindow);
    }

    @Override
    public boolean shouldBeAvailable (@NotNull Project project) {
        return ToolWindowFactory.super.shouldBeAvailable(project);
    }
}
