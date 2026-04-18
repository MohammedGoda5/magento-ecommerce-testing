# Docker image for running Magento tests
FROM maven:3.9.9-eclipse-temurin-21-jammy

# Install Chrome dependencies
RUN apt-get update && apt-get install -y \
    wget \
    gnupg \
    unzip \
    xvfb \
    libgconf-2-4 \
    libfontconfig1 \
    && rm -rf /var/lib/apt/lists/*

# Install Chrome
RUN wget -q -O - https://dl-ssl.google.com/linux/linux_signing_key.pub | apt-key add - \
    && echo "deb http://dl.google.com/linux/chrome/deb/ stable main" >> /etc/apt/sources.list.d/google.list \
    && apt-get update \
    && apt-get install -y google-chrome-stable \
    && rm -rf /var/lib/apt/lists/*

# Install Allure
RUN wget https://github.com/allure-framework/allure2/releases/download/2.34.0/allure-2.34.0.tgz \
    && tar -xzf allure-2.34.0.tgz -C /opt/ \
    && ln -s /opt/allure-2.34.0/bin/allure /usr/local/bin/allure \
    && rm allure-2.34.0.tgz

# Set display for headless mode
ENV DISPLAY=:99

# Create working directory
WORKDIR /app

# Copy pom.xml first for dependency caching
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copy source code
COPY src ./src
COPY testng.xml .

# Default command
CMD ["xvfb-run", "--auto-servernum", "--server-args=-screen 0 1920x1080x24", "mvn", "clean", "test", "-Dheadless=true"]
