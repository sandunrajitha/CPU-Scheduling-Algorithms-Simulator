/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.util.Comparator;

/**
 *
 * @author Sandun Rajitha
 */
public class Job {
    
    public int jobNo;
    public int arrivalTime;
    public int burstTime;
    
    public int startTime;
    public int waitTime;
    public int remainingTime;
    public int finishedTime;
    public boolean finished;
    public boolean started;
    public int turnAroundTime;
    
    public Job(int jobNo, int arrivalTime, int burstTime){
        this.jobNo = jobNo;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        
        this.startTime = 0;
        this.finishedTime = 0;
        this.finished = false;
        this.started = false;
        this.remainingTime = burstTime;
        this.waitTime = 0;
        this.turnAroundTime = 0;
    }

    public void setWaitTime() {
        this.waitTime = startTime - arrivalTime;
    }
    
    public void incrementWaitTime(){
        this.waitTime = this.waitTime + 1;
    }
    
    
    public void setJobNo(int jobNo) {
        this.jobNo = jobNo;
    }

    public void setArrivalTime(int arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setBurstTime(int burstTime) {
        this.burstTime = burstTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setFinishedTime(int finishedTime) {
        this.finishedTime = finishedTime;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public void setRemainingTime(int remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setTurnAroundTime() {
        this.turnAroundTime = waitTime + burstTime;
    }
    
    public void setStarted(boolean started) {
        this.started = started;
    }

    public int getJobNo() {
        return jobNo;
    }

    public int getArrivalTime() {
        return arrivalTime;
    }

    public int getBurstTime() {
        return burstTime;
    }

    public int getStartTime() {
        return startTime;
    }
    
    public int getWaitTime() {
        return waitTime;
    }

    public int getFinishedTime() {
        return finishedTime;
    }

    public boolean isFinished() {
        return finished;
    }
    
    
    public boolean isStarted() {
        return started;
    }
    

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    
    public Job getCopy(){
        Job copy = new Job(this.jobNo, this.arrivalTime, this.burstTime);
        return copy;
    }
     
    
    public static Comparator<Job> arrivalTimeComparator = new Comparator<Job>() {

	public int compare(Job j1, Job j2) {
	   int arrivalTime1 = j1.getArrivalTime();
	   int arrivalTime2 = j2.getArrivalTime();

	   //ascending order
	   return arrivalTime1 - arrivalTime2;

	   //descending order
	   //return job2-job1;
    }};
    
    public static Comparator<Job> burstTimeComparator = new Comparator<Job>() {

	public int compare(Job j1, Job j2) {
	   int burstTime1 = j1.getBurstTime();
	   int burstTime2 = j2.getBurstTime();
           
           return burstTime1 - burstTime2;
    }};
    
    public static Comparator<Job> remainingTimeComparator = new Comparator<Job>() {

	public int compare(Job j1, Job j2) {
	   int remainingTime1 = j1.getRemainingTime();
	   int remainingTime2 = j2.getRemainingTime();
           
           return remainingTime1 - remainingTime2;
    }};

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.jobNo;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Job other = (Job) obj;
        if (this.jobNo != other.jobNo) {
            return false;
        }
        return true;
    }
    
    
    
    @Override
    public String toString() {
        return "[ jobNo=" + jobNo + ", arrivalTime=" + arrivalTime + ", burstTime=" + burstTime + ", remainingTime =" + remainingTime +", startTime=" + startTime + ", "
                + "waitTime=" + waitTime + ", finishedTime=" + finishedTime + ", finished=" + finished + ", turnAroundTime=" + turnAroundTime + "] \n";
    }
}
