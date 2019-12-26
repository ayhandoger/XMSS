/**
 * 
 */


/**
 * @author
 * Nuri Ayhan Doger 
 * Schaafenstrasse 53
 * 50676 Köln
 * doger@ndym.de
 *  
 * XMSS- eXtended Management Support Systems v0.9 
 * (evolutionärer Prototyp im Rahmen einer Master-Thesis im Master-Studiengang "Master Of Science in Informationsystems)) 
 *
 * unter der Betreuung von:
 *
 * Prof.Dr. Dieter Ehrenberg
 * Institut für Wirtschaftsinformatik
 * Universität Leipzig
 * XMSS main frame.java
 */

// Diese Class-Datei XMSSmainFrame.java stellt das Mainframe der XMSS-Applikation dar
//
//package pXMSS; //Das Root-Package
import java.awt.*;
import java.awt.event.*;
import javax.swing.*; // Import der benötigten API-Packages

public class XMSSMenuBar extends JMenuBar 
{

   String[ ] fileItems = new String[ ] { "Open XMSS-File", "Save XMSS-File", "Open Media-File", "Exit" };
   String[ ] manageItems = new String[ ] { "Preferences", "Simulation", "Flow-Charts-Analyser" };
   String[ ] videoItems = new String[ ] { "Conference", "Capture Video", "Edit", "Configure Avatar", };
   String[ ] audioItems = new String[ ] { "Speech-Options", "Acoustic Designer", "Record Audio", "Edit Audio" };
   String[ ] phoneItems = new String[ ] { "Phone-Options", "Make a phone call", "Send SMS", "Use UMTS" };
   String[ ] interItems = new String[ ] { "Database-Settings", "Online-Analytical-Processing", "Plug-In-Settings", "Browser-Settings" };
   String[ ] helpItems = new String[ ] {  "XMSS Beta-Version 0.9", "Index A-Z", "XMSS-Introduction", "XMSS-Manual" };
   
   char[ ] fileShortcuts = { 'O','S','M','X' };
   char[ ] manageShortcuts = { 'P','S','F','V' };
   char[ ] videoShortcuts = { 'S','M','C','V' };
   char[ ] audioShortcuts = { 'C','H','L','J' };
   char[ ] phoneShortcuts = { 'B','U','Ü','K' };
   char[ ] interShortcuts = { 'D','G','D','I' };
   char[ ] helpShortcuts = { 'E','F','A','W' };
   
   XMSSprocesses process;
   XMSSmodules modules;
   
   public XMSSMenuBar(  ) 
  {

      JMenu fileMenu = new JMenu("FILE");
      JMenu manageMenu = new JMenu("MANAGE");
      JMenu videoMenu = new JMenu("VIDEO");
      JMenu audioMenu = new JMenu("AUDIO");
	  JMenu phoneMenu = new JMenu("PHONE");
	  JMenu interMenu = new JMenu("INTERFACES");
	  JMenu helpMenu = new JMenu("HELP");
	  JMenu report = new JMenu("View Reports");
      JMenu standardReport = new JMenu("Standard-Reports");
      JMenu adhocReport = new JMenu("Ad-Hoc-Report");
      JMenu exceptionReport = new JMenu("Exception-Reports");
      
      // Assemble the File menus with mnemonics.
      ActionListener printListener = new ActionListener(  ) 
      {
         public void actionPerformed(ActionEvent event) 
         {
            System.out.println("Menu item [" + event.getActionCommand(  ) +
                               "] was pressed.");
         }
      };
      for (int i=0; i < fileItems.length; i++) 
      {
         JMenuItem item = new JMenuItem(fileItems[i], fileShortcuts[i]);
         item.addActionListener(printListener);
         fileMenu.add(item);
      }

      for (int i=0; i < phoneItems.length; i++) 
      {
          JMenuItem item = new JMenuItem(phoneItems[i], phoneShortcuts[i]);
          item.addActionListener(printListener);
          phoneMenu.add(item);
       }
      
      for (int i=0; i < audioItems.length; i++) 
      {
          JMenuItem item = new JMenuItem(audioItems[i], audioShortcuts[i]);
          item.addActionListener(printListener);
          audioMenu.add(item);
      }
      
      for (int i=0; i < interItems.length; i++)
      {
          JMenuItem item = new JMenuItem(interItems[i], interShortcuts[i]);
          item.addActionListener(printListener);
          interMenu.add(item);
      }
      
      for (int i=0; i < interItems.length; i++) 
      {
          JMenuItem item = new JMenuItem(helpItems[i], helpShortcuts[i]);
          item.addActionListener(printListener);
          helpMenu.add(item);
      }
      
      // Assemble the File menus with keyboard accelerators.
      
      for (int i=0; i < manageItems.length; i++)
      {
         JMenuItem item = new JMenuItem(manageItems[i]);
         item.setAccelerator(KeyStroke.getKeyStroke(manageShortcuts[i],
              Toolkit.getDefaultToolkit(  ).getMenuShortcutKeyMask(  ), false));
         item.addActionListener(printListener);
         manageMenu.add(item);
      }
  
      // Insert a separator in the Management menu in Position 1 after "Undo".
      manageMenu.insertSeparator(1);

      // Assemble the submenus of the management menu.
      JMenuItem item;
      standardReport.add(item = new JMenuItem("Daily Report"));
      item.addActionListener(printListener);
      standardReport.add(item = new JMenuItem("Weekly Report"));
      standardReport.add(item = new JMenuItem("Monthly Report"));
      standardReport.add(item = new JMenuItem("4-Month Report"));
      standardReport.add(item = new JMenuItem("Yearly Report"));
      item.addActionListener(printListener);
      report.add(standardReport);
      report.add(adhocReport);
      report.add(exceptionReport);
      manageMenu.add(report);
      
      // assemble the video menu 
     
      videoMenu.add(item = new JCheckBoxMenuItem("Camera On"));
      item.addActionListener(printListener);
      videoMenu.addSeparator(  );
      ButtonGroup buttonGroup = new ButtonGroup(  );
      videoMenu.add(item = new JRadioButtonMenuItem("Radio 1"));
      item.addActionListener(printListener);
      buttonGroup.add(item);
      videoMenu.add(item = new JRadioButtonMenuItem("Radio 2"));
      item.addActionListener(printListener);
      buttonGroup.add(item);
      videoMenu.addSeparator(  );
      videoMenu.add(item = new JMenuItem("Potted Plant", 
                           new ImageIcon("image.gif")));
      item.addActionListener(printListener);
  
      //  adding all the menus to the menu bar.
      add(fileMenu);
      add(manageMenu);
      add(videoMenu);
	  add(audioMenu);  
      add(phoneMenu);
      add(interMenu);
	  add(helpMenu);
	  
	}
  
}




