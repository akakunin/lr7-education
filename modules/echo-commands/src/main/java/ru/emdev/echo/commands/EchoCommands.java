package ru.emdev.echo.commands;

import org.osgi.service.component.annotations.Component;
import org.osgi.service.component.annotations.Reference;

import ru.emdev.echo.EchoApi;

@Component(
		immediate=true,
		service = Object.class,
		property = { 
			"osgi.command.function=echo",
			"osgi.command.scope=echo" 
			})
public class EchoCommands {
	EchoApi echoApi;
	
	@Reference
	void bindEchoApi(EchoApi echoApi) {
		this.echoApi = echoApi;
	}
	
	void unbindEchoApi(EchoApi echoApi) {
		this.echoApi = null;
	}

	public void echo(String message) {
		String result = echoApi.echo(message);
		System.out.println(result);
	}

}
