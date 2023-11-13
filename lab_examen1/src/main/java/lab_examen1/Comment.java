package lab_examen1;

import java.util.Calendar;

public final class Comment {
    int postId;
    String autor;
    String comment;
    Calendar fecha;
    
    public Comment(int postId, String autor, String comment) {
        this.postId = postId;
        this.autor = autor;
        this.comment = comment;
        fecha = Calendar.getInstance();
    }
    
    public String print() {
        String date = fecha.get(Calendar.DAY_OF_MONTH) + "/"  + (fecha.get(Calendar.MONTH) + 1) + "/" + fecha.get(Calendar.YEAR);
        String msg = autor + " - " + date + " - "+comment;
        return msg;
        
    }

    public int getPostId() {
        return postId;
    }

    public String getAutor() {
        return autor;
    }

    public String getComment() {
        return comment;
    }

    public Calendar getFecha() {
        return fecha;
    }
    
}
