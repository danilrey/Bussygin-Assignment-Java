package MusicStreaming;

import java.util.Arrays;
import java.util.Scanner;


public class MusicStreamingLibrary {
    public MusicStreamingLibrary(String name) {
        ActionForSongs(name);
    }
    private Scanner scan = new Scanner(System.in);
    private String CurrentSong = "No songs Playing now\n";
    private boolean play = false;
    private static String PlayList [] = {
            "Born Slippy (Nuxx) - Under World\n",
            "Every Breath You Take - The Police\n",
            "Moscow Never Sleeps - DJ SMASH\n",
            "Big City Life - De lacure\n",
            "Money Trees - Kendrick Lamar, Jay Rock\n"
    };

    private void ShowPlayList() {
        for (String s : PlayList) {
            System.out.print(s);
        }
    }

    private void AddSongToPlayList(String name) {
        String[] newPlayList = Arrays.copyOf(PlayList, PlayList.length + 1);
        newPlayList[newPlayList.length - 1] = name + "\n";
        PlayList = newPlayList;
        System.out.println("Successfully uploaded to playlist, enter number of song if you want listen music:");
        PlaySong(false);
    }

    private void PlaySong(boolean enter) {
        if (enter) {
            System.out.println("Enter the number of the song you want to play:");
        }

        if (scan.hasNextInt()) {
            int songNumber = scan.nextInt();
            if (songNumber >= 1 && songNumber <= PlayList.length) {
                CurrentSong = PlayList[songNumber - 1];
                System.out.println("Now playing: " + CurrentSong);
            } else {
                System.out.println(":(\nThis number of song doesn't exist, enter 'play':");
            }
        } else {
            System.out.println(":(\nThis isn't number, enter 'play' or other command");
            scan.next();
        }
    }

    private void StopSong() {
        if (!play) {
            System.out.println(":(\nYou don't listen anything now, enter 'play' or other command");
        } else if (play) {
            System.out.println("Song stopped, enter number of song if you want listen music:");
            play = false;
            PlaySong(false);
        }
    }

    private void ActionForSongs(String name) {
        System.out.printf("Hello this is %s, enter action to play songs\n", name);
        String input = scan.nextLine();
        while (!input.equals("bye")) {
            if (input.equals("show playlist")) {
                this.ShowPlayList();
            } else if (input.equals("add song")) {
                System.out.println("Okay write 'name of song - name of singer'");
                String Song = scan.nextLine();
                AddSongToPlayList(Song);
            } else if (input.equals("play")) {
                PlaySong(true);
                play = true;
            } else if (input.equals("stop")) {
                StopSong();
            }
            input = scan.nextLine();
        }
        System.out.println("Okay see you next time, bye!");
    }

}
