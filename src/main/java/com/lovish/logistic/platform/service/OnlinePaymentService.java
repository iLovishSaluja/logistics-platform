package com.lovish.logistic.platform.service;

import java.util.List;

import com.lovish.logistic.platform.dto.CreateOnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.OnlinePaymentResponseDto;
import com.lovish.logistic.platform.dto.RefundPaymentRequestDto;
import com.lovish.logistic.platform.dto.VerifyOnlinePaymentRequestDto;

public interface OnlinePaymentService {

	CreateOnlinePaymentResponseDto createOrder(String shipmentId);

	OnlinePaymentResponseDto verifyPayment(VerifyOnlinePaymentRequestDto request);

	List<OnlinePaymentResponseDto> getMyPayments();

	OnlinePaymentResponseDto refundPayment(String paymentId, RefundPaymentRequestDto request);
}