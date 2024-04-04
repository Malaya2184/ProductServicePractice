package com.spider.productservicepractice.dtos;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class FakeStoreCrateProductDto {
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;
}
