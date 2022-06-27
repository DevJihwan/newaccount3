package newaccount.infra;

import newaccount.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(
    collectionResourceRel = "appliedResultRS",
    path = "appliedResultRS"
)
public interface AppliedResultRRepository
    extends PagingAndSortingRepository<AppliedResultR, Long> {
    List<AppliedResultR> findByCustNo(String custNo);
    List<AppliedResultR> findByCustNo(String custNo);
    List<AppliedResultR> findByCustNo(String custNo);
    // keep

}
