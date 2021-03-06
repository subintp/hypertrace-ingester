package org.hypertrace.semantic.convention.utils.error;

import java.util.List;
import org.hypertrace.core.datamodel.Event;
import org.hypertrace.core.datamodel.shared.SpanAttributeUtils;
import org.hypertrace.core.semantic.convention.constants.error.OTelErrorSemanticConventions;
import org.hypertrace.core.span.constants.RawSpanConstants;
import org.hypertrace.core.span.constants.v1.Error;
import org.hypertrace.core.span.constants.v1.OTSpanTag;
import org.hypertrace.traceenricher.enrichedspan.constants.v1.ErrorMetrics;

/**
 * Utility class for fetching error related attributes
 */
public class ErrorSemanticConventionUtils {

  private static final String OTEL_EXCEPTION_TYPE = OTelErrorSemanticConventions.EXCEPTION_TYPE.getValue();
  private static final String OTEL_EXCEPTION_MESSAGE = OTelErrorSemanticConventions.EXCEPTION_MESSAGE.getValue();
  private static final String OTEL_EXCEPTION_STACK_TRACE = OTelErrorSemanticConventions.EXCEPTION_STACKTRACE.getValue();

  private static final List<String> EXCEPTION_ATTRIBUTES = List.of(
      RawSpanConstants.getValue(Error.ERROR_ERROR),
      RawSpanConstants.getValue(OTSpanTag.OT_SPAN_TAG_ERROR),
      OTEL_EXCEPTION_TYPE,
      OTEL_EXCEPTION_MESSAGE
  );

  private static final List<String> EXCEPTION_STACK_TRACE_ATTRIBUTES = List.of(
      RawSpanConstants.getValue(Error.ERROR_STACK_TRACE),
      OTEL_EXCEPTION_STACK_TRACE
  );

  public static List<String> getAttributeKeysForException() {
    return EXCEPTION_ATTRIBUTES;
  }

  /**
   * This maps to {@link ErrorMetrics#ERROR_METRICS_ERROR_COUNT} enriched constant
   * @param event object encapsulating span data
   * @return check for error in the span event
   */
  public static boolean checkForError(Event event) {
    return EXCEPTION_ATTRIBUTES.stream().anyMatch(
        v -> SpanAttributeUtils.containsAttributeKey(event, v));
  }

  /**
   * This maps to {@link ErrorMetrics#ERROR_METRICS_EXCEPTION_COUNT} enriched constant
   * @param event object encapsulating span data
   * @return check for exception in the span event
   */
  public static boolean checkForErrorStackTrace(Event event) {
    return EXCEPTION_STACK_TRACE_ATTRIBUTES.stream()
        .anyMatch(v -> SpanAttributeUtils.containsAttributeKey(event, v));
  }
}
