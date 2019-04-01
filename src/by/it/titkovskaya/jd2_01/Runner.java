package by.it.titkovskaya.jd2_01;

import java.util.List;

public class Runner {
    public static void main(String[] args) {
        int numberOfAlbums = 3, numberOfTracks = 10, minLength = 180, maxLength = 400;
        List<Album> albums = Util.createAlbumsCollection(numberOfAlbums, numberOfTracks, minLength, maxLength);
        List<String> trackNames = Util.showTracks(minLength, albums);
        System.out.println(trackNames);
    }
}
