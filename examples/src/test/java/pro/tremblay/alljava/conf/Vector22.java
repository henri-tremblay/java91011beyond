/*
 * Copyright 2018-2021 Henri Tremblay.
 */
package pro.tremblay.alljava.conf;

import jdk.incubator.vector.FloatVector;
import jdk.incubator.vector.VectorSpecies;
import org.junit.Test;

import java.util.Arrays;

public class Vector22 {

  static final VectorSpecies<Float> SPECIES = FloatVector.SPECIES_256;

  @Test
  public void test() {
    float[] a = {1, 2, 3};
    float[] b = {1, 2, 3};
    float[] c = new float[3];

    vectorComputation(a, b, c);

    System.out.println(Arrays.toString(c));
  }

  void vectorComputation(float[] a, float[] b, float[] c) {

    for (int i = 0; i < a.length; i += SPECIES.length()) {
      var m = SPECIES.indexInRange(i, a.length);
      // FloatVector va, vb, vc;
      var va = FloatVector.fromArray(SPECIES, a, i, m);
      var vb = FloatVector.fromArray(SPECIES, b, i, m);
      var vc = va.mul(va) // 1*1, 2*2, 3*3 = 1, 4, 9
        .add(vb.mul(vb)) // 1*1, 2*2, 3*3 = 1, 4, 9 => 1+1, 4+4, 9+9 = 2, 8, 18
        .neg(); // -2, -8, -18

      vc.intoArray(c, i, m);
    }
  }
}

// show the incubator module
// add --add-modules=jdk.incubator.vector to runtime
