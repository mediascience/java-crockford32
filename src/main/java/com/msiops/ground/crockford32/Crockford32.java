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

import java.math.BigInteger;

/**
 * Base32 codec based on the <a
 * href="http://www.crockford.com/wrmg/base32.html">specification by Douglas
 * Crockford</a>. Encoded values are compact and resilient to transcription
 * errors.
 */
public interface Crockford32 {

    /**
     * Decode an encoded value.
     *
     * @param ev
     *            encoded value.
     *
     * @return decoded value.
     *
     * @throws NullPointerException
     *             if parameter is null.
     *
     * @throws RuntimeException
     *             if value cannot be decoded.
     *
     */
    static BigInteger decode(final String ev) {

        return Decoder.INSTANCE.decode(ev);

    }

    /**
     * Encode a value.
     *
     * @param v
     *            value to encode.
     *
     * @return encoded value
     *
     * @throws NullPointerException
     *             if parameter is null.
     */
    static String encode(final BigInteger v) {

        return Encoder.INSTANCE.encode(v).toString();

    }

    /**
     * Encode a value.
     *
     * @param v
     *            value to encode.
     *
     * @return encoded value
     *
     */
    static String encode(final long v) {

        return Encoder.INSTANCE.encode(BigInteger.valueOf(v)).toString();

    }

    /**
     * Encode a value.
     *
     * @param v
     *            value to encode. The value must be the string encoding of a
     *            base-10 integer of any precision.
     *
     * @return encoded value
     *
     * @throws NullPointerException
     *             if parameter is null
     *
     * @throws RuntimeException
     *             if the presented value does not represent an integer.
     */
    static String encode(final String v) {

        return Encoder.INSTANCE.encode(new BigInteger(v)).toString();

    }

}
