/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ee4216.gp14.stickynotesapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StickyNotesRepository extends JpaRepository<StickyNotes, Long> {
    List<StickyNotes> findByUsername(String text);
    
    List<StickyNotes> findByNidAndUsername(Long nid, String text);
}
