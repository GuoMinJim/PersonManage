package cn.pzhu.pserson.util;

import org.jose4j.jwk.RsaJsonWebKey;
import org.jose4j.jwk.RsaJwkGenerator;
import org.jose4j.jws.AlgorithmIdentifiers;
import org.jose4j.jws.JsonWebSignature;
import org.jose4j.jwt.JwtClaims;
import org.jose4j.jwt.consumer.InvalidJwtException;
import org.jose4j.jwt.consumer.JwtConsumer;
import org.jose4j.jwt.consumer.JwtConsumerBuilder;
import org.jose4j.lang.JoseException;

public class TokenUtils {

  private static RsaJsonWebKey rsaJsonWebKey;

  // 生成密钥
  static {
    try {
      rsaJsonWebKey = RsaJwkGenerator.generateJwk(2048);
    } catch (JoseException e) {
      e.printStackTrace();
    }
  }

  /**
   * @param issuer 发行者
   * @param audience 接收者
   * @param exprationTime 接受时间
   * @param notBeforeMinutesInThePast 过去有效时间
   */
  public static String create(String keyID, String issuer, String audience, String subject,
      int exprationTime, int notBeforeMinutesInThePast) throws JoseException {

    // key
    rsaJsonWebKey.setKeyId(keyID);

    //
    JwtClaims claims = new JwtClaims();
    claims.setIssuer(issuer);
    claims.setAudience(audience);
    // 过期时间设置为30分钟
    claims.setExpirationTimeMinutesInTheFuture(30);

    claims.setGeneratedJwtId();
    claims.setIssuedAtToNow();

    claims.setSubject(subject);
    claims.setNotBeforeMinutesInThePast(notBeforeMinutesInThePast);

    JsonWebSignature jws = new JsonWebSignature();
    jws.setPayload(claims.toJson());
    jws.setKey(rsaJsonWebKey.getPrivateKey());
    jws.setKeyIdHeaderValue(rsaJsonWebKey.getKeyId());
    jws.setAlgorithmHeaderValue(AlgorithmIdentifiers.RSA_USING_SHA256);

    String jwt = jws.getCompactSerialization();
    return jwt;
  }

  /**
   *
   * @param token
   * @param issuer
   * @param audience
   * @param subject
   * @return
   * @throws InvalidJwtException
   */
  public static boolean valid(String token, String issuer, String audience, String subject)
      throws InvalidJwtException {
    JwtConsumer jwtConsumer = new JwtConsumerBuilder()
        .setRequireExpirationTime() // 必须有过期时间
        .setMaxFutureValidityInMinutes(60) // but the  expiration time can't be too crazy
        .setAllowedClockSkewInSeconds(
            30) // allow some leeway in validating time based claims to account for clock skew
        .setExpectedIssuer(issuer) // whom the JWT needs to have been issued by
        .setExpectedAudience(audience) // to whom the JWT is intended for
        .setRequireSubject()
        .setRequireNotBefore()
        .setExpectedSubject(subject)
        .setVerificationKey(rsaJsonWebKey.getKey()) // verify the signature with the public key
        .build(); // create the JwtConsumer instance
    JwtClaims jwtClaims = jwtConsumer.processToClaims(token);
    return true;

  }



  public static void main(String[] args) {
    String s = null;
    try {
      s = create("123", "jgm", "mgj", "iloveu", 20, 20);
    } catch (JoseException e) {
      e.printStackTrace();
    }
    System.out.println(s);
  }
}
