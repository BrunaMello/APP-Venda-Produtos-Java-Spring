package com.brunamello.mvc.mudi.controller;

import com.brunamello.mvc.mudi.model.Pedido;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Arrays;
import java.util.List;

@Controller
public class HomeController {

    @GetMapping("/home")
    public String home(Model model){
        Pedido pedido = new Pedido();
        pedido.setNomeProduto("Iphone 12 Pro 128gb");
        pedido.setUrlImagem("https://store.storeimages.cdn-apple.com/4668/as-images.apple.com/is/iphone-12-pro-blue-hero?wid=940&hei=1112&fmt=png-alpha&qlt=80&.v=1604021661000");
        pedido.setUrlProduto("https://www.apple.com/pt/shop/buy-iphone/iphone-12-pro/ecr%C3%A3-de-6,1-polegadas-256gb-azul-pac%C3%ADfico");
        pedido.setDescricao("descricao ddskafnjfkvm,klfjnvmsjf");


        List<Pedido> pedidos = Arrays.asList(pedido);
        model.addAttribute("pedidos", pedidos);


        return "home";
    }


}
