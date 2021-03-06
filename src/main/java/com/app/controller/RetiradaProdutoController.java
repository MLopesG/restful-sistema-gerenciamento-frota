package com.app.controller;

import javax.validation.Valid;

import com.app.entity.RetiradaProduto;
import com.app.service.RetiradaProdutoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/retirada-produtos")
public class RetiradaProdutoController {
    
    @Autowired
    private RetiradaProdutoService service;

    @GetMapping("")
    public ResponseEntity<?> getAll(){
        return  ResponseEntity.ok(service.all());
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@Valid @RequestBody RetiradaProduto produto) {
        return ResponseEntity.ok(service.save(produto));
    }

    @PostMapping("/edit/{id}")
    public ResponseEntity<?> edit(@PathVariable(value = "id")  Integer id, @Valid @RequestBody RetiradaProduto produto)
    {   
        RetiradaProduto ProdutoBody = produto;
        ProdutoBody.setId(id);

        return ResponseEntity.ok(service.save(ProdutoBody));
    }

    @PostMapping("/delete/{id}")
    public ResponseEntity<?> deleteVeiculo(@PathVariable(value = "id")  Integer id){
        return ResponseEntity.ok(service.delete(id));
    }
}