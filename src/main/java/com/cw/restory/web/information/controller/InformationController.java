package com.cw.restory.web.information.controller;



import com.cw.restory.service.information.InformationService;
import com.cw.restory.web.common.response.CommonListResponse;
import com.cw.restory.web.information.response.InformationResponse;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "공지사항 API")
@RestController
@RequiredArgsConstructor
@RequestMapping("/informations")
public class InformationController {

    private final InformationService informationService;

    @Operation(summary = "공지사항 목록 조회", description = "모든 공지사항을 조회합니다.")
    @GetMapping
    public ResponseEntity<CommonListResponse<InformationResponse>> getAllInformation() {
        return ResponseEntity.ok().body(informationService.getAllInformation());
    }

    @Operation(summary = "공지사항 상세 조회", description = "공지사항 키값(ID)으로 공지사항 1개를 조회합니다.")
    @GetMapping("/{id}")
    public ResponseEntity<InformationResponse> getOneInformation(@PathVariable Long id) {
        return ResponseEntity.ok().body(informationService.getOneInformation(id));
    }

}
