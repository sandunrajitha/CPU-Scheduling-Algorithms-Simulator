/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

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
    ArrayList<Job> jobList;
    ArrayList<Job> readyQueue;
    Job currentJob;
    int quantum = 2;
    
    
    public Algorithm(ArrayList<Job> jobList){
        this.jobList = sortByArrivalTime(jobList);
        readyQueue = this.jobList;
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
}
