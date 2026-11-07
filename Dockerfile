FROM maven:3.6.3-jdk-8-openj9

RUN mkdir -p /opt/app

WORKDIR /opt/app

COPY . /opt/app

