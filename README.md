Crockford Base32 for Java
=========================

Base32 encoding using alphabet and character equivalence
as specified by Douglas Crockford.

## Usage

### Maven

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



