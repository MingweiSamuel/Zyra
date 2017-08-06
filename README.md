# Zyra

[![Travis](https://img.shields.io/travis/MingweiSamuel/Zyra/develop.svg?style=flat-square)](https://travis-ci.org/MingweiSamuel/Zyra)
[![Maven](https://img.shields.io/maven-central/v/com.mingweisamuel.zyra/zyra.svg?style=flat-square&label=maven)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mingweisamuel.zyra%22%20AND%20a%3A%22zyra%22)
[![Javadoc Stable](https://www.javadoc.io/badge/com.mingweisamuel.zyra/zyra.svg?style=flat-square)](https://www.javadoc.io/doc/com.mingweisamuel.zyra/zyra)


Java Library for the [Riot Games API](https://developer.riotgames.com/)

Zyra's goals are *speed* and *reliability*. Zyra has built-in behind-the-scenes multi-threading which
makes Zyra 6+ times faster than other libraries for large queries. Zyra handles rate limits and large
requests seamlessly. Zyra does not support the tournament APIs.


## Features

* Fast, multi-threaded
* Automatically retry failed requests
* Asynchronous chaining with CompletableFuture
* Highly-configurable


## Setup

Zyra requires Java 8.

If you are using Maven or Gradle, see the [Build Tools](#build-tools) section.
Otherwise, see the instructions below.

### Jars 
[![Nightly Build](https://img.shields.io/github/tag/MingweiSamuel/Zyra.svg?style=flat-square&label=nightly+build)](https://mingweisamuel.github.io/Zyra/)
[![GitHub Release](https://img.shields.io/github/release/MingweiSamuel/Zyra.svg?style=flat-square&label=github+release)](https://github.com/MingweiSamuel/Zyra/releases)

If you are not using a build system, release packaged jars are available through
[GitHub's releases](https://github.com/MingweiSamuel/Zyra/releases). Additionally, the most recent (nightly) build is available [here](https://mingweisamuel.github.io/Zyra/).
There are several different jars available:

* `zyra-VERSION-standalone.jar` - Go with this if you are not sure what you need. The jar has the minimal required 
dependencies needed to use Zyra.
* `zyra-VERSION-standalone-full.jar` - Has all Zyra's dependencies in their entirety, such as Google Guava. Larger 
than the minimal standalone jar.
* `zyra-VERSION.jar` - Has only Zyra. You will need to manually include the (many) dependencies.

`zyra-VERSION-javadoc.jar` contains the Javadocs and `zyra-VERSION-sources.jar` contains the sources.

### Build Tools
[![Maven](https://img.shields.io/maven-central/v/com.mingweisamuel.zyra/zyra.svg?style=flat-square&label=maven)](http://search.maven.org/#search%7Cga%7C1%7Cg%3A%22com.mingweisamuel.zyra%22%20AND%20a%3A%22zyra%22)

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

[![Javadoc Stable](https://img.shields.io/badge/javadoc-1.1.2-brightgreen.svg?style=flat-square&label=javadoc+stable)](https://www.javadoc.io/doc/com.mingweisamuel.zyra/zyra)
[![Javadoc Nightly](https://img.shields.io/github/tag/MingweiSamuel/Zyra.svg?style=flat-square&label=javadoc+nightly)](https://mingweisamuel.github.io/Zyra/apidocs/)

### Full example

The following code prints the top 10 champions for Doublelift and C9 Sneaky.

```java
import com.mingweisamuel.zyra.RiotApi;
import com.mingweisamuel.zyra.championMastery.ChampionMastery;
import com.mingweisamuel.zyra.enums.Region;
import com.mingweisamuel.zyra.lolStaticData.Champion;
import com.mingweisamuel.zyra.lolStaticData.ChampionList;
import com.mingweisamuel.zyra.summoner.Summoner;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutionException;

public class ZyraExample {

    public static void main(String[] args) throws ExecutionException, IOException {
        try (RiotApi api = RiotApi.builder("RGAPI-example-api-key").build()) {

            // get champion data (ignoring locale, version) by champion id
            ChampionList champList = api.staticData.getChampions(Region.NA, null, null, true);
            Map<String, Champion> champs = champList.data;

            // get summoners by name
            Map<String, Summoner> summoners =
                    api.summoners.getByName(Region.NA, Arrays.asList("c9 sne aky", "DoUbleLIft"));

            for (Summoner summoner : summoners.values()) {
                System.out.println(summoner.name + "'s Top 10 Champs:");
                // get top 10 champs by mastery for each summoner
                List<ChampionMastery> masteries =
                        api.championMasteries.getTopChampions(Region.NA, summoner.id, 10);

                for (int i = 0; i < masteries.size(); i++) {
                    ChampionMastery mastery = masteries.get(i);
                    // get champion for this mastery
                    Champion champ = champs.get(Integer.toString(mastery.championId));
                    // print i, champ name, champ mastery points, and champ level
                    System.out.printf("%3d) %-16s %,7d (%d)%n", i + 1, champ.name,
                            mastery.championPoints, mastery.championLevel);
                }
                System.out.println();
            }
        }
    }
}
```

Output (2017-01-18):
```
C9 Sneaky's Top 10 Champs:
  1) Jhin             268,866 (7)
  2) Lucian           195,541 (7)
  3) Ezreal           146,950 (7)
  4) Ashe             144,269 (7)
  5) Caitlyn          139,390 (7)
  6) Sivir             84,331 (7)
  7) Twitch            82,702 (7)
  8) Vayne             80,733 (7)
  9) Tristana          75,150 (6)
 10) Miss Fortune      70,757 (7)

Doublelift's Top 10 Champs:
  1) Jhin             126,291 (7)
  2) Caitlyn           97,410 (7)
  3) Vayne             79,420 (7)
  4) Lucian            77,254 (7)
  5) Kalista           43,572 (5)
  6) Ashe              36,408 (7)
  7) Ezreal            35,754 (6)
  8) Twitch            33,169 (6)
  9) Kog'Maw           22,459 (5)
 10) Tristana          20,582 (4)
 
 ```


### Building a `RiotApi` instance 

API interaction is done using instances of the
[`RiotApi`](http://www.mingweisamuel.com/Zyra/apidocs/com/mingweisamuel/zyra/RiotApi.html) class.
RiotApi has a builder-helper for configuring Zyra. To get a default instance (with default development rate limits):

```java
RiotApi api = RiotApi.build("RGAPI-example-api-key").build();
```

**IMPORTANT**: `RiotApi` implements `Closeable`. You should call `api.close()` if you are done with the `RiotApi` 
instance, otherwise your process may hang.

### Interacting with the API

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
