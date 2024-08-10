package tacos.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import tacos.TacoOrder;

import java.util.Date;
import java.util.List;

public interface OrderRepository extends CrudRepository<TacoOrder, Long> {

    List<TacoOrder> findByDeliveryZip(String deliveryZip);

    List<TacoOrder> readOrdersByDeliveryZipAndPlacedAtBetween(String deliveryZip, Date startDate, Date endDate);

    List<TacoOrder> findByDeliveryNameAndDeliveryCityAllIgnoreCase(String deliveryTo, String deliveryCity);

    List<TacoOrder> findByDeliveryCityOrderByDeliveryName(String city);

    //@Query("Order o where o.deliveryCity = 'Seattle'") // set nativeQuery = true to use regular SQL
    @Query(value = "select id from Taco_Order where delivery_City = 'Seatle';", nativeQuery = true)
    List<TacoOrder> readOrdersDeliveredInSeattle();

}
