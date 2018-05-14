package ru.emdev.echo.impl;

import ru.emdev.echo.EchoApi;

import org.osgi.service.component.annotations.Component;

/**
 * @author akakunin
 */
@Component(
	immediate = true,
	service = EchoApi.class
)
public class EchoService implements EchoApi {

	@Override
	public String echo(String message) {
		return message;
	}
}