# Example of encrypting API
Uses Jasypt for encryption.
##To run:
- install Maven
- set env vars:

${ENCRYPTION_PASSWORD} to password for encryption/decryption

${SERVER_PORT} to port on which the app will be running
- `mvn clean package`
- `java -jar ./target/encryptingexample-1.0.0-SNAPSHOT.jar`

