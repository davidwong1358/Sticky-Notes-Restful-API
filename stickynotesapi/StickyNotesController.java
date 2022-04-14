/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.gp14.stickynotesapi;

import java.util.List;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;



@RestController
public class StickyNotesController {

    @Autowired
    StickyNotesRepository stickyNotesRespository;

    @GetMapping("/api/stickynotes")
    public Iterable<StickyNotes> index() {
        return stickyNotesRespository.findAll();
    }

    @GetMapping("/api/stickynotes/{username}")
    public Iterable<StickyNotes> search(@PathVariable String username) {
        return stickyNotesRespository.findByUsername(username);
    }
    
    @GetMapping("/api/stickynotes/{username}/{noteid}")
    public Iterable<StickyNotes> searchUser(@PathVariable("username") String username, @PathVariable("noteid") String noteid) {
        Long noteId = Long.valueOf(noteid);
        String user = username;
        return stickyNotesRespository.findByNidAndUsername(noteId, user);
    }
    

    @PostMapping("/api/stickynotes")
    public StickyNotes create(@RequestBody StickyNotes newNotes) {
        Long nid = newNotes.getNoteID();
        String user = newNotes.getUsername();
        List<StickyNotes> note = stickyNotesRespository.findByNidAndUsername(nid, user);
        
        if (!note.isEmpty()){
            for (StickyNotes each: note){
                stickyNotesRespository.delete(each);
            }
        }
        
        return stickyNotesRespository.save(newNotes);
    }

    @PutMapping("/api/stickynotes/{username}/{noteid}")
    public StickyNotes update(@PathVariable("username") String username, @PathVariable("noteid") String noteid, @RequestBody StickyNotes newNotes) {
        Long noteId = Long.valueOf(noteid);
        String user = username;
        List<StickyNotes> note = stickyNotesRespository.findByNidAndUsername(noteId, user);
        for (StickyNotes each: note){
            each.setUsername(newNotes.getUsername());
            each.setContent(newNotes.getContent());
            each.setLocationX(newNotes.getLocationX());
            each.setLocationY(newNotes.getLocationY());
            each.setHeight(newNotes.getHeight());
            each.setWidth(newNotes.getWidth());
            stickyNotesRespository.save(each);
        }
        return null;
    }

    @DeleteMapping("/api/stickynotes")
    public boolean delete(@RequestBody StickyNotes newNotes) {
        Long noteId = newNotes.getNoteID();
        String user = newNotes.getUsername();
        List<StickyNotes> note = stickyNotesRespository.findByNidAndUsername(noteId, user);
        for (StickyNotes each: note){
            stickyNotesRespository.delete(each);
        }
        return true;
    }
}
