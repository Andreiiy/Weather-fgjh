package Weather.Weather;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.io.IOException;
import java.net.MalformedURLException;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;


public class Parser extends JFrame
{
	
	public static int count;
	
	
	
	public static void createGUI() throws MalformedURLException, IOException {
        JFrame frame = new JFrame("Weather");
        
        
        JLabel label = new JLabel("Weather in Israel!");
        label.setSize(100, 50);
        label.setLocation(0, 300);
       
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       
        DataWeather dataWeather = new DataWeather();
        String[] columnNames = {
                  "City",
                  "Temperature"
                  };
         
        String[][] data = dataWeather.getData();
        
        
               JTable table = new JTable(data, columnNames);
        
       
        JScrollPane scrollPane = new JScrollPane(table);
        table.setLocation(0, 100);
        
        JPanel jpanel = new JPanel();
        jpanel.add(scrollPane);
        
        
        frame.add(label,BorderLayout.NORTH);
        frame.add(jpanel);
        frame.setPreferredSize(new Dimension(650, 500));
        frame.pack();
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    
      
       
   }
	
    public static void main( String[] args ) throws MalformedURLException, IOException
    {
      //  System.out.println(getPage());
       // Document page = getPage();
       
         
        
       javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                 JFrame.setDefaultLookAndFeelDecorated(true);
                 try {
					createGUI();
				
				} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				}
            }
       });
    }
}

