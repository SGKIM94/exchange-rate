package com.woowahan.currency.service;

import com.woowahan.currency.dto.ClientResponseDto;

public interface ApiClient {
    ClientResponseDto retrieve(String url);
}
