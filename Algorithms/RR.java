/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Algorithms;

import Components.CurrentProcess;
import Components.Job;
import Main.CPU;
import java.util.ArrayList;

/**
 *
 * @author Sandun Rajitha
 */
public class RR extends Algorithm {

    private int iterations = 0;

    public RR(ArrayList<Job> jobList) {
        super(jobList);

    }

    @Override
    public CurrentProcess nextStep(int currentTime) {
        Job currentJob = null;

        addArrivedToTempQ(currentTime);
        //System.out.println("Q1 "+CPU.getQuantum());
        /**/
        if (tempQueue.isEmpty() && readyQueue.isEmpty()) {
            currentJob = new Job(0, 0, 0); //all jobs finished
            iterations = 0;
            currentProcess.setCurrentJob(currentJob);
        } else if (!tempQueue.isEmpty() && readyQueue.isEmpty()) {
            currentJob = new Job(11, 0, 0); //waiting
            iterations = 0;
            currentProcess.setCurrentJob(currentJob);

        } else if (!readyQueue.isEmpty()) {

            currentJob = readyQueue.get(0);
            readyQueue.remove(currentJob);
            iterations++;
            
            readyQueue.forEach(job -> {
                job.incrementWaitTime();
            });

            if (!currentJob.isStarted()) {
                currentJob.setStartTime(currentTime);
                currentJob.setStarted(true);
            }

            currentJob.setRemainingTime(currentJob.remainingTime - 1);

            if (currentJob.remainingTime > 0 && iterations < CPU.getQuantum()) {
                
                //System.out.println("Q2 "+CPU.getQuantum());
                //iterations++;
                //System.out.println(currentJob.getJobNo() + "added to begining");
                //System.out.println("iterations " + iterations);
                addArrivedToTempQ(currentTime);
                readyQueue.add(0, currentJob);
            
            } else if (currentJob.remainingTime > 0 && iterations >= CPU.getQuantum()) {
                //System.out.println("Q3 "+CPU.getQuantum());
                addArrivedToTempQ(currentTime+1);
                readyQueue.add(currentJob);
                iterations = 0;
                //System.out.println(currentJob.getJobNo() + "added to end");
                //System.out.println("iterations " + iterations);
                

            } else if (currentJob.remainingTime == 0) {
                //System.out.println("removed " + currentJob.getJobNo());
                readyQueue.remove(currentJob);
                currentJob.setFinishedTime(currentTime + 1);
                iterations = 0;
                currentJob.setTurnAroundTime();
                currentProcess.tableData.set(currentJob.getJobNo() - 1, currentJob);
                
            }

            currentProcess.setCurrentJob(currentJob);
            currentProcess.tableData.set(currentJob.getJobNo() - 1, currentJob);
        }
        /**/

        return currentProcess;
    }

}
