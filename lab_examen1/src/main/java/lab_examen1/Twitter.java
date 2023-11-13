package lab_examen1;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JTextArea;

public class Twitter extends SocialClass {
    public static StringBuilder list;

    public static StringBuilder getList(){
        return Twitter.list;
    }
    
    public Twitter(String username) {
        super(username);
    }

    @Override
    public void timeline(JList list) {
        DefaultListModel<String> lm=new DefaultListModel<>();
        for(int i=0;i<posts.size();i++){
            String item="Post #"+(i+1)+" - "
                    + posts.get(i);
            lm.addElement(item);
            
        }
        list.setModel(lm);
    }
 
    
}
