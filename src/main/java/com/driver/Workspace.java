package com.driver;

import org.apache.commons.lang3.tuple.Pair;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Workspace extends Gmail{

    private ArrayList<Meeting> calendar; // Stores all the meetings



    public Workspace(String emailId) {
        super(emailId,Integer.MAX_VALUE);

        this.calendar=new ArrayList<>();
        // The inboxCapacity is equal to the maximum value an integer can store.

    }
    public ArrayList<Meeting> getCalendar() {
        return calendar;
    }

    public void setCalendar(ArrayList<Meeting> calendar) {
        this.calendar = calendar;
    }

    public void addMeeting(Meeting meeting){
        //add the meeting to calendar
        Meeting m=new Meeting(meeting.getStartTime(),meeting.getEndTime());
        calendar.add(m);

    }

    public int findMaxMeetings(){
        int maxMaxMeeting=0;
        Collections.sort(calendar ,new Sortbyroll());
        for(int i=0;i<calendar.size()-1;i++){
            if (calendar.get(i).getEndTime().compareTo(calendar.get(i+1).getStartTime()) <0){
                maxMaxMeeting++;
            }
        }
        return maxMaxMeeting;
        // find the maximum number of meetings you can attend
        // 1. At a particular time, you can be present in at most one meeting
        // 2. If you want to attend a meeting, you must join it at its start time and leave at end time.
        // Example: If a meeting ends at 10:00 am, you cannot attend another meeting starting at 10:00 am

    }

}

class Sortbyroll implements Comparator<Meeting> {
    // Used for sorting in ascending order of
    // roll number
    @Override
    public int compare(Meeting a, Meeting b)
    {
        return a.getEndTime().compareTo(b.getEndTime());
    }

//    @Override
//    public int compare(T o1, T o2) {
//        return 0;
//    }
}
