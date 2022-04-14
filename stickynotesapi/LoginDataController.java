
package ee4216.gp14.stickynotesapi;

import java.util.Map;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;


@RestController
public class LoginDataController {

    @Autowired
    LoginDataRepository loginDataRespository;

    @GetMapping("/api/logindata")
    public Iterable<LoginData> index() {
        return loginDataRespository.findAll();
    }

    @GetMapping("/api/logindata/{username}")
    public Iterable<LoginData> search(@PathVariable String username) {
        return loginDataRespository.findByUsername(username);
    }

    @PostMapping("/api/logindata")
    public LoginData create(@RequestBody Map<String, String> body) {
        String username = body.get("username");
        String password = body.get("password");
        return loginDataRespository.save(new LoginData(username, password));
    }

    @PutMapping("/api/logindata/{id}")
    public LoginData update(@PathVariable String id, @RequestBody Map<String, String> body) {
        Long userId = Long.valueOf(id);
        LoginData note = loginDataRespository.findById(userId).orElse(null);
        note.setUsername(body.get("username"));
        note.setPassword(body.get("password"));
        return loginDataRespository.save(note);
    }

    @DeleteMapping("/api/logindata/{id}")
    public boolean delete(@PathVariable String id) {
        Long userId = Long.valueOf(id);
        loginDataRespository.deleteById(userId);
        return true;
    }

}
