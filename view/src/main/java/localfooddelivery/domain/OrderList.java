package localfooddelivery.domain;

import javax.persistence.*;
import java.util.List;
import java.util.Date;
import lombok.Data;

@Entity
@Table(name="OrderList_table")
@Data
public class OrderList {

        @Id
        //@GeneratedValue(strategy=GenerationType.AUTO)
        private Long id;


}