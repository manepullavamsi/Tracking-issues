package com.experiment.experience.springbootfeatures.utility;

public class ControllerAdvice_ref {}

/*


//package com.company.work.shared.platformdomain.project.component;
//import com.company.work.shared.platformdomain.project.exception.BadRequestException;
//import com.company.work.shared.platformdomain.project.exception.ErrorResponse;
//import com.company.work.shared.platformdomain.project.exception.NoContentFoundException;
//import com.company.work.shared.platformdomain.project.exception.ReportNotFoundException;
//import com.company.work.shared.platformdomain.project.exception.ReportsError;
//import com.company.work.shared.platformdomain.project.exception.DuplicateRecordInsertionException;
//import com.company.work.shared.platformlib.planreportdocslib.exception.RecordNotFoundException;
//import com.company.work.shared.platformlib.planreportdocslib.exception.RestControllerException;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;
@Slf4j
@Component
@ControllerAdvice("com.company.work.shared.platformdomain.project")
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler {
    private static final String UNEXPECTED_ERROR_MESSAGE = "Unexpected internal server error";
    private static final String BAD_REQUEST = "Bad request";
    private static final String NO_RECORD_FOUND = "No Record Found";
    private static final String DUPLICATE_RECORD = "Duplicate Record";
    private static final String NO_RECORDS = "No Records";
    @ExceptionHandler({RestControllerException.class})
    public final ResponseEntity<ReportsError> handleRestControllerException(
            RestControllerException e, WebRequest request) {
        if (e instanceof ReportNotFoundException) {
            return errorResponse(e);
        }
        log.warn("Unhandled RestControllerException");
        return handleUnexpectedException(e, request);
    }
    @ExceptionHandler({RuntimeException.class})
    public final ResponseEntity<ReportsError> handleUnexpectedException(
            RuntimeException e, WebRequest request) {
        log.error(UNEXPECTED_ERROR_MESSAGE, e);
        return errorResponse(
                new RestControllerException(
                        UNEXPECTED_ERROR_MESSAGE, HttpStatus.INTERNAL_SERVER_ERROR));
    }
    private ResponseEntity<ReportsError> errorResponse(RestControllerException e) {
        return errorResponse(e, new HttpHeaders());
    }
    private ResponseEntity<ReportsError> errorResponse(
            RestControllerException e, HttpHeaders headers) {
        return new ResponseEntity<>(
                new ReportsError(e.getHttpStatus().value(), e.getMessage()),
                headers,
                e.getHttpStatus());
    }
    @ExceptionHandler(BadRequestException.class)
    public final ResponseEntity<ErrorResponse> handleBadRequestException(
            BadRequestException ex, WebRequest request) {
        ErrorResponse error =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now(ZoneId.systemDefault()))
                        .path(request.getContextPath())
                        .error(BAD_REQUEST)
                        .message(ex.getMessage())
                        .exception(ex.getClass().getSimpleName())
                        .build();
        log.error("BadRequestException :: Exception occurred - {}", error);
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }
    @ExceptionHandler(ReportNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleReportNotFoundException(
            BadRequestException ex, WebRequest request) {
        ErrorResponse error =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now(ZoneId.systemDefault()))
                        .path(request.getContextPath())
                        .error(NO_RECORD_FOUND)
                        .message(ex.getMessage())
                        .exception(ex.getClass().getSimpleName())
                        .build();
        log.error("ReportNotFound Exception Exception occurred - {}", error);
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(SQLException.class)
    public ResponseEntity<Object> handleSQLException(SQLException ex) {
        List<SQLException> violations = new ArrayList<>();
        violations.add(ex);
        String format = Thread.currentThread().getStackTrace()[2].getMethodName() + "|{0}";
        log.warn(MessageFormat.format(format, violations));
        return new ResponseEntity<>(violations, HttpStatus.INTERNAL_SERVER_ERROR);
    }
    @ExceptionHandler(RecordNotFoundException.class)
    public final ResponseEntity<ErrorResponse> handleRecordNotFoundException(
            RecordNotFoundException ex, WebRequest request) {
        log.error("Exception Occurred ", ex);
        ErrorResponse error =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now(ZoneId.systemDefault()))
                        .path(request.getContextPath())
                        .error(NO_RECORD_FOUND)
                        .message(ex.getMessage())
                        .exception(ex.getClass().getSimpleName())
                        .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
    @ExceptionHandler(DuplicateRecordInsertionException.class)
    public final ResponseEntity<ErrorResponse> handleDuplicateRecordInsertionException(
            DuplicateRecordInsertionException ex, WebRequest request) {
        log.error("Exception Occurred ", ex);
        ErrorResponse error =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now(ZoneId.systemDefault()))
                        .path(request.getContextPath())
                        .error(DUPLICATE_RECORD)
                        .message(ex.getMessage())
                        .exception(ex.getClass().getSimpleName())
                        .build();
        return new ResponseEntity<>(error, HttpStatus.CONFLICT);
    }
    @ExceptionHandler(NoContentFoundException.class)
    public final ResponseEntity<ErrorResponse> handleNoContentFoundException(
            NoContentFoundException ex, WebRequest request) {
        ErrorResponse error =
                ErrorResponse.builder()
                        .timestamp(LocalDateTime.now(ZoneId.systemDefault()))
                        .path(request.getContextPath())
                        .error(NO_RECORDS)
                        .message(ex.getMessage())
                        .exception(ex.getClass().getSimpleName())
                        .build();
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }
}*/
