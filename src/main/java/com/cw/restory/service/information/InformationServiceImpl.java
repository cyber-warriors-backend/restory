package com.cw.restory.service.information;

import com.cw.restory.domain.information.entity.Information;
import com.cw.restory.domain.information.repository.InformationRepository;
import com.cw.restory.exception.custom.InformationNotFound;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.information.response.InformationResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class InformationServiceImpl implements InformationService {

    private final InformationRepository informationRepository;

    @Override
    public CommonListResponse<InformationResponse> getAllInformation() {
        List<InformationResponse> informationResponses = informationRepository.findAll()
                .stream().map(i -> InformationResponse.builder()
                        .information(i)
                        .build())
                .toList();

        return new CommonListResponse<InformationResponse>(informationResponses.size(), informationResponses);

    }

    @Override
    public InformationResponse getOneInformation(Long id) {
        Information information = informationRepository.findById(id)
                .orElseThrow(InformationNotFound::new);

        return InformationResponse.builder().information(information).build();
    }
}
