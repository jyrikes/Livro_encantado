package script;

import java.io.InputStream;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.SwingUtilities;

class Musica{
  private String URL;
  public Musica(String URL){
    this.URL = URL;
  }
  public void play(){
    try {
      // Carrega o arquivo de áudio (não funciona com .mp3, só .wav) 
  String resource = this.URL;
  InputStream input = getClass().getResourceAsStream(resource);
  Clip oClip = AudioSystem.getClip();
  AudioInputStream audioInput = AudioSystem.getAudioInputStream(input);
  oClip.open(audioInput);
  
  //oClip.loop(0); // Toca uma vez
  oClip.loop(Clip.LOOP_CONTINUOUSLY); // Toca continuamente (para o caso de músicas)
  
  // Para a execução (senão o programa termina antes de você ouvir o som)
  SwingUtilities.invokeLater(new Runnable() {
      public void run() {
    
      }
  });
  } catch (Exception e) {
    }
  }
}

