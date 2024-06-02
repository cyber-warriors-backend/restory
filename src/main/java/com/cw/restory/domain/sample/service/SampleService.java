package com.cw.restory.domain.sample.service;

import com.cw.restory.web.sample.request.SampleAddRequest;
import com.cw.restory.web.sample.response.SampleAddResponse;

public interface SampleService {
    SampleAddResponse addData(SampleAddRequest sampleAddRequest);
}
