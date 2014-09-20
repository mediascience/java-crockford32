/**
 * Licensed to Media Science International (MSI) under one or more
 * contributor license agreements. See the NOTICE file distributed with this
 * work for additional information regarding copyright ownership. MSI
 * licenses this file to you under the Apache License, Version 2.0 (the
 * "License"); you may not use this file except in compliance with the
 * License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations
 * under the License.
 */
package fn.com.msiops.ground.crockford32;

import static org.junit.Assert.*;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.msiops.ground.crockford32.Crockford32;

@RunWith(Parameterized.class)
public class RoundTripTest {

    @Parameters(name = "for {0}")
    public static Collection<Object[]> cases() {

        final List<Object> explicit = Arrays.asList(
            // @formatter:off
            0, 1,  31,  32,  255,  256,  65535,  65536,  7,  17,  "2903901236319012626102349123123166472839712816",
              -1, -31, -32, -255, -256, -65535, -65536, -7, -17, "-2903901236319012626102349123123166472839712816"
           // @formatter:on
                );

        final Stream<BigInteger> sexp = explicit.stream().map(o -> {
            final BigInteger rval;
            if (o instanceof Number) {
                rval = BigInteger.valueOf(((Number) o).longValue());
            } else if (o instanceof String) {
                rval = new BigInteger((String) o);
            } else {
                throw new AssertionError("unrecognized explicit item => " + o);
            }
            return rval;
        });

        final Random rng = new Random();
        final Stream<BigInteger> random = Stream.generate(() -> {
            final int len = rng.nextInt(10) + 1;
            final byte[] raw = new byte[len];
            rng.nextBytes(raw);
            return new BigInteger(raw);
        }).limit(13);

        return Stream.concat(sexp, random).map(o -> {
            return new Object[] { o };
        }).collect(Collectors.toList());

    }

    private final BigInteger toTest;

    public RoundTripTest(final BigInteger toTest) {

        this.toTest = Objects.requireNonNull(toTest);

    }

    @Test
    public void testRoundTrip() {

        final String encoded = Crockford32.encode(this.toTest);
        final BigInteger actual = Crockford32.decode(encoded);

        assertEquals(this.toTest, actual);

    }

}
