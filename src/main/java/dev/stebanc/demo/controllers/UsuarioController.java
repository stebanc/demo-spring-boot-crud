package dev.stebanc.demo.controllers;

import java.util.ArrayList;

import javax.websocket.server.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.stebanc.demo.models.UsuarioEntity;
import dev.stebanc.demo.services.UsuarioService;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
  @Autowired
  UsuarioService usuarioService;

  @GetMapping()
  public ArrayList<UsuarioEntity> getAllUsuarios() {
    return usuarioService.getAllUsuarios();
  }

  @GetMapping(path = "/{id}")
  public UsuarioEntity getUsuarioById(@PathVariable("id") Long id) {
    return usuarioService.getUsuarioById(id);
  }

  @GetMapping("/query")
  public ArrayList<UsuarioEntity> getUsuariosByPrioridad(@RequestParam("prioridad") Integer prioridad) {
    return usuarioService.getUsuariosByPrioridad(prioridad);
  }

  @PutMapping(path = "/{id}")
  public UsuarioEntity updateUsuario(@PathVariable("id") Long id, @RequestBody UsuarioEntity usuario) {
    return usuarioService.updateUsuario(id, usuario);
  }

  @PostMapping()
  public UsuarioEntity createUsuario(@RequestBody UsuarioEntity usuario) {
    return usuarioService.createUsuario(usuario);
  }

  @DeleteMapping(path = "/{id}")
  public void deleteUsuario(@PathVariable("id") Long id) {
    usuarioService.deleteUsuario(id);
  }

}
