package com.chinese.music.chinesemusic.factory;

import com.chinese.music.chinesemusic.ui.ChineseMusicToolWindow;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.wm.ToolWindow;
import com.intellij.openapi.wm.ToolWindowFactory;
import com.intellij.ui.content.Content;
import com.intellij.ui.content.ContentFactory;
import lombok.SneakyThrows;
import org.apache.commons.lang.StringUtils;
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

    @SneakyThrows
    @Override
    public void createToolWindowContent (@NotNull Project project, @NotNull ToolWindow toolWindow) {
        ChineseMusicToolWindow chineseMusicToolWindow = new ChineseMusicToolWindow();
        ContentFactory contentFactory = ContentFactory.SERVICE.getInstance();
        Content content = contentFactory.createContent(chineseMusicToolWindow.getRootJPanel(), StringUtils.EMPTY, false);
        toolWindow.getContentManager().addContent(content);
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
