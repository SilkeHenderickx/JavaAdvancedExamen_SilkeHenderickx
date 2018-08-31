package edu.ap.spring.view;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.swing.*;
import java.awt.*;

@Component
public class UI implements InitializingBean {

	JTabbedPane tabbedPane;
	JPanel jPanel;
	JLabel addQuotesTitle, getAllQuotesTitle, searchQuotesTitle;
	JButton addQuotesButton, getAllQuotesButton, searchQuotesButton;
	JTextField getAllQuotesText, searchQuotesResult, searchQuotesSearchTerm;
	JFrame jFrame;

	@Autowired
	EventHandler eventHandler;


	public void setupUI(){

		jFrame = new JFrame("EightBall");
		jFrame.setLayout(new FlowLayout());

		jPanel = new JPanel();
		jPanel.setLayout(new GridLayout(0, 1));


		jPanel.add(addQuotesTitle = new JLabel("Add Quotes to DB"));
		addQuotesButton = new JButton("Add");
		addQuotesButton.addActionListener(eventHandler::whenAddQuotesButtonClicked);
		jPanel.add(addQuotesButton);

		jPanel.add(new JLabel());
		jPanel.add(getAllQuotesTitle = new JLabel("Get all quotes"));
		getAllQuotesButton = new JButton("Get");
		getAllQuotesButton.addActionListener(eventHandler::whenGetAllClicked);
		jPanel.add(getAllQuotesButton);
		jPanel.add(getAllQuotesText = new JTextField(50));

		jPanel.add(new JLabel());
		jPanel.add(searchQuotesTitle = new JLabel("Get all quotes"));
		searchQuotesButton = new JButton("Get");
		searchQuotesButton.addActionListener(eventHandler::whenGetSearchClicked);
		jPanel.add(searchQuotesButton);
		searchQuotesSearchTerm = new JTextField(50);
		searchQuotesSearchTerm.setText("Searchterm");
		jPanel.add(searchQuotesSearchTerm);
		jPanel.add(searchQuotesResult = new JTextField(50));



		jFrame.add(jPanel);
		jFrame.setSize(300, 300);
		jFrame.setLocationRelativeTo(null);
		jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jFrame.pack();
		jFrame.setVisible(true);

	}


	@Override
	public void afterPropertiesSet() throws Exception {
		System.setProperty("java.awt.headless", "false");
	}
}
