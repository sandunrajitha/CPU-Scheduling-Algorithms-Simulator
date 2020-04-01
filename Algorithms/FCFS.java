/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Components.Job;
import java.util.ArrayList;

/**
 *
 * @author Sandun Rajitha
 */
public class FCFS extends Algorithm {

    boolean startSet = false; //flag to set the start time of the each job

    public FCFS(ArrayList<Job> jobList) {
        super(jobList);
    }

    @Override
    public Job nextStep(int currentTime) {
        Job currentJob = null;

        if (!tempQueue.isEmpty()) {
            tempQueue.forEach(job -> {
                if (job.arrivalTime == currentTime) {
                    readyQueue.add(job);
                }

            });
            readyQueue.forEach(job -> {
                tempQueue.remove(job);
            });
        }

        

        /**/
        if (!readyQueue.isEmpty()) {
            if (readyQueue.get(0).remainingTime > 0) {
                currentJob = readyQueue.get(0);
                currentJob.remainingTime--;
                if (currentJob.remainingTime > 0) {
                    readyQueue.set(0, currentJob);
                } else {
                    readyQueue.remove(currentJob);
                }
//            } else if (readyQueue.get(0).remainingTime == 0 && readyQueue.size() > 2) {
//                currentJob = readyQueue.get(1);
//                currentJob.remainingTime--;
//                readyQueue.set(1, currentJob);
//                readyQueue.remove(0);
//            
            } else {
                currentJob = new Job(0, 0, 0);
            }
        } else if (readyQueue.isEmpty() && !tempQueue.isEmpty()) {
            currentJob = new Job(11, 0, 0);
        } else if (readyQueue.isEmpty() && tempQueue.isEmpty()) {
            currentJob = new Job(0, 0, 0);;
        }
        /**/

        return currentJob;
    }

}
