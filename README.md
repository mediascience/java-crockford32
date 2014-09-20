Crockford Base32 for Java
=========================

Base32 encoding using alphabet and character equivalence
as specified by Douglas Crockford.

## Usage

### Include Dependencies

(Maven Central deployment pending)


### Codec
```java
BigInteger v = BigInteger.valueOf(123456);

String encoded = Crockford32.encode(v);
assert encoded.equals("3RJ0");

BigInteger recovered = Crockford.decode(encoded);
assert recovered.equals(v);

BigInteger recoveredAgain = Crockford.decode("3rjo");
assert recoveredAgain.equals(v);
```

## Versioning

Releases in the 0.x series are the Wild West. Anything can change between
releases--package names, method signatures, behavior, whatever. But if you
like it as it is right now, all the tests pass so just use it at its current
version and have fun.

The next version series will be 1.x. Every release in that series will be
backward compatible with every lower-numbered release in the same series
except possibly in the case of 1) a bug fix or 2) a correction to an
underspecification.

An incompatible change to the interface, behavior, license, or anything else
after the 1.x series is published will result in a new series, such as
2.x.

## Acknowledgements

This work implements the codec described by Douglas Crockford at
[http://www.crockford.com/wrmg/base32.html]. Mr. Crockford's lectures
and books on Javascript are highly entertaining and informative. Oh
yeah--and he invented JSON.

Thanks to Media Science International for its support of FOSS.

## License

Licensed to Media Science International (MSI) under one or more
contributor license agreements. See the NOTICE file distributed with this
work for additional information regarding copyright ownership. MSI
licenses this file to you under the Apache License, Version 2.0 (the
"License"); you may not use this file except in compliance with the
License. You may obtain a copy of the License at

http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
License for the specific language governing permissions and limitations
under the License.


