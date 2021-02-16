package com.brunamello.mvc.mudi.controller;

import com.brunamello.mvc.mudi.model.Pedido;
import com.brunamello.mvc.mudi.repository.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    private PedidoRepository pedidoRepository;

    @GetMapping("/home")
    public ModelAndView home(){

        List<Pedido> pedidos = pedidoRepository.findAll();
        ModelAndView mv = new ModelAndView("home");
        mv.addObject("pedidos", pedidos);
        return mv;
    }


}
