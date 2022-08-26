package com.educative.mergeIntervals;

import java.util.*;

class Job {
  int start;
  int end;
  int cpuLoad;

  public Job(int start, int end, int cpuLoad) {
    this.start = start;
    this.end = end;
    this.cpuLoad = cpuLoad;
  }
};

class MaximumCPULoad {

  public static int findMaxCPULoad(List<Job> jobs) {
    Collections.sort(jobs, (x,y)->x.start<y.start?-1:1);
    
    PriorityQueue<Job> currentJobs = new PriorityQueue<Job>(1, (x,y)->x.end<y.end?-1:1);
    Iterator<Job> jobIterator = jobs.iterator();
    Job newJob = jobIterator.next();
    currentJobs.add(newJob);
    
    int currentLoad = newJob.cpuLoad, maxLoad = newJob.cpuLoad;
    
    while(jobIterator.hasNext()) {
    	newJob = jobIterator.next();
    	
    	if(newJob.start<currentJobs.peek().end) {
    		currentJobs.add(newJob);
    		currentLoad+=newJob.cpuLoad;
    	} else {
    		while(!currentJobs.isEmpty() && currentJobs.peek().end<=newJob.start)
    			currentLoad-=currentJobs.poll().cpuLoad;
    		currentJobs.add(newJob);
    		currentLoad+=newJob.cpuLoad;
    	}
    	
    	maxLoad = Math.max(maxLoad, currentLoad);
    }
    
    return maxLoad;
  }

  public static void main(String[] args) {
    List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
    System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));
  }
}
