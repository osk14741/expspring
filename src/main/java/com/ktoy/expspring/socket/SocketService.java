package com.ktoy.expspring.socket;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class SocketService {

    private final SocketRepository socketRepository;

}
