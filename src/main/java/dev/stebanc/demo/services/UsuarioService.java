package dev.stebanc.demo.services;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.stebanc.demo.models.UsuarioEntity;
import dev.stebanc.demo.repositories.UsuarioRepository;

@Service
public class UsuarioService {
  @Autowired
  UsuarioRepository usuarioRepository;

  public ArrayList<UsuarioEntity> getAllUsuarios() {
    return (ArrayList<UsuarioEntity>) usuarioRepository.findAll();
  }

  public UsuarioEntity getUsuarioById(Long id) {
    return usuarioRepository.findById(id).orElse(null);
  }

  public UsuarioEntity createUsuario(UsuarioEntity usuario) {
    return usuarioRepository.save(usuario);
  }

  public UsuarioEntity updateUsuario(Long id, UsuarioEntity usuario) {
    UsuarioEntity usuarioActual = usuarioRepository.findById(id).orElse(null);
    if (usuarioActual != null) {
      usuarioActual.setNombre(usuario.getNombre());
      usuarioActual.setApellido(usuario.getApellido());
      usuarioActual.setEmail(usuario.getEmail());
      usuarioActual.setPrioridad(usuario.getPrioridad());
      return usuarioRepository.save(usuarioActual);
    } else {
      return null;
    }
  }

  public void deleteUsuario(Long id) {
    usuarioRepository.deleteById(id);
  }

  public ArrayList<UsuarioEntity> getUsuariosByPrioridad(Integer prioridad) {
    return (ArrayList<UsuarioEntity>) usuarioRepository.findByPrioridad(prioridad);
  }

}
