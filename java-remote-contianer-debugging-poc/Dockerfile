FROM openjdk:17-jdk-slim

# Set working directory inside container
WORKDIR /app

# Copy everything from target/ into /app/
COPY target/ /app/

# Optional: expose ports (your app may need these)
EXPOSE 8080
EXPOSE 5005

# Default: open bash shell
CMD ["/bin/bash"]