package com.cw.restory;

import com.cw.restory.domain.post.repository.PostImageRepository;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
public class AppRunnerTest implements ApplicationRunner {
    private final Environment environment;
    private final PostImageRepository postImageRepository;

    public AppRunnerTest(Environment environment, PostImageRepository postImageRepository) {
        this.environment = environment;
        this.postImageRepository = postImageRepository;
    }


    @Override
    public void run(ApplicationArguments args) {
        System.out.println("===================프로파일 테스트===================");
        System.out.println("Active profiles : "+ Arrays.toString(environment.getActiveProfiles()));
        System.out.println("Datasource driver : " + environment.getProperty("spring.datasource.driver-class-name"));
        System.out.println("Datasource url : " + environment.getProperty("spring.datasource.url"));
        System.out.println("Datasource username : " + environment.getProperty("spring.datasource.username"));
        System.out.println("Server Port : " + environment.getProperty("server.port"));
        System.out.println("Server url : " + environment.getProperty("server.url"));
        System.out.println("Default Property : " + environment.getProperty("default.string"));
        System.out.println("Common Property : " + environment.getProperty("common.string"));
        System.out.println("====================================================");


        //S3Client s3 = haha();

        String bucketName = ""; // 버킷 이름 입력

        // 객체 목록 요청
//        ListObjectsV2Request request = ListObjectsV2Request.builder()
//                .bucket(bucketName)
//                .build();
//
//        ListObjectsV2Response response = s3.listObjectsV2(request);

//		// 객체 키 출력 및 디코딩
//		response.contents().forEach(s3Object -> {
//			String encodedKey = s3Object.key();
//			try {
//				String decodedKey = URLDecoder.decode(encodedKey, "UTF-8"); // URL 디코딩
//				System.out.println(decodedKey); // 디코딩된 객체 키 출력
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		});
//
//		// 객체 키 출력
//		response.contents().forEach(s3Object -> {
//			String key = s3Object.key();
//			System.out.println(key); // 객체 키 출력
//		});
//        response.contents().forEach(s3Object -> {
//            String objectKey = s3Object.key();
//            String encodedObjectKey = URLEncoder.encode(objectKey, StandardCharsets.UTF_8);
//
//            String a = Normalizer.normalize(objectKey.replace("posts/", ""), Normalizer.Form.NFC);
//            String b = Normalizer.normalize(encodedObjectKey.replace("posts%2F", ""), Normalizer.Form.NFC);
//
//            if(!a .equals(b)){
//
//                Optional<PostImage> byImageUrl = postImageRepository.findByImageUrl(a);
//
//                byImageUrl.ifPresent(postImage -> {
//                    postImage.updateDescription(b);
//                    postImageRepository.save(postImage);
//                });
//
//                System.out.println(a);
//                System.out.println(b);
//            }
//
//        });


        // S3 클라이언트 종료
        //s3.close();
    }
//    public S3Client haha() {
//        String accessKey = "";
//        String secretKey = "";
//        String region = "";
//
//        AwsBasicCredentials awsCreds = AwsBasicCredentials.create(accessKey, secretKey);
//        return S3Client.builder()
//                .region(Region.of(region))
//                .credentialsProvider(StaticCredentialsProvider.create(awsCreds))
//                .build();
//    }
// asdf
}
