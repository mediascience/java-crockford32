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
import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Decoder implementation.
 */
final class Decoder {

    public static final Decoder INSTANCE = new Decoder();

    private final char[] lookup;

    {
        final Stream<CodeMap> smalpha = IntStream
                .range(0, RADIX)
                .boxed()
                .flatMap(
                        i -> {
                            final CodeMap l = new CodeMap(Character
                                    .toLowerCase(ALPHABET.charAt(i)), Character
                                    .forDigit(i, RADIX));
                            final CodeMap u = new CodeMap(Character
                                    .toUpperCase(ALPHABET.charAt(i)), Character
                                    .forDigit(i, RADIX));
                            return Stream.of(l, u);
                        });

        this.lookup = new char['z' + 1];
        Arrays.fill(this.lookup, (char) -1);
        Stream.concat(smalpha, EQUIVALENTS.stream()).forEach(m -> {
            this.lookup[m.encodedDigit] = m.javaDigit;
        });
    }

    public BigInteger decode(final CharSequence ev) {

        final boolean neg = ev.length() > 0 && ev.charAt(0) == '-';

        final IntStream jdigits = ev.chars().skip(neg ? 1 : 0)
                .map(c -> this.lookup[c]);

        final String jev = IntStream
                .concat(neg ? IntStream.of('-') : IntStream.empty(), jdigits)
                .collect(StringBuilder::new, StringBuilder::appendCodePoint,
                        StringBuilder::append).toString();

        return new BigInteger(jev, RADIX);

    }

}
