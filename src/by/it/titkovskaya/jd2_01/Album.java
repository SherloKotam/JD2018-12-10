package by.it.titkovskaya.jd2_01;

import java.util.List;

class Album {
    private String albumName;
    private List<Track> tracks;

    Album(String albumName, List<Track> tracks) {
        this.albumName = albumName;
        this.tracks = tracks;
    }

    String getAlbumName() {
        return albumName;
    }

    List<Track> getTracks() {
        return tracks;
    }

    @Override
    public String toString() {
        StringBuilder allTracks = new StringBuilder();
        for (Track track : tracks) {
            allTracks.append(track.getTrackName()).append("-").append(track.getTrackLength()).append(" sec\n");
        }
        return albumName + ":\n" +
                allTracks;
    }
}
