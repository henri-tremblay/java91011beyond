/*
 * Copyright 2018-2026 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.random.RandomGenerator;
import java.util.stream.Collectors;

public class JFR45 {

  public static void main(String[] args) {
    Map<String, String> map = RandomGenerator.getDefault().ints(1_000_000)
      .distinct()
      .mapToObj(Integer::toString)
      .collect(Collectors.toUnmodifiableMap(Function.identity(), Function.identity()));

    List<String> in = new ArrayList<>();
    for (int i = 0; i < Integer.MAX_VALUE; i++) {
      if (map.containsKey("" + i)) {
        in.add(map.get("" + i));
      }
    }
  }
}

// java -XX:StartFlightRecording=filename=app.jfr,settings=profile,dumponexit=true -jar your-app.jar

// PID=$(jcmd -l | grep JFR45 | cut -d' ' -f1)
// jcmd $PID JFR.start name=on_demand settings=profile jdk.ExecutionSample#period=1ms jdk.NativeMethodSample#period=1ms
// jcmd $PID JFR.check
// jcmd $PID JFR.dump name=on_demand filename=app.jfr
// jcmd $PID JFR.stop name=on_demand
// jfr summary app.jfr
// jfr print --events CPULoad,JavaErrorThrow app.jfr

// jcmd $PID JFR.start name=on_demand settings=profile jdk.MethodTrace#filter=java.lang.Integer::toString
// jcmd $PID JFR.dump name=on_demand filename=app.jfr
// jfr view --cell-height 5 MethodTrace app.jfr
// -XX:StartFlightRecording:method-timing=::<clinit>

// CPU-time profiling: java -XX:StartFlightRecording=jdk.CPUTimeSample#enabled=true,filename=profile.jfr -cp examples/target/test-classes pro.tremblay.alljava.conf.JFR45
// Lower sampling: java -XX:StartFlightRecording=jdk.ExecutionSample#period=10ms,jdk.NativeMethodSample#period=10ms,jdk.CPUTimeSample#period=10msfilename=profile.jfr -cp examples/target/test-classes pro.tremblay.alljava.conf.JFR45
