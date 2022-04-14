package ee4216.gp14.stickynotesapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LoginDataRepository extends JpaRepository<LoginData, Long> {
    
    List<LoginData> findByUsername(String text);
    
}
