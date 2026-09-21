package com.lovish.logistic.platform.exception;

import java.time.Instant;
import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.lovish.logistic.platform.dto.ErrorResponse;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	// InvalidConditionException
	@ExceptionHandler(InvalidConditionException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCondition(InvalidConditionException ex,
			HttpServletRequest request) {

		log.warn("Invalid condition provided: {}", ex.getMessage());

		return buildResponse(HttpStatus.BAD_REQUEST, "Invalid Condition", ex.getMessage(), request, null);
	}

	// BrokerApiException
	@ExceptionHandler(BrokerApiException.class)
	public ResponseEntity<ErrorResponse> handleBrokerApiException(BrokerApiException ex, HttpServletRequest request) {

		log.error("Broker API failure occurred: {}", ex.getMessage(), ex);

		return buildResponse(HttpStatus.BAD_GATEWAY, "Broker API Error", ex.getMessage(), request, null);
	}

	// HistoricalDataNotFoundException
	@ExceptionHandler(HistoricalDataNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleHistoricalDataNotFound(HistoricalDataNotFoundException ex,
			HttpServletRequest request) {

		log.warn("Historical data not found: {}", ex.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "Historical Data Not Found", ex.getMessage(), request, null);
	}

	// MarketDataUnavailableException
	@ExceptionHandler(MarketDataUnavailableException.class)
	public ResponseEntity<ErrorResponse> handleMarketDataUnavailable(MarketDataUnavailableException ex,
			HttpServletRequest request) {

		log.error("Market data service unavailable: {}", ex.getMessage());

		return buildResponse(HttpStatus.SERVICE_UNAVAILABLE, "Market Data Unavailable", ex.getMessage(), request, null);
	}

	// InvalidTradingSymbolException
	@ExceptionHandler(InvalidTradingSymbolException.class)
	public ResponseEntity<ErrorResponse> handleInvalidTradingSymbol(InvalidTradingSymbolException ex,
			HttpServletRequest request) {

		log.warn("Invalid trading symbol provided: {}", ex.getMessage());

		return buildResponse(HttpStatus.BAD_REQUEST, "Invalid Trading Symbol", ex.getMessage(), request, null);
	}

	// AccessDeniedException
	@ExceptionHandler(AccessDeniedException.class)
	public ResponseEntity<ErrorResponse> handleAccessDenied(AccessDeniedException ex, HttpServletRequest request) {

		return buildResponse(HttpStatus.FORBIDDEN, "Access Denied",
				"You do not have permission to access this resource", request, null);
	}

	// BadRequestException
	@ExceptionHandler(BadRequestException.class)
	public ResponseEntity<ErrorResponse> handleInvalidIndicatorInput(BadRequestException ex,
			HttpServletRequest request) {

		log.warn("Bad Request: {}", ex.getMessage());

		return buildResponse(HttpStatus.BAD_REQUEST, "Bad Request", ex.getMessage(), request, null);
	}

	// DuplicateResourceException
	@ExceptionHandler(DuplicateResourceException.class)
	public ResponseEntity<ErrorResponse> handleDuplicateResource(DuplicateResourceException ex,
			HttpServletRequest request) {

		log.warn("Duplicate resource: {}", ex.getMessage());

		return buildResponse(HttpStatus.CONFLICT, "Duplicate Resource", ex.getMessage(), request, null);
	}

	// EmailAlreadyExistsException
	@ExceptionHandler(EmailAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleEmailAlreadyExists(EmailAlreadyExistsException ex,
			HttpServletRequest request) {

		log.warn("Email already exists: {}", ex.getMessage());

		return buildResponse(HttpStatus.CONFLICT, "Email Already Exists", ex.getMessage(), request, null);
	}

	// UsernameAlreadyExistsException
	@ExceptionHandler(UsernameAlreadyExistsException.class)
	public ResponseEntity<ErrorResponse> handleUsernameAlreadyExists(UsernameAlreadyExistsException ex,
			HttpServletRequest request) {

		log.warn("Username already exists: {}", ex.getMessage());

		return buildResponse(HttpStatus.CONFLICT, "Username Already Exists", ex.getMessage(), request, null);
	}

	// InvalidCredentialsException
	@ExceptionHandler(InvalidCredentialsException.class)
	public ResponseEntity<ErrorResponse> handleInvalidCredentials(InvalidCredentialsException ex,
			HttpServletRequest request) {

		log.warn("Invalid credentials: {}", ex.getMessage());

		return buildResponse(HttpStatus.UNAUTHORIZED, "Invalid Credentials", ex.getMessage(), request, null);
	}

	// Unauthorized Exception
	@ExceptionHandler(UnauthorizedException.class)
	public ResponseEntity<ErrorResponse> handleScannerNotFound(UnauthorizedException ex, HttpServletRequest request) {

		log.warn("Unauthorized: {}", ex.getMessage());

		return buildResponse(HttpStatus.UNAUTHORIZED, "Its Unauthorized", ex.getMessage(), request, null);
	}

//       UserNotFound Exception
	@ExceptionHandler(UserNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleUserNotFound(UserNotFoundException ex, HttpServletRequest request) {

		log.warn("User not found: {}", ex.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "User Not Found", ex.getMessage(), request, null);
	}

//    StockNotFound Exception
	@ExceptionHandler(StockNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleStockNotFound(StockNotFoundException ex, HttpServletRequest request) {

		log.warn("Stock not found: {}", ex.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "Stock Not Found", ex.getMessage(), request, null);
	}

//  ResourceNotFoundException
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorResponse> handleNotFound(ResourceNotFoundException ex, HttpServletRequest request) {

		log.warn("Resource not found: {}", ex.getMessage());

		return buildResponse(HttpStatus.NOT_FOUND, "Resource Not Found", ex.getMessage(), request, null);
	}

//       Validation Errors
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ErrorResponse> handleValidation(MethodArgumentNotValidException ex,
			HttpServletRequest request) {

		Map<String, String> errors = new HashMap<>();

		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			errors.put(error.getField(), error.getDefaultMessage());
		}

		log.warn("Validation failed: {}", errors);

		return buildResponse(HttpStatus.BAD_REQUEST, "Validation Failed", "Input validation error", request, errors);
	}

//    DB Errors
	@ExceptionHandler(DataAccessException.class)
	public ResponseEntity<ErrorResponse> handleDb(DataAccessException ex, HttpServletRequest request) {

		log.error("Database error", ex);

		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Database Error", "Unable to process database request",
				request, null);
	}

//    Bad Requests
	@ExceptionHandler(IllegalArgumentException.class)
	public ResponseEntity<ErrorResponse> handleIllegal(IllegalArgumentException ex, HttpServletRequest request) {

		log.warn("Bad request: {}", ex.getMessage());

		return buildResponse(HttpStatus.BAD_REQUEST, "Bad Request", ex.getMessage(), request, null);
	}

//	Type Mismatch
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<ErrorResponse> handleTypeMismatch(Exception ex, HttpServletRequest request) {

		return buildResponse(HttpStatus.BAD_REQUEST, "Type Mismatch", "Invalid parameter type", request, null);
	}

//    Global Fallback
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ErrorResponse> handleGlobal(Exception ex, HttpServletRequest request) {

		log.error("Unhandled exception", ex);

		return buildResponse(HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", "Something went wrong", request,
				null);
	}

//    Common Builder
	private ResponseEntity<ErrorResponse> buildResponse(HttpStatus status, String error, String message,
			HttpServletRequest request, Map<String, String> validationErrors) {

		ErrorResponse response = new ErrorResponse(Instant.now(), status.value(), error, message,
				request.getRequestURI(), validationErrors);

		return ResponseEntity.status(status).body(response);
	}
}
