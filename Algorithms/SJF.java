/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Components.CurrentProcess;
import Components.Job;
import java.util.ArrayList;

/**
 *
 * @author Sandun Rajitha
 */
public class SJF extends Algorithm {

    public SJF(ArrayList<Job> jobList) {
        super(jobList);
    }

    @Override
    public CurrentProcess nextStep(int currentTime) {
        Job currentJob = null;
        boolean newJob = true;

        /**/
        addArrivedToTempQ(currentTime);
        
        if(newJob){
            sortByBurstTime(readyQueue);
            System.out.println(readyQueue.toString());
        }

        /**/
        if (tempQueue.isEmpty() && readyQueue.isEmpty()) {
            currentJob = new Job(0, 0, 0); //all jobs finished
            currentProcess.setCurrentJob(currentJob);
        } else if (!tempQueue.isEmpty() && readyQueue.isEmpty()) {
            currentJob = new Job(11, 0, 0); //waiting
            currentProcess.setCurrentJob(currentJob);

        } else if (!readyQueue.isEmpty()) {

            currentJob = readyQueue.get(0);
            newJob = false;
            
            if (!currentJob.isStarted()) {
                currentJob.setStartTime(currentTime);
                currentJob.setStarted(true);
            }
            currentJob.setRemainingTime(currentJob.remainingTime - 1);

            if (currentJob.remainingTime > 0) {
                System.out.println(currentJob.getJobNo());
                readyQueue.set(0, currentJob);

            } else if (currentJob.remainingTime == 0) {
                System.out.println("removed " + currentJob.getJobNo());
                readyQueue.remove(currentJob);
                currentJob.setFinishedTime(currentTime + 1);
                currentJob.setWaitTime();
                currentJob.setTurnAroundTime();
                currentProcess.tableData.set(currentJob.getJobNo() - 1, currentJob);
                newJob = true;
            }

            currentProcess.setCurrentJob(currentJob);
            currentProcess.tableData.set(currentJob.getJobNo() - 1, currentJob);
        }
        /**/

        return currentProcess;
    }
}
