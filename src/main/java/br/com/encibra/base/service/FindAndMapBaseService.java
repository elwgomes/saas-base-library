package br.com.encibra.base.service;

import br.com.encibra.base.entity.BaseEntity;
import br.com.encibra.base.shared.HttpException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

/**
 * Interface base para serviços que realizam busca e mapeamento de entidades para DTOs.
 *
 * @param <E> Tipo da entidade que estende BaseEntity
 * @param <D> Tipo do DTO (Data Transfer Object)
 */
public interface FindAndMapBaseService<E extends BaseEntity, D> extends FindBaseService<E> {
    /**
     * Busca uma entidade pelo ID e converte para DTO.
     *
     * @param id ID da entidade a ser buscada
     * @return Optional contendo o DTO se encontrado, ou vazio se não encontrado
     */
    Optional<D> findMapped(Long id);

    /**
     * Busca uma entidade pelo ID, converte para DTO e lança exceção se não encontrada.
     *
     * @param id ID da entidade a ser buscada
     * @return DTO da entidade encontrada
     * @throws HttpException se a entidade não for encontrada
     */
    D findOrThrowMapped(Long id);

    /**
     * Busca todas as entidades e converte para DTOs.
     *
     * @return Lista de DTOs das entidades encontradas
     */
    List<D> findAllMapped();

    /**
     * Busca todas as entidades com paginação e converte para DTOs.
     *
     * @param pageable Configuração de paginação
     * @return Página contendo os DTOs das entidades encontradas
     */
    Page<D> findAllMapped(Pageable pageable);

    /**
     * Converte uma entidade para seu respectivo DTO.
     *
     * @param entity Entidade a ser convertida
     * @return DTO resultante da conversão
     */
    D toDTO(E entity);
}
