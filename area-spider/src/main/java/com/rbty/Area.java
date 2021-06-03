package com.rbty;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Objects;

/**
 * @author tuzhiyong
 * @version 1.0
 * @description: TODO
 * @date 2021/5/25 19:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    private Long code;
    private String name;
    private Integer level;
    private Long pcode;
    private String link;
}
