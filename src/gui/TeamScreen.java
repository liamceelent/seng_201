package gui;


import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;

import rugby.Athlete;
import rugby.GameEnviroment;

import javax.swing.JPanel;

import javax.swing.SwingConstants;

import javax.swing.border.TitledBorder;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import java.awt.Font;

public class TeamScreen {
	

	private JFrame frame;
	private GameEnviroment enviroment;
	private JLabel activeLabel;

	
	public TeamScreen(GameEnviroment enviroment){
		this.enviroment = enviroment;
		initialize();
		frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void goHome() {
		enviroment.closeTeamScreen(this);
	}
	
	public void goAthlete(Athlete athlete) {
		enviroment.closeTeamScreen(this, athlete);
	}

	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setBounds(500, 300, 600, 500);
		
		
		JButton homeButton = new JButton("Home");
		homeButton.setBounds(252, 409, 89, 23);
		homeButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				goHome();
			}
		});
		frame.getContentPane().setLayout(null);
		frame.getContentPane().add(homeButton);

		activeLabel = new JLabel("Active team", SwingConstants.CENTER);
		activeLabel.setBounds(46, 19, 172, 30);
		frame.getContentPane().add(activeLabel);
		
		DefaultListModel<Athlete> athleteListModel = new DefaultListModel<Athlete>();
		athleteListModel.addAll(this.enviroment.getTeam());
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "wow", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(338, 185, 131, -168);

		frame.getContentPane().add(panel);

		
		JList<Athlete> activePlayerList = new JList<Athlete>();
		activePlayerList.setFont(new Font("Tahoma", Font.BOLD, 10));
		activePlayerList.setBounds(10, 49, 270, 285);
		frame.getContentPane().add(activePlayerList);
		activePlayerList.setModel(athleteListModel);
//		Athlete ed = GameEnviroment.generatePlayer();
		
		JButton selectAthleteButton = new JButton("select athlete");
		selectAthleteButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = activePlayerList.getSelectedValue(); 	
				if (athlete1 != null) {
					goAthlete(activePlayerList.getSelectedValue());
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from active team");
				}
			}
		});
		selectAthleteButton.setBounds(46, 356, 172, 23);
		frame.getContentPane().add(selectAthleteButton);
		
		
		JLabel reserveTitle = new JLabel("Reserve team", SwingConstants.CENTER);
		reserveTitle.setBounds(362, 27, 172, 14);
		frame.getContentPane().add(reserveTitle);
		
		DefaultListModel<Athlete> reserveModelList = new DefaultListModel<Athlete>();
		reserveModelList.addAll(enviroment.club.players);
		
		
		JList<Athlete> reserveList = new JList<Athlete>();
		reserveList.setFont(new Font("Tahoma", Font.BOLD, 10));
		reserveList.setBounds(304, 49, 270, 285);
		frame.getContentPane().add(reserveList);
		reserveList.setModel(reserveModelList);
		
		JButton selectReserveButton = new JButton("select reserve athlete");
		selectReserveButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = reserveList.getSelectedValue(); 	
				if (athlete1 != null) {
					goAthlete(reserveList.getSelectedValue());
				}else {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from reserve");
				}
			}
		});
		selectReserveButton.setBounds(372, 356, 172, 23);
		frame.getContentPane().add(selectReserveButton);
		
		JButton swapButton = new JButton("swap");
		swapButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Athlete athlete1 = reserveList.getSelectedValue(); 	
				Athlete athlete2 = activePlayerList.getSelectedValue();
				if (athlete1 == null | athlete2 == null) {
					JOptionPane.showMessageDialog(frame,"Please select a athlete from both");
				}else {
					enviroment.club.swapPlayer(athlete2, athlete1);
					JOptionPane.showMessageDialog(frame,"swapped " + athlete2.getName() + " with " + athlete1.getName());
					goHome();
				}
				
			}
		});
		swapButton.setBounds(252, 356, 89, 23);
		frame.getContentPane().add(swapButton);

	}
}
