package com.cw.restory.service.sample;

import com.cw.restory.web.sample.request.SampleAddRequest;
import com.cw.restory.web.sample.response.SampleAddResponse;

public interface SampleService {
    SampleAddResponse addData(SampleAddRequest sampleAddRequest);
}
