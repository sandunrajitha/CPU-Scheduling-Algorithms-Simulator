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
public class FCFS extends Algorithm {
    
    //boolean startSet = false; //flag to set the start time of the each job

    public FCFS(ArrayList<Job> jobList) {
        super(jobList);
    }
    
    @Override
    public CurrentProcess nextStep(int currentTime) {
        Job currentJob = null;
        
        /**/
        
//        System.out.print(" jobList"+jobList.size());
//        System.out.print(" tempQueue"+tempQueue.size());
//        System.out.print(" currentProcess"+currentProcess.getTableData().size());
//        System.out.print(" readyQueue"+readyQueue.size());
//        System.out.println(" ");
        /**/
        
//        if (!tempQueue.isEmpty()) {
//            tempQueue.forEach(job -> {
//                if (job.arrivalTime == currentTime) {
//                    readyQueue.add(job.getCopy());
//                }
//                
//            });
//            readyQueue.forEach(job -> {
//                tempQueue.remove(job);
//            });
//        }

        addArrivedToTempQ(currentTime);

        /**/
        if(tempQueue.isEmpty() && readyQueue.isEmpty()){
            currentJob = new Job(0, 0, 0);
            currentProcess.setCurrentJob(currentJob);
        }else if(!tempQueue.isEmpty() && readyQueue.isEmpty()){
            currentJob = new Job(11, 0, 0);
            currentProcess.setCurrentJob(currentJob);
        
        }else if(!readyQueue.isEmpty()){
            
            currentJob = readyQueue.get(0);
            if (!currentJob.isStarted()) {
                currentJob.setStartTime(currentTime);
                currentJob.setStarted(true);
            }
            currentJob.setRemainingTime(currentJob.remainingTime-1);
            
            if(currentJob.remainingTime>0){
                System.out.println(currentJob.getJobNo());
                readyQueue.set(0, currentJob);
                
            }else if (currentJob.remainingTime == 0) {
                System.out.println("removed "+currentJob.getJobNo());
                readyQueue.remove(currentJob);
                currentJob.setFinishedTime(currentTime+1);
                currentJob.setWaitTime();
                currentJob.setTurnAroundTime();
                currentProcess.tableData.set(currentJob.getJobNo()-1, currentJob);
            }
                
//                if(readyQueue.size()>1){
//                    for (int i = 1; i < readyQueue.size(); i++) {
//                        Job job = readyQueue.get(i);
//                        job.setWaitTime(job.getWaitTime()+1);
//                        currentProcess.tableData.set(job.getJobNo()-1, job);
//                    }
//                }
                
            currentProcess.setCurrentJob(currentJob);
            //currentProcess.tableData.remove(currentJob);
            currentProcess.tableData.set(currentJob.getJobNo()-1, currentJob);
        }
        /**/
        
        return currentProcess;
    }
    
}
