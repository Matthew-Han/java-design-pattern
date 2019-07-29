package xyz.yuanmo.model;

import lombok.*;

/**
 * @ClassName Basketball
 * @Description TODO
 * @Author MatthewHan
 * @Date 2019/7/25 16:00
 * @Version 1.0
 **/
@ToString
@Setter(value = AccessLevel.PUBLIC)
@Getter(value = AccessLevel.PUBLIC)
@AllArgsConstructor
@NoArgsConstructor
public class Basketball {

    private String color;
    private String size;
    private Double price;
}
