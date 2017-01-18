# Zyra

[![CircleCI](https://img.shields.io/circleci/project/github/MingweiSamuel/Zyra.svg?label=circleci)](https://circleci.com/gh/MingweiSamuel/Zyra/tree/develop)

Java Library for the [Riot Games API](https://developer.riotgames.com/)

Zyra's goals are *speed* and *reliability*. Zyra has built-in behind-the-scenes multi-threading which
makes Zyra 6+ times faster than other libraries for large queries. Zyra handles rate limits and large
requests seamlessly.


## Features

* Fast, multi-threaded
* Automatically retries failed requests
* Asynchronous chaining with CompletableFuture
* Highly-configurable


## Setup

If you are using Maven or Gradle, see the [Build Tools](#build0-tools) section.
Otherwise, see the instructions below.

### Jars 
[![Nightly Build](https://img.shields.io/github/tag/MingweiSamuel/Zyra.svg?label=nightly+build)](https://mingweisamuel.github.io/Zyra/)
[![GitHub Release](https://img.shields.io/github/release/MingweiSamuel/Zyra.svg?label=github+release)](https://github.com/MingweiSamuel/Zyra/releases)

If you are not using a build system, release packaged jars are available through
[GitHub's releases](https://github.com/MingweiSamuel/Zyra/releases). Additionally, the most recent (nightly) build is available [here](https://mingweisamuel.github.io/Zyra/).
There are several different jars available:

* `zyra-VERSION-standalone.jar` - Go with this if you are not sure what you need. The jar has the minimal required 
dependencies needed to use Zyra.
* `zyra-VERSION-standalone-full.jar` - Has all Zyra's dependencies in their entirety, such as Google Guava. Larger 
than the minimal standalone jar.
* `zyra-VERSION.jar` - Has only Zyra. You will need to manually include the (many) dependencies.

`zyra-VERSION-javadoc.jar` contains the JavaDocs and `zyra-VERSION-sources.jar` contains the sources.

### Build Tools
[![Maven Central](https://img.shields.io/maven-central/v/com.mingweisamuel.zyra/zyra.svg?label=maven+central)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mingweisamuel.zyra%22%20AND%20a%3A%22zyra%22)

#### Maven

Add the following to your `pom.xml` `dependencies` section. Make sure to update `VERSION`.

    <dependency>
        <groupId>com.mingweisamuel.zyra</groupId>
        <artifactId>zyra</artifactId>
        <version>VERSION</version>
    </dependency>

#### Gradle

For stability, you should replace `+` with an explicit version.

    repositories {
        mavenCentral()
    }
    
    dependencies {
        compile 'com.mingweisamuel.zyra:zyra:+'
    }

## Usage

Full JavaDocs for the current commit are available [here](http://www.mingweisamuel.com/Zyra/apidocs/).

TODO
