import java.util.Arrays;

import jdk.incubator.vector.VectorSpecies;
import jdk.incubator.vector.FloatVector;

public class Vector22 {

  private static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;

  private static void vectorComputation(float[] a, float[] b, float[] c) {

    for (int i = 0; i < a.length; i += SPECIES.length()) {
      var m = SPECIES.indexInRange(i, a.length);
      // FloatVector va, vb, vc;
      var va = FloatVector.fromArray(SPECIES, a, i, m);
      var vb = FloatVector.fromArray(SPECIES, b, i, m);
      var vc = va.mul(va).
        add(vb.mul(vb)).
        neg();
      vc.intoArray(c, i, m);
    }
  }

  public static void main(String[] args) {
    float[] a = { 1, 2, 3};
    float[] b = { 4, 5, 6};
    float[] c = { 0, 0, 0};
    vectorComputation(a, b, c);
    System.out.println(Arrays.toString(c));
  }
}

// java --add-modules jdk.incubator.vector Vector22.java
