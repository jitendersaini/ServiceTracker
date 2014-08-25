/**
 * 
 */
package com.accenture.tracker.config;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.accenture.tracker.aop.TraceInterceptor;

/**
 * @author j.saini
 *
 */
@Configuration
@EnableAspectJAutoProxy(proxyTargetClass = true)
public class TraceInterceptorConfig {

	@Bean
	public TraceInterceptor customizableTraceInterceptor() {
		TraceInterceptor traceInterceptor = new TraceInterceptor();
		traceInterceptor
				.setEnterMessage("Entering $[targetClassShortName].$[methodName]($[arguments])");
		traceInterceptor
				.setExitMessage("Leaving $[targetClassShortName].$[methodName](): $[returnValue]");
		return traceInterceptor;

	}

	@Bean
	public Advisor repositoryAdvisor() {
		AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
		pointcut.setExpression("execution(public * com.accenture.tracker.hibernate.domains..*(..))");
		pointcut.setExpression("execution(public * com.accenture.tracker.util..*(..))");
		pointcut.setExpression("execution(public * com.accenture.tracker.dao..*(..))");
		pointcut.setExpression("execution(public * com.accenture.tracker.services..*(..))");
		pointcut.setExpression("execution(public * com.accenture.tracker.controller..*(..))");
		return new DefaultPointcutAdvisor(pointcut,
				customizableTraceInterceptor());
	}

}
