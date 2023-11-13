package lab_examen1;

import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class Facebook extends SocialClass implements Commentable {

    public static ArrayList<Comment> comments;

    public Facebook(String username) {
        super(username);
        comments = new ArrayList();
    }

    @Override
    public boolean addComment(Comment comment) {
        UberSocial.comments.add(comment);
        comments.add(comment);
        JOptionPane.showMessageDialog(null,"Comentado");
        return true;
    }

    @Override
    public void timeline(JList list) {
        DefaultListModel<String> lm=new DefaultListModel<>();
        for(int i=0;i<UberSocial.allPostsF.size();i++){
            String item="Post #"+(i+1)+" - "+ UberSocial.allPostsF.get(i)+" Comments: ";
            for(Comment comment: UberSocial.comments){
            if(comment.getPostId()==i){
                item+=comment.print();
            }
        }
            
            
            
            
            
            lm.addElement(item);
            
        }
        list.setModel(lm);
    }
    
}
