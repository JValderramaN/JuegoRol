package utilities;

import java.applet.AudioClip;
import javax.swing.JApplet;
import java.io.File;
import java.net.URL;

public class Audio {

    private AudioClip clip = null;
    private String dir = null;

    public Audio(AudioClip ac) {
        clip = ac;
    }

    public Audio(URL u) {
        this(JApplet.newAudioClip(u));
        dir = u.getPath() + " " + u.getFile();
    }

    public Audio(File f) throws Exception {
        this(f.toURL());
    }

    public Audio(String d) throws Exception {
        this(new File(d));
    }

    public static Audio getAudioClip(String d) {
        try {
            return new Audio(d);
        } catch (Exception ex) {
            System.out.println(ex);
        }
        return null;
    }

    public void play() {
        clip.play();
    }

    public void stop() {
        clip.stop();
    }

    public void loop() {
        clip.loop();
    }

    public String toString() {
        return dir + "\n" + clip.toString();
    }
}
