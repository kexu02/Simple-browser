
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;


public class Browser extends JFrame{
    
    private JTextField addressBar;
    private JEditorPane display;

    public Browser() {
        super("Browser");
        addressBar = new JTextField("Type a URL");
        addressBar.addActionListener(
            new ActionListener() {
                public void actionPerformed(ActionEvent event)  {
                   loadWebsite(event.getActionCommand());
               }
           }
        );
        
        add(addressBar, BorderLayout.NORTH);
        
        display = new JEditorPane();
        display.setEditable(false);
        display.addHyperlinkListener(
            new HyperlinkListener() {
                public void hyperlinkUpdate(HyperlinkEvent event) {
                    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        loadWebsite(event.getURL().toString());
                    }
                }
            }
        );
        
        add (new JScrollPane(display), BorderLayout.CENTER);
        setSize(500,300);
    }

    private void loadWebsite(String url) {
        try {
            display.setPage(url);
            addressBar.setText(url);
        } catch(Exception e) {
            System.out.println("Invalid URL");
        }
    }
}
