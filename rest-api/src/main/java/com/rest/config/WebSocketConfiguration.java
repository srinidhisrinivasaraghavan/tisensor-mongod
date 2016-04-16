package com.rest.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.messaging.simp.config.ChannelRegistration;
import org.springframework.messaging.simp.config.MessageBrokerRegistry;
import org.springframework.web.socket.config.annotation.EnableWebSocketMessageBroker;
import org.springframework.web.socket.config.annotation.StompEndpointRegistry;
import org.springframework.web.socket.config.annotation.WebSocketMessageBrokerConfigurer;

@Configuration
@EnableWebSocketMessageBroker
public class WebSocketConfiguration implements WebSocketMessageBrokerConfigurer {

    public void registerStompEndpoints(final StompEndpointRegistry registry) {
        registry.addEndpoint("/random").withSockJS();
    }

    public void configureClientInboundChannel(
        final ChannelRegistration registration) {
    }

    public void configureClientOutboundChannel(
        final ChannelRegistration registration) {
    }

    public void configureMessageBroker(final MessageBrokerRegistry registry) {
    }

}
