package tn.iit.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MedicamentDto {
    @NotNull
    private long id;
    @NotNull
    @Size(min = 3)
    @NotEmpty
    private String name;
    @NotNull
    private float dosage;
    @NotNull
    private float price;
}
