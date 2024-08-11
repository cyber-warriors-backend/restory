package com.cw.restory.web.common.response;

import java.util.List;

public record CommonListResponse <T>(int count, List<T> data){}
