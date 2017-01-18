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

```xml
<dependency>
    <groupId>com.mingweisamuel.zyra</groupId>
    <artifactId>zyra</artifactId>
    <version>VERSION</version>
</dependency>
```

#### Gradle

For stability, you should replace `+` with an explicit version.

```groovy
repositories {
    mavenCentral()
}

dependencies {
    compile 'com.mingweisamuel.zyra:zyra:+'
}
```

## Usage

Full JavaDocs for the current commit are available [here](http://www.mingweisamuel.com/Zyra/apidocs/).

#### Building a `RiotApi` instance 

API interaction is done using instances of the
[`RiotApi`](http://www.mingweisamuel.com/Zyra/apidocs/com/mingweisamuel/zyra/RiotApi.html) class.
RiotApi has a builder-helper for configuring Zyra. To get a default instance (with default development rate limits):

```java
RiotApi api = RiotApi.build("RGAPI-example-api-key").build();
```

**IMPORTANT**: `RiotApi` implements `Closeable`. You should call `api.close()` if you are done with the `RiotApi` 
instance, otherwise your process may hang.

#### Interacting with the API

API interaction in Zyra is done through endpoint sets which correspond (almost) 1-to-1 to the sections listed in the 
[official Riot API Reference](https://developer.riotgames.com/api/methods).

Example:

```java
// get summoners by name
Map<String, Summoner> summoners =
        api.summoners.getByName(Region.NA, Arrays.asList("C9 Sneaky", "Doublelift"));
for (Summoner summoner : summoners.values()) {
    // get total champion mastery points for each summoner
    int score = api.championMasteries.getScore(Region.NA, summoner.id);
    System.out.println(summoner.name + ": " + score);
}
```

There are also asynchronous versions of every endpoint method which return `CompletableFuture`s to allow chaining.

More examples can be found in Zyra's [integration test sources](https://github.com/MingweiSamuel/Zyra/tree/develop/src/test/java/com/mingweisamuel/zyra/test).

#### Handling exceptions

TODO

