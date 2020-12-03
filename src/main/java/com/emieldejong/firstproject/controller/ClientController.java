package com.emieldejong.firstproject.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class ClientController {

    private static Map<Long, String> clients = new HashMap<>();
    static {
        clients.put(1L, "Jansen");
        clients.put(2L, "Pietersen");
        clients.put(3L, "Klaassen");
    }
    @GetMapping("/clients")
    public ResponseEntity get_clients() {
        return ResponseEntity.ok().body(this.clients);
    }
    @PostMapping("/clients")
    public ResponseEntity new_client(@RequestBody String client) {
        long newId = Collections.max(clients.keySet())+1;
        this.clients.put(newId, client);
        return new ResponseEntity("Client " + client + " aangemaakt.", HttpStatus.CREATED);
    }

    @GetMapping("/clients/{id}")
    public ResponseEntity get_client(@PathVariable long id) {
        if (this.clients.containsKey(id)) {
            String client = this.clients.get(id);
            return new ResponseEntity(client, HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Klant " + id + " bestaat niet.", HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/clients/{d}")
    public String update_client(@PathVariable("id") long id) {
        return "Klant " + id + " aangepast";
    }

    @PatchMapping("/clients/{id}")
    public String partial_update_client(@PathVariable("id") long id) {
        return "Klant " + id + " aangepast";
    }

    @DeleteMapping("/clients/{id}")
    public ResponseEntity delete_client(@PathVariable("id") long id) {
        if (this.clients.containsKey(id)) {
            this.clients.remove(id);
            return new ResponseEntity("Klant " + id + " verwijderd.", HttpStatus.OK);
        }
        else {
            return new ResponseEntity("Klant " + id + " bestaat niet.", HttpStatus.CONFLICT);
        }
    }
}


