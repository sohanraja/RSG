package libraryClasses;

import java.awt.*;
import java.io.File;
import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;
import org.openqa.selenium.Dimension;

import static org.monte.media.AudioFormatKeys.*;
import static org.monte.media.VideoFormatKeys.*;
 
public class ScriptVideoRecord {
    private ScreenRecorder screenRecorder;
  
    private static final ScriptVideoRecord scriptVideoRecord = new ScriptVideoRecord();
       public void startRecording(String path, String fileName) throws Exception
       {    
              File file = new File(path);
               
              
              Toolkit toolkit = Toolkit.getDefaultToolkit();

              int width = 1366;//screenSize.width;
              int height = (int)toolkit.getScreenSize().getHeight();
                             
              Rectangle captureSize = new Rectangle(0,0, width, height);
                             
            GraphicsConfiguration gc = GraphicsEnvironment
               .getLocalGraphicsEnvironment()
               .getDefaultScreenDevice()
               .getDefaultConfiguration();
 
           this.screenRecorder = new SpecializedScreenRecorder(gc, captureSize,
               new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    CompressorNameKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                    DepthKey, 24, FrameRateKey, Rational.valueOf(15),
                    QualityKey, 1.0f,
                    KeyFrameIntervalKey, 15 * 60),
               new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, "black",
                    FrameRateKey, Rational.valueOf(30)),
               null, file, fileName);
          this.screenRecorder.start();
       
       }
 
       public void stopRecording() throws Exception
       {
         screenRecorder.stop();
       }
       
       public static ScriptVideoRecord getInstance()
       {
           return scriptVideoRecord;
       }
       
}