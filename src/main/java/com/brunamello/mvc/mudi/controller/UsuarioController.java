package com.brunamello.mvc.mudi.controller;

import com.brunamello.mvc.mudi.model.Pedido;
import com.brunamello.mvc.mudi.model.StatusPedido;
import com.brunamello.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("usuario")
public class UsuarioController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("pedido")
    public ModelAndView home(Model model, Principal principal){

        List<Pedido> pedidos = pedidoRepository.findAllByUsuario(principal.getName());
        ModelAndView mv = new ModelAndView("usuario/home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }

    @GetMapping("pedido/{status}")
    public String porStatus(@PathVariable("status") String status, Model model, Principal principal){
        List<Pedido> pedidos = pedidoRepository.findByStatusAndUsers(StatusPedido.valueOf(status.toUpperCase()), principal.getName());
        model.addAttribute("pedidos", pedidos);
        model.addAttribute("status", status);
        return "usuario/home";
    }


    @ExceptionHandler(IllegalArgumentException.class)
    public String onError(){
        return "redirect:/usuario/home";
    }
}
