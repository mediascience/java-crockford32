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

import java.util.Arrays;
import java.util.Collection;
import java.util.Objects;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import com.msiops.ground.crockford32.Crockford32;

@RunWith(Parameterized.class)
public class EquivalenceTest {

    @Parameters(name = "{1} eqiv {0}")
    public static Collection<Object[]> cases() {

        // @formatter:off
        return Arrays.asList(

        // lower case
        new Object[] { "ABCDEFGHJKMNPQRSTVWXYZ",
                       "abcdefghjkmnpqrstvwxyz" },

        // human-friendly characters
        new Object[] { "110110",
                       "iloILO" },

        // everything at once
        new Object[] { "11123456789000AABBCCDDEEFFGGHHJJKKMMNNPPQQRRSSTTVVWWXXYYZZ",
                       "1lL234567890oOAaBbCcDdEeFfGgHhJjKkMmNnPpQqRrSsTtVvWwXxYyZz" }

        );
        // @formatter:on

    }

    private final String expected, actual;

    public EquivalenceTest(final String expected, final String actual) {

        this.expected = Objects.requireNonNull(expected);
        this.actual = Objects.requireNonNull(actual);

    }

    @Test
    public void testEquivalent() {

        assertEquals(Crockford32.decode(this.expected),
                Crockford32.decode(this.actual));

    }

}
