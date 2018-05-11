/*
 * James
 * GUI class for that creates the menu
 * May 11, 2018
 */
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.imageio.*;
import java.io.*;
import java.util.*;

public class MainMenu extends JFrame implements ActionListener{
  
  //Declare JPanel for the menu and for the game screen
  JPanel mainMenu = new JPanel();
  JPanel game = new JPanel();
  
  //Create a title to place on the menu panel
  JLabel menuTitle = new JLabel("Canadian Checkers", SwingConstants.CENTER);
  
  //Create a label using an image to add to the menu
  ImageIcon image = new ImageIcon("checkers.jpg");
  JLabel menuPic = new JLabel(image);
  
  //Declare the layout for the panels
  GridBagConstraints gbc = new GridBagConstraints();
  
  //Create JButtons for the menu
  JButton play = new JButton("PLAY");
  JButton quit = new JButton("QUIT");
  
  //Constructor that creates the GUI for main menu
  public MainMenu(){
    
    //Set the title of the fram as well as size
    setTitle("Canadian Checkers");
    setSize(800,800);
    
    //Make the size unchangable by the user
    setResizable(false);
    
    //Set the layout of the fram
    setLayout(new GridBagLayout());
    
    //Add an action listener to each button
    play.addActionListener(this);
    quit.addActionListener(this);
    
    //Set the layout of the menu panel
    mainMenu.setLayout(new GridBagLayout());
    
    //Set the layout constraints
    gbc.fill = GridBagConstraints.HORIZONTAL;
    gbc.insets = new Insets(0,5,50,5);
    
    //Add the title, image, and buttons to the menu panel
    gbc.weightx=1;
    gbc.weighty=1;
    gbc.ipady=0;
    gbc.gridx = 2;
    gbc.gridy = 0;
    menuTitle.setFont(new Font("Serif", Font.BOLD, 24));
    mainMenu.add(menuTitle,gbc);
    gbc.gridx = 2;
    gbc.gridy = 1;
    mainMenu.add(play,gbc);
    gbc.gridx = 2;
    gbc.gridy = 2;
    mainMenu.add(quit,gbc);
    gbc.gridx=2;
    gbc.gridy=9;
    mainMenu.add(menuPic,gbc);
    
    
    //Add the panels to the fram
    add(mainMenu);
    add(game);
    
    //Set the frame to visible and the menu panel
    mainMenu.setVisible(true);
    game.setVisible(false);
    setVisible(true);
  }
  
  //Action performed method to determine what the user wants to do
  public void actionPerformed(ActionEvent event){
    //Declare JButton
    JButton buttonPressed;
    
    if(event.getSource() instanceof JButton){
      buttonPressed = (JButton)(event.getSource());
      
      //If the play button is pressed change the visibility of panels
      if(buttonPressed.equals(play)){
        mainMenu.setVisible(false);
        game.setVisible(true);
      }
      //else if the quit button is pressed close the frame
      else if(buttonPressed.equals(quit)){
        this.dispose();
      }
    }
  }
  
  public static void main(String [] args){
    //Declare the JFrame
    MainMenu frame1 = new MainMenu();
    frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
  }
  
}
