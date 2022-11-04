package localfooddelivery.infra;

import localfooddelivery.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import java.util.List;

@RepositoryRestResource(collectionResourceRel="orderLists", path="orderLists")
public interface OrderListRepository extends PagingAndSortingRepository<OrderList, Long> {

    

    
}
