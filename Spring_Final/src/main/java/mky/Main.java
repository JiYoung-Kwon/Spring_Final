package mky;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

public class Main {
	public Main() {
		ApplicationContext ac = new FileSystemXmlApplicationContext("src/main/java/mky/hosassembler.xml");
		
		HospitalParsing hp = ac.getBean("hpp", HospitalParsing.class);
		hp.Hospital();
	}
	
	public static void main(String[] args) {
		new Main();
	}
}