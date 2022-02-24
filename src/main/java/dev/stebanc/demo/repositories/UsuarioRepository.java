package dev.stebanc.demo.repositories;

import java.util.ArrayList;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import dev.stebanc.demo.models.UsuarioEntity;

@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {
  public abstract ArrayList<UsuarioEntity> findByPrioridad(Integer prioridad);
}

