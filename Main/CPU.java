/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Main;

import Algorithms.Algorithm;
import Algorithms.FCFS;
import Components.Job;
import java.util.ArrayList;

/**
 *
 * @author Sandun Rajitha
 */
public class CPU {
    
    private static Algorithm algorithm;
    //public static int currentTime;
    public static int quantum = 2;
    public static ArrayList<Job> jobList;

//    public CPU(int quantum, ArrayList<Job> jobList) {
//        this.jobList = jobList;
//    }
    
    public static Job nextStep(int currentTime){
        Job job = algorithm.nextStep(currentTime);
//        System.out.println(job.toString());
        return job;
    }
    
    public static void setJobList(ArrayList<Job> jobList){
        CPU.jobList = jobList;
    }
    
    public static void setQuantum(int quantum){
        CPU.quantum = quantum;
    }
    
    
    public static void setAlgorithm(String algorithm){
        switch(algorithm){
            case "FCFS": CPU.algorithm = new FCFS(jobList);
        }
    }
    
    
    
}
