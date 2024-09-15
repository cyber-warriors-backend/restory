package com.cw.restory.service.information;


import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.information.response.InformationResponse;

public interface InformationService {
    public CommonListResponse<InformationResponse> getAllInformation();

    public InformationResponse getOneInformation(Long id);
}
