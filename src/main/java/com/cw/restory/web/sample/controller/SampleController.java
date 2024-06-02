package com.cw.restory.web.sample.controller;

import com.cw.restory.domain.sample.service.SampleService;
import com.cw.restory.web.sample.request.SampleAddRequest;
import com.cw.restory.web.sample.response.SampleAddResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/sample")
public class SampleController {

    private final SampleService sampleService;

    @GetMapping("/add")
    public SampleAddResponse addData(SampleAddRequest request) {
        return sampleService.addData(request);
    }

//    @PostMapping("/test")
//    public void test(@RequestBody @Validated TestRequest request){
//        testService.test(request);
//    }
}
