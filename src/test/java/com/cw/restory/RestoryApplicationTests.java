package com.cw.restory;

import org.junit.jupiter.api.Test;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import software.amazon.awssdk.auth.credentials.AwsBasicCredentials;
import software.amazon.awssdk.auth.credentials.StaticCredentialsProvider;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;

@SpringBootApplication
class RestoryApplicationTests {

	public S3Client haha() {
		String accessKey = "";
		String secretKey = "";
		String region = "";

		AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
		return S3Client.builder()
				.region(Region.of(region))
				.credentialsProvider(StaticCredentialsProvider.create(awsCreds))
				.build();
	}

	@Test
	void contextLoads() {
//
//		S3Client s3 = haha();
//
//		String bucketName = ""; // 버킷 이름 입력
//
//		// 객체 목록 요청
//		ListObjectsV2Request request = ListObjectsV2Request.builder()
//				.bucket(bucketName)
//				.build();
//
//		ListObjectsV2Response response = s3.listObjectsV2(request);
//
////		// 객체 키 출력 및 디코딩
////		response.contents().forEach(s3Object -> {
////			String encodedKey = s3Object.key();
////			try {
////				String decodedKey = URLDecoder.decode(encodedKey, "UTF-8"); // URL 디코딩
////				System.out.println(decodedKey); // 디코딩된 객체 키 출력
////			} catch (UnsupportedEncodingException e) {
////				e.printStackTrace();
////			}
////		});
////
////		// 객체 키 출력
////		response.contents().forEach(s3Object -> {
////			String key = s3Object.key();
////			System.out.println(key); // 객체 키 출력
////		});
//		System.out.println(URLEncoder.encode(Normalizer.normalize("토당문화플랫폼_1", Normalizer.Form.NFC), StandardCharsets.UTF_8));
//
//		response.contents().forEach(s3Object -> {
//			String objectKey = s3Object.key();
//			String encodedObjectKey = URLEncoder.encode(Normalizer.normalize(objectKey, Normalizer.Form.NFC), StandardCharsets.UTF_8);
//
//			objectKey = objectKey.replace("posts/", "");
//			encodedObjectKey = encodedObjectKey.replace("posts%2F", "");
//			if(!objectKey.equals(encodedObjectKey)){
//				System.out.println(objectKey);
//				System.out.println(encodedObjectKey);
//			}
//
//		});
//
//
//		// S3 클라이언트 종료
//		s3.close();
	}

}

