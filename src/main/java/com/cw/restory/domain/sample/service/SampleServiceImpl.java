package com.cw.restory.domain.sample.service;

import com.cw.restory.domain.sample.entity.Sample;
import com.cw.restory.domain.sample.repository.SampleRepository;
import com.cw.restory.web.sample.request.SampleAddRequest;
import com.cw.restory.web.sample.response.SampleAddResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class SampleServiceImpl implements SampleService {

    private final SampleRepository sampleRepository;
    @Override
    public SampleAddResponse addData(SampleAddRequest sampleAddRequest) {
        Sample sample = Sample.builder()
                .a(sampleAddRequest.a())
                .b(sampleAddRequest.b())
                .build();

        sample.sum();
        sampleRepository.save(sample);

        return new SampleAddResponse(sample.getSum());
    }
}
