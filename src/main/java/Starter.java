import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeoutException;
import org.openbaton.exceptions.MonitoringException;
import org.openbaton.plugin.PluginStarter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Created by rados on 12/17/2017. */
public class Starter {

  public static void main(String[] args)
      throws NoSuchMethodException, InterruptedException, IOException, InstantiationException,
          TimeoutException, IllegalAccessException, InvocationTargetException, MonitoringException {
    Logger log = LoggerFactory.getLogger(Starter.class);
    if (args.length == 4) {
        PluginStarter.registerPlugin(
                PrometheusMonitoringAgent.class,
                args[0],
                args[1],
                Integer.parseInt(args[2]),
                //          Integer.parseInt(args[3]));
                1);
    } else {
        PluginStarter.registerPlugin(PrometheusMonitoringAgent.class, "zabbix", "192.168.56.101",
                5672, 1);
    }

    
//    PrometheusMonitoringAgent prometheusMonitoringAgent = new PrometheusMonitoringAgent();
//    List<String> hosts = new ArrayList<>();
////    hosts.add("openbatoncompose_rabbitmq_broker_1");
////    hosts.add("openbatoncompose_nfvo_1");
//    hosts.add("localhost:9090");
//    List<String> metrics = new ArrayList<>();
////    metrics.add("up");
////    metrics.add("container_cpu_load_average_10s");
//    //        metrics.add("http_request_size_bytes_sum");
////    metrics.add("go_gc_duration_seconds");
//    metrics.add("http_requests_total");
//    log.info(prometheusMonitoringAgent.rangeQueryJob(hosts, metrics, "30").toString());
  }
}
