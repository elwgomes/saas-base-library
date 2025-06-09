package br.com.encibra.base.service.implementation;

import br.com.encibra.base.entity.BaseEntity;
import br.com.encibra.base.repository.BaseRepository;
import br.com.encibra.base.service.FindAndMapAndFilterBaseService;
import br.com.encibra.base.shared.HttpException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public abstract class AbstractFindAndMapAndFilterBaseService<E extends BaseEntity, D, F>
        extends AbstractFindAndMapBaseService<E, D> implements FindAndMapAndFilterBaseService<E, D, F> {

    private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(AbstractFindAndMapAndFilterBaseService.class);

    public AbstractFindAndMapAndFilterBaseService(BaseRepository<E> repository, HttpException exception) {
        super(repository, exception);
    }

    public List<E> findAll(F filter) {
        log.info("BaseFindService.findAll > Finding all entities with filter");
        var spec = this.getSpecificationFilter(filter);
        return repository.findAll(spec);
    }

    public Page<E> findAll(F filter, Pageable pageable) {
        log.info("BaseFindService.findAll > Finding all entities paginated");
        var spec = this.getSpecificationFilter(filter);
        return repository.findAll(spec, pageable);
    }

    public List<D> findAllMapped(F filter) {
        log.info("BaseFindService.findAllMapped > Finding all entities with filter");
        return this.findAll(filter).stream().map(this::toDTO).toList();
    }

    public Page<D> findAllMapped(F filter, Pageable pageable) {
        log.info("BaseFindService.findAllMapped > Finding all entities paginated with filter");
        return this.findAll(filter, pageable).map(this::toDTO);
    }

    public abstract Specification<E> getSpecificationFilter(F filter);
}