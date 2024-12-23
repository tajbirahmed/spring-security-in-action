Spring Security Crypto Module(SSCM)
-----
- Part of the Spring Security that deals with cryptography. 

Two features 
- *Key Generator* -- Objects used to generate keys for hashing and encryption algorithm.
- *Encrptors* -- Objects used to encrypt or decrypt data.

## Key Generators 

two main types of key generators 
 1. BytesKeyGenerator 
 2. StringKeyGenerator

factory class for above two is `KeyGenerators`

### StringKeyGenerator

>Definition

```java
public interface StringKeyGenerator {
    String generateKey();
}
```
>Usage

```java
StringKeyGenerator keyGenerator = KeyGenerators.string();
String salt = keyGenerator.generateKeY();
```

### BytesKeyGenerator
>Definition
```java
public interface BytesKeyGenerator { 
    int getKeyLength(); 
    byte[] generateKey(); 
}
```
>Usage 
```java
BytesKeyGenerator keyGenerator = KeyGenerators.secureRandom();  
byte [] key = keyGenerator.generateKey(); 
int keyLength = keyGenerator.getKeyLength();
```
to generate keys of specific length, 
```java
BytesKeyGenerator keyGenerator = KeyGenerators.secureRandom(int keyLength);
```
to return same key for each call to the generator

```java
BytesKeyGenerator keyGenerator = KeyGenerators.shared(int keyLength);
```

## Encryptors 
two main types of Encryptors 
1. TextEncryptor 
2. BytesEncryptor

### TextEncryptor
> Definition
```java
public interface TextEncryptor { 
    String encrypt(String text); 
    String decrypt(String encryptedText); 
}
```
### BytesEncryptor 
```java
public interface BytesEncryptor { 
    byte[] encrypt(byte[] byteArray); 
    byte[] decrypt(byte[] encryptedByteArray); 
}
```