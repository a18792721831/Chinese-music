package com.chinese.music.chinesemusic.action;

import com.chinese.music.chinesemusic.executor.CustomExecutor;
import com.intellij.openapi.actionSystem.AnAction;
import com.intellij.openapi.actionSystem.AnActionEvent;

public class ChineseMusicMain extends AnAction {

    @Override
    public void actionPerformed (AnActionEvent e) {
        // TODO: insert action logic here
        CustomExecutor customExecutor = new CustomExecutor();

    }
}
