package com.ieti.project.web.controller;

import com.ieti.project.persistence.entity.BusinessEntity;
import com.ieti.project.persistence.entity.ShoppingCartEntity;
import com.ieti.project.service.BusinessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/shoppingCart")
public class ShoppingCartController {

    private final ShoppingCartService shoppingCartService;

    @Autowired
    public ShoppingCartController(ShoppingCartService shoppingCartService){
        this.shoppingCartService = shoppingCartService;
    }

    @GetMapping
    public ResponseEntity<List<ShoppingCartEntity>> getAll(){
        return ResponseEntity.ok(this.shoppingCartService.getAll());
    }

    @GetMapping("/{shoppingCartId}")
    public ResponseEntity<BusinessEntity> get(@PathVariable int shoppingCartId){
        return ResponseEntity.ok(this.shoppingCartService.get(shoppingCartId));
    }

    @PostMapping
    public ResponseEntity<BusinessEntity> add(@RequestBody ShoppingCartEntity shoppingCart){
        if (shoppingCart.getShoppingCartId() == null || !this.shoppingCartService.exists(shoppingCart.getShoppingCartId())){
            return ResponseEntity.ok(this.shoppingCartService.save(shoppingCart));
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping
    public ResponseEntity<BusinessEntity> update(@RequestBody ShoppingCartEntity shoppingCart){
        if (shoppingCart.getShoppingCartId() != null && this.shoppingCartService.exists(shoppingCart.getShoppingCartId())){
            return ResponseEntity.ok(this.shoppingCartService.save(shoppingCart));
        }
        return ResponseEntity.badRequest().build();
    }

    @DeleteMapping("/{shoppingCartId}")
    public ResponseEntity<Void> delete(@PathVariable int shoppingCartId){
        if (this.shoppingCartService.exists(shoppingCartId)){
            this.shoppingCartService.delete(shoppingCartId);
            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().build();
    }


}
