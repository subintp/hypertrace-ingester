package org.hypertrace.semantic.convention.utils.messaging;

/**
 * OTEL specific attributes for Messaging system
 */
public enum OtelMessagingSemanticConventions {
  MESSAGING_SYSTEM("messaging.system"),
  MESSAGING_URL("messaging.url"),
  RABBITMQ_MESSAGING_SYSTEM_VALUE("rabbitmq"),
  RABBITMQ_ROUTING_KEY("messaging.rabbitmq.routing_key");

  private final String value;

  OtelMessagingSemanticConventions(String value) {
    this.value = value;
  }

  public String getValue() {
    return value;
  }
}
