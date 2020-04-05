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
public class CurrentProcess {
    
    public ArrayList<Job> tableData = new ArrayList<Job>();
    public Job currentJob;

    public ArrayList<Job> getTableData() {
        return tableData;
    }

    public Job getCurrentJob() {
        return currentJob;
    }

    public void setTableData(ArrayList<Job> tableData) {
        this.tableData = tableData;
    }

    public void setCurrentJob(Job currentJob) {
        this.currentJob = currentJob;
    }
    
    
    
}
