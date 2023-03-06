package com.driver;

import org.apache.commons.lang3.tuple.Triple;

import java.util.ArrayList;
import java.util.Date;

public class Gmail extends Email {


    private int inboxCapacity; //maximum number of mails inbox can store
    //Inbox: Stores mails. Each mail has date (Date), sender (String), message (String). It is guaranteed that message is distinct for all mails.
    //Trash: Stores mails. Each mail has date (Date), sender (String), message (String)

//    private ArrayList<Mail> Inbox;
//    private ArrayList<Mail> Trash;
    private ArrayList<Triple<Date, String, String>> inbox;
    private ArrayList<Triple<Date, String, String>> trash;
    public Gmail(String emailId, int inboxCapacity) {
        super(emailId);
        this.inboxCapacity=inboxCapacity;
//        Inbox=new ArrayList<>();
//        Trash=new ArrayList<>();
        this.inbox=new ArrayList<>();
        this.trash=new ArrayList<>();
    }

    public void receiveMail(Date date, String sender, String message){
        // If the inbox is full, move the oldest mail in the inbox to trash and add the new mail to inbox.
        // It is guaranteed that:
        // 1. Each mail in the inbox is distinct.
        // 2. The mails are received in non-decreasing order. This means that the date of a new mail is greater than
        //    equal to the dates of mails received already.

//        if(Inbox.size()==this.inboxCapacity) Trash.add(Inbox.remove(0));
//
//        Inbox.add(new Mail(date, sender, message));

        if(inbox.size()==this.inboxCapacity){
            Triple<Date, String, String> oldestMail=inbox.get(0);
            inbox.remove(0);
            trash.add(oldestMail);

            // for above we can also write
            //trash.add(inbox.remove(0));
        }

        Triple<Date, String, String> mail= Triple.of(date, sender, message);
        inbox.add(mail);
    }

    public void deleteMail(String message){
        // Each message is distinct
        // If the given message is found in any mail in the inbox, move the mail to trash, else do nothing

//        for(int i=0; i<Inbox.size(); i++){
//            Mail m=Inbox.get(i);
//            if(m.getMessage().equals(message)) Trash.add(Inbox.remove(i));
//        }

        for(int i=0; i<inbox.size(); i++){
            if(message.equals(inbox.get(i).getRight())){
                trash.add(inbox.remove(i));
                break;
            }
        }

    }

    public String findLatestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the latest mail present in the inbox

//        if(Inbox.size()==0) return null;
//        else return Inbox.get(Inbox.size()-1).getMessage();

        if(inbox.isEmpty()) return null;

        return inbox.get(inbox.size()-1).getRight();

    }

    public String findOldestMessage(){
        // If the inbox is empty, return null
        // Else, return the message of the oldest mail present in the inbox

//        if (Inbox.size()==0) return null;
//        else return Inbox.get(0).getMessage();

        if(inbox.isEmpty()) return null;

        return inbox.get(0).getRight();
    }

    public int findMailsBetweenDates(Date start, Date end){
        //find number of mails in the inbox which are received between given dates
        //It is guaranteed that start date <= end date
        int count=0;

        for(int i=0; i<inbox.size(); i++){
            if(inbox.get(i).getLeft().compareTo(start)>=0 && inbox.get(i).getLeft().compareTo(end)<=0) count++;
        }

        return count;

    }

    public int getInboxSize(){
        // Return number of mails in inbox
        //return Inbox.size();
        return inbox.size();
    }

    public int getTrashSize(){
        // Return number of mails in Trash
        //return Trash.size();
        return trash.size();
    }

    public void emptyTrash(){
        // clear all mails in the trash
        //Trash.clear();
        //return;
        trash.clear();

    }

    public int getInboxCapacity() {
        // Return the maximum number of mails that can be stored in the inbox
        return this.inboxCapacity;
    }
    public void setInboxCapacity(int inboxCapacity) {
        this.inboxCapacity = inboxCapacity;
    }

}
