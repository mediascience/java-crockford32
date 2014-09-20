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

import org.junit.Test;

import com.msiops.ground.crockford32.Crockford32;

/**
 * Test values are encoded as expected. We accept the round trip tests as
 * evidence of correct decoding given that these tests pass.
 */
public class EncodeTest {

    private static String encode(final long v) {
        return Crockford32.encode(BigInteger.valueOf(v));
    }

    private static String encode(final String dev) {
        return Crockford32.encode(new BigInteger(dev));
    }

    @Test
    public void testAllDigits() {

        assertEquals("1234567890ABCDEFGHJKMNPQRSTVWXYZ",
                encode("48666027465740248334042279998573767950272985055"));

    }

    @Test
    public void testEncode123456() {

        assertEquals("3RJ0", encode(123456));

    }

    @Test
    public void testEncodeNeg123456() {

        assertEquals("-3RJ0", encode(-123456));

    }

    @Test
    public void testEncodeZero() {

        assertEquals("0", encode(0));

    }

    @Test
    public void testNegAllDigits() {

        assertEquals("-1234567890ABCDEFGHJKMNPQRSTVWXYZ",
                encode("-48666027465740248334042279998573767950272985055"));

    }
}
