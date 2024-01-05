package com.tsoft.sched.config;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.springframework.stereotype.Component;

@Component
public class QuartzCondition implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        String containerNameFromProperty = context.getEnvironment().getProperty("container.name");
        if ("agent".equals(containerNameFromProperty)) {
            return true;
        }
        return false;
    }
}
