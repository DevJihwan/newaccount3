package newaccount.domain;

import newaccount.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "preApplicationAS",
    path = "preApplicationAS"
)
public interface PreApplicationARepository
    extends PagingAndSortingRepository<PreApplicationA, Long> {}
