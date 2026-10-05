package com.Carrental.car.SErvice;

import jakarta.transaction.Transactional;

import java.util.UUID;

public interface AcountService {
    @Transactional
    public Void Transfer(UUID fromid,UUID toid,Double amount);

}
