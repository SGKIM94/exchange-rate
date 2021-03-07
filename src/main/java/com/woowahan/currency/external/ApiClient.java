package com.woowahan.currency.external;

import com.woowahan.currency.dto.ClientResponseDto;

public interface ApiClient {
    ClientResponseDto retrieve(String url);
}
