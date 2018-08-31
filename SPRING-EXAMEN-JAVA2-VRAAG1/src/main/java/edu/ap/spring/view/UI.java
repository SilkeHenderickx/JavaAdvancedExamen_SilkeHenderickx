package edu.ap.spring.view;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UI implements InitializingBean {

	@Autowired
	EventHandler eventHandler;

	public UI(){}

	public void setupUI(){

	}

	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
