package com.bns.project.model;

import java.time.LocalDate;

import com.bns.project.validator.DateRangeParams;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TradeHistory {

	private LocalDate startDate;
	private LocalDate endDate;
	
	@DateRangeParams
	public TradeHistory(LocalDate startDate, LocalDate endDate) {
		this.startDate = startDate;
		this.endDate = endDate;
	}
}
