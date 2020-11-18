package cn.zzf.spring.cloud.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * @author GaoFeng
 * @date 2020/11/11 23:59
 */
@Accessors(chain = true)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserOrder {
    private Long id;
    private Long userId;
    private Long productId;
    private Integer quantity;
    private Integer money;
    private Byte state;
}
