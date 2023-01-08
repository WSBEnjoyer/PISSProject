# Description

This is the logging service for the PISS project. The service listens
for requests on port 8085 with websocket endpoint `/logging-websocket`.
After a connection is established, the browser sends messages that are
then being saved to a file.

# Configuration

The most important configuration to do is to specify the log file path.
As of writing this, that path is configured as value of the `LoggingService`
class' member variable `LOG_FILE_PATH`. Yes, if this is changed, the
service must be recompiled. A better way for configuration might be added
later.

# How to run this thing

1. `./gradlew :logging:bootRun` from the project root directory
2. ???
3. Profit

# How to use it

If you want to do some custom testing, the service listens on port 8085
by default. The Angular application is already set up to communicate with
it.
