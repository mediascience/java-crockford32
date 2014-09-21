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
package com.msiops.ground.crockford32;

import static com.msiops.ground.crockford32.Constants.*;

import java.math.BigInteger;
import java.util.stream.IntStream;

/**
 * Encoder implementation.
 */
final class Encoder {

    public static final Encoder INSTANCE = new Encoder();

    private final char[] lookup = ALPHABET.toCharArray();

    /**
     * We create the only instance.
     */
    private Encoder() {
    }

    public StringBuilder encode(final BigInteger v) {
        return encode(v, new StringBuilder());
    }

    public StringBuilder encode(final BigInteger v, final StringBuilder accum) {

        final String rvs = v.toString(RADIX);
        final boolean neg = v.signum() < 0;

        final CharSequence vs = neg ? rvs.subSequence(1, rvs.length()) : rvs;

        final IntStream digits = vs.codePoints()
                .map(c -> Character.digit(c, RADIX)).map(i -> this.lookup[i]);

        return IntStream.concat(neg ? IntStream.of('-') : IntStream.empty(),
                digits).collect(() -> accum, StringBuilder::appendCodePoint,
                StringBuilder::append);

    }

}
