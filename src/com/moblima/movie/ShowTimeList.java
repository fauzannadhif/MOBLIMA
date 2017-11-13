package com.moblima.movie;

import java.util.ArrayList;

public class ShowTimeList {
    private ArrayList<ShowTime> showTimes;

    public ShowTimeList(){
        //FileIO
    }

    public ArrayList<ShowTime> getShowTimes() {
        return showTimes;
    }

    public void addShowTimes(ShowTime newShowTime) {
        this.showTimes.add(newShowTime);
    }
    public void setShowTimes(ShowTime UnneededShowTime) {
        this.showTimes.set(this.showTimes.indexOf(UnneededShowTime), this.showTimes.get(this.showTimes.size()-1));
        this.showTimes.remove(this.showTimes.size()-1);
    }

}
