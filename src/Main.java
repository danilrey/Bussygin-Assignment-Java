import MusicStreaming.MusicStreamingLibrary;

import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, write name of library for your music!");
        Scanner scanner = new Scanner(System.in);
        String start = scanner.nextLine();
        while (!start.equals("ex")) {
            if (start.equals("yandex")) {
                MusicStreamingLibrary Yandex = new MusicStreamingLibrary("Yandex");
            } else if (start.equals("spotify")) {
                MusicStreamingLibrary Spotify = new MusicStreamingLibrary("Spotify");
            } else if (start.equals("apple")) {
                MusicStreamingLibrary AppMus = new MusicStreamingLibrary("Apple Music");
            }
            start = scanner.next();
        }


    }
}