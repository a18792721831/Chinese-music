package com.chinese.music.chinesemusic.ui;

import com.chinese.music.chinesemusic.utils.ResBundleUtil;
import com.intellij.ui.ClickListener;
import com.intellij.ui.JBColor;
import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import icons.ChineseMusicIcons;
import java.awt.CardLayout;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;
import javax.swing.plaf.metal.MetalSliderUI;
import javax.swing.text.BadLocationException;
import javax.swing.text.DefaultStyledDocument;
import lombok.Getter;
import org.jetbrains.annotations.NotNull;

/**
 * @author jiayongqi
 * @date 2022/11/02 16:02
 **/
public class ChineseMusicToolWindow {
//    private JProgressBar progressTime;
//    private JButton play;
//    private JButton skipForward;
//    private JButton playCircle;
//    private JButton playShuffle;
//    private JProgressBar volumeProgress;
//    private JLabel currentTime;
//    private JLabel musicTime;
//    private JLabel musicAuthor;
//    private JLabel musicName;
//    private JButton musicAdd;
//    private JButton showMusicPlayList;
//    private JPanel circlePlayPanel;
//    private JPanel musicPlayPanel;
//    private JButton pause;
//    private JButton stopPlayCircle;
//    private JPanel volumePanel;
//    private JButton cancelVolume;
//    private JButton volumeLess;
//    private JButton volumeMore;
//    private JButton volumeMiddle;

    private static final String CARD_NAME_PLAY = "play";
    private static final String CARD_NAME_PAUSE = "pause";
    private static final String CARD_NAME_PLAY_CIRCLE = "play.circle";
    private static final String CARD_NAME_PLAY_CIRCLE_STOP = "play.circle.stop";
    private static final String CARD_NAME_PLAY_VOLUME_CANCEL = "volume.cancel";
    private static final String CARD_NAME_PLAY_VOLUME_LESS = "volume.less";
    private static final String CARD_NAME_PLAY_VOLUME_MIDDLE = "volume.middle";
    private static final String CARD_NAME_PLAY_VOLUME_MORE = "volume.more";

    @Getter
    private JPanel rootJPanel;
    private GridLayoutManager layout;
    private JTextPane musicWord;
    private JLabel skipBack;
    private JPanel playPauseJPanel;
    private CardLayout playPauseLayout;
    private JLabel play;
    private JLabel pause;
    private JLabel skipForward;
    private JLabel folderPlus;
    private JLabel musicName;
    private JLabel shuffle;
    private JPanel playCircleJPanel;
    private CardLayout playCircleLayout;
    private JLabel playCircle;
    private JLabel playCircleStop;
    private JLabel currentTime;
    private JLabel musicAuthor;
    private JLabel musicTime;
    private JPanel volumeJPanel;
    private CardLayout volumeLayout;
    private JLabel volumeX;
    private JLabel volumeLess;
    private JLabel volumeMiddle;
    private JLabel volumeMore;
    private JSlider volumeSlider;
    private JLabel musicList;
    private JLabel volumeView;
    private JSlider currentTimeSlider;
    DefaultStyledDocument musicWordDocument;


    public ChineseMusicToolWindow () throws BadLocationException {
        initComponent();
        addListener();
    }

    private void initComponent () throws BadLocationException {
        rootJPanel = new JPanel();
        layout = new GridLayoutManager(5, 11, new Insets(0, 0, 0, 0), - 1, - 1);
        rootJPanel.setLayout(layout);

        musicWord = new JTextPane();
        musicWord.setEditable(false);
        musicWord.setEditable(false);
        musicWordDocument = new DefaultStyledDocument();
        musicWordDocument.insertString(0, "music\nword", null);
        musicWord.setDocument(musicWordDocument);
        rootJPanel.add(musicWord, getConstraints(0, 0, 2, 10));

        folderPlus = new JLabel();
        folderPlus.setIcon(ChineseMusicIcons.FolderPlus24Icon);
        folderPlus.setToolTipText(ResBundleUtil.message("music.add.like.tip"));
        rootJPanel.add(folderPlus, getConstraints(2, 3, 1, 1));

        musicName = new JLabel();
        musicName.setText("musicName");
        musicName.setToolTipText(ResBundleUtil.message("music.name"));
        rootJPanel.add(musicName, getConstraints(2, 4, 1, 1));

        shuffle = new JLabel();
        shuffle.setIcon(ChineseMusicIcons.Shuffle24Icon);
        shuffle.setToolTipText(ResBundleUtil.message("play.shuffle.tip"));
        rootJPanel.add(shuffle, getConstraints(2, 5, 1, 1));

        playCircleJPanel = new JPanel();
        playCircleLayout = new CardLayout();
        playCircleJPanel.setLayout(playCircleLayout);
        playCircle = new JLabel();
        playCircle.setIcon(ChineseMusicIcons.PlayCircle24Icon);
        playCircle.setToolTipText(ResBundleUtil.message("play.circle.tip"));
        playCircleJPanel.add(playCircle, CARD_NAME_PLAY_CIRCLE);
        playCircleStop = new JLabel();
        playCircleStop.setIcon(ChineseMusicIcons.StopCircle24Icon);
        playCircleStop.setToolTipText(ResBundleUtil.message("stop.play.circle"));
        playCircleJPanel.add(playCircleStop, CARD_NAME_PLAY_CIRCLE_STOP);
        rootJPanel.add(playCircleJPanel, getConstraints(2, 6, 1, 1));

        musicList = new JLabel();
        musicList.setIcon(ChineseMusicIcons.List24Icon);
        musicList.setToolTipText(ResBundleUtil.message("show.music.play.list.tip"));
        rootJPanel.add(musicList, getConstraints(2, 10, 1, 1));

        skipBack = new JLabel();
        skipBack.setIcon(ChineseMusicIcons.SkipBack24Icon);
        skipBack.setToolTipText(ResBundleUtil.message("skip.back.tip"));
        rootJPanel.add(skipBack, getConstraints(3, 0, 2, 1));

        playPauseJPanel = new JPanel();
        playPauseLayout = new CardLayout();
        playPauseJPanel.setLayout(playPauseLayout);
        play = new JLabel();
        play.setIcon(ChineseMusicIcons.Play24Icon);
        play.setToolTipText(ResBundleUtil.message("play.tip"));
        playPauseJPanel.add(play, CARD_NAME_PLAY);
        pause = new JLabel();
        pause.setIcon(ChineseMusicIcons.Pause24Icon);
        pause.setToolTipText(ResBundleUtil.message("play.pause.tip"));
        playPauseJPanel.add(pause, CARD_NAME_PAUSE);
        rootJPanel.add(playPauseJPanel, getConstraints(3, 1, 2, 1));

        skipForward = new JLabel();
        skipForward.setIcon(ChineseMusicIcons.SkipForward24Icon);
        skipForward.setToolTipText(ResBundleUtil.message("skip.forward.tip"));
        rootJPanel.add(skipForward, getConstraints(3, 2, 2, 1));

        currentTime = new JLabel();
        currentTime.setText("00:00");
        rootJPanel.add(currentTime, getConstraints(3, 3, 1, 1));

        musicAuthor = new JLabel();
        musicAuthor.setText("zhoujielun");
        rootJPanel.add(musicAuthor, getConstraints(3, 4, 1, 1));

        musicTime = new JLabel();
        musicTime.setText("99:99");
        rootJPanel.add(musicTime, getConstraints(3, 6, 1, 1));

        volumeJPanel = new JPanel();
        volumeLayout = new CardLayout();
        volumeJPanel.setLayout(volumeLayout);
        volumeX = new JLabel();
        volumeX.setIcon(ChineseMusicIcons.VolumeX24Icon);
        volumeX.setToolTipText(ResBundleUtil.message("volume.reset.tip"));
        volumeJPanel.add(volumeX, CARD_NAME_PLAY_VOLUME_CANCEL);
        volumeLess = new JLabel();
        volumeLess.setIcon(ChineseMusicIcons.VolumeLess24Icon);
        volumeJPanel.add(volumeLess, CARD_NAME_PLAY_VOLUME_LESS);
        volumeMiddle = new JLabel();
        volumeMiddle.setIcon(ChineseMusicIcons.VolumeMiddle24Icon);
        volumeJPanel.add(volumeMiddle, CARD_NAME_PLAY_VOLUME_MIDDLE);
        volumeMore = new JLabel();
        volumeMore.setIcon(ChineseMusicIcons.VolumeMore24Icon);
        volumeJPanel.add(volumeMore, CARD_NAME_PLAY_VOLUME_MORE);
        rootJPanel.add(volumeJPanel, getConstraints(3, 7, 1, 1));

        volumeSlider = new JSlider();
        volumeSlider.setMaximum(100);
        volumeSlider.setMinimum(0);
        volumeSlider.setValue(50);
        volumeSlider.setPaintTicks(true);
        volumeSlider.setPaintTrack(true);
        volumeSlider.setOrientation(SwingConstants.HORIZONTAL);
        volumeSlider.setUI(new MyMetalSliderUI());
        rootJPanel.add(volumeSlider, getConstraints(3, 8, 1, 2));

        volumeView = new JLabel();
        volumeView.setText("50");
        rootJPanel.add(volumeView, getConstraints(3, 10, 1, 1));

        currentTimeSlider = new JSlider();
        currentTimeSlider.setMaximum(100);
        currentTimeSlider.setMinimum(0);
        currentTimeSlider.setValue(50);
        currentTimeSlider.setUI(new MyMetalSliderUI());
        rootJPanel.add(currentTimeSlider, new GridConstraints(4, 3, 1, 7,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_HORIZONTAL,
                GridConstraints.SIZEPOLICY_CAN_SHRINK, GridConstraints.SIZEPOLICY_CAN_SHRINK,
                null, null, null, 0, false));
    }

    private GridConstraints getConstraints (int row, int column, int rowSpan, int colSpan) {
        return new GridConstraints(row, column, rowSpan, colSpan,
                GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_NONE,
                GridConstraints.SIZEPOLICY_FIXED, GridConstraints.SIZEPOLICY_FIXED,
                null, null, null, 0, false);
    }

    private void addListener () {
        new PlayClickListener().installOn(play, true);
        new SkipBackClickListener().installOn(skipBack, true);
        new PauseClickListener().installOn(pause, true);
        new SkipForwardClickListener().installOn(skipForward, true);
    }

    static class SkipForwardClickListener extends ClickListener{
        @Override
        public boolean onClick (@NotNull MouseEvent event, int clickCount) {
            System.out.println("skipForward");
            // TODO:下一曲
            return true;
        }
    }

    class PauseClickListener extends ClickListener{
        @Override
        public boolean onClick (@NotNull MouseEvent event, int clickCount) {
            playPauseLayout.show(playPauseJPanel, CARD_NAME_PLAY);
            // TODO : 暂停歌曲
            return true;
        }
    }

    static class SkipBackClickListener extends ClickListener{
        @Override
        public boolean onClick (@NotNull MouseEvent event, int clickCount) {
            System.out.println("skipBack");
            return true;
        }
    }

    class PlayClickListener extends ClickListener {
        @Override
        public boolean onClick (@NotNull MouseEvent event, int clickCount) {
            playPauseLayout.show(playPauseJPanel, CARD_NAME_PAUSE);
            // TODO:播放歌曲,如果没有正在播放的歌曲，需要弹出歌单窗口，选择歌曲
            return true;
        }
    }

    public static void main (String[] args) throws BadLocationException {
        JFrame frame = new JFrame("ChineseMusicToolWindow");
        frame.setContentPane(new ChineseMusicToolWindow().rootJPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }

    static class MyMetalSliderUI extends MetalSliderUI{
        @Override
        public void paintThumb (Graphics g) {
            Graphics2D g2d = (Graphics2D) g;
            g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            g2d.setColor(JBColor.RED);
            g2d.fillOval(thumbRect.x + 2, thumbRect.y + 5, thumbRect.width / 2,thumbRect.height / 2);
        }
    }
}
