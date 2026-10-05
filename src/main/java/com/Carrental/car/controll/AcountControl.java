package com.Carrental.car.controll;


import com.Carrental.car.SErvice.AcountService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping("/Payment")
public class AcountControl {

    private  final AcountService acountService;

    public AcountControl(AcountService acountService) {
        this.acountService = acountService;
    }

    @GetMapping("/amount/{fromid}/{toid}/{amount}")
    public Void transferPayment(@PathVariable UUID fromid,
                                @PathVariable UUID toid,
                                @PathVariable Double amount)
    {
        return acountService.Transfer(fromid,toid,amount);
    }
}
