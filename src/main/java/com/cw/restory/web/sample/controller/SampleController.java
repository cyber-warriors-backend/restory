package com.cw.restory.web.sample.controller;

import com.cw.restory.domain.sample.service.SampleService;
import com.cw.restory.web.sample.request.SampleAddRequest;
import com.cw.restory.web.sample.response.SampleAddResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Tag(name = "샘플 API", description = "샘플 API 입니다.")
@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    @Operation(summary = "더하기", description = "받은 값을 더합니다.")
    @PostMapping("/add")
    public SampleAddResponse addData(@RequestBody @Validated SampleAddRequest request) {
        return sampleService.addData(request);
    }

//    @PostMapping("/test")
//    public void test(@RequestBody @Validated TestRequest request){
//        testService.test(request);
//    }
}
