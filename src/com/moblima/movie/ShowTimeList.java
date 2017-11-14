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

    public void removeShowTimes(ShowTime removedShowTime){
		showTimes.set(showTimes.indexOf(removedShowTime), showTimes.get(showTimes.size()-1));
		showTimes.remove(showTimes.size()-1);
	}

}
