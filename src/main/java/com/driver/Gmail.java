package com.driver;

import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class Gmail extends Email {

    int inboxCapacity; //maximum number of mails inbox can store
    List<mails> Inbox;
    List<mails> Trash;
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity =1000;
        Inbox=new LinkedList<>();
        Trash=new LinkedList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        if (Inbox.size()>=inboxCapacity){
            Trash.add(Inbox.remove(0));
            Inbox.add(new mails(date,sender,message));
        }
        else {
            Inbox.add(new mails(date,sender,message));
        }
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than equal to the dates of mails received already.

    }

    public void deleteMail(String message){
        for (mails mail : Inbox){
            if (mail.message.equals(message)){
                Inbox.remove(mail);
            }
        }
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

    }

    public String findLatestMessage(){
        if (Inbox.size()>0){
            return Inbox.get(Inbox.size()-1).message;
        }
        else {
            return null;
        }
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

    }

    public String findOldestMessage(){
        if (Inbox.size()>0){
            return Inbox.get(0).message;
        }
        else {
            return null;
        }

        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

    }

    public int findMailsBetweenDates(Date start, Date end){
        int count=0;
        boolean present=false;
        for (mails mail: Inbox){
            if (mail.date.equals(start)){
                present=true;
            }
            if (present==true ){
                count++;

            }
            if (mail.date.equals(end)){
                present=false;
            }
        }
        return count;
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        return Inbox.size();

    }

    public int getTrashSize(){
        // Return number of mails in Trash
        return Trash.size();

    }

    public void emptyTrash(){
        // clear all mails in the trash
        Trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return inboxCapacity;
    }
}
