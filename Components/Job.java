/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

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
    public int finishedTime;
    public boolean finished;
    public int turnAroundTime;

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
    
    public int remainingTime;

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

    public void setTurnAroundTime(int turnAroundTime) {
        this.turnAroundTime = turnAroundTime;
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

    public int getRemainingTime() {
        return remainingTime;
    }

    public int getTurnAroundTime() {
        return turnAroundTime;
    }
    
    
    
    public Job(int jobNo, int arrivalTime, int burstTime){
        this.jobNo = jobNo;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        
        this.startTime = 0;
        this.finishedTime = 0;
        this.finished = false;
        this.remainingTime = burstTime;
        this.waitTime = 0;
        this.turnAroundTime = 0;
    }
}
