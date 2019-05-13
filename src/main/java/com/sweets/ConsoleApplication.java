package com.sweets;

import com.sweets.entity.Sweet;
import com.sweets.repositoty.SweetRepo;
import com.sweets.service.SweetsService;

public class ConsoleApplication {

    public static void main(String[] args) throws Exception {

        Sweet sweet=Sweet.builder()
                .setName("new_sweet")
                .setSweetFilling("some_filling")
                .setFillingWeight(6000L)
                .setSweetWrapper("some_wrapper")
                .setWrapperWeight(6000L)
                .build();

        System.out.println(sweet);
        SweetRepo sweetRepo=new SweetRepo();
        SweetsService sweetsService=new SweetsService(sweetRepo);
        sweetsService.findAll();
        sweetsService.findEntityById(1L);
        sweetsService.addSweet(sweet);

    }
}
