package br.com.encibra.base.service.implementation;

import br.com.encibra.base.entity.BaseEntity;
import br.com.encibra.base.repository.BaseRepository;
import br.com.encibra.base.service.FindBaseService;
import br.com.encibra.base.shared.HttpException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
public abstract class AbstractFindBaseService<E extends BaseEntity> implements FindBaseService<E> {
    protected final BaseRepository<E> repository;

    protected final HttpException exception;

    public Optional<E> find(Long id) {
        log.info("BaseFindService.find > Finding entity by id");
        return repository.findById(id);
    }

    public E findOrThrow(Long id) {
        log.info("BaseFindService.findOrThrow > Finding entity by id");
        return this.find(id).orElseThrow(() -> exception);
    }

    public E findWithNullableOrThrow(@Nullable Long id) {
        log.info("BaseFindService.findWithNullableOrThrow > Finding entity by id");
        return Optional.ofNullable(id).map(this::findOrThrow).orElse(null);
    }

    public List<E> findAll() {
        log.info("BaseFindService.findAll > Finding all entities");
        return repository.findAll();
    }

    public Page<E> findAll(Pageable pageable) {
        log.info("BaseFindService.findAll > Finding all entities with filter paginated");
        return repository.findAll(pageable);
    }
}