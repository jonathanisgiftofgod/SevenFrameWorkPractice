package login4jExamples;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;

public class BasicConfigurationExample {
	static Logger logger = Logger.getLogger(BasicConfigurationExample.class);
	public static void main(String[] args) {
		BasicConfigurator.configure(); 
		logger.debug("This is debug Message");
		logger.info("This is info Message");
		logger.warn("This is warning Message");
		logger.error("This is debug error");
		logger.fatal("This is fatal Message");
	}
}
