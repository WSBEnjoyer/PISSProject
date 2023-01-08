import { RxStompConfig } from '@stomp/rx-stomp';

export const loggingRxStompConfig: RxStompConfig = {
  brokerURL: 'ws://localhost:8085/logging-websocket',

  heartbeatIncoming: 0,
  heartbeatOutgoing: 20000,

  reconnectDelay: 0,
};
