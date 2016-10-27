package uy.com.hg.loadgen.entities;

import javax.ejb.Singleton;

@Singleton
public class StateHandler {
	private Boolean started = Boolean.FALSE;
	
	private Integer counter = 0;

	public Boolean getStarted() {
		return started;
	}

	public void setStarted(Boolean started) {
		this.started = started;
	}

	public Integer incrementCounter() {
		counter = (counter + 1) % 100;
		return counter;
	}
}
