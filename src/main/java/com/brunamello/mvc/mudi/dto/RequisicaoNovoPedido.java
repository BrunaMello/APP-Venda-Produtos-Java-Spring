package com.brunamello.mvc.mudi.dto;

import com.brunamello.mvc.mudi.model.Pedido;
import com.brunamello.mvc.mudi.model.StatusPedido;
import org.springframework.web.bind.annotation.GetMapping;

import javax.validation.constraints.NotBlank;


public class RequisicaoNovoPedido {

    @NotBlank
    private String nomeProduto;

    @NotBlank
    private String urlProduto;

    @NotBlank
    private String imgProduto;

    @NotBlank
    private String descProduto;


    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String getUrlProduto() {
        return urlProduto;
    }

    public void setUrlProduto(String urlProduto) {
        this.urlProduto = urlProduto;
    }

    public String getImgProduto() {
        return imgProduto;
    }

    public void setImgProduto(String imgProduto) {
        this.imgProduto = imgProduto;
    }

    public String getDescProduto() {
        return descProduto;
    }

    public void setDescProduto(String descProduto) {
        this.descProduto = descProduto;
    }

    public Pedido toPedido() {
        Pedido pedido = new Pedido();
        pedido.setNomeProduto(nomeProduto);
        pedido.setUrlProduto(urlProduto);
        pedido.setUrlImagem(imgProduto);
        pedido.setDescricao(descProduto);
        pedido.setStatus(StatusPedido.AGUARDANDO);
        return pedido;

    }




}
