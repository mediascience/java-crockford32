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

public class ApiTest {

    @Test
    public void testLongInput() {

        assertEquals(Crockford32.encode(BigInteger.valueOf(123456L)),
                Crockford32.encode(123456L));

    }

    @Test
    public void testNegativeLongInput() {

        assertEquals(Crockford32.encode(BigInteger.valueOf(-123456L)),
                Crockford32.encode(-123456L));

    }

    @Test
    public void testNegativeStringInput() {

        assertEquals(Crockford32.encode("-123456"),
                Crockford32.encode(-123456L));

    }

    @Test
    public void testStringInput() {

        assertEquals(Crockford32.encode("123456"), Crockford32.encode(123456L));

    }

}
