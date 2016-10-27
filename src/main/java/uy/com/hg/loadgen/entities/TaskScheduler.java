package uy.com.hg.loadgen.entities;

import javax.ejb.EJB;
import javax.ejb.Schedule;
import javax.ejb.Singleton;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Singleton
public class TaskScheduler {
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskScheduler.class);
	
	@EJB
	TaskRunner taskRunner;
	
	@EJB
	StateHandler stateHandler;
	
	@Schedule(second = "*/2", minute = "*", hour = "*", persistent = false)
	public void scheduleTask(){
		Boolean started = stateHandler.getStarted();
		if (Boolean.TRUE.equals(started)){
			int counter = stateHandler.incrementCounter();
			LOGGER.info(String.format("Invoking task with %s iterations",counter));
			taskRunner.runTask(counter);
		} else {
			LOGGER.info("Starting...");
			stateHandler.setStarted(Boolean.TRUE);
		}
	}
}
