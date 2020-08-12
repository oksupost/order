
package local.external;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Date;
//Cloud에서 사용
//@FeignClient(name="delivery", url="http://delivery:8080")
//Local에서 사용
//@FeignClient(name="delivery", url="http://localhost:8082")
//동기 호출시 사용
@FeignClient(name="delivery", url="${api.url.delivery}")
public interface CancellationService {

    @RequestMapping(method= RequestMethod.POST, path="/cancellations")
    public void cancel(@RequestBody Cancellation cancellation);

}