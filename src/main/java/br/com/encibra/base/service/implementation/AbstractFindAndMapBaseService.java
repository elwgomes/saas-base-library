package br.com.encibra.base.service.implementation;

import br.com.encibra.base.entity.BaseEntity;
import br.com.encibra.base.repository.BaseRepository;
import br.com.encibra.base.service.FindAndMapBaseService;
import br.com.encibra.base.shared.HttpException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public abstract class AbstractFindAndMapBaseService<E extends BaseEntity, D> extends AbstractFindBaseService<E>
        implements FindAndMapBaseService<E, D> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractFindAndMapAndFilterBaseService.class);

    public AbstractFindAndMapBaseService(BaseRepository<E> repository, HttpException exception) {
        super(repository, exception);
    }

    public Optional<D> findMapped(Long id) {
        log.info("BaseFindService.findMapped > Finding entity by id");
        var entity = this.find(id);
        return entity.map(this::toDTO);
    }

    public D findOrThrowMapped(Long id) {
        log.info("BaseFindService.findOrThrowMapped > Finding entity by id");
        var entity = this.findOrThrow(id);
        return this.toDTO(entity);
    }

    public List<D> findAllMapped() {
        log.info("BaseFindService.findAllMapped > Finding all entities");
        return this.findAll().stream().map(this::toDTO).toList();
    }

    public Page<D> findAllMapped(Pageable pageable) {
        log.info("BaseFindService.findAllMapped > Finding all entities paginated");
        return this.findAll(pageable).map(this::toDTO);
    }
}
