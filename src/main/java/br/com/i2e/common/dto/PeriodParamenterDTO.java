package br.com.i2e.common.dto;

import java.time.LocalDate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor
public class PeriodParamenterDTO {

	private LocalDate initialDate;
	private LocalDate finalalDate;
}
