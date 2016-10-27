package uy.com.hg.loadgen.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.ejb.Asynchronous;
import javax.ejb.Stateless;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Stateless
public class TaskRunner {
	private static final int ARRAY_SIZE = 10000;
	
	private static final Logger LOGGER = LoggerFactory.getLogger(TaskRunner.class);
		
	
	@Asynchronous
	public void runTask(int iterations){
		Random rnd = new Random();
		for (int i = 0; i < iterations; i++) {
			runTask();
			int sleep = rnd.nextInt(50);
			try {
				Thread.sleep(sleep);
			} catch (InterruptedException e) {
				LOGGER.error("Interrupted!!",e);
			}
		}
		LOGGER.info("Finished generating "+iterations+" lists");
	}

	private void runTask() {
		List<Integer> lista = new ArrayList<Integer>();
		for (int i = 0; i < ARRAY_SIZE; i++) {
			int suma = 0;
			for (Integer elementoActual : lista) {
				suma = (suma + elementoActual); 
			}
			lista.add(i);
		}		
	}
}
