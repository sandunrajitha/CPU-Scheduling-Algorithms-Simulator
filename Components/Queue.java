/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Components;

import java.util.ArrayList;

/**
 *
 * @author Sandun Rajitha
 */
public class Queue {
    
    private ArrayList<Job> jobList;

    
    public Queue(int queueSize) {
        this.jobList = new ArrayList<Job>(queueSize);
    }
    
    
    
}
