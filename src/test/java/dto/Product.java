package dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@Builder
@NoArgsConstructor
public class Product {
    @Builder.Default
    private String productName = "Sauce Labs Backpack";
    private String productPrice;
}