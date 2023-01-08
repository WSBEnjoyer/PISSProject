import { Injectable } from '@angular/core';
import { RxStomp } from "@stomp/rx-stomp";
import { loggingRxStompConfig } from "../rx-stomp.config";
import { LoggingMessage } from "../model";

@Injectable({
  providedIn: 'root'
})
export class LoggingService {
  private readonly loggingEndpoint = '/ws/logs';
  private loggingConnection: RxStomp | undefined;

  constructor() {
    this.connect();
  }

  public log(message: string): void {
    const logMessage: LoggingMessage = {
      message
    };

    this.loggingConnection?.publish({
      destination: this.loggingEndpoint,
      body: JSON.stringify(logMessage),
    });
  }

  private connect(): void {
    this.loggingConnection = new RxStomp();
    this.loggingConnection.configure(loggingRxStompConfig);
    this.loggingConnection.activate();
  }
}
