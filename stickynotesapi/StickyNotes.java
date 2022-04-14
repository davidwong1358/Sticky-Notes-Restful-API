package ee4216.gp14.stickynotesapi;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "STICKY_NOTES")
public class StickyNotes {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private Long nid;
    private String username;
    private String content;
    private int location_x;
    private int location_y;
    private int height;
    private int width;

    public StickyNotes() {
    }

    public StickyNotes(String user, Long nid, String content, int x, int y, int h, int w) {
        this.setUsername(user);
        this.setNoteID(nid);
        this.setContent(content);
        this.setLocationX(x);
        this.setLocationY(y);
        this.setHeight(h);
        this.setWidth(w);
    }

    public StickyNotes(Long id, Long nid, String user,  String content, int x, int y, int h, int w) {
        this.setID(id);
        this.setNoteID(nid);
        this.setUsername(user);
        this.setContent(content);
        this.setLocationX(x);
        this.setLocationY(y);
        this.setHeight(h);
        this.setWidth(w);
    }

    //Set Method
    public void setID(Long id) {
        this.id = id;
    }
    
    public void setNoteID(Long nid) {
        this.nid = nid;
    }

    public void setUsername(String user) {
        this.username = user;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setLocationX(int x) {
        this.location_x = x;
    }

    public void setLocationY(int y) {
        this.location_y = y;
    }

    public void setHeight(int h) {
        this.height = h;
    }

    public void setWidth(int w) {
        this.width = w;
    }



    //Get Method
    public Long getID() {
        return id;
    }
    
    public Long getNoteID() {
        return nid;
    }

    public String getUsername() {
        return username;
    }

    public String getContent() {
        return content;
    }

    public int getLocationX() {
        return location_x;
    }

    public int getLocationY() {
        return location_y;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    @Override
    public String toString() {

        return String.format(
                "StickyNotes[id=%d, nid=%d, username='%s', content='%s', location_x=%d, location_y=%d, height=%d, width=%d]",
                id, nid, username, content, location_x, location_y, height, width);
    }

}
