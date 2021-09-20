package com.nxbeyxnd.site.models.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
public class SocialCounterDto {
    List<String> counter = new ArrayList<>();

    public SocialCounterDto(List<String> counter) {
        this.counter = counter;
    }
}
