
package com.lovish.logistic.platform.mapper;

import org.springframework.stereotype.Component;

import com.lovish.logistic.platform.dto.OnlinePaymentResponseDto;
import com.lovish.logistic.platform.entity.OnlinePayment;

@Component
public class OnlinePaymentMapper {

	public OnlinePaymentResponseDto toResponseDto(OnlinePayment payment) {
		OnlinePaymentResponseDto dto = new OnlinePaymentResponseDto();

		dto.setId(payment.getId());
		dto.setShipmentId(payment.getShipmentId());
		dto.setRazorpayOrderId(payment.getRazorpayOrderId());
		dto.setRazorpayPaymentId(payment.getRazorpayPaymentId());
		dto.setRazorpayRefundId(payment.getRazorpayRefundId());
		dto.setAmount(payment.getAmount());
		dto.setRefundedAmount(payment.getRefundedAmount());
		dto.setCurrency(payment.getCurrency());
		dto.setStatus(payment.getStatus());
		dto.setRefundStatus(payment.getRefundStatus());
		dto.setCreatedAt(payment.getCreatedAt());
		dto.setUpdatedAt(payment.getUpdatedAt());

		return dto;
	}
}
