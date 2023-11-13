package lab_examen1;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public abstract class SocialClass {

    ArrayList<String> friends;
    ArrayList<String> posts;
    String username;
    String msg;
    

    public SocialClass(String username) {
        friends = new ArrayList();
        posts = new ArrayList();
        this.username = username;
    }

    public boolean addFriend(String user) {
        SocialClass log=UberSocial.logged;
        SocialClass friend=UberSocial.buscar(username, 0);

       if(log.friends.contains(user)){
           JOptionPane.showMessageDialog(null, "ya es amigo de "+user);
           return false;
       }else{
       log.friends.add(user);
       
       
       JOptionPane.showMessageDialog(null, "Amigo agregado");
       return true;    
       }
       
    }

    public void addPost(String msg) {
        posts.add(msg);
    }

    public abstract void timeline(JList list);

    public void myProfile(JTextArea area, JList list) {
        msg = "User: " + username+"\n"
                + "Friends: "+showFriends();
        timeline(list);
        area.setText(msg);
    }

    String showFriends() {
        String list="";
        for (String friend : friends) {
            list+=friend+"\n";
        }
        return list;
    }

    public ArrayList<String> getFriends() {
        return friends;
    }

    public ArrayList<String> getPosts() {
        return posts;
    }

    public String getUsername() {
        return username;
    }

    public String getMsg() {
        return msg;
    }
    
    
}
