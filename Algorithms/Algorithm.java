/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Components.CurrentProcess;
import Components.Job;
import static Components.Job.arrivalTimeComparator;
import static Components.Job.burstTimeComparator;
import static Components.Job.remainingTimeComparator;
import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author Sandun Rajitha
 */
public abstract class Algorithm {
    ArrayList<Job> jobList, tempQueue, currentProcessData;
    ArrayList<Job> readyQueue = new ArrayList<Job>();
    Job currentJob;
    CurrentProcess currentProcess = new CurrentProcess();
    
    public Algorithm(ArrayList<Job> jobList){
        
        currentProcess.setTableData(arrayListCopy(jobList));
        this.jobList = sortByArrivalTime(arrayListCopy(jobList));
        this.tempQueue = arrayListCopy(this.jobList);
        //this.currentProcessData = arrayListCopy(jobList);
        
        
    }
    
    public abstract CurrentProcess nextStep (int currentTime);

    
    public void addArrivedToTempQ(int currentTime){
        if (!tempQueue.isEmpty()) {
            tempQueue.forEach(job -> {
                if (job.arrivalTime == currentTime) {
                    readyQueue.add(job.getCopy());
                    System.out.println("current time "+ currentTime);
                    System.out.println(job.getJobNo()+" arrived");
                }
                
            });
            readyQueue.forEach(job -> {
                tempQueue.remove(job);
            });
        }
    }
    
    public ArrayList<Job> sortByArrivalTime(ArrayList<Job> list){
        ArrayList<Job> jobs = list;
        
        Collections.sort(jobs, arrivalTimeComparator);
        
        return jobs;
    }
    
    public ArrayList<Job> sortByBurstTime(ArrayList<Job> list){
        ArrayList<Job> jobs = list;
        
        Collections.sort(jobs, burstTimeComparator);
        
        return jobs;
    }
    
    public ArrayList<Job> sortByremainingTime(ArrayList<Job> list){
        ArrayList<Job> jobs = list;
        
        Collections.sort(jobs, remainingTimeComparator);
        
        return jobs;
    }
    
    public ArrayList<Job> arrayListCopy(ArrayList<Job> list){
        ArrayList<Job> copy = new ArrayList<>();
        
       list.forEach(job ->{
           copy.add(job.getCopy());
       });
        
        return copy;
    }
}
