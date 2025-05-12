package br.com.encibra.base.service;

import br.com.encibra.base.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.jetbrains.annotations.Nullable;
import java.util.List;
import java.util.Optional;

public interface FindBaseService<E extends BaseEntity> {
    /**
     * Busca entidade pelo ID.
     *
     * @param id Id da entidade
     * @return Entidade encontrada como Optional
     */
    Optional<E> find(Long id);

    /**
     * Busca entidade pelo ID e:<br/>
     * - Se ID for não nulo e não encontrar a entidade lança exceção;<br/>
     * - Se ID for não nulo e encontrar a entidade retorna a entidade.
     *
     * @param id Id da entidade
     * @return Entidade encontrada
     * @throws HttpException Exceção de entidade não encontrada
     */
    E findOrThrow(Long id);

    /**
     * Busca entidade pelo ID e:<br/>
     * - Se ID for nulo retorna nulo;<br/>
     * - Se ID for não nulo e não encontrar a entidade lança exceção;<br/>
     * - Se ID for não nulo e encontrar a entidade retorna a entidade.
     *
     * @param id Id da entidade
     * @return Entidade encontrada
     * @throws HttpException Exceção de entidade não encontrada
     */
    E findWithNullableOrThrow(@Nullable Long id);

    /**
     * Busca todas as entidades.
     *
     * @return Lista de entidades
     */
    List<E> findAll();

    /**
     * Busca todas as entidades com filtro paginado.
     *
     * @param pageable Filtro paginado
     * @return Página de entidades
     */
    Page<E> findAll(Pageable pageable);
}