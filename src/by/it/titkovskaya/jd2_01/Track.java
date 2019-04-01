package by.it.titkovskaya.jd2_01;

class Track {
    private String trackName;
    private int trackLength;

    Track(String trackName, int trackLength) {
        this.trackName = trackName;
        this.trackLength = trackLength;
    }

    String getTrackName() {
        return trackName;
    }

    int getTrackLength() {
        return trackLength;
    }

    @Override
    public String toString() {
        return trackName + '-' +
                trackLength + " sec\n";
    }
}
