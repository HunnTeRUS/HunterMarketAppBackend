package com.hunter.cursomc.repositories;

import com.hunter.cursomc.domain.ItemPedido;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItensPedidoRepository extends JpaRepository<ItemPedido, Integer> {
}
