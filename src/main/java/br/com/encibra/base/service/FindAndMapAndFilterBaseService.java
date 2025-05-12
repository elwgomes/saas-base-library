package br.com.encibra.base.service;

import br.com.encibra.base.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Interface base para serviços que realizam busca, mapeamento e filtragem de entidades.
 *
 * @param <E> Tipo da entidade
 * @param <D> Tipo do DTO
 * @param <F> Tipo do filtro
 */
public interface FindAndMapAndFilterBaseService<E extends BaseEntity, D, F> extends FindAndMapBaseService<E, D> {
    /**
     * Busca todas as entidades com filtro.
     *
     * @param filter Filtro a ser aplicado
     * @return Lista de entidades encontradas
     */
    List<E> findAll(F filter);

    /**
     * Busca todas as entidades com filtro e paginação.
     *
     * @param filter   Filtro a ser aplicado
     * @param pageable Configuração de paginação
     * @return Página de entidades encontradas
     */
    Page<E> findAll(F filter, Pageable pageable);

    /**
     * Busca todas as entidades com filtro e converte para DTO.
     *
     * @param filter Filtro a ser aplicado
     * @return Lista de DTOs
     */
    List<D> findAllMapped(F filter);

    /**
     * Busca todas as entidades com filtro e paginação e converte para DTO.
     *
     * @param filter   Filtro a ser aplicado
     * @param pageable Configuração de paginação
     * @return Página de DTOs
     */
    Page<D> findAllMapped(F filter, Pageable pageable);
}
