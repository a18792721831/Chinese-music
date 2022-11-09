package com.chinese.music.chinesemusic.ui;

import com.chinese.music.chinesemusic.utils.ChineseMusicUtil;
import com.intellij.openapi.util.Disposer;
import com.intellij.openapi.wm.CustomStatusBarWidget;
import com.intellij.openapi.wm.StatusBar;
import com.intellij.ui.ClickListener;
import com.intellij.util.ui.update.Activatable;
import icons.ChineseMusicIcons;
import java.awt.CardLayout;
import java.awt.event.MouseEvent;
import javax.swing.Icon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * @author jiayongqi
 * @date 2022/11/04 10:02
 **/
public class ChineseMusicStatusBarWidget implements CustomStatusBarWidget, Activatable {
    private static final String CARD_NAME_PLAY = "status.play";
    private static final String CARD_NAME_PAUSE = "status.pause";
    private static final String CARD_NAME_MUSIC = "status.music";
    private JPanel rootJPanel;
    private CardLayout cardLayout;
    private JLabel playLabel;
    private JLabel pauseLabel;
    private JLabel musicLabel;

    public ChineseMusicStatusBarWidget () {
        initComponent();
        addButtonListener();
    }

    private void addButtonListener () {
        new ClickListener() {
            @Override
            public boolean onClick (@NotNull MouseEvent event, int clickCount) {
                //noinspection CallToSystemGC
                cardLayout.show(rootJPanel, CARD_NAME_PAUSE);
                return true;
            }
        }.installOn(playLabel, true);
        new ClickListener() {
            @Override
            public boolean onClick (@NotNull MouseEvent event, int clickCount) {
                //noinspection CallToSystemGC
                cardLayout.show(rootJPanel, CARD_NAME_PLAY);
                return true;
            }
        }.installOn(pauseLabel, true);
        new ClickListener() {
            @Override
            public boolean onClick (@NotNull MouseEvent event, int clickCount) {
                //noinspection CallToSystemGC
                cardLayout.show(rootJPanel, CARD_NAME_PAUSE);
                return true;
            }
        }.installOn(musicLabel, true);
    }

    private void initComponent () {
        rootJPanel = new JPanel();
        cardLayout = new CardLayout();
        playLabel = new JLabel();
        pauseLabel = new JLabel();
        musicLabel = new JLabel();
        rootJPanel.setLayout(cardLayout);
        Icon playIcon = ChineseMusicIcons.PlayIcon;
        Icon pauseIcon = ChineseMusicIcons.PauseIcon;
        Icon musicIcon = ChineseMusicIcons.ToolWindowIcon;
        playLabel.setIcon(playIcon);
        pauseLabel.setIcon(pauseIcon);
        musicLabel.setIcon(musicIcon);
        rootJPanel.add(musicLabel, CARD_NAME_MUSIC);
        rootJPanel.add(playLabel, CARD_NAME_PLAY);
        rootJPanel.add(pauseLabel, CARD_NAME_PAUSE);
    }


    @Override
    public JComponent getComponent () {
        return rootJPanel;
    }

    @Override
    public @NonNls @NotNull String ID () {
        return ChineseMusicUtil.PLUGIN_ID + "." + ChineseMusicStatusBarWidget.class.getName();
    }

    @Override
    public void install (@NotNull StatusBar statusBar) {

    }

    @Override
    public void dispose () {
        Disposer.dispose(this);
    }
}
