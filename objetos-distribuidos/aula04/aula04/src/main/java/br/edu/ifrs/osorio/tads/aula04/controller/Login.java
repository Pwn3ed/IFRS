	package br.edu.ifrs.osorio.tads.aula04.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/login")
public class Login{

@PostMapping("/autentica")
public String validarLogin(@RequestParam String usuario, @RequestParam String senha){
        if (usuario.equals("adm") && senha.equals("123")){
                return "ok";
        }else{
                return "senha inválida";
        }
}
}
