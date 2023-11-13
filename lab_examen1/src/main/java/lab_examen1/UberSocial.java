package lab_examen1;

import java.util.ArrayList;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class UberSocial {
    public static SocialClass logged;
    public static ArrayList<SocialClass> usuarios = new ArrayList();
    public static ArrayList<String> allPostsT = new ArrayList();
    public static ArrayList<String> allPostsF = new ArrayList();
    public static ArrayList<Comment> comments= new ArrayList();
   
    public static SocialClass buscar(String username, int i) {
    if (i>=usuarios.size()) {
        return null;
    }
    String nombre=usuarios.get(i).getUsername();
    if (username.equals(nombre)) {
        return usuarios.get(i);
    } else {
        return buscar(username, i+1);
    }
}
    
   public static void agregarCuenta(String username, String tipo){
        if(tipo.equalsIgnoreCase("Facebook")){
            Facebook fb = new Facebook(username);
            usuarios.add(fb);
        } else if (tipo.equalsIgnoreCase("Twitter")){
            Twitter twit = new Twitter(username);
            usuarios.add(twit);
        }
    }
    
    public void agregarPost(String user, String post){
        for(SocialClass usuario : usuarios){
            if(usuario.username.equals(user)){
                usuario.addPost(post);
            }
        }
    }
    
    public static void agregarAmigo(String user1, String user2){
        SocialClass username1 = buscar(user1,0);
        SocialClass username2 = buscar(user2,0);
        if(user2!=null){
            if ((username2 instanceof Twitter && username1 instanceof Twitter)||(username1 instanceof Facebook && username2 instanceof Facebook )) {
            username1.addFriend(user2);
            username2.friends.add(user1);
        }
        }else{
            JOptionPane.showMessageDialog(null, "Usuario no existe");
        }
        
        return;
        
    }
        
    public void agregarComment(String user, int postID, String autor, String comment){
        for(SocialClass usuario: usuarios){
            if(usuario instanceof Facebook && usuario.username.equals(user)){
                for (int i = 0; i<usuario.posts.size();i++) {
                    if (i ==postID) {
                        ((Facebook) usuario).comments.add(new Comment(postID, autor, comment));
                    }
                }
            }
        }
    }
    
    public static void profileForm(String user, JTextArea  area, JList list){
        for(SocialClass usuario: usuarios){
            if(usuario.username.equals(user)){
                usuario.myProfile(area,list);
            }
        }
    }
    
    public int findPost(Comment comment){
    return 0;    
    }
    
    
    
}
