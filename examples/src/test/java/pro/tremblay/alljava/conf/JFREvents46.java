package pro.tremblay.alljava.conf;

import jdk.jfr.Category;
import jdk.jfr.Configuration;
import jdk.jfr.Description;
import jdk.jfr.Event;
import jdk.jfr.Label;
import jdk.jfr.Name;
import jdk.jfr.consumer.EventStream;
import jdk.jfr.consumer.RecordingStream;
import jdk.management.jfr.RemoteRecordingStream;

import javax.management.MBeanServerConnection;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CompletableFuture;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class JFREvents46 {

  public static void main(String[] args) {
    Map<String, String> map = RandomGenerator.getDefault().ints(1_000_000)
      .distinct()
      .mapToObj(Integer::toString)
      .collect(Collectors.toUnmodifiableMap(Function.identity(), Function.identity()));

    List<String> in = new ArrayList<>();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      String key = Integer.toString(i);
      if (map.containsKey(key)) {
        MapHitEvent evt = new MapHitEvent();
        if (evt.isEnabled()) {
          evt.index = i;
          evt.commit();
        }
        in.add(map.get(key));
      }
    }
  }
}

@Name("demo.MapHit")
@Label("Map Hit")
@Category({"Demo", "Map"})
@Description("Emitted when the map contains the probed integer")
class MapHitEvent extends Event {
  @Label("Index")
  int index;
}

// PID=$(jcmd -l | grep JFREvents46 | cut -d' ' -f1)
// jcmd $PID JFR.start name=on_demand settings=profile
// jfr stream --pid $PID --events demo.MapHit
// jcmd $PID JFR.dump name=on_demand filename=app.jfr
// jfr summary app.jfr
// jfr print --events demo.MapHit app.jfr
