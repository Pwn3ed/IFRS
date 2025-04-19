package ifrs.edu.br.ex_security.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeController {
    
    @GetMapping("/")
    public String home() {
        return "Starting page, use the following routes:"
            +"<br>"
            +"<br>- /login"
            +"<br>"
            +"<br>- /visitante"
            +"<br>- /estudante"
            +"<br>- /professor"
            +"<br>- /administrador"
            +"<br>"
            +"<br>Obs: the password is the same as the name"
            ;
    }

    @GetMapping("/visitante")
    public String visitante() {
        return "Visitante";
    }

    @GetMapping("/estudante")
    public String estudante() {
        return "Estudante";
    }

    @GetMapping("/professor")
    public String professor() {
        return "Professor";
    }

    @GetMapping("/administrador")
    public String administrador() {
        return "Administrador";
    }

}
