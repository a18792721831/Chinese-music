package com.chinese.music.chinesemusic.executor;

import com.intellij.openapi.Disposable;
import com.intellij.openapi.project.Project;
import com.intellij.openapi.util.Disposer;

/**
 * @author jiayongqi
 * @date 2022/11/02 15:15
 **/
public class CustomExecutor implements Disposable {

    private Project project;

    @Override
    public void dispose () {
        Disposer.dispose(this);
    }
}
