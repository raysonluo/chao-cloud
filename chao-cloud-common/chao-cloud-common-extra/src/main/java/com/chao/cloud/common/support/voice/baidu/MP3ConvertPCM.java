package com.chao.cloud.common.support.voice.baidu;

import java.io.InputStream;
import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import org.apache.commons.io.IOUtils;

import javazoom.spi.mpeg.sampled.file.MpegAudioFileReader;

/**
 * MP3转PCM Java方式实现
 * @author 小帅丶
 * @date 2017年12月6日
 */
public class MP3ConvertPCM {

    /**
     * MP3转换PCM
     * @param inputStream MP3输入流
     * @throws Exception
     */
    public static byte[] mp3Convert2pcm(InputStream inputStream) throws Exception {
        // 转换PCM audioInputStream 数据
        AudioInputStream audioInputStream = getPcmAudioInputStream(inputStream);
        byte[] pcmBytes = IOUtils.toByteArray(audioInputStream);
        return pcmBytes;
    }

    /**
     * 获取PCM AudioInputStream 数据
     * @param inputStream MP3输入流
     * @return AudioInputStream PCM输入流
     */
    private static AudioInputStream getPcmAudioInputStream(InputStream inputStream) {
        AudioInputStream audioInputStream = null;
        AudioFormat targetFormat = null;
        try {
            AudioInputStream in = null;
            MpegAudioFileReader mp = new MpegAudioFileReader();
            in = mp.getAudioInputStream(inputStream);
            AudioFormat baseFormat = in.getFormat();
            targetFormat = new AudioFormat(AudioFormat.Encoding.PCM_SIGNED, baseFormat.getSampleRate(), 16,
                    baseFormat.getChannels(), baseFormat.getChannels() * 2, baseFormat.getSampleRate(), false);
            audioInputStream = AudioSystem.getAudioInputStream(targetFormat, in);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return audioInputStream;
    }

}