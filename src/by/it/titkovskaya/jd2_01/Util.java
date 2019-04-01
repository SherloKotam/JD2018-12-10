package by.it.titkovskaya.jd2_01;

import java.util.ArrayList;
import java.util.List;

class Util {

    static List<Album> createAlbumsCollection(int numberOfAlbums, int numberOfTracks, int minLength, int maxLength) {
        List<Album> albums = new ArrayList<>();
        for (int i = 0; i < numberOfAlbums; i++) {
            List<Track> tracks = new ArrayList<>();
            for (int j = 0; j < numberOfTracks; j++) {
                int trackLength = (int) (Math.random() * (maxLength - minLength + 1)) + minLength;
                int trackNumber = j + 1;
                Track track = new Track("Track" + trackNumber, trackLength);
                tracks.add(track);
            }
            int albumNumber = i + 1;
            Album album = new Album("Album" + albumNumber, tracks);
            albums.add(album);
        }
        return albums;
    }

    static List<String> showTracks(int minLength, List<Album> albums) {
        List<String> trackNames = new ArrayList<>();
        for (Album album : albums) {
            List<Track> tracks = album.getTracks();
            for (Track track : tracks) {
                if (track.getTrackLength() > minLength) {
                    String trackName = "\n" + album.getAlbumName() + "-" + track.getTrackName()
                            + "-" + track.getTrackLength() + " sec";
                    trackNames.add(trackName);
                }
            }
        }
        return trackNames;
    }

}
