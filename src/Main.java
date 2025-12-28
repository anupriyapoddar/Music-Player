import javax.smartcardio.CardChannel;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.FileNotFoundException;
import javax.sound.sampled.Clip;


import java.io.IOException;
import java.sql.SQLOutput;
import java.io.File;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {


        String filePath = "/Users/anupriyapoddar/Downloads/music-player/itachi_uchiha_theme.wav";
        File file = new File(filePath);

        try(Scanner sc =  new Scanner(System.in);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(file)){

            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);


            String response = "";
            while(!response.equals("Q")){

                System.out.println("P = Play");
                System.out.println("S = Stop");
                System.out.println("PA = Pause");
                System.out.println("RE = Resume");
                System.out.println("R = Reset");
                System.out.println("Q = Quit");
                System.out.println("Enter Your Choice: ");

                response = sc.next().toUpperCase();

                switch(response){
                    case "P", "RE" -> clip.start();
                    case "S", "PA" -> clip.stop();
                    case "R" -> clip.setMicrosecondPosition(0);
                    case "Q" -> clip.close();
                    default -> System.out.println("Invalid choice");
                }
            }

        }
        catch(FileNotFoundException e){
            System.out.println("could not locate file !");
        }
        catch(LineUnavailableException e){
            System.out.println("Unable to access audio resource !");
        }
        catch(UnsupportedAudioFileException e){
            System.out.println("Audio file is not supported !");
        }
        catch(IOException e){
            System.out.println("Something went wrong !!!");
        }
        finally{
            System.out.println("BYE !!!");
            // sc.close();
        }
    }
}